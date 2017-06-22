
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
        
        p.setNome("ana");
        p.setEndereco("Correntes");
        
        //ps.inserir(p);
       //ps.alterar(p);
       //ps.remover(p);
      //ps.recuperarTodos();
      //ps.recuperar(getId());
        
        
        //OBS: PARA REMOVER UMA PUBLICAÇÃO É NECESSÁRIO, REMOVER ANTES O ORGÃO!
        //PARA REMOVER UM USUÁRIO É NECESSÁRIO, REMOVER UMA PUBLICAÇÃO!
        //TUDO ISSO É NECESSÁRIO, CASO TENHA DENPENDÊNCIAS ENTRE AS ENTIDADES
        //OU SEJA, AO REALIZAR UM CADASTRO EM CASCATA(TANTO DE USUARIO,PUBLICAOCAO E ORGAO) SIMULTÂNEO!
        //CASO CONTRÁRIO TODO O CRUD FUNCIONARÁ CORRETAMENTE!
        //MAS UMA COISA, TEM UMAS ANOTAÇÕES DE CASCADE NAS ENTIDADES, NÃO REMOVE, CASO PRECISE MUDAR PARA
        //QUANDO HOUVER ESSAS DEPENDÊNCIAS, SEJA POSSÍVEL REMOVER EM CASCATA, AEE NÃO DARÁ ERROS!
        //MANDA BRASA NO REST!

        u.setNome("CJ");
        u.setEmail("cj@gmail.com");
        u.setSenha("cj");
        
       // u.setId((long)3);
        
        //u2.inserir(u);
        //u2.alterar(u);
        //u2.recuperar((long)5);
        //u2.remover(u);
        //u2.recuperarTodos();
        

        //u.setNome("asdf");
        //u.setEmail("anderson@gmail.com");
        //u.setSenha("001");
       // u.setId((long)52);
        
      
        // u.setId((long)1);
       ///////////////////////////

       // pb.setId(10);//corrigido erro de atualização, no caso estava inserindo! 
        pb.setCategoria("Segurança");
        pb.setDescricao("Falta de pulíticas públicas!");
        pb.setLocalidade("Boa vista!");
        pb.setStatus("Pendente");
        //pb.getUsuario().add(u);
        //u.setId((long)1);
        //u2.recuperar((long)4);
        pb.setUsuario(u);
        //pb.setId((long)3);
        //p2.inserir(pb);

        //p2.remover(pb);
        //p2.alterar(pb);
        //p2.remover(pb);


      
        //pb.setCategoria("");
        //pb.setDescricao("fgdgh energia!");
        ///pb.setLocalidade("Rua de mghagano 1!");
        //pb.setStatus("Pendente");
      //  pb.setIdUsuario((long)4);
        //pb.setId((long)7);
        //pb.getUsuario().add(u);
        
        //pb.setId((long)2);
        //p2.inserir(pb);
        //p2.alterar(pb);
        //p2.remover(pb);
        //p2.recuperar((long)1);
        //p2.recuperarTodos();
        
        //pb.setId();
       
        

        o.setNome("Diferente");
        o.setSenha("0011");

       // o.setNome("Orgão2");
       // o.setSenha("22222");

       // o.getPublicacao().add(pb);
       
        
        //o2.inserir(o);
        //o.setId(1);
        //o2.alterar(o);
        //o2.remover(o);
        //o2.recuperar((long)1);
        
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
