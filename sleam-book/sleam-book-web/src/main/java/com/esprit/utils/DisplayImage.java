package com.esprit.utils;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author javaknowledge
 */
public class DisplayImage extends HttpServlet {

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
            System.out.println("IMG--------------------------------------------------- ID" + id);

            Connection con = Database.getConnection();
            stmt = con.createStatement();
            String strSql = "select photoPath from publication where id='" + id + "' ";
            System.out.println("IMG---------------------------------------------------SQL1: " + strSql);
            System.out.println("IMG---------------------------------------------------SQL2: " + strSql.toString());
            rs = stmt.executeQuery(strSql);
            System.out.println("IMG---------------------------------------------------rs1: " + rs);
            System.out.println("IMG---------------------------------------------------rs2: " + rs.toString());
            if (rs.next()) {
                byte[] bytearray = new byte[1048576];
                int size = 0;
                sImage = rs.getBinaryStream(1);
                response.reset();
                response.setContentType("image/jpeg");
               
                    response.getOutputStream().
                            write(bytearray, 0, size);
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}