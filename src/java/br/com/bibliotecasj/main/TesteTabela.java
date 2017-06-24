/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.main;

import br.com.bibliotecasj.util.HibernateUtil;

/**
 *
 * @author Aluno
 */
public class TesteTabela {
    
    public static void main(String[] args){
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}
