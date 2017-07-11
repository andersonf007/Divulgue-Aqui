package dao;


import entidade.Orgao;
import excecao.TransacaoException;
import hibernate.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Izaquias
 */
public class OrgaoDao implements DaoGenerico<Orgao> {

    private static EntityManager manager;

    public OrgaoDao() {
    }

    @Override
    public void inserir(Orgao o)  throws TransacaoException{
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaoDao.manager.getTransaction().begin();

        try {
            OrgaoDao.manager.persist(o);
            OrgaoDao.manager.getTransaction().commit();
            System.out.println("Dados do orgão salvos com sucesso!");
        } catch (Exception e) {
            OrgaoDao.manager.getTransaction().rollback();
            System.out.println(e.getMessage());
            throw new TransacaoException(TransacaoException.NAOCADASTROU);
        } finally {
            OrgaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void alterar(Orgao o) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaoDao.manager.getTransaction().begin();

        try {
            
            OrgaoDao.manager.merge(o);
            OrgaoDao.manager.getTransaction().commit();
            System.out.println("Registros do Orgão alterados com sucesso!");
        } catch (Exception e) {
            OrgaoDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta operação!");
            System.out.println(e.getMessage());
        } finally {
            OrgaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public void remover(Orgao o) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaoDao.manager.getTransaction().begin();
        try {
            o = OrgaoDao.manager.find(Orgao.class, o.getId());
            OrgaoDao.manager.remove(o);
            OrgaoDao.manager.getTransaction().commit();
            System.out.println("Orgão removido com sucesso!");
        } catch (Exception e) {
            OrgaoDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover este registro!");
            System.out.println(e.getMessage());
        } finally {
            OrgaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public Orgao recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        OrgaoDao.manager.getTransaction().begin();

        try {
           Orgao o =  (Orgao) OrgaoDao.manager.find(Orgao.class, id);
           System.out.println("Encontrado com sucesso!");
           return o;
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
        } finally {
            OrgaoDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        return null;
    }

    @Override
    public List<Orgao> recuperarTodos() {

        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) OrgaoDao.manager.createQuery("select o from Orgao o", Orgao.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            OrgaoDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }
    
    public Orgao recuperarOrgaoUsuarioSenha(String usuario, String senha){
        String hql = "from Orgao o where nomeUsuario=:usuarioOrgao and senha=:senhaOrgao";//como tá no bd!
        Orgao o = null;
         manager = HibernateUtil.getInstance().getFactory().createEntityManager();
         
         try {
            Query query = manager.createQuery(hql);
            o = (Orgao) query.setParameter("usuarioOrgao", usuario).setParameter("senhaOrgao", senha).getSingleResult();//como tá na classe!
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return o;
    }

}
