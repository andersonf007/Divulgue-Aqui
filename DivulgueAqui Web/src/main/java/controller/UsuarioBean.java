 
package controller;

import dao.UsuarioDao;
import entidade.Usuario;
import hibernate.Criptografia;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Izaquias
 */

@SessionScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Controller, Serializable{
    private static final long serialVersionUID = -6707698940390690698L;
    
    
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
        usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
        dao.inserir(usuario);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(usuario.getNome() + " foi registrado com sucesso!"));
        usuario = new Usuario();
        return "menu.xhtml";
    }

    @Override
    public String atualizar() {
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        dao.alterar(u);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário " + u.getNome() + "seus registros foram atualizados com sucesso!"));
        usuario = new Usuario();
        return "visualizaUsuario.xhtml";    
    }

    @Override
    public String deletar() { 
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        dao.remover(u);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registros do Usuário foram removidos com sucesso!"));
        return "menu.xhtml";        
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
