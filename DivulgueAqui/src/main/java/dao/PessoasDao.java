/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
import entidade.PessoaEntidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class PessoasDao implements DaoGenerico<PessoaEntidade> {

    private static EntityManager manager;

    public PessoasDao() {
    }

    @Override
    public void inserir(PessoaEntidade p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoasDao.manager.getTransaction().begin();

        try {
            PessoasDao.manager.persist(p);
            PessoasDao.manager.getTransaction().commit();
            System.out.println("Dados armazenados com sucesso!");
        } catch (IllegalArgumentException iae) {
            PessoasDao.manager.getTransaction().rollback();
            System.out.println("Ocorreu algo inexperado!");
            //throw new IllegalArgumentException("Dados inválidos, tente novamente, reveja a operação!");
        } finally {

            //Pessoas.manager.getTransaction().rollback();
            PessoasDao.manager.close();
            System.out.println("Fim da operação!");
        }
    }

    @Override
    public void alterar(PessoaEntidade p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoasDao.manager.getTransaction().begin();

        try {
            //Neste método nunca adicionei esta próxima linha de código e alterava normalmente, caso quando tu teste, não funcionar
            //tu descomenta e testa!
            //p = PessoasDao.manager.find(PessoaEntidade.class, p.getId());
            PessoasDao.manager.merge(p);
            PessoasDao.manager.getTransaction().commit();
            System.out.println("Dados alterados com sucesso!");
        } catch (Exception e) {
            PessoasDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta alteração!");
        } finally {
            PessoasDao.manager.close();
            System.out.println("Fim da sessão!");

        }

    }

    @Override
    public void remover(PessoaEntidade p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoasDao.manager.getTransaction().begin();
        try {
            p = PessoasDao.manager.find(PessoaEntidade.class, p.getId());
            PessoasDao.manager.remove(p);
            PessoasDao.manager.getTransaction().commit();
            System.out.println("Registro removido com sucesso!");
        } catch (Exception e) {
            PessoasDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover este registro!");
        } finally {
            PessoasDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public PessoaEntidade recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoasDao.manager.getTransaction().begin();

        try {
            return (PessoaEntidade) PessoasDao.manager.find(PessoaEntidade.class, id);
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
        } finally {
            PessoasDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        return null;
    }

    @Override
    public List<PessoaEntidade> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) PessoasDao.manager.createQuery("select p from PessoaEntidade p", PessoaEntidade.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            PessoasDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }

}
