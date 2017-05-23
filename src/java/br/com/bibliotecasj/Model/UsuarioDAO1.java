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
 import br.com.bibliotecasj.Model.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jose Junio
 */
public class UsuarioDAO1 implements DAOGenerico<Usuario> {
    public static UsuarioDAO1 instance;
    private UsuarioDAO1(){
    
} 
    public static UsuarioDAO1 getInstance(){
        if(instance == null){
            instance = new UsuarioDAO1();
        }
        return instance;
    }
     /**public SessionFactory abrirSession() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        return factory;
    }*/

    @Override
    public void create(Usuario t) {
        Session session = BancoMysqlDAO.getInstance().abrirSession().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Usuario t) {
       Session session = BancoMysqlDAO.getInstance().abrirSession().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Usuario read(String consul) {
        Session session = BancoMysqlDAO.getInstance().abrirSession().openSession();
        List<Usuario> usuarios = readALL();
        Usuario usu = null;

        for (int i = 0; i < usuarios.size(); i++) {

            if (consul.equals(usuarios.get(i).getCpf())) {
                usu = usuarios.get(i);
            }
        }
       
        session.close();
        return usu;

    }

    @Override
    public void delete(String consult) {
        Session session = BancoMysqlDAO.getInstance().abrirSession().openSession();
        session.beginTransaction();
        List<Usuario> usuarios = readALL();
        Usuario usu = null;

        for (int i = 0; i < usuarios.size(); i++) {

            if (consult.equals(usuarios.get(i).getCpf())) {
                usu = usuarios.get(i);
            }
        }
        session.delete(usu);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Usuario> readALL() {
        Session session = BancoMysqlDAO.getInstance().abrirSession().openSession();
        Query consulta = session.createQuery("from Usuario");
        List<Usuario> usuarios = consulta.list();
        session.close();
        return usuarios;
    }

}