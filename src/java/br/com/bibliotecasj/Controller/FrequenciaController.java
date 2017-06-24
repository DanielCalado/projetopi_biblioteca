/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Controller;

import br.com.bibliotecasj.Model.Frequencia;
import br.com.bibliotecasj.DAO.FrequenciaDAO;
import br.com.bibliotecasj.DAO.UsuarioDAO;
import br.com.bibliotecasj.Model.Usuario;
import br.com.bibliotecasj.util.Messages;
import static com.sun.faces.facelets.util.Path.context;
import java.util.Date;
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
public class FrequenciaController{
    
private Frequencia frequencia = new Frequencia();
public FrequenciaController(){
 
    }


    public void salvar(Frequencia fre) {
        try{
        fre.setData(new Date());
        fre.setHora(new Date());
        Usuario usuExiste = UsuarioDAO.getInstance().buscar(fre.getCpf());
        if(usuExiste != null){
         fre.setUsuario(usuExiste);
        }
        FrequenciaDAO.getInstance().salvar(fre);
        frequencia = new Frequencia();
        Messages.getInstance().adicionarMensagem(null, "Frequencia registrada!", FacesMessage.SEVERITY_INFO);
    
        }catch(Exception ex){
            
        }
   
    }
     public void alterar(Frequencia fre) {
        try{
        fre.setData(new Date());
        fre.setHora(new Date());
        Usuario usuExiste = UsuarioDAO.getInstance().buscar(fre.getCpf());
        if(usuExiste != null){
         fre.setUsuario(usuExiste);
        }
        FrequenciaDAO.getInstance().alterar(fre);
        frequencia = new Frequencia();
        Messages.getInstance().adicionarMensagem(null, "Frequencia registrada!", FacesMessage.SEVERITY_INFO);
    
        }catch(Exception ex){
            
        }
   
    }
    public void excluir(){
        FrequenciaDAO.getInstance().deletar(this.frequencia.getCpf());
        frequencia = new Frequencia();
        Messages.getInstance().adicionarMensagem(null, "Excluida com sucesso!", FacesMessage.SEVERITY_INFO);
    
    }

    public void consultar(String cpf) {
        this.frequencia = FrequenciaDAO.getInstance().buscar(cpf);

    }

    public List<Frequencia> consultarTodos() {
        return FrequenciaDAO.getInstance().listarTodos();
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }
   

  

}

