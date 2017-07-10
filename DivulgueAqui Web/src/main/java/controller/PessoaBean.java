
package controller;

import dao.PessoaDao;
import entidade.Pessoa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
//import javax.faces.bean.SessionScoped;

//@SessionScoped
@ViewScoped

/**
 *
 * @author Izaquias
 */
@ManagedBean(name = "pessoaBean")

public class PessoaBean implements Controller{
    
    private Pessoa pessoa;
    private PessoaDao dao = null;

    @PostConstruct
    public void inicializar(){
        pessoa = new Pessoa();
        dao = new PessoaDao();
    }

    public PessoaBean() {
    }
    
    public PessoaBean(Pessoa pessoa, PessoaDao dao) {
          this.pessoa = pessoa;
          this.dao = dao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDao getDao() {
        return dao;
    }

    public void setDao(PessoaDao dao) {
        this.dao = dao;
    }
    
    @Override
    public String salvar() {
        dao.inserir(pessoa);
        pessoa = new Pessoa();
        return "index.xhtml";
    }

    @Override
    public String atualizar() {
        dao.alterar(pessoa);
        //pessoa = new Pessoa();
        return "index.xhtml";    
    }

    @Override
    public Pessoa buscar(Long id) {
       return dao.recuperar(id);
    }

    @Override
    public List<Pessoa> listarTodos() {
       return dao.recuperarTodos();
    }
    
}
