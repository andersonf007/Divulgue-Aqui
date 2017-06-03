
package controller;

import dao.PessoasDao;
import entidade.PessoaEntidade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;


//@SessionScoped

/**
 *
 * @author Izaquias
 */
@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean implements Controller{
    
    private PessoaEntidade pessoa;
    private PessoasDao dao = null;

    @PostConstruct
    public void inicializar(){
        pessoa = new PessoaEntidade();
        dao = new PessoasDao();
    }

    public PessoaBean() {
    }
    
    public PessoaBean(PessoaEntidade pessoa, PessoasDao dao) {
          this.pessoa = pessoa;
          this.dao = dao;
    }

    public PessoaEntidade getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntidade pessoa) {
        this.pessoa = pessoa;
    }

    public PessoasDao getDao() {
        return dao;
    }

    public void setDao(PessoasDao dao) {
        this.dao = dao;
    }
    
    @Override
    public String salvar() {
        dao.inserir(pessoa);
        pessoa = new PessoaEntidade();
        return "index.xhtml";
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
