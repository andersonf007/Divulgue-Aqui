 
package dao;

import entidade.PublicacaoEntidade;
import hibernate.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */


public class PublicacoesDao implements DaoGenerico<PublicacaoEntidade>{

    private static EntityManager  manager; 
    
    public PublicacoesDao() {
    }
    
    @Override
    public void inserir(PublicacaoEntidade pb) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacoesDao.manager.getTransaction().begin();
        
        try {
            PublicacoesDao.manager.persist(pb);
            PublicacoesDao.manager.getTransaction().commit();
            System.out.println("Dados gravados com sucesso!");
        } catch (Exception e) {
            PublicacoesDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
        }finally{
            PublicacoesDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void alterar(PublicacaoEntidade pb) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacoesDao.manager.getTransaction().begin();
        try {
            PublicacoesDao.manager.merge(pb);
            PublicacoesDao.manager.getTransaction().commit();
            System.out.println("Alteração executada com sucesso!");
        } catch (Exception e) {
            PublicacoesDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
        }finally{
            PublicacoesDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void remover(PublicacaoEntidade pb) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacoesDao.manager.getTransaction().begin();
        
        try {
            pb = PublicacoesDao.manager.find(PublicacaoEntidade.class, pb.getId());
            PublicacoesDao.manager.remove(pb);
            PublicacoesDao.manager.getTransaction().commit();
            System.out.println("Registro deletado com sucesso!");
        } catch (Exception e) {
            PublicacoesDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
        }finally{
            PublicacoesDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public PublicacaoEntidade recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacoesDao.manager.getTransaction().begin();
        
        try {
            return (PublicacaoEntidade) PublicacoesDao.manager.find(PublicacaoEntidade.class, id);
            
        } catch (Exception e) {
           System.out.println("id não encontrado!");
           System.out.println(e.getMessage());    
        }finally{
            PublicacoesDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        
        return null;
    }

    @Override
    public List<PublicacaoEntidade> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
           return (List) PublicacoesDao.manager.createQuery("select pb from PublicacaoEntidade pb", PublicacaoEntidade.class);
        } catch (Exception e) {
           System.out.println("Algo inexperado aconteceu, reveja seu código!!");
           System.out.println(e.getMessage());         
        }finally{
           PublicacoesDao.manager.close();
           System.out.println("Fim da sessão!!");
        }
        
        return null;
    }
    
}
