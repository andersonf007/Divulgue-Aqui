package controller;

import dao.PublicacaoDao;
import entidade.Publicacao;
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

    private PublicacaoDao dao;
    private Publicacao publicacao;

    public PublicacaoBean() {
    }

    @PostConstruct
    public void inicializar() {
        dao = new PublicacaoDao();
        publicacao = new Publicacao();
    }

    @Override
    public String salvar() {
        dao.inserir(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Publicação salva com sucesso!"));
       
        //FacesContext.getCurrentInstance().getExternalContext().getFlash().put(null, new FacesMessage("Publicação salva com sucesso!"));
        //FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        publicacao = new Publicacao();
        return "menu.xhtml";//?faces-redirect=true
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
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Publicação foi removida com sucesso!"));
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

}
