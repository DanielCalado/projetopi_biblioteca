/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Model;

/**
 *
 * @author Aluno
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.Column;

@Entity
public class Login implements Serializable {
    @Id
    @Column(name="id", nullable=false, unique=true)
    private int id;
    @Column(name="userNome", nullable=false, unique=true)
    private String nomeUsuario;
    @Column(name="senha", nullable=false, unique=false)
    private String senha;
    @Column(name="UltAcesso", unique=true)
    @Temporal(TemporalType.DATE)
    private Date ultimoAcesso;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
    
    
}
