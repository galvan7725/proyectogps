/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author galva
 */
public class render {

    public byte[] getBytes(int id){
        
    Conexion conn = new Conexion();
    Connection con = conn.getConexion();
    ResultSet rs = conn.visualizar(id);
    
//    tabla.setDefaultRenderer(Object.class, new TablaImagen());
    
//    DefaultTableModel dt= new DefaultTableModel();
//    dt.addColumn("Nombre");
//    dt.addColumn("Foto");
        try {
             byte[] data= null;
            while(rs.next()){
            Object[] fila = new Object[1];
//            fila[0] = rs.getObject(2);
            Blob blob = rs.getBlob(1);
            data = blob.getBytes(1, (int)blob.length());
           BufferedImage img = null;
                try {
                    
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                ImageIcon icono = new ImageIcon(img);
                fila[1] = new JLabel(icono);
//                dt.addRow(fila);
            
            }
//            tabla.setModel(dt);
//            tabla.setRowHeight(64);
            return data;
        } catch (Exception e) {
        e.printStackTrace();
        }
        return null;
    }
    
}
