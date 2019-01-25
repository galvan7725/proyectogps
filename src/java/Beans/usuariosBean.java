/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.Usuarios_vistaDao;
import Model.Usuarios_vista;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;



import javax.inject.Named;

/**
 *
 * @author galva
 */
@Named(value="usuariosBean")
@ViewScoped
public class usuariosBean implements Serializable{
    
    private List<Usuarios_vista> lstUsuarios;
    private Usuarios_vista usuarios = new Usuarios_vista();

    public List<Usuarios_vista> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuarios_vista> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public Usuarios_vista getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios_vista usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Usuarios_vista> listar() throws Exception {
    
        Usuarios_vistaDao dao;
        try {
            dao = new Usuarios_vistaDao();
            this.lstUsuarios=dao.listar();
            return lstUsuarios;
            
        } catch (Exception e) {
            throw e;
        }
        
    }
}
