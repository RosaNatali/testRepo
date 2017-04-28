package com.esprit.utils;

import java.sql.*;
import java.io.*;
import java.nio.file.Files;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.*;
import javax.servlet.http.*;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import services.userManagement.UserManagementRemote;

/**
 *
 * @author javaknowledge
 */
public class DisplayPhoto extends HttpServlet {
	
	@EJB
	private UserManagementRemote umr;

    private static final long serialVersionUID = 4593558495041379082L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Statement stmt = null;
        ResultSet rs;
        InputStream sImage;
        try {

            String id = request.getParameter("Image_id");
            System.out.println("P---------------------------------------------------ID: " + id);

            Connection con = Database.getConnection();
            stmt = con.createStatement();
            String strSql = "select photoPath from photo where photoId='" + id + "' ";
            System.out.println("P---------------------------------------------------SQL1: " + strSql);
            System.out.println("P---------------------------------------------------SQL2: " + strSql.toString());
            
            rs = stmt.executeQuery(strSql);
            
            System.out.println("P---------------------------------------------------rs1: " + rs);
            System.out.println("P---------------------------------------------------rs2: " + rs.toString());
            
           
            int result = Integer.parseInt(id);
            
            String libelle = umr.findPhotoById(result).getPhotoLibelle();
            int libelleSize = libelle.length();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Libelle Size: " + libelleSize);
            String path = umr.findPhotoById(result).getPhotoPath();
            int pathSize = path.length();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Path Size: " + pathSize);
            String defaultPath = umr.findPhotoById(result).getPhotoPath().substring(0, pathSize-libelleSize);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ WOW: " + defaultPath);
            
            File filep = new File(defaultPath, libelle);
            response.setHeader("Content-Type", getServletContext().getMimeType(libelle));
            response.setHeader("Content-Length", String.valueOf(filep.length()));
            response.setHeader("Content-Disposition", "inline; filename=\"" + libelle + "\"");
            Files.copy(filep.toPath(), response.getOutputStream());
            
            
            
//            if (rs.next()) {
//                byte[] bytearray = new byte[1048576];
//                int size = 0;
//                sImage = rs.getBinaryStream(1);
//                response.reset();
//                response.setContentType("image/jpeg");
//                while ((size = sImage.read(bytearray)) != -1) {
//                    response.getOutputStream().
//                            write(bytearray, 0, size);
//                }
//            }
            
            
            
            
            
//            Connection con = Database.getConnection();
//            stmt = con.createStatement();
//            String strSql = "select photoPath from photo where photoId='" + id + "' ";
//            rs = stmt.executeQuery(strSql);
//            if (rs.next()) {
//                byte[] bytearray = new byte[1048576];
//                int size = 0;
//                sImage = rs.getBinaryStream(1);
//                response.reset();
//                response.setContentType("image/jpeg");
//                while ((size = sImage.read(bytearray)) != -1) {
//                    response.getOutputStream().
//                            write(bytearray, 0, size);
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public StreamedContent wow(String id) throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();

	   
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
//	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	    	
	    	
	    	int result = Integer.parseInt(id);
	    	
	    	String path = umr.findPhotoById(result).getPhotoPath();
	    	System.out.println("******************************************LLL: " + path.toString());
	    	
	    	System.out.println("--------------------------------------SAR1: " + path);
	    	System.out.println("--------------------------------------SAR2: " + path.toString());
	    	String lol = path.replaceAll("\\\\", "/");
	    	System.out.println("--------------------------------------XYZ1: " + lol);
	    	System.out.println("--------------------------------------XYZ2: " + lol.toString());
	        return new DefaultStreamedContent(new FileInputStream(new File(lol.toString())));
	    }
	
    
    
    
}