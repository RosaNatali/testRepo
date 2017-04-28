package com.esprit.utils;

import java.sql.*;
import java.io.*;

class SaveImageToDatabase
{
	public static void main(String[] args) throws SQLException
    {
		System.out.println("***********************************1");
		Connection connection = null;
		String connectionURL = "jdbc:mysql://localhost:3306/sleamdb";
		System.out.println("***********************************2");
        ResultSet rs = null;
        PreparedStatement psmnt = null;
        FileInputStream fis;
        
        try
        {
//        	System.out.println("***********************************3");
//        	Class.forName("com.mysql.jdbc.Driver").newInstance();
//        	System.out.println("***********************************4");
//        	connection = DriverManager.getConnection(connectionURL, "root", "root");
//        	System.out.println("***********************************5");
//        	psmnt = connection.prepareStatement("insert into user(id, name, password, username) " + "values(?,?,?,?)");
//        	System.out.println("***********************************6"); 
//        	psmnt.setInt(1, 1);
//        	psmnt.setString(2,"mahendra");
//            psmnt.setString(3,"mahendra");
//            psmnt.setString(4,"mahendra");
//            int s = psmnt.executeUpdate();
//          if(s>0)
//          {
//          	System.out.println("Uploaded successfully !");
//          }
//          else
//          {
//          	System.out.println("unsucessfull to upload image.");
//          }
        	System.out.println("***********************************3");
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	System.out.println("***********************************4");
        	connection = DriverManager.getConnection(connectionURL, "root", "root");
        	System.out.println("***********************************5");
        	File image = new File("D:/oo.jpg");
        	System.out.println("***********************************6");
        	psmnt = connection.prepareStatement("insert into publication(DTYPE, photoLibelle, photoPath, title, owner_id) " + "values(?,?,?,?,?)");
        	System.out.println("***********************************7");
        	psmnt.setString(1,"");
        	System.out.println("***********************************77");
        	psmnt.setString(2,"mahendra");
        	System.out.println("***********************************8");
	        psmnt.setString(5,"1");
	        System.out.println("***********************************9");
	        psmnt.setString(4,"Delhi");
            System.out.println("***********************************10");
            fis = new FileInputStream(image);
            System.out.println("***********************************11");
            psmnt.setBinaryStream(3, (InputStream)fis, (int)(image.length()));
            System.out.println("***********************************12");
            int s = psmnt.executeUpdate();
            System.out.println("***********************************13");
            if(s>0)
            {
            	System.out.println("***********************************14");
            	System.out.println("Uploaded successfully !");
            }
            else
            { System.out.println("***********************************15");
            	System.out.println("unsucessfull to upload image.");
            }
            System.out.println("***********************************16");
        }
        catch (Exception ex)
        {
        	System.out.println("Found some error : "+ex);
        }
        finally
        {
        	connection.close();
            psmnt.close();
        }
    }
}
