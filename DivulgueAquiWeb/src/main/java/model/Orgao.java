
package model;

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
    private String senha;
    
    @OneToMany
    private List<Publicacao> publicacao;

    public Orgao() {
    }

    public Orgao( String nome, String senha, List<Publicacao> publicacao) {
        
        this.nome = nome;
        this.senha = senha;
        this.publicacao = publicacao;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Publicacao> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(List<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }
    
}
