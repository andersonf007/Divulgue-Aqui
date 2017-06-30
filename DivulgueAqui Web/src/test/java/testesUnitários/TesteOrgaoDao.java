 
package testesUnitários;

import dao.OrgaoDao;
import entidade.Orgao;
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
    public void verificarInsercaoOrgaoDB(){

        Orgao orgao = new Orgao();
        OrgaoDao dao = new OrgaoDao();
        
        orgao.setNome("Forum");
        orgao.setEmail("forum@gmail.com");
        orgao.setSenha("1010");
        
        try {
             dao.inserir(orgao);
             System.err.println("Orgão salvo com sucesso!");
            
        } catch (Exception e) {
             Assert.fail("Erro ao tentar salvar");
        }
           
    }
    
    //nao funciona
    @Ignore// Também funcionou!
    @Test
    public void verificarAtualizacaoOrgaoDB(){
        Orgao orgao;
        OrgaoDao dao = new OrgaoDao();
        orgao = dao.recuperar(6L);
        orgao.setNome("Forum");
        orgao.setEmail("forum@gmail.com");
        orgao.setSenha("9090");
        
        try {
            
             dao.alterar(orgao);
             System.err.println("Orgão alterado com sucesso!");
        } catch (Exception e) {
            Assert.fail("Erro ao tentar alterar o orgão");
        }
        
    }
    
    @Ignore
    @Test
    public void verificarExclusaoOrgaoDB(){
        Orgao orgao;
        OrgaoDao dao = new OrgaoDao();
        
        orgao = dao.recuperar(3L);
        
        try {
             dao.remover(orgao);
             System.err.println("Orgão excluido com sucesso!");
        } catch (Exception e) {
            Assert.fail("Erro ao tentar excluir o orgão");
        }
    }
    @Ignore
    @Test
    public void listarTodosOrgaosBD(){
        OrgaoDao dao = new OrgaoDao();
        
        for(Orgao o: dao.recuperarTodos()){
            System.out.println("Nome:" + o.getNome());
            System.out.println("Senha:" + o.getSenha());
            System.out.println("--------------------------------");
            
        }
    }
    //nao funciona
    @Ignore//Funcionou também
    @Test
    public void verificarBuscaOrgaoDB(){
        Orgao orgao;
        OrgaoDao dao = new OrgaoDao();
        
        orgao = dao.recuperar(6L);
        
        System.out.println("Id:" + orgao.getId());
        System.out.println("Nome:" + orgao.getNome());
        System.out.println("Senha:" + orgao.getSenha());
        
    }
    
}
