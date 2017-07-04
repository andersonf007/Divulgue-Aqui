package controller;

import dao.AdministradorDao;
import entidade.Administrador;
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
@ManagedBean(name="administradorBean")
public class AdministradorBean implements Controller, Serializable{
    private static final long serialVersionUID = -6254703512368138279L;
    

    private Administrador administrador;
    private AdministradorDao dao;
    //private Criptografia criptografia;

    public AdministradorBean() {
    
    }
    @PostConstruct
    public void iniciar(){
        administrador = new Administrador();
        dao = new AdministradorDao();
    }
    
    @Override
    public String salvar() {
        //ver como vai ficar a criptografia aqui!
        administrador.setSenha(Criptografia.encriptografar(administrador.getSenha()));
        System.out.println("Criptografando senha!!!");
        dao.inserir(administrador);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Adminitrador " + administrador.getNome() + " foi cadastrado com sucesso!"));
        this.administrador = new Administrador();
        return "menuOrgao.xhtml";
    }

    @Override
    public String atualizar() {
         administrador.setSenha(Criptografia.encriptografar(administrador.getSenha()));
         dao.alterar(administrador);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orgao " + administrador.getNome() + " dados atualizados com sucesso!"));
         this.administrador = new Administrador();
         return "menuOrgao.xhtml";
    }

    @Override
    public String deletar() {
        dao.remover(administrador);
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orgao " + administrador.getNome() + " dados removidos com sucesso!"));
        //this.administrador = new Administrador();
        return "menuOrgao.xhtml";
    }

    @Override
    public Administrador buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<Administrador> listarTodos() {
        return dao.recuperarTodos();
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public AdministradorDao getDao() {
        return dao;
    }

    public void setDao(AdministradorDao dao) {
        this.dao = dao;
    }

}
