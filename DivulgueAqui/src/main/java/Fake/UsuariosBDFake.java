/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fake;

import dao.DaoGenerico;
import entidade.UsuarioEntidade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Izaquias
 */
public final class UsuariosBDFake implements DaoGenerico<UsuarioEntidade>{

    
    private final Map<String, UsuarioEntidade> tabela = new HashMap<>();

    public UsuariosBDFake() {
         this.inserir(new UsuarioEntidade("izaquias cavalcante", "izaquiascavalcante@gmail.com", "izaquias20"));
    }
    
    
    @Override
    public void inserir(UsuarioEntidade user) {
        this.tabela.put(user.getNome(), user);
    }

    @Override
    public void alterar(UsuarioEntidade user) {
        this.tabela.containsValue(user);//Analizar com mais calma esse método!
    }

    @Override
    public void remover(UsuarioEntidade user) {
       this.tabela.remove(user.getNome(), user);
    }

    @Override
    public UsuarioEntidade recuperar(Long chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioEntidade> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
