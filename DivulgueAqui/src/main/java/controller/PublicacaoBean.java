package controller;

import dao.PublicacaoDao;
import entidade.Publicacao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

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
        dao.alterar(publicacao);
        publicacao = new Publicacao();
        return "index.xhtml";
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
