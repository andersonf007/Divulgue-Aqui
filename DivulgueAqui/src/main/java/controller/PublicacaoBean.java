
package controller;

import dao.PublicacoesDao;
import entidade.PublicacaoEntidade;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Izaquias
 */
@ViewScoped

@ManagedBean(name = "publicacaoBean")
public class PublicacaoBean implements Controller{

    private PublicacaoEntidade publicacao;
    private PublicacoesDao dao;

    
    public void iniciar(){
        publicacao = new PublicacaoEntidade();
        dao = new PublicacoesDao();
    }
    
    public PublicacaoBean() {
    }

    public PublicacaoEntidade getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(PublicacaoEntidade publicacao) {
        this.publicacao = publicacao;
    }

    public PublicacoesDao getDao() {
        return dao;
    }

    public void setDao(PublicacoesDao dao) {
        this.dao = dao;
    }
    
    @Override
    public String salvar() {
        dao.inserir(publicacao);
        return "";
    }

    @Override
    public String atualizar() {
        dao.alterar(publicacao);
        return "";
    }

    @Override
    public String deletar() {
        dao.remover(publicacao);
        return "";
    }

    @Override
    public PublicacaoEntidade buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<PublicacaoEntidade> listarTodos() {
        return dao.recuperarTodos();
    }
    
}
