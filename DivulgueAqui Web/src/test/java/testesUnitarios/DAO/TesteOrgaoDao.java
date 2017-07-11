 
package testesUnitarios.DAO;

import dao.OrgaoDao;
import entidade.Orgao;
import excecao.TransacaoException;
import hibernate.Criptografia;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Izaquias
 */


public class TesteOrgaoDao {

     @Ignore
    @Test
    public void verificarInsercaoOrgaoDB() throws TransacaoException{

        Orgao orgao = new Orgao();
        OrgaoDao dao = new OrgaoDao();
        
        orgao.setNome("Celpe");
        orgao.setEmail("Celpe@gmail.com");
        orgao.setSenha("0024");
        
        orgao.setSenha(Criptografia.encriptografar(orgao.getSenha()));
        
        dao.inserir(orgao);
        
        List<Orgao> orgaos = dao.recuperarTodos();
        Assert.assertEquals("Celpe", orgaos.get(orgaos.size()-1).getNome());
    }
    
    @Ignore
    @Test
    public void verificarAtualizacaoOrgaoDB(){
        Orgao orgao;
        OrgaoDao dao = new OrgaoDao();
        orgao = dao.recuperar(4L);
        orgao.setNome("Forum");
        orgao.setEmail("forum@gmail.com");
        orgao.setSenha("9894");
        
        dao.alterar(orgao);
        
        orgao = dao.recuperar(4L);
        Assert.assertEquals("Forum", orgao.getNome());
    }
    
    @Ignore
    @Test
    public void listarTodosOrgaosBD(){
        OrgaoDao dao = new OrgaoDao();
        
        List<Orgao> orgaos = dao.recuperarTodos();
        
        Assert.assertEquals("Forum", orgaos.get(0).getNome());
        Assert.assertEquals("Admistrativo", orgaos.get(1).getNome());
    }
    
    @Ignore
    @Test
    public void verificarBuscaOrgaoDB(){
        Orgao orgao;
        OrgaoDao dao = new OrgaoDao();
        
        orgao = dao.recuperar(6L);
        Assert.assertEquals("Forum", orgao.getNome());
      
    }
    
}
