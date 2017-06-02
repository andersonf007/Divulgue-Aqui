
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
    private String endereco;
    
    @OneToMany
    private Collection<PublicacaoEntidade> problemas = new ArrayList<>();

    public OrgaoEntidade() {
    }

    public OrgaoEntidade( String nome, String endereco, Collection<PublicacaoEntidade> problemas) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Informe o nome do orgão responsável!");
        }
        if(endereco == null || endereco.isEmpty()){
            throw new IllegalArgumentException("Informe o endereço de instalção onde o orgão se localiza!");
        }
        if(problemas == null || problemas.isEmpty()){
            throw new IllegalArgumentException("Impossível enviar publicações, pois ainda não foram inseridas!");
        }
        
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

    public Collection<PublicacaoEntidade> getProblemas() {
        return problemas;
    }

    public void setProblemas(Collection<PublicacaoEntidade> problemas) {
        this.problemas = problemas;
    }
    
}

