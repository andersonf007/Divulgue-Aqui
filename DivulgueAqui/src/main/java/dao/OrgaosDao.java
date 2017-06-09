package dao;

import entidade.OrgaoEntidade;
import hibernate.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class OrgaosDao implements DaoGenerico<OrgaoEntidade> {

    private static EntityManager manager;

    public OrgaosDao() {
    }

    @Override
    public void inserir(OrgaoEntidade o) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaosDao.manager.getTransaction().begin();

        try {
            OrgaosDao.manager.persist(o);
            OrgaosDao.manager.getTransaction().commit();
            System.out.println("Dados salvos com sucesso!");
        } catch (Exception e) {
            OrgaosDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
        } finally {
            OrgaosDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void alterar(OrgaoEntidade o) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaosDao.manager.getTransaction().begin();

        try {
          //  o = OrgaosDao.manager.find(OrgaoEntidade.class, o.getId());
           OrgaosDao.manager.merge(o);
           OrgaosDao.manager.getTransaction().commit();
           System.out.println("Registros alterados com sucesso!");
        } catch (Exception e) {
            OrgaosDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
        } finally {
            OrgaosDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void remover(OrgaoEntidade o) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaosDao.manager.getTransaction().begin();
        try {
            o = OrgaosDao.manager.find(OrgaoEntidade.class, o.getId());
            OrgaosDao.manager.remove(o);
            OrgaosDao.manager.getTransaction().commit();
            System.out.println("Registro removido com sucesso!");
        } catch (Exception e) {
            OrgaosDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover este registro!");
        } finally {
            OrgaosDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public OrgaoEntidade recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaosDao.manager.getTransaction().begin();

        try {
            return (OrgaoEntidade) OrgaosDao.manager.find(OrgaoEntidade.class, id);
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
        } finally {
            OrgaosDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        return null;
    }

    @Override
    public List<OrgaoEntidade> recuperarTodos() {

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) OrgaosDao.manager.createQuery("select o from OrgaoEntidade o", OrgaoEntidade.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            OrgaosDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }

}
