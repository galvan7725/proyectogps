/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import Util.MyUtil;
import Util.UserClass;

/**
 *
 * @author galva
 */
@ApplicationScoped
@Named(value = "appBean")
public class appBean {

    /**
     * Creates a new instance of appBean
     */
    loginBean l= new loginBean();
    private  int id= l.getRol();
    public appBean() {
        this.id= id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void prueba(){
    UserClass u = new UserClass();
    u.prueba2();
    }
    
    public String getBaseUrl(){
    return MyUtil.baseurl();
    }
    
    public String getBasePath(){
    return MyUtil.basepath();
    }
    
    public String getUsuarioActual() throws Exception{
   
    return MyUtil.usuario(1);
    }
    
    public String getBasePathLogin(){
    return MyUtil.login();
    }
    
    public String vistaInicio(){
        return MyUtil.vistas();
    }
    
}
