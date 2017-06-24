/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.main;

import br.com.bibliotecasj.DAO.FrequenciaDAO;
import br.com.bibliotecasj.DAO.LoginDAO;
import br.com.bibliotecasj.DAO.UsuarioDAO;
import br.com.bibliotecasj.Model.Frequencia;
import br.com.bibliotecasj.Model.Login;
import br.com.bibliotecasj.Model.Usuario;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class UsuarioDAOteste {
   public static void main(String[] args){
       FrequenciaDAO log = new FrequenciaDAO();
       log.deletar("111.111.111-11");
   }}
     /*  Login log = new Login();
       log.setLogin("daniel");
       log.setSenha("ffffs");
       LoginDAO dao = new LoginDAO();
       dao.alterar(log);
   }
   }
       FrequenciaDAO dao = new FrequenciaDAO();
        Frequencia usu = dao.buscar("111.111.111-11");
        ;
       
        System.out.println(usu);
      
    }}
         FrequenciaDAO dao = new FrequenciaDAO();
        
        dao.deletar("111.111.111-11");
   }}
    Frequencia fre = new Frequencia();
        fre.setDescricao("danieffdldd");
        fre.setCpf("111.111.222.22");
        fre.setData(new Date());
        fre.setHora(new Date());
        Usuario usuExiste = UsuarioDAO.getInstance().buscar(fre.getCpf());
        if(usuExiste != null){
         fre.setUsuario(usuExiste);
        }
        FrequenciaDAO dao = new FrequenciaDAO();
        dao.salvar(fre);
    }}
     public static void main(String[] args){
        Usuario usu = new Usuario();
        usu.setCpf("111.111.222.22");
       UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(usu);
    }
}
   
        
        
    public static void main(String[] args){
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usu = dao.readALL();
        
        for(Usuario usuario : usu){
            System.out.println(usuario);
        }
    }
    public static void main(String[] args){
       
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usu = dao.read(null);
        Usuario usu2 = dao.read("ffff");
       
        System.out.println(usu);
        System.out.println(usu2);
    }
     public static void main(String[] args){
       
        UsuarioDAO dao = new UsuarioDAO();
        
        dao.deletar("ffff");
}}*/
