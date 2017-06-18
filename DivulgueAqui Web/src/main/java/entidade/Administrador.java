
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

    public Administrador() {
        
    }

    public Administrador(Long id, String nome, String email, String senha) {
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
