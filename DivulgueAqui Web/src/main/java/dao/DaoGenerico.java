
package dao;

import excecao.TransacaoException;
import java.util.List;

/**
 *
 * @author Izaquias
 * @param <T>
 */
public interface DaoGenerico<T> {
    
    public void inserir(T t)  throws TransacaoException;
    public void alterar(T t)  throws TransacaoException;
    public void remover(T t)  throws TransacaoException;
    public T recuperar(Long chave)  throws TransacaoException;
    public List<T> recuperarTodos()  throws TransacaoException;
    
}
