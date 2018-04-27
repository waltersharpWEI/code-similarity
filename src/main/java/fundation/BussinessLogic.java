package fundation;

import com.zhixiangli.code.similarity.CodeSimilarity;
import com.zhixiangli.code.similarity.strategy.CosineSimilarity;
import java.io.*;

public class BussinessLogic {
	// default algorithm is Longest Common Subsequence.
	public static boolean isTheSame(String str1, String str2, double threshold) {
			CodeSimilarity codeSimilarity = new CodeSimilarity();
			double sim1 = codeSimilarity.get(str1, str1);
			CodeSimilarity cosineSimilarity = new CodeSimilarity(new CosineSimilarity());
			double sim2 = cosineSimilarity.get(str1, str2);
			return (sim1 + sim2) / 2.0 > threshold;
	}
	
	public static boolean isTheSameFS(String path1, String path2, double threshold) {
		String str1 = readFromFile(path1);
		String str2 = readFromFile(path2);
			
		CodeSimilarity codeSimilarity = new CodeSimilarity();
		double sim1 = codeSimilarity.get(str1, str1);
		CodeSimilarity cosineSimilarity = new CodeSimilarity(new CosineSimilarity());
		double sim2 = cosineSimilarity.get(str1, str2);
		return (sim1 + sim2) / 2.0 > threshold;
	}
	
	public static String readFromFile(String path) {
		   File filename = new File(path); 
		   String str1 = "";
		   try {
	           InputStreamReader reader = new InputStreamReader(  
	                   new java.io.FileInputStream(filename)); // 建立一个输入流对象reader  
	           BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言 
	           String line = "";  
	           line = br.readLine();
	           str1 = str1 + line;
	           while (line != null) {  
	               line = br.readLine(); // 一次读入一行数据  
	           }  
		   } catch (IOException e) {
			   System.out.println("File Error");
		   }
           return str1;
	}
	
	/*
	 * path1 choose a file as the new income function
	 * dir2 indicate a directory as the lib of current functions
	 * return true if found
	 */
	public static boolean findFuncInLib(String path1, String dir1, double threshold) throws IOException {
		boolean found = false;
		
		 int filecount=0;  
	     File dirFile = new File(dir1);  
	     if (!dirFile.exists()) {  
	    	 System.out.println("function lib do not exist");  
	         return false;  
	     }    
	     
	     if (!dirFile.isDirectory()) {  
	    	 if (dirFile.isFile()) {  
	    		 System.out.println("Lib is a file");
	    		 System.out.println(dirFile.getCanonicalFile());  
	         }  
	         return false;  
	     }  
	          
	     //System.out.print("|--");  
	     //System.out.println(dirFile.getName());  
	     String[] fileList = dirFile.list();  
	     //int currentDepth=depth+1;  
	     for (int i = 0; i < fileList.length; i++) {  
	    	 String string = fileList[i];  
	         File file = new File(dirFile.getPath(),string);  
	        
	         if (BussinessLogic.isTheSameFS(path1, file.getAbsoluteFile().toString(), threshold)) {
	        	 found = true;
	        	 System.out.println(file.getAbsolutePath());
	         }
	         
	         String name = file.getName();  
	         if (file.isDirectory()) {  
	                //find(file.getCanonicalPath(),currentDepth);
	        	    System.out.println("Current version does not support nested lib");
	         }else{  
	               // System.out.println(name);  
	         }  
	     }  
		
		return found;
	}
}
