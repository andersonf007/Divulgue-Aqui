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
    private PublicacaoDao dao;
    private Usuario usuario;
    private UsuarioDao daoUsuario;

    public PublicacaoBean() {
    }

    @PostConstruct
    public void inicializar() {
        dao = new PublicacaoDao();
        daoUsuario = new UsuarioDao();
        publicacao = new Publicacao();
        usuario = new Usuario();
    }

    @Override
    public String salvar() {//fazer validação pelo model
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        usuario = daoUsuario.recuperar(u.getId());
        publicacao.setUsuario(usuario);
        dao.inserir(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Publicação salva com sucesso!"));
       
        //FacesContext.getCurrentInstance().getExternalContext().getFlash().put(null, new FacesMessage("Publicação salva com sucesso!"));
        //FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        publicacao = new Publicacao();
        return "menuUsuario.xhtml";//?faces-redirect=true
    }

    @Override
    public String atualizar() {
        dao.alterar(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O status da publicação foi mudado para  " + publicacao.getStatus() + " com sucesso!"));
        publicacao = new Publicacao();
        return "apresentaPublicacao.xhtml";//?faces-redirect=true
    }

    @Override
    public String deletar() {
        dao.remover(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Publicação foi removida com sucesso!"));
        return "apresentaPublicacao.xhtml";//?faces-redirect=true
    }

    @Override
    public Publicacao buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<Publicacao> listarTodos() {
        return dao.recuperarTodos();
    }
    
    public List publicacaoUsuario(Long id){
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        return dao.consultarPorUsuario(u.getId());
    }
    public PublicacaoDao getDao() {
        return dao;
    }

    public void setDao(PublicacaoDao dao) {
        this.dao = dao;
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
