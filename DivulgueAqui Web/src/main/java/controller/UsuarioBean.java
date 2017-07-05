 
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
    public String salvar() {//Fazer validação no  Dao para freiar quando houver resgistro a ser duplicado no BD!
        usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
        dao.inserir(usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário " + usuario.getNome() + " foi cadastrado com sucesso!"));
        usuario = new Usuario();
        return "menu.xhtml";//?faces-redirect=true
    }

    @Override
    public String atualizar() {
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        u.setSenha(Criptografia.encriptografar(u.getSenha()));
        dao.alterar(u);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário " + u.getNome() + "dodos foram atualizados com sucesso!"));
        usuario = new Usuario();
        return "visualizaUsuario.xhtml";//?faces-redirect=true    
    }

    @Override
    public String deletar() {//Validar: mandar mensagem para o usuário caso ele tenha publicações! 
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        dao.remover(u);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados do Usuario foram removidos com sucesso!"));
        return "menu.xhtml";//?faces-redirect=true//fazerLogin.xhtml        
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
