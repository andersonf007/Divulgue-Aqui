
package com.github.izaquias.divulgueaquiweb.controller;

import com.github.izaquias.divulgueaquiweb.dao.Pessoas;
import com.github.izaquias.divulgueaquiweb.model.Pessoa;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

@ViewScoped
@SessionScoped

/**
 *
 * @author Izaquias
 */
@ManagedBean(value = "pessoaBean")
public class PessoaBean implements Controller{
    
    private Pessoa pessoa;
    private Pessoas dao;

    @PostConstruct
    public void inicializar(){
        pessoa = new Pessoa();
        dao = new Pessoas();
    }
    
    public PessoaBean(Pessoa pessoa, Pessoas dao) {
        this.pessoa = pessoa;
        this.dao = dao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoas getDao() {
        return dao;
    }

    public void setDao(Pessoas dao) {
        this.dao = dao;
    }
    
    

    @Override
    public String salvar() {
        dao.inserir(pessoa);
        return "";
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar(Long chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
