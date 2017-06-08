/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
import entidade.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Izaquias
 */
public class PessoaDao implements DaoGenerico<Pessoa> {

    private static EntityManager manager;

    public PessoaDao() {
    }

    @Override
    public void inserir(Pessoa p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoaDao.manager.getTransaction().begin();

        try {
            PessoaDao.manager.persist(p);
            PessoaDao.manager.getTransaction().commit();
            System.out.println("Dados armazenados com sucesso!");
        } catch (IllegalArgumentException iae) {
            PessoaDao.manager.getTransaction().rollback();
            System.out.println("Ocorreu algo inexperado!");
            System.out.println(iae.getMessage());
            //throw new IllegalArgumentException("Dados inválidos, tente novamente, reveja a operação!");
        } finally {

            //Pessoas.manager.getTransaction().rollback();
            PessoaDao.manager.close();
            System.out.println("Fim da operação!");
        }
    }

    @Override
    public void alterar(Pessoa p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoaDao.manager.getTransaction().begin();

        try {
            //Neste método nunca adicionei esta próxima linha de código e alterava normalmente, caso quando tu teste, não funcionar
            //tu descomenta e testa!
            //p = PessoaDao.manager.find(Pessoa.class, p.getId());
            PessoaDao.manager.merge(p);
            PessoaDao.manager.getTransaction().commit();
            System.out.println("Dados alterados com sucesso!");
        } catch (Exception e) {
            PessoaDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível realizar esta alteração!");
            System.out.println(e.getMessage());
        } finally {
            PessoaDao.manager.close();
            System.out.println("Fim da sessão!");

        }

    }

    @Override
    public void remover(Pessoa p) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoaDao.manager.getTransaction().begin();
        try {
            p = PessoaDao.manager.find(Pessoa.class, p.getId());
            PessoaDao.manager.remove(p);
            PessoaDao.manager.getTransaction().commit();
            System.out.println("Registro removido com sucesso!");
        } catch (Exception e) {
            PessoaDao.manager.getTransaction().rollback();
            System.out.println("Não foi possível remover este registro!");
            System.out.println(e.getMessage());
        } finally {
            PessoaDao.manager.close();
            System.out.println("Fim da sessão!");
        }
    }

    @Override
    public Pessoa recuperar(Long id) {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();
        PessoaDao.manager.getTransaction().begin();

        try {
            Pessoa p = (Pessoa) PessoaDao.manager.find(Pessoa.class, id);
            Pessoa ps = p;
            return p;
            //return (Pessoa) PessoaDao.manager.find(Pessoa.class, id);
        } catch (Exception e) {
            System.out.println("id não encontrado!");
            System.out.println(e.getMessage());
        } finally {
            PessoaDao.manager.close();
            System.out.println("Fim da sessão!");
        }
        return null;
    }

    @Override
    public List<Pessoa> recuperarTodos() {
        manager = HibernateUtil.getInstance().getFactory().createEntityManager();

        try {
            return (List) PessoaDao.manager.createQuery("select p from Pessoa p", Pessoa.class).getResultList();

        } catch (Exception e) {

            System.out.println("Algo inexperado aconteceu, reveja seu código!!");
            System.out.println(e.getMessage());
        } finally {
            PessoaDao.manager.close();
            System.out.println("Fim da sessão!!");
        }

        return null;
    }

}
