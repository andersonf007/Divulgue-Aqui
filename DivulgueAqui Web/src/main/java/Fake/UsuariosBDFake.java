package Fake;

import dao.DaoGenerico;
import entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Izaquias
 */
public final class UsuariosBDFake implements DaoGenerico<Usuario>{
    
    List<Usuario> usuarios = new ArrayList<>();
    
    @Override
    public void inserir(Usuario usuario) {
        usuario.setId(usuarios.size() + 1L);
        this.usuarios.add(usuario);
    }

    @Override
    public void alterar(Usuario usuario) {
        for (Usuario u : usuarios) {
            if(Objects.equals(u.getId(), usuario.getId())){
                u = usuario;
            }
        }
    }

    @Override
    public void remover(Usuario usuario) {
        for (Usuario u : usuarios) {
            if(Objects.equals(u.getId(), usuario.getId())){
                usuarios.remove(u);
            } 
        }
    }

    @Override
    public Usuario recuperar(Long id) {
        Usuario u = null;
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getId(), id)) {
                u = usuario;
            }
        }
        return u;
    }

    @Override
    public List<Usuario> recuperarTodos() {
        return usuarios;
    }

}
