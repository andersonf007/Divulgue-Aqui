package dao;

import hibernate.HibernateUtil;
import entidade.Usuario;
import excecao.TransacaoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Izaquias
 */
public class UsuarioDao implements DaoGenerico<Usuario> {

    private static EntityManager manager;

    public UsuarioDao() {

    }

    @Override
    public void inserir(Usuario u) throws TransacaoException {
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        UsuarioDao.manager.getTransaction().begin();

        try {
            UsuarioDao.manager.persist(u);
            UsuarioDao.manager.getTransaction().commit();
            System.out.println("Usuário salvo com sucesso!");

        }catch (Exception operation) {

            UsuarioDao.manager.getTransaction().rollback();
            System.out.println(operation.getMessage());
            throw new TransacaoException(TransacaoException.NAOCADASTROU);
            

        }finally {
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
        Usuario u2 = null;
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        UsuarioDao.manager.getTransaction().begin();
        try {
            u2 = UsuarioDao.manager.find(Usuario.class, u.getId());
            UsuarioDao.manager.remove(u2);
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

    public Usuario recuperarUsuarioPorNomeFicticio(String nomeDeUsuario){
        Usuario u = null;

        String hql = "from Usuario o where nomeFicticio=:nomeUsuario";//como tá no bd, e o segundo param. é como um álias!

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);
            u = (Usuario) query.setParameter("nomeUsuario", nomeDeUsuario).getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return u;
    }   
    
    public boolean verificarUsuarioPorNomeFicticio(String nomeDeUsuario){
    //verifica se o nome de usuario ja existe no banco de dados
        Usuario u = null;

        String hql = "from Usuario o where nomeFicticio=:nomeUsuario";
        
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);
            u = (Usuario) query.setParameter("nomeUsuario", nomeDeUsuario).getSingleResult();
            
            if (u  != null){ // existe no banco de dados
                return false;
            }else{ // nao existe no banco de dados
                return true;
            }
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    } 

    public Usuario recuperarUsuarioNome(String nome){
        Usuario u = null;

        String hql = "from Usuario o where nome=:usuario";//como tá no bd, e o segundo param. é como um álias!

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);

            u = (Usuario) query.setParameter("usuario", nome).getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        
        return u;
    }
     
    public Usuario buscarUsuarioPorNomeSenha(String usuario, String senha){
        String hql = "from Usuario u where nomeFicticio=:nomeUser and senha=:senhaUser";
        Usuario u = null;
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        
        try {
            Query query = manager.createQuery(hql);
            u = (Usuario) query.setParameter("nomeUser", usuario).setParameter("senhaUser", senha).getSingleResult();
            System.out.println("Usuário Logou no sistema!");
        } catch (Exception e) {
            System.out.println("Dados incorretos, Usuário não logou no sistema!");
            System.out.println(e.getMessage());
        }
    
    return u;
    } 
}
