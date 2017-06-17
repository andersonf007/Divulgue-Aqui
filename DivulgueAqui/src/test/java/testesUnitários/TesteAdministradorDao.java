 
package testesUnitários;

import dao.AdministradorDao;
import entidade.Administrador;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Izaquias
 */


public class TesteAdministradorDao {
    @Ignore
    @Test
    public void vericarInsercaoAdminBD(){
        Administrador admin = new Administrador();
        AdministradorDao dao = new AdministradorDao();
        
        admin.setNome("master");
        admin.setEmail("master@gmail.com");
        admin.setSenha("1000");
        
        try {
            dao.inserir(admin);
            System.out.println("Admin salvo com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar salvar o admin!");
        }
    }
    
    @Ignore
    @Test
    public void vericarAtualizacaoAdminBD(){
        Administrador admin = new Administrador();
        AdministradorDao dao = new AdministradorDao();
        
        admin.setId((long)4);
        admin.setNome("root");
        admin.setEmail("root@gmail.com");
        admin.setSenha("1000");
        
        try {
            dao.alterar(admin);
            System.out.println("Admin atualizado com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar atualizar o admin!");
        }
    }
    
    @Ignore
    @Test
    public void vericarExclusaoAdminBD(){
        Administrador admin = new Administrador();
        AdministradorDao dao = new AdministradorDao();
        
        admin.setId((long)2);
        admin.setNome("root");
        admin.setEmail("root@gmail.com");
        admin.setSenha("1000");
        
        try {
            dao.remover(admin);
            System.out.println("Admin exclido com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar excluir o admin!");
        }
    }
    @Ignore
    @Test
    public void listarTodosAdminBD(){
        
        AdministradorDao dao = new AdministradorDao();
        
        for(Administrador a: dao.recuperarTodos()){
            System.out.println("Nome:" + a.getNome());
            System.out.println("E-mail:" + a.getEmail());
            System.out.println("Senha:" + a.getSenha());
            System.out.println("-----------------------------");
        }
    }
}
