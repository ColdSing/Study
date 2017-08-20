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
 * ��װ����Java��Դ���룩���ò���
 * @author ������
 *
 */
public class JavaFileUtils {

		
	/**
	 * ���ݱ���Ϣ����java���Դ����
	 * @param tableInfo ����Ϣ
	 * @param convertor ת����
	 * @return java���Դ��
	 */
	public static String creatJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
		StringBuilder src = new StringBuilder();
		
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		
		for(ColumnInfo c:columns.values()){
			javaFields.add(creatFieldGetSetSRC(c, convertor));
		}
		
		//����package���
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//����import���
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//�������������
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		//���������б�
		for(JavaFieldGetSet jfgs:javaFields){
			src.append(jfgs.getFieldInfo());
		}
		src.append("\n\n\n");
		//����get/set����
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
	 * �����ֶ���Ϣ����java������Ϣ���磺varchar username-->private String username;�Լ���Ӧ�� set��get����Դ��
	 * @param column �ֶ���Ϣ
	 * @param convertor ����ת����
	 * @return java ���Ժ�set/get����Դ��
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
