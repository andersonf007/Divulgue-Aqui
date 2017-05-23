
package com.github.izaquias.divulgueaquiweb.dao;

import java.util.List;

/**
 *
 * @author Izaquias
 * @param <T>
 */
public interface DaoGenerico<T> {
    
    public void inserir(T t);
    public void alterar(T t);
    public void remover(T t);
    public T recuperar(Long chave);
    public List<T> recuperarTodos();
    
}
