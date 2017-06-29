/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fake;

import dao.DaoGenerico;
import entidade.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Izaquias
 */
public final class UsuariosBDFake implements DaoGenerico<Usuario>{

    
    private final Map<String, Usuario> tabela = new HashMap<>();

    public UsuariosBDFake() {
         this.inserir(new Usuario(1L,"izaquias cavalcante", "izaquiascavalcante@gmail.com", "izaquias20",""));
    }
    
    
    @Override
    public void inserir(Usuario user) {
        this.tabela.put(user.getNome(), user);
    }

    @Override
    public void alterar(Usuario user) {
        this.tabela.containsValue(user);//Analizar com mais calma esse método!
    }

    @Override
    public void remover(Usuario user) {
       this.tabela.remove(user.getNome(), user);
    }

    @Override
    public Usuario recuperar(Long id) {
       Usuario u =  this.tabela.get(id);
       return u;
    }

    @Override
    public List<Usuario> recuperarTodos() {
        //List<Usuarios> u = this.tabela.keySet();
        return null;
    }
    
}
