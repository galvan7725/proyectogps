/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Usuario;
import Util.UserClass;
import java.io.Serializable;
import javafx.scene.paint.Color;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author galva
 */

@Named(value = "userBean")
@SessionScoped
public class userBean implements Serializable{
    
    private String foto;
    private String datos;
    private String nombre;
    private int id;
    private  String  arr[]= new String[3];
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public void inicializarDatos(){
        
       loginBean l = new loginBean();
       UserClass u = new UserClass();
        try {
            arr = u.UserData((int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id"));
             this.foto= (arr[0]);
             this.datos= arr[1];
             this.nombre = arr[2];
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public String pruebaColor(){
    
    return "#8e44ad";
    }
    
    
    
}
