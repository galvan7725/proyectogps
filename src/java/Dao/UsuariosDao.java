/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Usuarios;
import Util.Conexion;
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
            
            String sql = "select * from vista_usuarios;" ;
            System.out.println("sql usuarios");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            lista= new ArrayList();
            
            while(rs.next()){
            Usuarios users = new Usuarios();
            users.setId(rs.getInt("id"));
            users.setNombre(rs.getString("nombre"));
            users.setaPaterno(rs.getString("aPaterno"));
            users.setaMaterno(rs.getString("aMaterno"));
            users.setFechaNac(rs.getString("fechaNac"));
            users.setDescrpcion(rs.getString("descrpcion"));
            users.setFoto(rs.getString("nombre"));
            users.setDescripcion(rs.getString("descripcion"));
            
            
            lista.add(users);
            }
            return lista;
        } catch (Exception e) {
        e.printStackTrace();
        }
        return null;
        
        
    }
    
}
