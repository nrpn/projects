package fileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	int k = 1;
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
				fos.write(i+0);
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
				fos.write(i-0);
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
				CopyFile.copy(listOfFiles[i].getPath(), tempFile.getPath());
			}

			copyDirectoryStructure(listOfFiles[i],tempFile);

		}
	}

	/*	public static void copyFilesInStructure(File source, File target){
		File[] listOfFiles = source.listFiles();
		if ((listOfFiles == null) || (listOfFiles.length ==  0)) {
		  return;	
		}
		for(int i = 0; i< listOfFiles.length;i++){
			String s = rename(listOfFiles[i].getName());
			File tempFile = new File(target+"/"+listOfFiles[i].getName());
			if (listOfFiles[i].isDirectory() == true) {
				tempFile.mkdir();
			}
			if (listOfFiles[i].isFile() == true) {
				CopyFile.copy(listOfFiles[i].getPath(), tempFile.getPath());
			}

			copyDirectoryStructure(listOfFiles[i],tempFile);

		}
	}*/	

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
	public void renameDirStructure1(String sourceDir){
		File srcDir = new File(sourceDir);
		File[] listOfFiles = srcDir.listFiles();

		for(int i = 0; i< listOfFiles.length;i++){
			if ((listOfFiles == null) || (listOfFiles.length ==  0)) {
				continue;	
			}			
			String s1= listOfFiles[i].getName();
			File dest = new File(sourceDir+rename(listOfFiles[i].getName()));	

//			Boolean b = listOfFiles[i].renameTo(dest);
			File temp = new File(sourceDir+"\\"+"Nripen"+k);
			k++;
			Boolean b = listOfFiles[i].renameTo(temp);
			if (b == false){
				b= true;
			}
			String s = temp.getPath();
			if (temp.isDirectory() == true) {
			renameDirStructure1(temp.getPath()+"\\");
			}

		}
	}	
	
	public void renameDirStructure(String sourceDir){
		File srcDir = new File(sourceDir);
		File[] listOfFiles = srcDir.listFiles();

		for(int i = 0; i< listOfFiles.length;i++){
			if ((listOfFiles == null) || (listOfFiles.length ==  0)) {
				continue;	
			}			
			String s1= listOfFiles[i].getName();
			String s2 =namePartOfFromFileName(listOfFiles[i].getName()); 
			String s3 =rename(namePartOfFromFileName(listOfFiles[i].getName())); 
			String s4 =extPartOfFromFileName(listOfFiles[i].getName()); 
			String s5 =rename(extPartOfFromFileName(listOfFiles[i].getName())); 
			File dest;
			if (s5.equalsIgnoreCase("") || s5.length() == 0){
			  dest = new File(sourceDir+"\\"+s3);	
			}else {
				dest = new File(sourceDir+"\\"+s3+"."+ s5);
			}

//			Boolean b = listOfFiles[i].renameTo(dest);
//			File temp = new File(sourceDir+"\\"+"Nripen"+k);
//			k++;
			Boolean b = listOfFiles[i].renameTo(dest);
			if (b == false){
				b= true;
			}
			String s = dest.getPath();
			if (dest.isDirectory() == true) {
			renameDirStructure(dest.getPath()+"\\");
			}
		}
	}
	
	public String namePartOfFromFileName(String fileName){
	  String s = "";
	  int index = fileName.lastIndexOf('.');
	  if (index > 0){
	    s = fileName.substring(0, index);
	    return s;
	  }else return fileName;
	}
	
	public String extPartOfFromFileName(String fileName){
		  String s = "";
		  int index = fileName.lastIndexOf('.');
		  if (index > 0){
		    s = fileName.substring(index+1);
		  }
		  return s;
		}

}
