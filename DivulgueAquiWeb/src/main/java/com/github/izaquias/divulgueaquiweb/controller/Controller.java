
package com.github.izaquias.divulgueaquiweb.controller;

import java.util.List;

/**
 *
 * @author Izaquias
 */
public interface Controller {
    public String salvar();
    public String atualizar();
    public String deletar();
    public Object buscar(Long chave);
    public List listarTodos();
}
