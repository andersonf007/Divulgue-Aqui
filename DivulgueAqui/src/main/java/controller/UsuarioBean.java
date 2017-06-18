 
package controller;

import dao.UsuarioDao;
import entidade.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Izaquias
 */
@ViewScoped

@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Controller{
    
    private UsuarioDao dao;
    private Usuario usuario; 

    public UsuarioBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        usuario = new Usuario();
        dao = new UsuarioDao();
    }
    
    @Override
    public String salvar() {
        dao.inserir(usuario);
        usuario = new Usuario();
        return "index.xhtml?faces-redirect=true";
    }

    @Override
    public String atualizar() {
        dao.alterar(usuario);
        usuario = new Usuario();
        return "index.xhtml?faces-redirect=true";    
    }

    @Override
    public String deletar() {
        dao.remover(usuario);
        return "index.xhtml?faces-redirect=true";        
    }

    @Override
    public Usuario buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        return dao.recuperarTodos();
    }

    public UsuarioDao getDao() {
        return dao;
    }

    public void setDao(UsuarioDao dao) {
        this.dao = dao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
