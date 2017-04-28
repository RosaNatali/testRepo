package com.esprit.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.Photo;
import entities.Publication;
import entities.User;
import services.userManagement.UserManagementRemote;

@WebServlet("/pages/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,	// 2MB
				 maxFileSize=1024*1024*10,		// 10MB
				 maxRequestSize=1024*1024*50)	// 50MB
public class UploadServlet extends HttpServlet {

	/**
	 * Name of the directory where uploaded files will be saved, relative to
	 * the web application directory.
	 */
	private static final String SAVE_DIR = "uploadFiles";
	
	private List<Publication> lps;
	
	@EJB
	private UserManagementRemote umr;

	/**
	 * handles file upload
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*
		System.out.println("**********************************************************************UPLOAD LL");
		// gets absolute path of the web application
		String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;

		
		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		if (fileSaveDir.exists()) {
			
			System.out.println("--------------------------------------------LOL1: " + fileSaveDir.getAbsolutePath());
			System.out.println("--------------------------------------------LOL2: " + fileSaveDir.getCanonicalPath());
		}
*/
		//********************************************************************************************************************************
				File f = new File("C:\\PHOTOS");
		    	try{
		    	    if(f.mkdir()) { 
		    	    	System.out.println("---------------------------------LOL: " + f.getAbsolutePath());
		    	        System.out.println("Directory Created");
		    	    } else {
		    	        System.out.println("Directory is not created");
		    	    }
		    	} catch(Exception e){
		    	    e.printStackTrace();
		    	}
		//********************************************************************************************************************************
		    	
		
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			// refines the fileName in case it is an absolute path
			fileName = new File(fileName).getName();
			String path = f.getAbsolutePath()+ "\\" + fileName;
			System.out.println("-------------------------------------------AAAAA: " + path);
			
//			part.write(File.separator + fileName);
			part.write(path);
			
			/********************************************************/
			Publication publication = new Publication();
			User user = new User();
			user = umr.findUserById(1);

			publication.setOwner(user);
			publication.setTitle("aaa");
			umr.createPublicationByUser(1, publication);
			
			Publication p = umr.findPublicationById(1);
			
			Photo photo = new Photo();
			photo.setPhotoLibelle(fileName);
			photo.setPhotoPath(path);
			photo.setPublication(p);
			umr.createPhoto(photo);

//			lps = umr.findPublicationsByUser(userId);
			
		}

		request.setAttribute("message", "Upload has been done successfully!");
		getServletContext().getRequestDispatcher("/pages/publication.xhtml").forward(request, response);
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
}