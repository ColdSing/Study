package com.fxx.sorm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.fxx.sorm.bean.ColumnInfo;
import com.fxx.sorm.bean.TableInfo;
import com.fxx.sorm.core.DBManager;
import com.fxx.sorm.core.TableContext;

public class JavaFileUtils {
	public static String creatSetandGet(ColumnInfo cif,TypeConvertor convertor){
		StringBuilder sb = new StringBuilder();
		/**
		 * set方法
		 */
		sb.append("\tpublic void set");
		sb.append(StringUtils.first2Uppercase(cif.getName()));
		sb.append("(");
		sb.append(convertor.databaseType2JavaType(cif.getType()));
		sb.append(" ");
		sb.append(cif.getName());
		sb.append("){\n");
		sb.append("\t\tthis.");
		sb.append(cif.getName());
		sb.append("=");
		sb.append(cif.getName());
		sb.append(";\n");
		sb.append("\t}");
		
		sb.append("\n");
		/**
		 * get方法
		 */
		sb.append("\tpublic ");
		sb.append(convertor.databaseType2JavaType(cif.getType()));
		sb.append(" get");
		sb.append(StringUtils.first2Uppercase(cif.getName()));
		sb.append("(){\n");
		sb.append("\t\treturn this.");
		sb.append(cif.getName());
		sb.append(";\n");
		sb.append("\t}");
		
		return sb.toString();
		
	}
	public static String creatfield(ColumnInfo cif,TypeConvertor convertor){
		StringBuilder sb = new StringBuilder();
		sb.append("\tprivate ");
		sb.append(convertor.databaseType2JavaType(cif.getType()));
		sb.append(" "+cif.getName());
		sb.append(";\n");
		return sb.toString();
	}
	public static String creatClass(TableInfo tif,TypeConvertor convertor){
		StringBuilder sb = new StringBuilder();
		sb.append("package ");
		sb.append(DBManager.getConf().getPoPackage());
		sb.append(";\n\n");
		sb.append("import java.util.*;\n");
		sb.append("import java.lang.*;\n\n");
		sb.append("public class ");
		sb.append(StringUtils.first2Uppercase(tif.getTname()));
		sb.append("{\n");
		Map<String,ColumnInfo> columns = tif.getColumns(); 
		for(ColumnInfo cif:columns.values()){
			sb.append(creatfield(cif, convertor));
		}
		for(ColumnInfo cif:columns.values()){
			sb.append(creatSetandGet(cif, convertor));
			sb.append("\n\n");
		}
		sb.append("}");
		return sb.toString();
	}
	public static void creatPOFiles(TableInfo tif,TypeConvertor convertor){
		File f= new File(DBManager.getConf().getSrcPath()+"\\"+DBManager.getConf().getPoPackage().replaceAll("\\.", "\\\\"));
		BufferedWriter bw =null;
		if(!f.exists()){
			f.mkdirs();
		}
		try {
			bw = new BufferedWriter(new FileWriter(new File(f,StringUtils.first2Uppercase(tif.getTname())+".java")));
			bw.write(creatClass(tif, convertor));
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
	
	public static void main(String[] args) {
		
		//System.out.println(DBManager.getConf().getSrcPath()+"\\"+DBManager.getConf().getPoPackage().replaceAll("\\.", "\\\\"));
	}
}
