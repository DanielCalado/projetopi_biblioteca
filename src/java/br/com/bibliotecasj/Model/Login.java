/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author Aluno
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Login.listar", query = "SELECT login FROM Login login"),
@NamedQuery(name = "Login.Buscarlog", query = "SELECT login FROM Login login WHERE login.login = :login")
})
public class Login {
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String senha;

    public Login(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Login() {
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", login=" + login + ", senha=" + senha + '}';
    
    }
}
    

