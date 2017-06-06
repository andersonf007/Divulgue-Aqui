package dao;

import hibernate.HibernateUtil;
import entidade.UsuarioEntidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class UsuariosDao implements DaoGenerico<UsuarioEntidade> {

    private static EntityManager manager;

    public UsuariosDao() {

    }

    @Override
    public void inserir(UsuarioEntidade u) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        UsuariosDao.manager.getTransaction().begin();

        try {

            UsuariosDao.manager.persist(u);
            UsuariosDao.manager.getTransaction().commit();
            System.out.println("Usuário salvo com sucesso!");

        } catch (UnsupportedOperationException operation) {

            UsuariosDao.manager.getTransaction().rollback();
            System.out.println("Operação cancelada");
            //throw new UnsupportedOperationException("Operação cancelada, pois os dados passados não satisfazem as regras da aplicação!");

        } finally {
            UsuariosDao.manager.close();
            System.out.println("Fim da Operação");
        }
    }

    @Override
    public void alterar(UsuarioEntidade u) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        UsuariosDao.manager.getTransaction().begin();

        try {
             //Em meus projetos anteriores não precisou, mas por garantia se precisar coloca!
            //u = UsuariosDao.manager.find(UsuarioEntidade.class, u.getId());
            UsuariosDao.manager.merge(u);
            UsuariosDao.manager.getTransaction().commit();
            System.out.println("usuario alterado com sucesso!!");
        } catch (Exception e) {
            UsuariosDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível fazer está operação!!");

        } finally {
            UsuariosDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

    }

    @Override
    public void remover(UsuarioEntidade u) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        UsuariosDao.manager.getTransaction().begin();
        try {
            u = UsuariosDao.manager.find(UsuarioEntidade.class, u.getId());
            UsuariosDao.manager.remove(u);
            UsuariosDao.manager.getTransaction().commit();
            System.out.println("Registro removido com sucesso!");
        } catch (Exception e) {
            UsuariosDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover este registro!");
        } finally {
            UsuariosDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }
    @Override

    public UsuarioEntidade recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        UsuariosDao.manager.getTransaction().begin();
        
        try {
            UsuarioEntidade u = (UsuarioEntidade) UsuariosDao.manager.find(UsuarioEntidade.class, id);
            UsuarioEntidade a = u;
            return u;
          //  return (UsuarioEntidade) UsuarioDao.manager.find(Paciente.class, Get.SUS);
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
        } finally {
            UsuariosDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        return null;
    }

    @Override
    public List<UsuarioEntidade> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) UsuariosDao.manager.createQuery("select p from UsuarioEntidade p", UsuarioEntidade.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            UsuariosDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }

   

}
