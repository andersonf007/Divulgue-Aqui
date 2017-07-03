 
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário " + usuario.getNome() + " foi cadastrado com sucesso!"));
        usuario = new Usuario();
        return "menu.xhtml";//?faces-redirect=true
    }

    @Override
    public String atualizar() {
        usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
        dao.alterar(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário " + usuario.getNome() + "dodos foram atualizados com sucesso!"));
        usuario = new Usuario();
        return "index.xhtml";//?faces-redirect=true    
    }

    @Override
    public String deletar() {
        dao.remover(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados do Usuario foram removidos com sucesso!"));
        return "index.xhtml";//?faces-redirect=true        
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
    
    public void buscarUsuarioNome(String nome){
        dao.recuperarUsuarioNome(nome);
    } 
}
