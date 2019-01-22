/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import Util.MyUtil;
import Util.loginClass;


/**
 *
 * @author galva
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

   
    private String usuario1;
    private String clave1;
    private int rol;
    private Object ob[] = new Object[2];
    private boolean acceso;
    private int id;

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public loginBean() {
       this.id= id;
       
    }



    public String getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(String usuario1) {
        this.usuario1 = usuario1;
    }

    public String getClave1() {
        return clave1;
    }

    public void setClave1(String clave1) {
        this.clave1 = clave1;
    }

    public int getRol() {
        return this.rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
    
    

    public void login(ActionEvent actionEvent) throws Exception {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean loggedIn;
        String ruta = "";

        //this.usuario = this.usuarioDao.login(this.usuario);
        loginClass a= new loginClass();
        ob=a.login(this.usuario1, this.clave1,this.rol);
        this.acceso = Boolean.parseBoolean(ob[0].toString());
        this.id = Integer.parseInt(ob[1].toString());
        if (this.acceso) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario1);
            loggedIn = true;
         
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario1);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", this.id);
            ruta = MyUtil.basepathlogin() + "views/Index.xhtml";
            
            
            
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "LoginError", "Usuario y/o clave incorrectas");
            
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }
    
    
    public void loggout(){
        System.out.println("Salir");
    String ruta= MyUtil.basepathlogin()+"login.xhtml";
    RequestContext context = RequestContext.getCurrentInstance();
    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession sesion =(HttpSession) facesContext.getExternalContext().getSession(false);
    sesion.invalidate();
    
    context.addCallbackParam("loggedOut", true);
    context.addCallbackParam("ruta", ruta);
    }
    
    public void submit() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    

}
