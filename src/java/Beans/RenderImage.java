/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.Database;
import Util.Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author galva
 */

    public class RenderImage extends HttpServlet {
    private static final long serialVersionUID = 4593558495041379083L;
 
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Statement stmt = null;
        ResultSet rs;
        InputStream sImage;
        try {
 
            String id = request.getParameter("Image_id");
            System.out.println("inside servlet–>" + id);
            Conexion conn= new Conexion();
            Connection con = conn.getConexion();
            stmt = con.createStatement();
            String strSql = "select image from upload_image where image_id='" + id + "' ";
            rs = stmt.executeQuery(strSql);
            if (rs.next()) {
                byte[] bytearray = new byte[1048576];
                int size = 0;
                sImage = rs.getBinaryStream(1);
                response.reset();
                response.setContentType("image/jpeg");
                while ((size = sImage.read(bytearray)) != -1) {
                    response.getOutputStream().
                            write(bytearray, 0, size);
                }
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

