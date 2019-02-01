/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.Personas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author galva
 */
public class verificarDuplicado {
 
    
    public boolean verificarPersona(Personas per) throws SQLException{
    Object[] data= new Object[6];
            data[0]=per.getId_persona();
            data[1]=per.getNombre();
            data[2]=per.getaPaterno();
            data[3]=per.getaMaterno();
            data[4]=per.getFechaNac();
            data[5]=per.getTelefono();
            
            if(resultado(data) > 1){
            return true;
            }else{
            return false;
            }
    }
    
    
    public int resultado(Object[] d) throws SQLException{
        int lastid=0;
        int cont=0;
        
         lastid=getLastId();
       Object[][] tabla = new Object[lastid][6];
       Conexion conn = new Conexion();
            Connection con = conn.getConexion();
        //Se rellena la tabla
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            
            String sql = "select * from personas ORDER BY id_persona desc;";
            System.out.println("sql usuarios");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int i=0;
            while(rs.next()){
           
                for (int j = 0; j < 6; j++) {
                    tabla[i][j]=rs.getObject(j+1);
                }
            i++;
            }
            //Fin del rellenado de la tabla, la tabla ya esta llena
            //Inicia la busqueda de campos iguales
            
            for(int y=0;y<lastid;y++){               
                    if(d[1].toString().equals(tabla[y][1].toString()) && d[2].toString().equals(tabla[y][2].toString()) && d[3].toString().equals(tabla[y][3].toString())){
                        cont ++;
                    }              
            }
            System.err.println("Numero de campos repetidos");
            return cont;
            
            
        } catch (SQLException e) {
            throw e;
        }
        
    }
    
    
    public int getLastId() throws SQLException{
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
