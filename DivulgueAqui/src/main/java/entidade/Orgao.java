package entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Izaquias
 */
@Entity
public class Orgao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String senha;

    @OneToMany//(cascade = CascadeType.MERGE)
    private Collection<Publicacao> publicacao = new ArrayList<>();

    public Orgao() {
    }

    public Orgao(String nome, String senha, Collection<Publicacao> publicacao) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Informe o nome do orgão responsável!");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Informe o endereço de instalção onde o orgão se localiza!");
        }
        if (publicacao == null || publicacao.isEmpty()) {
            throw new IllegalArgumentException("Impossível enviar publicações, pois ainda não foram inseridas!");
        }

        this.nome = nome;
        this.senha = senha;
        this.publicacao = publicacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Collection<Publicacao> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Collection<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }

}
