package dao;

import hibernate.HibernateUtil;
import entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Izaquias
 */
public class UsuarioDao implements DaoGenerico<Usuario> {

    private static EntityManager manager;

    public UsuarioDao() {

    }

    @Override
    public void inserir(Usuario u) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        UsuarioDao.manager.getTransaction().begin();

        try {

            UsuarioDao.manager.persist(u);
            UsuarioDao.manager.getTransaction().commit();
            System.out.println("Usuário salvo com sucesso!");

        } catch (Exception operation) {

            UsuarioDao.manager.getTransaction().rollback();
            System.out.println("Operação cancelada");
            System.out.println(operation.getMessage());
            

        } finally {
            UsuarioDao.manager.close();
            System.out.println("Fim da Operação");
        }
    }

    @Override
    public void alterar(Usuario u) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        UsuarioDao.manager.getTransaction().begin();

        try {
           u = UsuarioDao.manager.find(Usuario.class, u.getId());
            UsuarioDao.manager.merge(u);
            UsuarioDao.manager.getTransaction().commit();
            System.out.println("usuario alterado com sucesso!!");
        } catch (Exception e) {
            UsuarioDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer está operação!!");
            System.out.println(e.getMessage());
        } finally {
            UsuarioDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

    }

    @Override
    public void remover(Usuario u) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        UsuarioDao.manager.getTransaction().begin();
        try {
            u = UsuarioDao.manager.find(Usuario.class, u.getId());
            UsuarioDao.manager.remove(u);
            UsuarioDao.manager.getTransaction().commit();
            System.out.println("Usuário removido com sucesso!");
        } catch (Exception e) {
            UsuarioDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover este registro!");
            System.out.println(e.getMessage());
        } finally {
            UsuarioDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }
    @Override

    public Usuario recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        UsuarioDao.manager.getTransaction().begin();
        
        try {
            Usuario u = (Usuario) UsuarioDao.manager.find(Usuario.class, id);
            //UsuarioEntidade us = u;//Me explique isso!
            return u;
          
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
        } finally {
            UsuarioDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        return null;
    }

    @Override
    public List<Usuario> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) UsuarioDao.manager.createQuery("select p from Usuario p", Usuario.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            UsuarioDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }

    public Usuario recuperarUsuarioIdNome(long id, String nome){
        Usuario u = null;

        String hql = "from Usuario o where id=:idUsuario and nome=:nomeUsuario";//como tá no bd, e o segundo param. é como um álias!

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);
            u = (Usuario) query.setParameter("idUsuario", id).setParameter("nomeUsuario", nome).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return u;
    }   

}
