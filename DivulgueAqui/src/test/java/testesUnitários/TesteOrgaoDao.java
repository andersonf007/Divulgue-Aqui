 
package testesUnitários;

import dao.OrgaoDao;
import entidade.Orgao;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Izaquias
 */


public class TesteOrgaoDao {
 
    @Test
    public void verificarInsercaoDB(){
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
    
}
