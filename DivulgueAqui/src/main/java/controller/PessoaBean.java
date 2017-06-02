
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
        dao.alterar(pessoa);
        return "";
    }

    @Override
    public String deletar() {
        dao.remover(pessoa);
        return "";    
    }

    @Override
    public PessoaEntidade buscar(Long id) {
        return dao.recuperar(id);
    }

    @Override
    public List<PessoaEntidade> listarTodos() {
        return dao.recuperarTodos();
    }
    
}
