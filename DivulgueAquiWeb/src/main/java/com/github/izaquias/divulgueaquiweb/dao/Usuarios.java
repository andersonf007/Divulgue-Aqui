
package com.github.izaquias.divulgueaquiweb.dao;

import com.github.izaquias.divulgueaquiweb.hibernate.HibernateUtil;
import com.github.izaquias.divulgueaquiweb.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class Usuarios implements DaoGenerico<Usuario>{

    private static EntityManager manager;
    
    public Usuarios(){
        
    }
    
    @Override
    public void inserir(Usuario u) {
       manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       
       Usuarios.manager.getTransaction().begin();
       
       try{
           Usuarios.manager.persist(u);
           Usuarios.manager.getTransaction().commit();
           System.out.println("Usuário salva com sucesso!");
       
       }catch(UnsupportedOperationException operation){
           
           Usuarios.manager.getTransaction().rollback();
           System.out.println("Operação cancelada");
           throw new UnsupportedOperationException("Operação cancelada, pois os dados passados não satisfazem as regras da aplicação!");
           
           
       }finally{
           Usuarios.manager.close();
          System.out.println("Fim da Operação");
       }
    }

    @Override
    public void alterar(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario recuperar(Long chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
