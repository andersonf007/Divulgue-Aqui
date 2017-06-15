package entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquias
 */
@Entity
public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;
    @Column(length = 50, nullable = false)
    private String categoria;
    @Column(length = 50, nullable = false)
    private String localidade;
    @Temporal(TemporalType.DATE)
    @Column
    private Date data = Date.from(Instant.now());
    ;
    @Column(length = 100, nullable = false)
    private String descricao;
    @Column(length = 10, nullable = false)
    private String status;
    @OneToMany//(cascade = CascadeType.MERGE)
    private Collection<Usuario> usuarios = new ArrayList<>();

    //Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;
    
    public Publicacao() {
    }

    public Publicacao(String categoria, String localidade, Date data, String descricao, Collection<Usuario> usuarios, String status) {

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
        if (usuarios == null || usuarios.isEmpty()) {
            throw new IllegalArgumentException("Usuário não registrado, impossível publicar a respeito!");
        }
        this.categoria = categoria;
        this.localidade = localidade;
        this.descricao = descricao;
        this.usuarios = usuarios;//Ver se não dará complicações futuras! 
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

    public Collection<Usuario> getUsuario() {
        return usuarios;
    }

    public void setUsuario(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
