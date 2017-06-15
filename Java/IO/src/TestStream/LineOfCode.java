package TestStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineOfCode {

	public  static int lineOfCode(File src) throws IOException{
		int sum=0;
		if(src.isFile()){
			sum+=count(src);
		}
		else
		{
			File[] fileList = src.listFiles();
			for(File f:fileList){
				if(f.isDirectory()){
					sum+=lineOfCode(f);
				}else{
					sum+=count(f);
				}
			}
		}
		return sum;
	}
	public static int count(File src) throws IOException{
		int sum=0;
		BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(src), "utf-8"));
		String info = null;
		if(src.getName().endsWith(".java")){
			while(null!= (info=br.readLine())){
				sum++;
			}
		}
		br.close();
		return sum;
	}
	
	
	public static void main(String[] args) {
		File src = new File("G:/Study");
		try {
			System.out.println(lineOfCode(src));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
