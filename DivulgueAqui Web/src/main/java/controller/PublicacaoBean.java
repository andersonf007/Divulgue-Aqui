package controller;

import dao.PublicacaoDao;
import dao.UsuarioDao;
import entidade.Publicacao;
import entidade.Usuario;
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
@ManagedBean(name="publicacaoBean")
public class PublicacaoBean implements Controller, Serializable {
    private static final long serialVersionUID = 1L;

    private Publicacao publicacao;
    private PublicacaoDao daoPublicacao;
    private Usuario usuario;
    private UsuarioDao daoUsuario;

    public PublicacaoBean() {
    }

    @PostConstruct
    public void inicializar() {
        daoPublicacao = new PublicacaoDao();
        daoUsuario = new UsuarioDao();
        publicacao = new Publicacao();
        usuario = new Usuario();
    }

    @Override
    public String salvar() {
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        usuario = daoUsuario.recuperar(u.getId());
        publicacao.setUsuario(usuario);
        
        daoPublicacao.inserir(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Publicação salva com sucesso!"));
       
        publicacao = new Publicacao();
        return "menuUsuario.xhtml";
    }

    @Override
    public String atualizar() {
        daoPublicacao.alterar(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O status da publicação foi mudado para  " + publicacao.getStatus() + ", com sucesso!"));
        publicacao = new Publicacao();
        return "apresentaPublicacao.xhtml";
    }

    @Override
    public String deletar() {
        daoPublicacao.remover(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Publicação foi removida com sucesso!"));
        return "apresentaPublicacao.xhtml";
    }

    @Override
    public Publicacao buscar(Long id) {
        return daoPublicacao.recuperar(id);
    }

    @Override
    public List<Publicacao> listarTodos() {
        return daoPublicacao.recuperarTodos();
    }
    
    public List publicacaoUsuario(Long id){
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        return daoPublicacao.consultarPorUsuario(u.getId());
    }
    public PublicacaoDao getDaoPublicacao() {
        return daoPublicacao;
    }

    public void setDaoPublicacao(PublicacaoDao daoPublicacao) {
        this.daoPublicacao = daoPublicacao;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(UsuarioDao daoUsuario) {
        this.daoUsuario = daoUsuario;
    }
    
}
