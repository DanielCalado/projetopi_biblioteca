/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.DAO;


import br.com.bibliotecasj.Model.Frequencia;
import br.com.bibliotecasj.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aluno
 */
public class FrequenciaDAO implements DAOGenerico<Frequencia>{
 
    public static FrequenciaDAO instance;
    public FrequenciaDAO(){
    
} 
    public static FrequenciaDAO getInstance(){
        if(instance == null){
            instance = new FrequenciaDAO();
        }
        return instance;
    }
    @Override
    public void salvar(Frequencia fre) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(fre);
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
    public void alterar(Frequencia fre) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(fre);
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
    public Frequencia buscar(String cpf) {
      Session sessao = HibernateUtil.getSessionFactory().openSession();
     Frequencia fre = null;
     try{
        
         Query consulta = sessao.getNamedQuery("frequencia.BuscarCpf");
         consulta.setString("cpf", cpf);
         fre = (Frequencia) consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return fre; 
     }

    @Override
    public void deletar(String fre) {
      Session sessao = HibernateUtil.getSessionFactory().openSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     Frequencia frequencia = buscar(fre);
     sessao.delete(frequencia);
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
    public List<Frequencia> listarTodos() {
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     List<Frequencia> fre = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("Frequencia.listar");
         fre = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return fre; 
    }
}