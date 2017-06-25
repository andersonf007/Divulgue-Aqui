 
package dao;

import entidade.Publicacao;
import hibernate.HibernateUtil;
import java.util.ArrayList;
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
                        
        } catch (Exception e) {
           System.out.println("Algo inexperado aconteceu, reveja seu código!!");
           System.out.println(e.getMessage());         
        }finally{
           PublicacaoDao.manager.close();
           System.out.println("Fim da sessão!!");
        }
        
        return null;
    }
    
    public List<Publicacao> buscarPublicacaoPorIdUsuario(long id, Long id_usuario){
        String hql = "select id from Publicacao p join Usuario u where p.id=:idPublicacao and u.idUsuario=:idUser";
        
        Publicacao p = null;
        
         manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
         try {
              Query query = manager.createQuery(hql);
              p = (Publicacao) query.setParameter("idPublicacao", id).setParameter("idUser", id).getResultList();
        } catch (Exception e) {
             System.out.println("Não encontrou resultados para essa busca, reveja o código!");
             System.out.println(e.getMessage());
        }finally{
             manager.close();
         }
        
         
        return (List<Publicacao>) p;
    }
    
    //Com @NamedQuerie vide entidade publicacao!
    public List<Publicacao> consultarPorUsuario(Long usuarioId){
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        List<Publicacao> publicacao;
        try {
           Query q = manager.createNamedQuery("Publicacao.consultarPorUsuario");
           q.setParameter("usuarioId", usuarioId);
           publicacao = q.getResultList();
        } catch (Exception e) {
           publicacao = new ArrayList();
        }finally{
            manager.close();
        }
        return publicacao;
    }
}
