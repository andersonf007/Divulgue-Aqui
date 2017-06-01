
package dao;

import hibernate.HibernateUtil;
import model.entidade.UsuarioEntidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class UsuariosDao implements DaoGenerico<UsuarioEntidade>{

    private static EntityManager manager;
    
    public UsuariosDao(){
        
    }
    
    @Override
    public void inserir(UsuarioEntidade u) {
       manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       
       UsuariosDao.manager.getTransaction().begin();
       
       try{
           
           UsuariosDao.manager.persist(u);
           UsuariosDao.manager.getTransaction().commit();
           System.out.println("Usuário salvo com sucesso!");
       
       }catch(UnsupportedOperationException operation){
           
           UsuariosDao.manager.getTransaction().rollback();
           System.out.println("Operação cancelada");
           throw new UnsupportedOperationException("Operação cancelada, pois os dados passados não satisfazem as regras da aplicação!");
           
           
       }finally{
           UsuariosDao.manager.close();
          System.out.println("Fim da Operação");
       }
    }

    @Override
    public void alterar(UsuarioEntidade u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(UsuarioEntidade u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioEntidade recuperar(Long chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioEntidade> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
