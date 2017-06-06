



import dao.OrgaosDao;
import dao.PublicacoesDao;
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
        OrgaosDao o2 = new OrgaosDao();
        PublicacoesDao p2 = new PublicacoesDao();
        
        UsuarioEntidade u = new UsuarioEntidade();
        
        PublicacaoEntidade pb = new PublicacaoEntidade();

        OrgaoEntidade o = new OrgaoEntidade();
        
        PessoaEntidade p = new PessoaEntidade();
        //Ao inserir, altere os valores para não ficar com valores repetidos  no BD! 
        

        p.setNome("angela");
        p.setEndereco("Garanhuns");
        
       
        ///////////////////////////
       // u.setNome("pedhro");
       // u.setEmail("phedroEmail");
       // u.setSenha("001");
       // u.setId((long)52);
        
      
      // u.setId((long)1);
       ///////////////////////////
        pb.setCategoria("Serviços Públicos");
        pb.setDescricao("Falta de Iluminção pública.");
        pb.setLocalidade("Rua Correntes");
        //Date hoje = Date.from(Instant.now());
        //pb.setData(hoje);
        pb.getUsuario().add(u);
        //////////////////////
        
        o.setNome("jantar");
        o.setSenha("22078");
        //o.getPublicacao().add(pb);
        ///////////////////////
        manager.getTransaction().begin();
        // manager.persist(p);
        // u2.recuperar((long)52);
        // u2.alterar(u);
        // u2.remover(u);
        // u2.inserir(u);
        // u2.recuperar((long)201);
        // System.out.println(u2.getNome());
        //manager.persist(u);
        
        o2.inserir(o);
        
        
        //manager.persist(pb);
        //manager.persist(o);
        manager.getTransaction().commit();
        manager.close();
    }
}
