package controller;

import dao.OrgaoDao;
import entidade.Orgao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Izaquias
 */
@ViewScoped

@ManagedBean(name = "orgaoBean")
public class OrgaoBean implements Controller {

    private OrgaoDao dao;
    private Orgao orgao;

    public OrgaoBean() {
    }

    @PostConstruct
    public void inicializar() {
        orgao = new Orgao();
        dao = new OrgaoDao();
    }

    @Override
    public String salvar() {
        dao.inserir(orgao);
        orgao = new Orgao();
        return "index.xhtml";
    }

    @Override
    public String atualizar() {
        dao.alterar(orgao);
        orgao = new Orgao();
        return "index.xhtml";
    }

    @Override
    public String deletar() {
        dao.remover(orgao);
        return "index.xhtml";
    }

    @Override
    public Orgao buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<Orgao> listarTodos() {
        return dao.recuperarTodos();
    }

    public OrgaoDao getDao() {
        return dao;
    }

    public void setDao(OrgaoDao dao) {
        this.dao = dao;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

}
