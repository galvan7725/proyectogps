/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.UsuariosDao;
import Model.Usuarios;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author galva
 */
@Named(value="usuariosBean")
@SessionScoped
public class usuariosBean {
    
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
    
    public List<Usuarios> listar() throws Exception {
    
        UsuariosDao dao;
        try {
            dao = new UsuariosDao();
            return lstUsuarios=dao.listar();
            
        } catch (Exception e) {
            throw e;
        }
        
    }
}
