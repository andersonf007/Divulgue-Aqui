 
package dao;

import entidade.Publicacao;
import hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Izaquias
 */


public class PublicacaoDao implements DaoGenerico<Publicacao>, Serializable{
    private static final long serialVersionUID = 1L;

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
        Publicacao pb2 = null;
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PublicacaoDao.manager.getTransaction().begin();
        
        try {
            pb2 = PublicacaoDao.manager.find(Publicacao.class, pb.getId());
            PublicacaoDao.manager.remove(pb2);
            PublicacaoDao.manager.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Publicação foi removida com sucesso!"));
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
            return p;
            
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
    
    public List<Publicacao> buscarPublicacaoPorIdUsuario(Long id_usuario){
      
        String hql = "from Publicacao where idUsuario=:id_usuario";
        ArrayList<Publicacao> pb = new ArrayList<>();
        
         manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
         try {
              Query query = manager.createQuery(hql);
              pb =(ArrayList<Publicacao>) query.setParameter("id_usuario", id_usuario).getResultList();
        } catch (Exception e) {
             System.out.println("Não encontrou resultados para essa busca, reveja o código!");
             System.out.println(e.getMessage());
        }finally{
             manager.close();
         }
        
        return  pb;
    }
    
    public List<Publicacao> contaStatusPublicacao(String statusAtual){
        String hql = "FROM Publicacao WHERE status=:statusConsulta";
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        List<Publicacao> publicacao;
        try {
           Query quantidade = manager.createQuery(hql);
           quantidade.setParameter("statusConsulta", statusAtual);
           publicacao = quantidade.getResultList();
        } catch (Exception e) {
           publicacao = new ArrayList();
        }
        return publicacao;
    }
    
    public long contarStatusProblemaPendente(){
        String hql = "SELECT COUNT(*) FROM Publicacao  WHERE status='PENDENTE'";
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       
        try {
            Query quantidade = manager.createQuery(hql);
           return  (Long)quantidade.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Fim da sessão!");
        }
        
        return 0;
    }
    
    public long contarStatusProblemaAnalizando(){
        String hql = "SELECT COUNT(*) FROM Publicacao  WHERE status='ANALIZANDO'";
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       
        try {
            Query quantidade = manager.createQuery(hql);
           return  (Long)quantidade.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Fim da sessão!");
        }
        
        return 0;
    }
    
    public long contarStatusProblemaResolvendo(){
        String hql = "SELECT COUNT(*) FROM Publicacao  WHERE status='RESOLVENDO'";
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       
        try {
            Query quantidade = manager.createQuery(hql);
           return  (Long)quantidade.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Fim da sessão!");
        }
        
        return 0;
    }
    
    public long contarStatusProblemaResolvido(){
        String hql = "SELECT COUNT(*) FROM Publicacao  WHERE status='RESOLVIDO'";
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       
        try {
            Query quantidade = manager.createQuery(hql);
           return  (Long)quantidade.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Fim da sessão!");
        }
        
        return 0;
    }
    
    public long contarStatusProblemaIgnorado(){
        String hql = "SELECT COUNT(*) FROM Publicacao  WHERE status='IGNORADO'";
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
       
        try {
            Query quantidade = manager.createQuery(hql);
           return  (Long)quantidade.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Fim da sessão!");
        }
        
        return 0;
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
