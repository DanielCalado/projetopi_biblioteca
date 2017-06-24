/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.DAO;
import java.util.List;


public interface DAOGenerico<T> {

    public void salvar(T t);
    
    public void alterar(T t);
    
    public T buscar(String c);

    public void deletar(String usu);

    public List<T> listarTodos();

}
