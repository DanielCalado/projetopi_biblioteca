/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20161d13gr0031
 */
package br.com.bibliotecasj.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BancoMysqlDAO {

    private static BancoMysqlDAO instance; 
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private BancoMysqlDAO() {
        this.sessionFactory = abrirSession();
    }

    public static  BancoMysqlDAO getInstance() {

        if (instance == null) {
            instance = new BancoMysqlDAO();
        }
        return instance;
    }

    public SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }
    public static Session iniciarTrasacao(){
        Session session = getInstance().abrirSession().openSession();
        session.beginTransaction();
        return session;
    }
    public static Session fecharTransacao(Session session){
        session.getTransaction().commit();
        session.close();
        return session;
    }
/*
    public SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }
      public void create(G g){
        Session session = abrirSession().openSession();
        session.beginTransaction();
        session.save(g);
        session.getTransaction().commit();
        session.close();
    }*/


    
}
