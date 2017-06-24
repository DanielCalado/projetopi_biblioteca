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

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
   import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
@NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
@NamedQuery(name = "Usuario.BuscarCpf", query = "SELECT usuario FROM Usuario usuario WHERE usuario.cpf = :cpf")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    
    private int id;
    @Column(length = 30)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date datanas;
    @Column(length = 10)
    private String sexo;
    @Column
    private String cpf;
    @Column
    private String telefone;
    @Column(length = 30)
    private String email;
    @Column(length = 30)
    private String ensino;
     @OneToOne(cascade=CascadeType.ALL)
    @NotNull
    private Endereco endereco;
   
    
    public Usuario(){
       this.endereco = new Endereco(); 
    }
    public Usuario( String nome, Date datanas, String sexo, String cpf, String telefone, String email, String ensino, Endereco endereco) {
        
        this.nome = nome;
        this.datanas = datanas;
        this.sexo = sexo;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.ensino = ensino;
        this.endereco = endereco;
         
    }

   

   

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setDatanas(Date datanas) {
        this.datanas = datanas;
    }

    public Date getDatanas() {
        return datanas;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEnsino(String ensino) {
        this.ensino = ensino;
    }

    public String getEnsino() {
        return ensino;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

 
    
}
