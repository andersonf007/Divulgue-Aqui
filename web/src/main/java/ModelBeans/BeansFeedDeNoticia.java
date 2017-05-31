/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBeans;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ander
 */
public class BeansFeedDeNoticia {
    
    private long codigo;
    private String localidade;
    private LocalDateTime data;
    private String descricao;
    private String categoria;
    private long IdUsuario;
    private long PesquisarPeloIdUsuario;

    public BeansFeedDeNoticia(long codigo, String localidade, LocalDateTime data, String descricao, String categoria, long IdUsuario) {
        this.codigo = codigo;
        this.localidade = localidade;
        this.data = LocalDateTime.now();
        this.descricao = descricao;
        this.categoria = categoria;
        this.IdUsuario = IdUsuario;
    }

    public BeansFeedDeNoticia(){}

    
    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * @param localidade the localidade to set
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * @return the data
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the IdUsuario
     */
    public long getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the PesquisarPeloIdUsuario
     */
    public long getPesquisarPeloIdUsuario() {
        return PesquisarPeloIdUsuario;
    }

    /**
     * @param PesquisarPeloIdUsuario the PesquisarPeloIdUsuario to set
     */
    public void setPesquisarPeloIdUsuario(long PesquisarPeloIdUsuario) {
        this.PesquisarPeloIdUsuario = PesquisarPeloIdUsuario;
    }
    
}
