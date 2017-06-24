/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Controller;


import br.com.bibliotecasj.Model.Login;
import br.com.bibliotecasj.DAO.LoginDAO;
import br.com.bibliotecasj.Model.Usuario;

import br.com.bibliotecasj.util.Criptografia;
import br.com.bibliotecasj.util.Messages;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@SessionScoped
public class ControllerLoginLogado {

    private Login usuarioLogado = null;

    public ControllerLoginLogado() {
    }

    public String validaLogin(String login, String senha){

        Login clienteTeste;
        //Consulta se existe um cliente cadastrado para o Login informado.
        clienteTeste = LoginDAO.getInstance().buscar(login);
        if (clienteTeste == null) {
            Messages.getInstance().adicionarMensagem(null, "Erro ao efetuar Login! Confira o login ea senha", FacesMessage.SEVERITY_ERROR);
            return null;
             
        } else {
            if (clienteTeste.getSenha().equals(Criptografia.criptografar(senha))) {
                this.usuarioLogado = clienteTeste;
                //Inclui o cliente na sessão.
                Messages.getInstance().adicionarMensagem(null, "Login efetuado com sucesso!", FacesMessage.SEVERITY_INFO);
                Messages.getInstance().adicionarMensagem(null, "Bem Vindo! " + usuarioLogado.getLogin(), FacesMessage.SEVERITY_INFO);
            
                return "index.xhtml";
            } else {
                Messages.getInstance().adicionarMensagem(null, "Senha incorreta", FacesMessage.SEVERITY_ERROR);
            
                return null;
            }
        }
    }
    public void alterar(Login log) {
        
        try{
        Login novo = LoginDAO.getInstance().buscar(log.getLogin());
        log.setSenha(Criptografia.criptografar(log.getSenha()));
        if(novo == null){
        LoginDAO.getInstance().alterar(log);
       usuarioLogado = new Login();
        
        Messages.getInstance().adicionarMensagem(null, "Cadastro alterado com sucesso!", FacesMessage.SEVERITY_INFO);
  
        }else{
           Messages.getInstance().adicionarMensagem(null, "Login já cadastrado!", FacesMessage.SEVERITY_WARN);
     
 }
        }catch(Exception ex){
            
        }
    }
    
    public String excluir() {
        LoginDAO.getInstance().deletar(this.usuarioLogado.getLogin());
      usuarioLogado = new Login();
        Messages.getInstance().adicionarMensagem(null, "Excluido com sucesso!", FacesMessage.SEVERITY_WARN);
     return "Login.xhtml";
    }
    public String logout() {
        //Retira o cliente da sessão.
        this.usuarioLogado = null;
        return "Login.xhtml";
    }

    public Login getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Login usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

}
