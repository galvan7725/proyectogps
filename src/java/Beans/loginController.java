 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author galva
 */

@ManagedBean
@SessionScoped
public class loginController implements Serializable{
    
    public void verificarSesion(){
    String usuario;
        try {
           usuario =  (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           if(usuario == null){
           FacesContext.getCurrentInstance().getExternalContext().redirect("./../login.xhtml");
           }
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }
    
    public void borrarSession() throws IOException{
   FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hasta Luego", null ); 

        
    
    FacesContext.getCurrentInstance().getExternalContext().redirect("./../login.xhtml");
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
    }
    
    
}
