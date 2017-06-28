package entidade;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquias
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Publicacao.consultarPorUsuario",
            query = "SELECT p FROM Publicacao p "
            + " WHERE p.usuario.id = :usuarioId")
})
public class Publicacao implements Serializable {

    
   

    private static final long serialVersionUID = 1L;
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;
    
    @Expose
    @Column(length = 50, nullable = true)
    private String categoria;
    
    @Expose
    @Column(length = 50, nullable = false)
    private String localidade;
    
    @Expose
    @Temporal(TemporalType.DATE)
    @Column
    private Date data = Date.from(Instant.now());
    
    @Expose
    @Column(nullable = false)
    private String descricao;
    
    @Expose
    @Column(length = 10, nullable = true)
    private String status;
    
    @JoinColumn(name="idUsuario",updatable=false)
    @ManyToOne
    private Usuario usuario;
    
    public Publicacao() {
    }

    public Publicacao(String categoria, String localidade, Date data, String descricao, String status) {

        if (categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("Informe a categoria que melhor se enquadra o problema, insira a informação!");
        }
        if (localidade == null || localidade.isEmpty()) {
            throw new IllegalArgumentException("Informe a localidade atual do problema corretamente!");
        }
        if (data == null || data.before(data)) {
            throw new IllegalArgumentException("Data não resgistrada, de ser informada!");//melhorar
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Informe uma descrição do problema a ser divulgado!");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Informe uma descrição do problema a ser divulgado!");
        }
       
        this.categoria = categoria;
        this.localidade = localidade;
        this.descricao = descricao;
      //  this.usuarios = usuarios;//Ver se não dará complicações futuras! 
        this.data = data;
        this.status = status;
       
    }
    
        public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
}
