/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Beans.appBean;
import Beans.userBean;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import org.apache.commons.codec.digest.DigestUtils;


/**
 *
 * @author galva
 */
public class loginClass {
    
    
    
    
    public Object[] login(String nombre ,String claveo, int rol) throws Exception{
        String texto=claveo;
        String encript=DigestUtils.shaHex(texto);
       
        Object[] obj = new Object[2]; 
        String [] res = new String[4];
        res= consultar_datos(nombre,encript,rol);
        if(res != null){
            obj[0] = true;
            obj[1] =res[0];
        return obj;
        }else{
             obj[0]= false;
             obj[1] =res[0];

        return obj;
        }
    }
    
    
     public String[] consultar_datos(String nombre, String clave, int rol) throws Exception{
       
                try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "call login('"+nombre+"','"+clave+"',"+rol+");" ;
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

           
          String resultado[] = new String[4];
          

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
                 Usuario u = new Usuario();
                 u.setId(Integer.parseInt(resultado[0]));
                 System.out.println("id --->"+String.valueOf(resultado[0]));
            return resultado;
            }else{
            return null;
            }
        } catch (Exception e) {
        throw e;
        }
       
    
    }
     
     public void prueba(){
    System.out.println("correcto");
    }
    
}
