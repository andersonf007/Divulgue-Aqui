



import dao.OrgaosDao;
import dao.PessoasDao;
import dao.PublicacoesDao;
import dao.UsuariosDao;
import hibernate.HibernateUtil;
import entidade.OrgaoEntidade;
import entidade.PessoaEntidade;
import entidade.PublicacaoEntidade;
import entidade.UsuarioEntidade;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TesteConexaoBD {
    
    static EntityManager manager;
    
     public static void main(String[] horaDoShow){
        
    
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
    
        
        UsuarioEntidade u = new UsuarioEntidade();
        PublicacaoEntidade pb = new PublicacaoEntidade();
        OrgaoEntidade o = new OrgaoEntidade();
        PessoaEntidade p = new PessoaEntidade();
        
        //Ao inserir, altere os valores para não ficar com valores repetidos  no BD! 
        
         UsuariosDao u2 = new UsuariosDao();
         PublicacoesDao pu2 = new PublicacoesDao();
         OrgaosDao o2 = new OrgaosDao();
         PessoasDao p2 = new PessoasDao();
        
        p.setNome("adones");
        p.setEndereco("imbécil");
        
        
       
        ///////////////////////////
        u.setNome("adones22");
        u.setEmail("adones22@gmail.com");
        u.setSenha("sacopela22");
        //u.setId(52);
      
       ///////////////////////////
      
        pb.setCategoria("Agua");
        pb.setDescricao("Encanção estourada!");
        pb.setLocalidade("Rua de garnhuns");
        pb.setStatus("Espera");
        //Date hoje = Date.from(Instant.now());
        //pb.setData(hoje);
        //pb.getUsuario().add(u);
        pb.getId();
        //////////////////////
        
        o.setNome("Prefeitura");
        o.setEndereco("Rua Camilo Fonseca, Centro nº 220");
        o.getProblemas().add(pb);
        ///////////////////////
        manager.getTransaction().begin();
        //p2.inserir(p);
        //manager.persist(p);
        //u2.inserir(u);
        pu2.alterar(pb);        
        //manager.persist(u);
        
        //manager.persist(pb);
        //manager.persist(o);
        manager.getTransaction().commit();
        manager.close();
    }
}
