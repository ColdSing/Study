package TestStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestPrintStream {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps=System.out;
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("G:/hehe.txt"))));
		
	}

}
