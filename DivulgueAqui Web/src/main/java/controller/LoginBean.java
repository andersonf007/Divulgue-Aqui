package controller;


import dao.AdministradorDao;
import entidade.Administrador;
import dao.OrgaoDao;
import entidade.Orgao;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Izaquias
 */

@ManagedBean(name = "LoginBean")
@SessionScoped

public class LoginBean {


    private String nome;
    private String senha;
    private Administrador admin;
    private AdministradorDao daoAdmin;
    private Orgao orgaoLogin;
    private OrgaoDao daoOrgao;

    public LoginBean() {
        
    }
    @PostConstruct
    public void Inicializar() {
        daoAdmin = new AdministradorDao();
        admin = new Administrador();
        orgaoLogin = new Orgao();
        daoOrgao = new OrgaoDao();
    }
    
    public String fazerLogin() {

        
        String redireciona = "";
        
         Administrador a = daoAdmin.buscarAdminPorNomeSenha(nome, senha);
        
        if (a != null) {
        
            this.setAdminLogado(a);
                 
                FacesContext.getCurrentInstance().addMessage
                (null, new FacesMessage("O administrador " + a.getNome() + " logado com sucesso!"));
                 redireciona = "menuOrgao.xhtml";//?faces-redirect=true
        
        }else{ 
            
        Orgao o = daoOrgao.recuperarOrgaoUsuarioSenha(nome, senha);
        
        if(o != null){
           this.setOrgaoLogado(o);
            redireciona = "menuAdmim.xhtml?faces-redirect=true";
        }
         else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login", "Email ou senha invalidos"));
            }
        }
        return redireciona;
    }
    
    public String fazerLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "fazerLogin.xhtml?faces-redirect=true";

    }
    
    private void setOrgaoLogado(Orgao o){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("OrgaoLogado",o);
    }
    
    public boolean VerificaOrgaoLogado(){
        Orgao o = (Orgao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("OrgaoLogado");
        return o != null;
    }


    private void setAdminLogado(Administrador a){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("AdminLogado", a);
    }
    
    public boolean  verificarAdminLogado(){
        Administrador a = (Administrador) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AdminLogado");
        return a != null;
    }
    
    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public AdministradorDao getDaoAdmin() {
        return daoAdmin;
    }

    public void setDaoAdmin(AdministradorDao daoAdmin) {
        this.daoAdmin = daoAdmin;
    }
    
    public Orgao getOrgaoLogin() {
        return orgaoLogin;
    }

    public void setOrgaoLogin(Orgao orgaoLogin) {
        this.orgaoLogin = orgaoLogin;
    }

    public OrgaoDao getDaoOrgao() {
        return daoOrgao;
    }

    public void setDaoOrgao(OrgaoDao daoOrgao) {
        this.daoOrgao = daoOrgao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
