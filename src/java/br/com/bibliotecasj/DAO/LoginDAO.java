/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.DAO;

import br.com.bibliotecasj.DAO.DAOGenerico;
import br.com.bibliotecasj.Model.Login;
import br.com.bibliotecasj.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aluno
 */
public class LoginDAO implements DAOGenerico<Login>{
 
    public static LoginDAO instance;
    public LoginDAO(){
    
} 
    public static LoginDAO getInstance(){
        if(instance == null){
            instance = new LoginDAO();
        }
        return instance;
    }
    @Override
    public void salvar(Login log) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(log);
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
    public void alterar(Login log) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(log);
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
    public Login buscar(String login) {
      Session sessao = HibernateUtil.getSessionFactory().openSession();
     Login log = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Login.Buscarlog");
         consulta.setString("login", login);
         log = (Login) consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return log; 
     }

    @Override
    public void deletar(String log) {
      Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     Login login = buscar(log);
     sessao.delete(login);
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
    public List<Login> listarTodos() {
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     List<Login> log = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("Login.listar");
         log = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return log; 
    }
}
