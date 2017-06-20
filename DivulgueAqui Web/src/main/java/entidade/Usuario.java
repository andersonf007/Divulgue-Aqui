
package entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Izaquias
 */
@Entity
public class Usuario implements Serializable{

    
    /**
     * @param id the id to set
     */
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//add 1++ 
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String nome;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false)
    private String senha;
    
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Collection<Publicacao> publicacao = new ArrayList<>();

    public Usuario() {
    }

    
    public Usuario( String nome, String email, String senha) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome do Usuário deve ser informado corretamente!");
        }
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("O email do Usuário deve ser preenchido corretamente!");
        }
        if(senha == null || senha.isEmpty()){
            throw new IllegalArgumentException("A senha do usuário deve ser informada corretamente!");
        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   /**
     * @return the publicacao
     */
    public Collection<Publicacao> getPublicacao() {
        return publicacao;
    }

    /**
     * @param publicacao the publicacao to set
     */
    public void setPublicacao(Collection<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }


}
