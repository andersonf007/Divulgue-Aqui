package controller;

import dao.PublicacaoDao;
import entidade.Publicacao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Izaquias
 */
@ViewScoped

@ManagedBean
public class PublicacaoBean implements Controller {

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
        publicacao = new Publicacao();
        return "index.xhtml";
    }

    @Override
    public String atualizar() {
        //Publicacao publicacao = buscar(getPublicacao().getId());
        dao.alterar(publicacao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O status da publicação foi mudado para  " + publicacao.getStatus() + "com sucesso!"));
        publicacao = new Publicacao();
        return "apresentaPublicacao.xhtml?faces-redirect=true";
    }

    @Override
    public String deletar() {
        dao.remover(publicacao);
        publicacao = new Publicacao();
        return "index.xhtml";
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
