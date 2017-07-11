 
package testesUnitarios.DAO;

import dao.AdministradorDao;
import entidade.Administrador;
import excecao.TransacaoException;
import hibernate.Criptografia;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Izaquias
 */


public class TesteAdministradorDao {
    
    @Test
    public void vericarInsercaoAdminBD() throws TransacaoException{
        Administrador admin = new Administrador();
        AdministradorDao dao = new AdministradorDao();
        
        admin.setNome("admin");
        admin.setEmail("admin@gmail.com");
        admin.setSenha("1234");
        admin.setSenha(Criptografia.encriptografar(admin.getSenha()));
        
        dao.inserir(admin);
        
        List<Administrador> administradores = dao.recuperarTodos(); 
        Assert.assertEquals("novo", administradores.get(administradores.size() -1).getNome());
        
    }
    
    @Test
    public void vericarAtualizacaoAdminBD(){
        Administrador admin;
        AdministradorDao dao = new AdministradorDao();
        
        admin = dao.recuperar(7L);
        
        admin.setNome("extreme2");
        admin.setEmail("extreme2@gmail.com");
        admin.setSenha("321");
        admin.setSenha(Criptografia.encriptografar(admin.getSenha()));
        
        dao.alterar(admin);
        
        admin = dao.recuperar(7L); 
        Assert.assertEquals("extreme2", admin.getNome());
        
    }
    
    @Test
    public void listarTodosAdminBD(){
        
        AdministradorDao dao = new AdministradorDao();
        List<Administrador> administradores = dao.recuperarTodos(); 
        Assert.assertEquals("master", administradores.get(1).getNome());
        
    }
    
    @Test
    public void buscarAdminPorId(){
        AdministradorDao dao = new AdministradorDao();
        Administrador admin;
        
        admin = dao.recuperar(10L);
        
        Assert.assertEquals("mehor", admin.getNome());
    }
}
