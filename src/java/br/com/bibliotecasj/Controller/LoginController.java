/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Controller;

import br.com.bibliotecasj.Model.Login;
import br.com.bibliotecasj.DAO.LoginDAO;
import br.com.bibliotecasj.util.Criptografia;
import br.com.bibliotecasj.util.Messages;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginController{
  
    private Login login = new Login();
    
public LoginController(){
 
    }


    public void salvar(Login log) {
        try{
        Login novo = LoginDAO.getInstance().buscar(log.getLogin());
        log.setSenha(Criptografia.criptografar(log.getSenha()));
        if(novo == null){
        LoginDAO.getInstance().salvar(log);
        login = new Login();
        
        Messages.getInstance().adicionarMensagem(null, "Cadastro efetuado com sucesso!", FacesMessage.SEVERITY_INFO);
  
        }else{
           Messages.getInstance().adicionarMensagem(null, "Login já cadastrado!", FacesMessage.SEVERITY_WARN);
     
 }
        }catch(Exception ex){
            
        }
    }
   
    public void consultar(String id) {
        this.login = LoginDAO.getInstance().buscar(id);

    }

    public List<Login> consultarTodos() {
        return LoginDAO.getInstance().listarTodos();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
   
  

}