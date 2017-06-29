package dao;

import hibernate.HibernateUtil;
import entidade.Usuario;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            UsuarioDao.manager.find(Usuario.class, u.getId());
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

    public Usuario recuperarUsuarioIdNome(String nome){
        Usuario u = null;

        String hql = "from Usuario o where nome=:nomeUsuario";//como tá no bd, e o segundo param. é como um álias!

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);
            u = (Usuario) query.setParameter("nomeUsuario", nome).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return u;
    }   
    
    public Usuario buscarPorEmailAndSenha(String email, String senha){
        Usuario u = null;
        String hql = "FROM Usuario u WHERE email=:EmailUser and senha=:senhaUser";
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);
            u = (Usuario) query.setParameter("EmailUser", email).setParameter("senhaUser", senha).getSingleResult();
        } catch (Exception e) {
            System.out.println("Dados não encontrados!");
            System.out.println(e.getMessage());
        }finally{
            manager.close();
            System.out.println("Fim da sessão!");
        }
        return u;
    }
}
