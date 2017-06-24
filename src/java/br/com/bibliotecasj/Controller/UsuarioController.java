 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Controller;

import br.com.bibliotecasj.Model.Usuario;
import br.com.bibliotecasj.DAO.UsuarioDAO;
import br.com.bibliotecasj.util.Messages;
import static com.sun.faces.facelets.util.Path.context;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
*
* 
*/
@ManagedBean
@RequestScoped
public class UsuarioController{
    
private Usuario usuario = new Usuario();
public UsuarioController(){
 
    }


    public String salvar(Usuario usu) {
        try{
        Usuario novo = UsuarioDAO.getInstance().buscar(usu.getCpf());
        if(novo == null){
        UsuarioDAO.getInstance().salvar(usu);
        usuario = new Usuario();
        Messages.getInstance().adicionarMensagem(null, "Cadastro efetuado com sucesso!", FacesMessage.SEVERITY_INFO);
     return "ConsultarTodos.xhtml";
        }else{
           Messages.getInstance().adicionarMensagem(null, "CPF já cadastrado!", FacesMessage.SEVERITY_WARN);
     
 }
        }catch(Exception ex){
            
        }
    return null;
    }
    public String alterar(Usuario usu) {
        try{
        
        UsuarioDAO.getInstance().alterar(usu);
        usuario = new Usuario();
        Messages.getInstance().adicionarMensagem(null, "Cadastro alterado com sucesso!", FacesMessage.SEVERITY_INFO);
     return "ConsultarTodos.xhtml";
       
        }catch(Exception ex){
            
        }
    return null;
    }
    public void excluir(){
        UsuarioDAO.getInstance().deletar(this.usuario.getCpf());
        usuario = new Usuario();
    }

    public void consultar(String cpf) {
        this.usuario = UsuarioDAO.getInstance().buscar(cpf);

    }

    public List<Usuario> consultarTodos() {
        return UsuarioDAO.getInstance().listarTodos();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   

  

}

