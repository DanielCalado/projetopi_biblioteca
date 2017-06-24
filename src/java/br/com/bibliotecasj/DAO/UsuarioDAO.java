/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.DAO;

import br.com.bibliotecasj.Model.Usuario;
import br.com.bibliotecasj.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO implements DAOGenerico<Usuario>{
 
    public static UsuarioDAO instance;
    public UsuarioDAO(){
    
} 
    public static UsuarioDAO getInstance(){
        if(instance == null){
            instance = new UsuarioDAO();
        }
        return instance;
    }
    @Override
    public void salvar(Usuario usu) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(usu);
     sessao.getTransaction().commit();
     
    }catch (RuntimeException ex){
        if(transacao != null){
            //desfaz a transacao
            transacao.rollback();
        }
    }finally{
         sessao.close();
     }
    }
    @Override
    public void alterar(Usuario usu) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(usu);
     sessao.getTransaction().commit();
     
    }catch (RuntimeException ex){
        if(transacao != null){
            //desfaz a transacao
            transacao.rollback();
        }
    }finally{
         sessao.close();
     }
    }
    
    @Override
    public Usuario buscar(String cpf) {
      Session sessao = HibernateUtil.getSessionFactory().openSession();
     Usuario usu = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Usuario.BuscarCpf");
         consulta.setString("cpf", cpf);
         usu = (Usuario) consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return usu; 
     }

    @Override
    public void deletar(String usu) {
      Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     Usuario usuario = buscar(usu);
     sessao.delete(usuario);
     sessao.getTransaction().commit();
     
    }catch (RuntimeException ex){
        if(transacao != null){
            transacao.rollback();
        }
    }finally{
         sessao.close();
     }
    }
    

    @Override
    public List<Usuario> listarTodos() {
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     List<Usuario> usu = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("Usuario.listar");
         usu = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return usu; 
    }
}
