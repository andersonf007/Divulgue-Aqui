
package controller;

import dao.OrgaosDao;
import entidade.OrgaoEntidade;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Izaquias
 */
@ViewScoped

@ManagedBean(name = "orgaoBean")
public class OrgaoBean implements Controller{

    private OrgaoEntidade orgao;
    private OrgaosDao dao;
    
    public void iniciar(){
        orgao = new OrgaoEntidade();
        dao = new OrgaosDao();
    }

    public OrgaoBean() {
    }

    public OrgaoEntidade getOrgao() {
        return orgao;
    }

    public void setOrgao(OrgaoEntidade orgao) {
        this.orgao = orgao;
    }

    public OrgaosDao getDao() {
        return dao;
    }

    public void setDao(OrgaosDao dao) {
        this.dao = dao;
    }
    
    @Override
    public String salvar() {
        dao.inserir(orgao);
        return "";
    }

    @Override
    public String atualizar() {
        dao.alterar(orgao);
        return "";
    }

    @Override
    public String deletar() {
        dao.remover(orgao);
        return "";
    }

    @Override
    public OrgaoEntidade buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<OrgaoEntidade> listarTodos() {
        return dao.recuperarTodos();
    }
    
}
