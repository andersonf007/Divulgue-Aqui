
package entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
public class OrgaoEntidade implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String senha;
    
    @OneToMany
    private Collection<PublicacaoEntidade> publicacao = new ArrayList<>();

    public OrgaoEntidade() {
    }

    public OrgaoEntidade( String nome, String senha, Collection<PublicacaoEntidade> publicacao) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Informe o nome do orgão responsável!");
        }
        if(senha == null || senha.isEmpty()){
            throw new IllegalArgumentException("Informe o endereço de instalção onde o orgão se localiza!");
        }
        if(publicacao == null || publicacao.isEmpty()){
            throw new IllegalArgumentException("Impossível enviar publicações, pois ainda não foram inseridas!");
        }
        
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

    public Collection<PublicacaoEntidade> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Collection<PublicacaoEntidade> publicacao) {
        this.publicacao = publicacao;
    }
    
}

