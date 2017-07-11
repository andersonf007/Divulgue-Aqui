
package entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @authxor Izaquias
 */

@Entity
public class Administrador implements Serializable{
  
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, nullable = false, unique = true)
  private String nome;
  @Column(length = 50, nullable = false, unique = true)
  private String email;
  @Column(length = 50, nullable = false)
  private String senha;
  
//  @Column(name="nomeUsuario",length = 50, nullable = false, unique = true)
//  private String usuario;

    public Administrador() {
        
    }

    public Administrador(Long id, String nome, String email, String senha) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("O nome do administrador deve ser preenchido!");
        }
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException("o e-mail do administrador deve ser preenchido!");
        }
        if(senha == null || senha.isEmpty()){
            throw new IllegalArgumentException("A senha do administrador deve ser preenchida!");
        }
        this.id = id;
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

}
