package controller;


import dao.AdministradorDao;
import entidade.Administrador;
import dao.OrgaoDao;
import dao.UsuarioDao;
import entidade.Orgao;
import entidade.Usuario;
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
    private String email;
    private Administrador admin;
    private AdministradorDao daoAdmin;
    private Usuario usuario;
    private UsuarioDao daoUsuario;
    private Orgao orgao;
    private OrgaoDao daoOrgao;

    public LoginBean() {
        
    }
    @PostConstruct
    public void Inicializar() {
        daoAdmin = new AdministradorDao();
        admin = new Administrador();
        orgao = new Orgao();
        daoOrgao = new OrgaoDao();
        usuario = new Usuario();
        daoUsuario = new UsuarioDao();
    }
    
    public String fazerLogin() {

        
        String redireciona = "";
        
         Administrador a = daoAdmin.buscarAdminPorNomeSenha(nome, senha);
         
        if (a != null) {
        
            this.setAdminLogado(a);
                 
                FacesContext.getCurrentInstance().addMessage
                (null, new FacesMessage("O administrador " + a.getNome() + " logado com sucesso!"));
                 redireciona = "menuOrgao.xhtml";//?faces-redirect=true
        
        }
        
        else{ 
            
//        Orgao o = daoOrgao.recuperarOrgaoUsuarioSenha(nome, senha);
//        
//        if(o != null){
//           this.setOrgaoLogado(o);
//            redireciona = "menuAdmim.xhtml?faces-redirect=true";
//        }
        Usuario u = daoUsuario.buscarUsuarioPorNomeSenha(nome, senha);
        if(u != null){
            this.setUsuarioLogado(u);
            FacesContext.getCurrentInstance().addMessage
                (null, new FacesMessage("O usuario " + u.getNome() + " logado com sucesso!"));
            redireciona = "menuUsuario.xhtml";//
        } 
            
         else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login", "Nome ou senha invalidos"));
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
    
    public void setUsuarioLogado(Usuario u){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UsuarioLogado",u);
    }
    
    public boolean verificarUsuarioLogado(){
        Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UsuarioLogado");
        return u != null;    
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
    
    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public OrgaoDao getDaoOrgao() {
        return daoOrgao;
    }

    public void setDaoOrgao(OrgaoDao daoOrgao) {
        this.daoOrgao = daoOrgao;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(UsuarioDao daoUsuario) {
        this.daoUsuario = daoUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
