 
package dao;

import entidade.Publicacao;
import hibernate.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Izaquias
 */


public class PublicacaoDao implements DaoGenerico<Publicacao>{

    private static EntityManager  manager; 
    
    public PublicacaoDao() {
    }
    
    @Override
    public void inserir(Publicacao pb) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacaoDao.manager.getTransaction().begin();
        
        try {
            PublicacaoDao.manager.persist(pb);
            PublicacaoDao.manager.getTransaction().commit();
            System.out.println("Publicação gravada com sucesso!");
        } catch (Exception e) {
            PublicacaoDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
            System.out.println(e.getMessage());
        }finally{
            PublicacaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void alterar(Publicacao p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacaoDao.manager.getTransaction().begin();
        try {
           
            PublicacaoDao.manager.merge(p);
            PublicacaoDao.manager.getTransaction().commit();
            System.out.println("Publicação Atualizada com sucesso!");
        } catch (Exception e) {
            PublicacaoDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
            System.out.println(e.getMessage());
        }finally{
            PublicacaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void remover(Publicacao pb) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacaoDao.manager.getTransaction().begin();
        
        try {
            pb = PublicacaoDao.manager.find(Publicacao.class, pb.getId());
            PublicacaoDao.manager.remove(pb);
            PublicacaoDao.manager.getTransaction().commit();
            System.out.println("Publicação deletada com sucesso!");
          
        } catch (Exception e) {
            PublicacaoDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
            System.out.println(e.getMessage());
        }finally{
            PublicacaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public Publicacao recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacaoDao.manager.getTransaction().begin();
        
        try {
            Publicacao p = (Publicacao) PublicacaoDao.manager.find(Publicacao.class, id);
            //Publicacao pu = p;
            return p;
            //return (Publicacao) PublicacaoDao.manager.find(Publicacao.class, id);
            
        } catch (Exception e) {
           System.out.println("id não encontrado!");
           System.out.println(e.getMessage());    
        }finally{
            PublicacaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        
        return null;
    }

    @Override
    public List<Publicacao> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
           return (List) PublicacaoDao.manager.createQuery("select pb from Publicacao pb", Publicacao.class).getResultList();
                        //PublicacaoDao.manager.createQuery("select pb from Publicacao pb", Publicacao.class).getResultList();
        } catch (Exception e) {
           System.out.println("Algo inexperado aconteceu, reveja seu código!!");
           System.out.println(e.getMessage());         
        }finally{
           PublicacaoDao.manager.close();
           System.out.println("Fim da sessão!!");
        }
        
        return null;
    }
    
    public List<Publicacao> buscarPublicacaoPorIdUsuario(long id) {

        String hql = "select * from Publicacao where idUsuario:=id";

        Publicacao p = null;

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            Query query = manager.createQuery(hql);
            p = (Publicacao) query.setParameter("idUsuario", id).getResultList();
        } catch (Exception e) {
            System.out.println("Não encontrou resultados para essa busca, reveja o código!");
            System.out.println(e.getMessage());
        }

        return (List<Publicacao>) p;
    }
}
