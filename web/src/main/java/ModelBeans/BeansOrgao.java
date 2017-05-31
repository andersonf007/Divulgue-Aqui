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
public class BeansOrgao {
    
    private int codigo;
    private String nome;
    private String senha;
    private String pesquisaNome;
    private long pesquisarId;

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
     * @return the pesquisaNome
     */
    public String getPesquisaNome() {
        return pesquisaNome;
    }

    /**
     * @param pesquisaNome the pesquisaNome to set
     */
    public void setPesquisaNome(String pesquisaNome) {
        this.pesquisaNome = pesquisaNome;
    }

    /**
     * @return the pesquisarId
     */
    public long getPesquisarId() {
        return pesquisarId;
    }

    /**
     * @param pesquisarId the pesquisarId to set
     */
    public void setPesquisarId(long pesquisarId) {
        this.pesquisarId = pesquisarId;
    }
    
}
