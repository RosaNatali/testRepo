package com.esprit.utils;

import java.sql.*;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author javaknowledge
 */
@ManagedBean
@SessionScoped
public class TableBeanPhoto {

    private String imageID;
    private String imageName;
    private String path;
    private String publicationTitle;
    private Integer ownerId;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageLength() {
        return imageLength;
    }

    public void setImageLength(String imageLength) {
        this.imageLength = imageLength;
    }
    private String imageLength;

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
    
    
    public String getPublicationTitle() {
		return publicationTitle;
	}

	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}

	public Integer getOwnerId() {
		return ownerId;
	}
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	Connection MySQLcon = null;
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public List<TableBeanPhoto> getAllImage() {
        List<TableBeanPhoto> imageInfo = new ArrayList<TableBeanPhoto>();
        Connection con = Database.getConnection();
        try {
            stmt = con.createStatement();
            String strSql = "select photoId, photoLibelle, photoPath, id from photo order by photoId";
            
            //System.err.println("*select all***" + strSql);
            rs = stmt.executeQuery(strSql);
            while (rs.next()) {
                TableBeanPhoto tbl = new TableBeanPhoto();
                tbl.setImageID(rs.getString("photoId"));
                tbl.setImageName(rs.getString("photoLibelle"));
                
                String s = rs.getString("photoPath");
                String path2 = s.replaceAll("\\\\", "/");
                tbl.setPath(path2);
                
                tbl.setOwnerId(rs.getInt("id"));
                imageInfo.add(tbl);
            }
        } catch (SQLException e) {
            System.out.println("Exception in getAllImage::" + e.getMessage());
        }
        return imageInfo;
    }
}