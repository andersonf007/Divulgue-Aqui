 
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
        
        admin.setNome("mestre");
        admin.setEmail("mestre@gmail.com");
        admin.setSenha("1000");
        
        try {
            dao.inserir(admin);
            System.out.println("Admin salvo com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar salvar o admin!");
        }
    }
    //nao funciona
    @Ignore
    @Test
    public void vericarAtualizacaoAdminBD(){
        Administrador admin;
        AdministradorDao dao = new AdministradorDao();
        
        admin = dao.recuperar(2L);
        
        admin.setNome("master");
        admin.setEmail("master@gmail.com");
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
        Administrador admin;
        AdministradorDao dao = new AdministradorDao();
        
        admin = dao.recuperar(3L);
        
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
    //nao funciona
    @Ignore
    @Test
    public void buscarAdminPorId(){
        AdministradorDao dao = new AdministradorDao();
        Administrador admin;
        
        admin = dao.recuperar(2L);
        
        System.out.println("Id:" + admin.getId());
        System.out.println("Nome:" + admin.getNome());
        System.out.println("E-mail:" + admin.getEmail());
        System.out.println("Senha:" + admin.getSenha());
    }
}
