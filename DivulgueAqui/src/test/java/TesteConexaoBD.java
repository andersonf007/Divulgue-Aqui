



import dao.UsuariosDao;
import hibernate.HibernateUtil;
import entidade.OrgaoEntidade;
import entidade.PessoaEntidade;
import entidade.PublicacaoEntidade;
import entidade.UsuarioEntidade;
import java.time.Instant;
import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TesteConexaoBD {
    
    static EntityManager manager;
    
     public static void main(String[] horaDoShow){
        
    
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
    
        UsuariosDao u2 = new UsuariosDao();
        UsuarioEntidade u = new UsuarioEntidade();
        
        PublicacaoEntidade pb = new PublicacaoEntidade();

        OrgaoEntidade o = new OrgaoEntidade();
        
        PessoaEntidade p = new PessoaEntidade();
        //Ao inserir, altere os valores para não ficar com valores repetidos  no BD! 
        

        p.setNome("angela");
        p.setEndereco("Garanhuns");
        
       
        ///////////////////////////
        u.setNome("jhdfgyhgghghghghhjg");
        u.setEmail("izghghghgquerfgias@gmail.com");
        u.setSenha("izaqsdaguias21");
        u.setId(52);
      
       ///////////////////////////
        pb.setCategoria("Serviços Públicos");
        pb.setDescricao("Falta de Iluminção pública.");
        pb.setLocalidade("Rua Correntes");
        //Date hoje = Date.from(Instant.now());
        //pb.setData(hoje);
        pb.getUsuario().add(u);
        //////////////////////
        
        o.setNome("Prefeitura");
        o.setEndereco("Rua Camilo Fonseca, Centro nº 220");
        o.getProblemas().add(pb);
        ///////////////////////
        manager.getTransaction().begin();
        //manager.persist(p);
        u2.alterar(u);
        //manager.persist(u);
        
        //manager.persist(pb);
        //manager.persist(o);
        manager.getTransaction().commit();
        manager.close();
    }
}
