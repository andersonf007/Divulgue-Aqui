
package controller;

import dao.UsuariosDao;
import entidade.UsuarioEntidade;
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

    
    private UsuarioEntidade usuario;
    private UsuariosDao dao = null;
    
    @PostConstruct
    public void iniciar(){
        usuario = new UsuarioEntidade();
        dao = new UsuariosDao();
    }
    
    public UsuarioBean() {
      
    }

    public UsuarioEntidade getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntidade usuario) {
        this.usuario = usuario;
    }

    public UsuariosDao getDao() {
        return dao;
    }

    public void setDao(UsuariosDao dao) {
        this.dao = dao;
    }
    
    @Override
    public String salvar() {
        dao.inserir(usuario);
        return "";
    }

    @Override
    public String atualizar() {
        dao.alterar(usuario);
        return ""; 
    }

    @Override
    public String deletar() {
        dao.remover(usuario);
       return ""; 
    }

    @Override
    public UsuarioEntidade buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<UsuarioEntidade> listarTodos() {
        return dao.recuperarTodos();
    }
    
}
