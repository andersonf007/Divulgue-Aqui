 
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
    public void verificarOrgaoUsuarioDB(){

        Orgao orgao = new Orgao();
        OrgaoDao dao = new OrgaoDao();
        
        orgao.setNome("Centro Administrativo");
        orgao.setSenha("1010");
        
        try {
             dao.inserir(orgao);
             System.err.println("Orgão salvo com sucesso!");
            
        } catch (Exception e) {
             Assert.fail("Erro ao tentar salvar");
        }
           
    }
    

    @Ignore
    @Test
    public void verificarAtualizacaoOrgaoDB(){
        Orgao orgao = new Orgao();
        orgao.setId(11);
        orgao.setNome("Administrativo");
        orgao.setSenha("1010");
        OrgaoDao dao = new OrgaoDao();
        
        try {
            
             dao.alterar(orgao);
             System.err.println("Orgão alterado com sucesso!");
        } catch (Exception e) {
            Assert.fail("Erro ao tentar alterar o orgão");
        }
        
    }
    
    @Test
    @Ignore
    public void verificarExclusaoOrgaoDB(){
        Orgao orgao = new Orgao();
        orgao.setId(11);
        orgao.setNome("Administrativo");
        orgao.setSenha("1010");
        OrgaoDao dao = new OrgaoDao();
        
        try {
             dao.remover(orgao);
             System.err.println("Orgão excluido com sucesso!");
        } catch (Exception e) {
            Assert.fail("Erro ao tentar excluir o orgão");
        }
    }
    @Ignore
    @Test
    public void verificarBuscaOrgaoDB(){
        Orgao orgao = new Orgao();
        orgao.setId(11);
        orgao.setNome("Administrativo");
        orgao.setSenha("1010");
        OrgaoDao dao = new OrgaoDao();
        
        //if(orgao.equals(dao.recuperar(long(11)))){
        
    
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
    
}
