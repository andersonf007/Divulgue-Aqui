/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.izaquias.divulgueaquiweb.dao;

import com.github.izaquias.divulgueaquiweb.hibernate.HibernateUtil;
import com.github.izaquias.divulgueaquiweb.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author Izaquias
 */
public class Pessoas implements DaoGenerico<Pessoa>{

    private static EntityManager manager;

    public Pessoas() {
    }
    
    
    @Override
    public void inserir(Pessoa p){
           manager = HibernateUtil.getInstance().getFactory().createEntityManager();
           Pessoas.manager.getTransaction().begin();
       
       try{
           Pessoas.manager.persist(p);
           Pessoas.manager.getTransaction().commit();
           System.out.println("Dados armazenados com sucesso!");
       }catch(IllegalArgumentException iae){
           Pessoas.manager.getTransaction().rollback();
           System.out.println("Ocorreu algo inexperado!");
           throw new IllegalArgumentException("Dados inválidos, tente novamente, reveja a operação!");
       } finally{
           Pessoas.manager.close();
           System.out.println("Fim da operação!");
       }       
    }   
    

    @Override
    public void alterar(Pessoa t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Pessoa t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa recuperar(Long chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
