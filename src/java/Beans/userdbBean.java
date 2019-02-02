/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.UsuariosDao;
import Model.Usuarios;
import Util.Herramientas;
import Util.verificarDuplicado;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import Util.verificarDuplicado;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author galva
 */
@Named(value="userdbBean")
@ViewScoped
public class userdbBean implements Serializable{
    private List<Usuarios> lstUsuarios;
    private Usuarios usuarios = new Usuarios();
     private UploadedFile file;
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

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
    public void insertar()throws Exception{
    UsuariosDao dao;
        try {
//            dao = new UsuariosDao();
//            personasBean p= new personasBean();
//            verificarDuplicado v = new verificarDuplicado();
////
//            if(v.verificarPersona(p.getPersonas())){
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta:", "Ya existe un usuario con ese nombre");
//            PrimeFaces.current().dialog().showMessageDynamic(message);
//            }else{
//            p.insertar();
//            Herramientas h = new Herramientas();
//            int lastid= h.getLastIdPersonas();
//            if (file != null) {
//          
//                System.out.println(file.getFileName());
//                InputStream fin2 = file.getInputstream();
//                
//            dao.Insertar(usuarios,lastid, fin2, file.getSize() );
//                        
//                
//             
//        }
//        else{
//        FacesMessage msg = new FacesMessage("Please select image!!");
//                FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
//            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
}
