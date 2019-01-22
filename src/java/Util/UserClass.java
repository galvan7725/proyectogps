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

/**
 *
 * @author galva
 */
public class UserClass {
    
    public String[] UserData(int id){
        int id2= id;
        String arr[] = new String [5];
        //primer valor : ombre de la imagen, segundo valor: Informacion del usuario
        String arr2[] = new String[3];
        String datos="";
        
        try {
            arr= consultaDatos(id2);
            for (int i = 0; i < 2; i++) {
                System.out.println("Dato ---> "+i+" : "+arr[i]);
            }
            datos=arr[1]+" , "+arr[4]+" .";
            arr2[0]=arr[1];
            arr2[1]= datos;
            arr2[2]= arr[1];
            return arr2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
      
    }
    
    
    private String[] consultaDatos(int id){
        try {
            
            
              PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "select id,nombre,aPaterno,aMaterno,descrpcion from vista_usuarios where id = "+id+ ";";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

           
          String resultado[] = new String[5];
          

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    resultado[i]=filas[i].toString();
                }
                //resultado[]=filas[];
                for(int j=0;j<resultado.length;j++){
                System.out.println("Resultado --->"+resultado[j]);
                //modelo.addRow(filas);
                }
                }
                
            if(resultado[0] != null){
            return resultado;
            }else{
            return null;
            }
            
        } catch (Exception e) {
        }
        
        
    return null;
    }
    
    public void prueba2 (){
        System.out.println("Boton salir 2----->");
    }
    
    
}
