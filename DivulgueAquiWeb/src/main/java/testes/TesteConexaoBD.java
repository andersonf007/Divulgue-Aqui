
package testes;


import hibernate.HibernateUtil;
import model.Pessoa;
import model.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class TesteConexaoBD {
    
    static EntityManager manager;
    
     public static void main(String[] horaDoShow){
        
    
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
    
        Usuario u = new Usuario();
    
       
        Pessoa p = new Pessoa();
        //Ao inserir, altere os valores para não ficar com valores repetidos  no BD! 
        
        p.setNome("andreza");
        p.setSenha("123");
        
//        u.setNome("izaquias");
//        u.setEmail("izaquias@gmail.com");
//        u.setSenha("izaquias19");
//        u.setIdade(19);
        
        
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        manager.close();
       
        
    }
    
}
