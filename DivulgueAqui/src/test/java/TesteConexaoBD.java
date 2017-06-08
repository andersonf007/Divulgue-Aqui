
import dao.OrgaoDao;
import dao.PessoaDao;
import dao.PublicacaoDao;
import dao.UsuarioDao;
import hibernate.HibernateUtil;
import entidade.Orgao;
import entidade.Pessoa;
import entidade.Publicacao;
import entidade.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TesteConexaoBD {
    
    static EntityManager manager;
    
     public static void main(String[] horaDoShow){
        
    
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
    
        //Daos
        UsuarioDao u2 = new UsuarioDao();
        OrgaoDao o2 = new OrgaoDao();
        PublicacaoDao p2 = new PublicacaoDao();
         PessoaDao ps = new PessoaDao();
        

        //Entity
        Usuario u = new Usuario();
        Publicacao pb = new Publicacao();
        Orgao o = new Orgao();
        Pessoa p = new Pessoa();
        
        //Ao inserir, altere os valores para não ficar com valores repetidos  no BD! 
        
        p.setNome("adones");
        p.setEndereco("imbécil");
        
        //ps.inserir(p);
       // ps.alterar(p);
       //ps.remover(p);
      //ps.recuperarTodos();
      //ps.recuperar(getId());
        
        
        
       
        ///////////////////////////

        u.setNome("adones");
        u.setEmail("adones@gmail.com");
        u.setSenha("sacopela22");
        
        //u2.inserir(u);
        //u2.alterar(u);
        //u2.remover(u);
        //u2.recuperarTodos();
        //u.setId(52);

       // u.setNome("pedhro");
       // u.setEmail("phedroEmail");
       // u.setSenha("001");
       // u.setId((long)52);
        
      
      // u.setId((long)1);
       ///////////////////////////
      
        pb.setCategoria("Agua");
        pb.setDescricao("Encanção estourada!");
        pb.setLocalidade("Rua de garnhuns");
        pb.setStatus("Pendente");
        pb.getUsuario().add(u);
        
        //p2.inserir(pb);
        //p2.alterar(pb);
        //p2.remover(pb);
        //p2.recuperarTodos();
        
        //pb.setId();
       
        
        o.setNome("Público");
        o.setSenha("22078");
        
        o.getPublicacao().add(pb);
       
        //o2.inserir(o);
        //o2.alterar(o);
        o2.remover(o);
        //o2.recuperarTodos();
        
        ///////////////////////
        //manager.getTransaction().begin();

        //manager.persist(p);

        // manager.persist(p);
        // u2.recuperar((long)52);
        // u2.alterar(u);
        // u2.remover(u);
        // u2.inserir(u);
        // u2.recuperar((long)201);
        // System.out.println(u2.getNome());

        //manager.persist(u);
        
        //o2.inserir(o);
        
        
        //manager.persist(pb);
        //manager.persist(o);
        //manager.getTransaction().commit();
        //manager.close();
    }
}
