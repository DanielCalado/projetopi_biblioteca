 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Controller;

import br.com.bibliotecasj.Model.Endereco;
import br.com.bibliotecasj.Model.Usuario;
import br.com.bibliotecasj.Model.UsuarioDAO1;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
*
* @author Jose Junio
*/

@ManagedBean
@RequestScoped
public class UsuarioBean {
    
    private Usuario usuario = new Usuario();
    
public UsuarioBean(){
 
    }


    public void salvar(Usuario usu) {
        
        UsuarioDAO1.getInstance().create(usu);
        
        usuario = new Usuario();
    }
 
    public void excluir() {
        UsuarioDAO1.getInstance().delete(this.usuario.getCpf());
        usuario = new Usuario();
    }

    public void alterar() {
        
        this.setUsuario(usuario);
        UsuarioDAO1.getInstance().update(this.usuario);
        usuario = new Usuario();
    }

    public void consultar(String cpf) {
        this.usuario = UsuarioDAO1.getInstance().read(cpf);

    }

    public List<Usuario> consultarTodos() {
        return UsuarioDAO1.getInstance().readALL();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   

  

}
