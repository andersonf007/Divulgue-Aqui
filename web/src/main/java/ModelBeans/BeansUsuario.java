/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBeans;

/**
 *
 * @author ander
 */
public class BeansUsuario {
    
    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private long pesquisarPorId;
    private String pesquisarPorNome;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the pesquisarPorId
     */
    public long getPesquisarPorId() {
        return pesquisarPorId;
    }

    /**
     * @param pesquisarPorId the pesquisarPorId to set
     */
    public void setPesquisarPorId(long pesquisarPorId) {
        this.pesquisarPorId = pesquisarPorId;
    }

    /**
     * @return the pesquisarPorNome
     */
    public String getPesquisarPorNome() {
        return pesquisarPorNome;
    }

    /**
     * @param pesquisarPorNome the pesquisarPorNome to set
     */
    public void setPesquisarPorNome(String pesquisarPorNome) {
        this.pesquisarPorNome = pesquisarPorNome;
    }
    
}
