
package com.github.izaquias.divulgueaquiweb.model;

import java.io.Serializable;
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
public class Orgao implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 35, nullable = false)
    private String nome;
    @Column(length = 40, nullable = false)
    private String endereco;
    
    @OneToMany
    private List<Problema> problemas;

    public Orgao() {
    }

    public Orgao( String nome, String endereco, List<Problema> problemas) {
        
        this.nome = nome;
        this.endereco = endereco;
        this.problemas = problemas;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }
    
}
