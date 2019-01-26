/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.PersonasDao;
import Model.Personas;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author galva
 */
@Named(value="personasBean")
@ViewScoped
public class personasBean implements Serializable{
    private List<Personas> lstPersonas;
    private Personas personas = new Personas();

    public List<Personas> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Personas> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }
    
    public List<Personas> listar() throws Exception {
   
        PersonasDao dao;
        try {
            dao = new PersonasDao();
            this.lstPersonas=dao.listar();
            return lstPersonas;
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
