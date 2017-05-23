
package com.github.izaquias.divulgueaquiweb.testes;


import com.github.izaquias.divulgueaquiweb.hibernate.HibernateUtil;
import com.github.izaquias.divulgueaquiweb.model.Pessoa;
import com.github.izaquias.divulgueaquiweb.model.Usuario;
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
        p.setEndereco("São Paulo");
        
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
