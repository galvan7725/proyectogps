/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author galva
 */
public class Herramientas {
    
     public int getLastIdPersonas() throws SQLException{
        Conexion conn = new Conexion();
            Connection con = conn.getConexion();
         Object[] datos = new Object[6];
         int id;
    try{
        PreparedStatement ps = null;
            ResultSet rs = null;
            
            
            String sql = "select * from personas ORDER BY id_persona desc;";
            System.out.println("sql usuarios");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            for(int i=0;i<1;i++){
                
                datos[0]=rs.getInt("id_persona");
                datos[1]=rs.getString("nombre");
                datos[2]=rs.getString("aPaterno");
                datos[3]=rs.getString("aMaterno");
                datos[4]=rs.getString("fechaNac");
                datos[5]=rs.getString("telefono");
            }
            
            id=Integer.parseInt(String.valueOf(datos[0]));
            
//            while(rs.next()){
//            Usuarios u = new Usuarios();
//            u.setId(rs.getInt("id"));
//            u.setId_persona(rs.getInt("id_persona"));
//            u.setId_rol(rs.getInt("id_rol"));
//            u.setClave(rs.getString("clave"));
//            u.setFoto(rs.getBytes("foto"));
//            u.setEstado_fk(rs.getInt("estado_fk"));
//            
//            lista.add(u);
//            }

   
return id;
    }catch(SQLException e){
    throw e;
    }finally{
    con.close();
    }
        
    }
    
}
