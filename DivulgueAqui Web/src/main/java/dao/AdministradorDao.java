
package dao;

import entidade.Administrador;
import excecao.TransacaoException;
import hibernate.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author Izaquias
 */


public class AdministradorDao implements DaoGenerico<Administrador>{

    private static EntityManager manager;
    
    public AdministradorDao() {
    
    }

    @Override
    public void inserir(Administrador a) throws TransacaoException  {
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        AdministradorDao.manager.getTransaction().begin();
        
        try {
            
            AdministradorDao.manager.persist(a);
            AdministradorDao.manager.getTransaction().commit();
            System.out.println("Admin salvo com sucesso!");
        } catch (Exception e) {
            AdministradorDao.manager.getTransaction().rollback();
            System.out.println(e.getMessage());
             throw new TransacaoException(TransacaoException.NAOCADASTROU);
        }finally{
            AdministradorDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void alterar(Administrador a) {
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        AdministradorDao.manager.getTransaction().begin();
        
        try {
            AdministradorDao.manager.merge(a);
            AdministradorDao.manager.getTransaction().commit();
            System.out.println("Admin atualizado com sucesso!");
        } catch (Exception e) {
            AdministradorDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível atualizar o admin!");
            System.out.println(e.getMessage());
        }finally{
            AdministradorDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void remover(Administrador a) {
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        AdministradorDao.manager.getTransaction().begin();
        
        try {
            a = AdministradorDao.manager.find(Administrador.class, a.getId());
            AdministradorDao.manager.remove(a);
            AdministradorDao.manager.getTransaction().commit();
            System.out.println("Admin deletado com sucesso!");
        } catch (Exception e) {
            AdministradorDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível deletar o admin!");
            System.out.println(e.getMessage());
        }finally{
            AdministradorDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public Administrador recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        AdministradorDao.manager.getTransaction().begin();
        try {
            Administrador a;
            a = (Administrador) AdministradorDao.manager.find(Administrador.class, id);
            System.out.println("Admin encontrado com sucesso!");
            return a;
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
            
        }finally{
            AdministradorDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        
        return null;
    }

    @Override
    public List<Administrador> recuperarTodos() {
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
              return (List) AdministradorDao.manager.createQuery("select a from Administrador a", Administrador.class).getResultList();
        } catch (Exception e) {
              
            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());

        }finally{
            AdministradorDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        
        return null;
    }
    
    public Administrador buscarAdminPorNomeSenha(String nome, String senha){
        String hql = "from Administrador a where nome=:nomeAdmin and senha=:senhaAdmin";
        Administrador a = null;
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);
            a = (Administrador) query.setParameter("nomeAdmin", nome).setParameter("senhaAdmin", senha).getSingleResult();
            System.out.println("Admin Logou no sistema!");
        } catch (Exception e) {
            System.out.println("Dados incorretos, admin não logou no sistema!");
            System.out.println(e.getMessage());
        }
    
    return a;
    }
}
