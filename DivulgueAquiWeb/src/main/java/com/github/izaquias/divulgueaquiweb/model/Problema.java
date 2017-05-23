
package com.github.izaquias.divulgueaquiweb.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Izaquias
 */
@Entity
public class Problema implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 35, nullable = false)
    private String categoria;
    @Column(length = 35, nullable = false)
    private String localidade;
    @Column(length = 8, nullable = false)//Se adicionar "hora" ocorrer um erro excesso não suportado de caracteres! 
    private LocalDate data;
    @Column(length = 35, nullable = false)
    private String descricao;
    @OneToMany
    private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!

    public Problema() {
    }

    public Problema(String categoria, String localidade, LocalDate data, String descricao, List<Usuario> usuarios) {
        
        this.categoria = categoria;
        this.localidade = localidade;
        this.data = LocalDate.now();//Verificar se, quando é passado o parâmetro "data" no construtor, faça ocorrer um erro! 
        this.descricao = descricao;
        this.usuarios = usuarios;
    }

    public long getId() {
        return id;
    }

    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Usuario> getUsuario() {
        return usuarios;
    }

    public void setUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
