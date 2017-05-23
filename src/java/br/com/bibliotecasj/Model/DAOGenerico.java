/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bibliotecasj.Model;
import java.util.List;


public interface DAOGenerico<T> {

    public void create(T t);

    public void update(T t);

    public T read(String c);

    public void delete(String txt);

    public List<T> readALL();

}
