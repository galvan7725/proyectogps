/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuarios;
import Util.Conexion;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galva
 */
public class UsuariosDao {

public List<Usuarios> listar() throws SQLException{
    List<Usuarios> lista;
    try {
        PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            
            String sql = "select * from usuarios;" ;
            System.out.println("sql usuarios");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            lista= new ArrayList();
            
            while(rs.next()){
            Usuarios u = new Usuarios();
            u.setId(rs.getInt("id"));
            u.setId_persona(rs.getInt("id_persona"));
            u.setId_rol(rs.getInt("id_rol"));
            u.setClave(rs.getString("clave"));
            u.setFoto(rs.getBytes("foto"));
            u.setEstado_fk(rs.getInt("estado_fk"));
            
            lista.add(u);
            }
            return lista;
    } catch (Exception e) {
    throw e;
    }

}

 public void Insertar(Usuarios us,int id_persona, InputStream imagen, long tamaño) throws Exception{
    
        try {
        PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            String sql = "insert into usuarios values (?,?,?,?,?,?);";
            System.out.println(sql);
           
            ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, id_persona);
            ps.setInt(3, us.getId_rol());
            ps.setString(4, us.getClave());
            ps.setBinaryStream(5, imagen, tamaño);
            ps.setInt(6, us.getEstado_fk());           
            ps.executeUpdate();
            

        } catch (Exception e) {
            throw e;
        }finally{
        
        }
    }
    
}
