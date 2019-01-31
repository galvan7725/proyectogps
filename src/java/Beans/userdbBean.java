/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author galva
 */
@Named(value="userdbBean")
@ViewScoped
public class userdbBean implements Serializable{
    private List<Usuarios> lstUsuarios;
    private Usuarios usuarios = new Usuarios();

    public List<Usuarios> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuarios> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    public void insertar()throws Exception{
    Usuarios dao;
        try {
            dao = new Usuarios();
            //
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
