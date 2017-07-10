package controller;

import dao.OrgaoDao;
import entidade.Orgao;
import hibernate.Criptografia;
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
        orgao.setSenha(Criptografia.encriptografar(orgao.getSenha()));
        dao.inserir(orgao);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orgao " + orgao.getNome() + " foi cadastrado com sucesso!"));
        orgao = new Orgao();
        return "menuAdmin.xhtml";
    }

    @Override
    public String atualizar() {
        Orgao o = (Orgao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("OrgaoLogado");
        dao.alterar(o);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orgao " + o.getNome() + " foi atualizado com sucesso!"));
        orgao = new Orgao();
        return "menuOrgao.xhtml";
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
