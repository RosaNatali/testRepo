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
public class TableBean {

    private String imageID;
    private String imageName;
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

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	Connection MySQLcon = null;
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public List<TableBean> getAllImage() {
        List<TableBean> imageInfo = new ArrayList<TableBean>();
        Connection con = Database.getConnection();
        try {
            stmt = con.createStatement();
            String strSql = "select id, photoLibelle, title, owner_id from publication order by id ";
            //System.err.println("*select all***" + strSql);
            rs = stmt.executeQuery(strSql);
            while (rs.next()) {
                TableBean tbl = new TableBean();
                tbl.setImageID(rs.getString("id"));
                tbl.setImageName(rs.getString("photoLibelle"));
                tbl.setPublicationTitle(rs.getString("title"));
                tbl.setOwnerId(rs.getInt("owner_id"));
                imageInfo.add(tbl);
            }
        } catch (SQLException e) {
            System.out.println("Exception in getAllImage::" + e.getMessage());
        }
        return imageInfo;
    }
}