package fileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile2 {
	
	public static void copy(String source, String target){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int i;
		
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while((i= fis.read()) != -1) {
				fos.write(i+10);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void retrieve(String source, String target){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int i;
		
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while((i= fis.read()) != -1) {
				fos.write(i-10);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public static void copyDirectoryStructure(File source, File target){
		File[] listOfFiles = source.listFiles();
		if ((listOfFiles == null) || (listOfFiles.length ==  0)) {
		  return;	
		}
		for(int i = 0; i< listOfFiles.length;i++){
			File tempFile = new File(target+"/"+listOfFiles[i].getName());
			if (listOfFiles[i].isDirectory() == true) {
				tempFile.mkdir();
			}
			else if (listOfFiles[i].isFile() == true) {
				CopyFile2.copy(listOfFiles[i].getPath(), tempFile.getPath());
			}
			
			copyDirectoryStructure(listOfFiles[i],tempFile);
			
		}
	}
	
	public static String rename(String sourceFileName){
		char[] arrSource = sourceFileName.toCharArray() ;
		char[] arrTarget = new char[sourceFileName.length()];
		int j;
		for (int i = 0; i<sourceFileName.length(); i++){
			j = arrSource[i] + 1;
			arrTarget[i] = (char)j;	
		}
		String s = new String(arrTarget);
		return s;
	}
	
	public static String retrieveRename(String sourceFileName){
		char[] arrSource = sourceFileName.toCharArray() ;
		char[] arrTarget = new char[sourceFileName.length()];
		int j;
		for (int i = 0; i<sourceFileName.length(); i++){
			j = arrSource[i] - 1;
			arrTarget[i] = (char)j;	
		}
		String s = new String(arrTarget);
		return s;
	}

}
