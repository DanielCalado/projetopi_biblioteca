/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Model;

import java.sql.Time;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aluno
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Frequencia.listar", query = "SELECT frequencia FROM Frequencia frequencia"),
@NamedQuery(name = "frequencia.BuscarCpf", query = "SELECT frequencia FROM Frequencia frequencia WHERE frequencia.cpf = :cpf")
})
public class Frequencia {
   
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String cpf;
    @Column
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date data;
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column
    private String descricao;
    @OneToOne(cascade=CascadeType.ALL)
    private Usuario usuario;

    public Frequencia(int id, String cpf, String nome, Date data, Date hora, String descricao, Usuario usuario) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    
    public Frequencia(){
        
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getHora() {
        return hora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
      
    
}
