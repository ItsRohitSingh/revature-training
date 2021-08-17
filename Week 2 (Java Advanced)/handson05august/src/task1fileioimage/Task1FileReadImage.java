package task1fileioimage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task1FileReadImage {

	public static void readFromFile() {
		
		try {
			FileInputStream reader = new FileInputStream("C:\\Users\\Rohit\\Pictures\\LRM_EXPORT_31331367298202_20190115_204002831.jpeg");

			BufferedInputStream br = new BufferedInputStream(reader);
			BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("D:\\test_pic.jpeg"));
			
			int line = br.read();
			
			while(line!=-1) {
				//System.out.println(line);
				bw.write((char)line);
				
				line = br.read();
			}
			
			br.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		readFromFile();
	}
}
