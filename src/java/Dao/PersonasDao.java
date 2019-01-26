/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Personas;
import Model.Usuarios_vista;
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
public class PersonasDao {

    public List<Personas> listar() throws SQLException {
        List<Personas> lista;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "select * from personas;";
            System.out.println("sql usuarios");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Personas per = new Personas();
                per.setId_persona(rs.getInt("id_persona"));
                per.setNombre(rs.getString("nombre"));
                per.setaPaterno(rs.getString("aPaterno"));
                per.setaMaterno(rs.getString("aMaterno"));
                per.setFechaNac(rs.getString("fechaNac"));
                per.setTelefono(rs.getString("telefono"));

                lista.add(per);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public void isertar(Personas per) throws Exception {
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            String sql = "insert into personas (nombre,aPaterno,aMaterno,fechaNac,telefono) values (?,?,?,?,?);";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getaPaterno());
            ps.setString(3, per.getaMaterno());
            ps.setString(4, per.getFechaNac());
            ps.setString(5, per.getTelefono());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }

    }

    public Personas LeerId(Personas per) throws Exception {

        Personas pe = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        String sql = "select * from personas where id_persona = ?;";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
        pe = new Personas();
        
        }
        
    }

}
