
package model.entidade;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquias
 */
@Entity
//@Converter(autoApply = true)
public class PublicacaoEntidade implements Serializable{

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private long id;
    @Column(length = 50, nullable = false)
    private String categoria;
    @Column(length = 50, nullable = false)
    private String localidade;
    @Temporal(TemporalType.DATE)
    @Column
    private Date data = Date.from(Instant.now());;
    @Column(length = 100, nullable = false)
    private String descricao;
    @Column(length = 10, nullable = false )
    private String status;
    @OneToMany
    private Collection<UsuarioEntidade> usuarios = new ArrayList<>();;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;//Fazer o devido relacionamento ORM!
    //private List<Usuario> usuarios;
    
    public PublicacaoEntidade() {
    }

    public PublicacaoEntidade(String categoria, String localidade,Date data, String descricao, Collection<UsuarioEntidade> usuarios, String status) {
        
        if(categoria == null || categoria.isEmpty()){
            throw new IllegalArgumentException("Informe a categoria que melhor se enquadra o problema, insira a informação!");
        }
        if(localidade == null || localidade.isEmpty()){
            throw new IllegalArgumentException("Informe a localidade atual do problema corretamente!");
        }
        if(data == null || data.before(data)){
            throw new IllegalArgumentException("Data não resgistrada, de ser informada!");//melhorar
        }
        if(descricao == null || descricao.isEmpty()){
            throw new IllegalArgumentException("Informe uma descrição do problema a ser divulgado!");
        }
        if(usuarios == null || usuarios.isEmpty()){
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

    public Collection<UsuarioEntidade> getUsuario() {
        return usuarios;
    }

    public void setUsuario(Collection<UsuarioEntidade> usuarios) {
        this.usuarios = usuarios;
    }
}
