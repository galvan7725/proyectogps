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
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;





import javax.inject.Named;
import org.primefaces.PrimeFaces;

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
    
    public void leerID(Personas per) throws Exception{
       PersonasDao dao;
       Personas p;
        try {
            dao= new PersonasDao();
            p =dao.LeerId(per);
            if(p != null){
                System.out.println("Leer Id "+p.getId_persona());
        personas = p;
              
                    System.out.println(String.valueOf(p.getNombre()));
                
            }else{
                System.out.println("Id nulo");
            }
            
            //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje:", "Cambio exitoso");
            //PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (Exception e) {
        throw e;
        }
               
      }
    
    public void registrar() throws Exception{
        PersonasDao dao;
        try {
            dao= new PersonasDao();
            dao.insertar(personas);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje:", "Ingreso Exitoso: Persona");
         
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (Exception e) {
        throw e;
        }
    }
    
}
