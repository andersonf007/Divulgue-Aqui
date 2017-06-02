
package entidade;

import excecoes.UsuarioMenorDeIdadeException;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Izaquias
 */
@Entity
public class UsuarioEntidade implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//add 50+ 
    private long id;
    @Column(length = 50, nullable = false, unique = true)
    private String nome;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false)
    private String senha;
    
    public UsuarioEntidade() {
    }

    
    public UsuarioEntidade( String nome, String email, String senha) {
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

    public long getId() {
        return id;
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

}
