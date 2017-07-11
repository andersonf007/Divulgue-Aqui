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

    public AdministradorBean() {
    
    }
    @PostConstruct
    public void iniciar(){
        administrador = new Administrador();
        dao = new AdministradorDao();
    }
    
    @Override
    public String salvar() {
        
        administrador.setSenha(Criptografia.encriptografar(administrador.getSenha()));
        dao.inserir(administrador);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrador " + administrador.getNome() + " foi registrado com sucesso!"));
        this.administrador = new Administrador();
        return "menuAdmin.xhtml";
    }

    @Override
    public String atualizar() {
         Administrador a = (Administrador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AdminLogado");
        
         dao.alterar(a);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administador " + a.getNome() + " atualizou seus registros com sucesso!"));
         this.administrador = new Administrador();
         return "menuAdmin.xhtml";
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
