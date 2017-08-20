package com.fxx.sorm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fxx.sorm.bean.ColumnInfo;
import com.fxx.sorm.bean.JavaFieldGetSet;
import com.fxx.sorm.bean.TableInfo;
import com.fxx.sorm.core.DBManager;
import com.fxx.sorm.core.MySqlTypeConvertor;
import com.fxx.sorm.core.TableContext;
import com.fxx.sorm.core.TypeConvertor;
/**
 * 封装生成Java（源代码）常用操作
 * @author 风潇潇
 *
 */
public class JavaFileUtils {

		
	/**
	 * 根据表信息生成java类的源代码
	 * @param tableInfo 表信息
	 * @param convertor 转换器
	 * @return java类的源码
	 */
	public static String creatJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
		StringBuilder src = new StringBuilder();
		
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		for(ColumnInfo c:columns.values()){
			javaFields.add(creatFieldGetSetSRC(c, convertor));
		}
		
		//生成package语句
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//生成import语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//生成类声明语句
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		//生成属性列表
		for(JavaFieldGetSet jfgs:javaFields){
			src.append(jfgs.getFieldInfo());
		}
		src.append("\n\n\n");
		//生成get/set方法
		for(JavaFieldGetSet jfgs:javaFields){
			src.append(jfgs.getGetInfo());
			src.append(jfgs.getSetInfo());
		}
		
		src.append("}");
		return src.toString();
	}
	
	public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor){
		String src = creatJavaSrc(tableInfo, convertor);
		
		String srcPath = DBManager.getConf().getSrcPath()+"\\";
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.","\\\\");
		System.out.println(srcPath+packagePath);
		BufferedWriter bw = null;
		
		File f = new File(srcPath+packagePath);
		if(!f.exists()){
			f.mkdirs();
		}
		
		try {
			bw=new BufferedWriter(new FileWriter(new File(f,StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java")));
			bw.write(src);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null){
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 根据字段信息生成java属性信息。如：varchar username-->private String username;以及相应的 set和get方法源码
	 * @param column 字段信息
	 * @param convertor 类型转换器
	 * @return java 属性和set/get方法源码
	 */
	public static JavaFieldGetSet creatFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor){
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
		
		//public String getUsername(){return username;}
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//public void setUsername(String username){this.username=username;}
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"("+javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	
	public static void main(String[] args) {
//		ColumnInfo cl = new ColumnInfo("username", "varchar", 0);
//		creatFieldGetSetSRC(cl,new MySqlTypeConvertor()).toString();
		Map<String,TableInfo>tb = TableContext.tables;
		for(TableInfo ti:tb.values()) {
			createJavaPOFile(ti,new MySqlTypeConvertor()) ;
		}
		
	}
}
