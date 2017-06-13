package controller;

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

    public Orgao orgaoLogin;
    public OrgaoDao daoOrgao;
    private String nome;
    private String senha;
    public LoginBean() {
        
    }
    @PostConstruct
    public void Inicializar() {
        orgaoLogin = new Orgao();
        daoOrgao = new OrgaoDao();
    }
    
    public String fazerLogin() {
        String redireciona = "";
        
        Orgao o = daoOrgao.recuperarOrgaoUsuarioSenha(nome, senha);
        
        if(o != null){
            this.setOrgaoLogado(o);
            redireciona = "menuOrgao.xhtml";
        }else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login", "Email ou senha invalidos"));
            }
        
        return redireciona;
    }
    
    public String fazerLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "fazerLogin.xhtml";

    }
    
    private void setOrgaoLogado(Orgao o){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("OrgaoLogado",o);
    }
    
    public boolean VerificaOrgaoLogado(){
        Orgao o = (Orgao) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("OrgaoLogado");
        return o != null;
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
