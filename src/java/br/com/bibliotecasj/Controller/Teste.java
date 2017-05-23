/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Controller;
import br.com.bibliotecasj.Model.Endereco;
import java.util.Date;
import br.com.bibliotecasj.Model.Usuario;
import java.util.ArrayList;
import java.util.List;



public class Teste {
    
    public static void main(String[] ags){
   
        UsuarioBean usuario = new UsuarioBean();
        
        Usuario usu = null;
        Endereco end = null;
        
        Usuario a;
        Endereco b;
        
         b = new Endereco(1, "RUA", 54, "PLANALTO", "SAO JOAO", "PE", "55555");
        
        a = new Usuario("dani", null, "f", "1111-111", "3232", "dani@gmail.com", "medio", b);
        usuario.salvar(a);
       
    /** b = new Usuario("alan",null,"m",null,"981572591","aluno@gmail.com",10,"medio",null);
     usuario.salvar(b);
     c = new Usuario("carlos",null,"m","123.432.167-43","981572591","aluno@gmail.com",10,"superior",null);
     usuario.salvar(c);
    d = new Usuario("ana",null,"f",null,"981572591","aluno@gmail.com",10,"superior",null);
     usuario.salvar(d);
     */
    }  
}
