package fileTest;

import java.io.File;

public class FileTestMain {

	public static void main(String[] args) {
		String strRootSrcDir = "G:/Nripen Works/EOM Java/Java WorkSpace/CS/customerService_batch_dev_june_Copy/src/main/java/com/cvs/cs/batch/plugin/";
		String strRootDestDir = "C:/temp/java/batch/";
//		String strRootDestDir = "C:/Program Files/Notepad++/plugins/";
		File rootSrcDir = new File(strRootSrcDir);
		File rootDestDir = new File(strRootDestDir);
		CopyFile.copyDirectoryStructure(rootSrcDir, rootDestDir);
//		CopyFile.copyFilesInStructure(rootSrcDir, rootDestDir);
//		CopyFile c = new CopyFile();
//		c.renameDirStructure(strRootDestDir);
		
//		CopyFile.copy("G:/Nripen Works/EOM Java/Java WorkSpace/NotePadPlugin/", "C:/Program Files/Notepad++/plugins/");
	}

}
