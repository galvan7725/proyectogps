/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;


/**
 *
 * @author galva
 */
public class MyUtil {
 
    public static String baseurl(){
    return "http://localhost:8080/ProyectoGPS2.0/";
    }
    
    public static String basepathlogin(){
    return "/ProyectoGPS2.0/faces/";
    }
    
    //redireccion a las vistas
    
    public static String basepath(){
    return "/faces/views/";
    }
    
    public static String login(){
    return "/faces/";
    }
    
    public static String vistas(){
    return "views/";
    }
    
    public static String usuario(int id) throws Exception{
       String[] datos= new String[6];
       String Datos=null;
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "select id,nombre,aPaterno,aMAterno,fechaNac,descrpcion from vista_usuarios where id = "+id+" ;" ;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

           
          
          

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    datos[i]=filas[i].toString();
                }
                //resultado[]=filas[];
                for(int j=0;j<datos.length;j++){
                System.out.println("Resultado --->"+datos[j]);
                //modelo.addRow(filas);
                }
                }
            Datos="id: "+datos[0]+" ,Nombre: "+datos[1]+"  "+datos[2]+"  "+datos[3]+" ,FechaNacimiento: "+datos[4]+" ,Rol: "+datos[5];
            
        } catch (Exception e) {
        throw e;
        }finally{
        
        }
       
    return Datos;
    }
    
}
