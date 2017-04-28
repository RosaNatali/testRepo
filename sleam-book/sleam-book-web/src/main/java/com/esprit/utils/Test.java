package com.esprit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;

import org.primefaces.model.UploadedFile;

public class Test {

	public static void main(String[] args) throws IOException
	{

		/********************************/
    	
//    	try{
//    	    if(f.mkdir()) { 
//    	    	System.out.println("---------------------------------LOL: " + f.getAbsolutePath());
//    	        System.out.println("Directory Created");
//    	    } else {
//    	        System.out.println("Directory is not created");
//    	    }
//    	} catch(Exception e){
//    	    e.printStackTrace();
//    	} 
		
		/***********************************************************************************/
//		File f = new File("C:\\LOLO");
		
		File dir=new File("C:\\HI");
		if(!dir.exists()){
		dir.mkdir();}
		//then generate File name

//		File destination = new File("/path/to/your/uploads", file.getName());
//		file.renameTo(destination);

	}

}
