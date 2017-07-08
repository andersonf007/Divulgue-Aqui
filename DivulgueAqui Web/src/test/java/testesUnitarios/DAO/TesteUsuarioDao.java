 
package testesUnitarios.DAO;
import dao.UsuarioDao;
import entidade.Usuario;
import hibernate.Criptografia;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Izaquias
 */


public class TesteUsuarioDao {
    
   @Test
    public void verificarInsercaoUsuarioDB(){
        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        
        usuario.setNome("Michael Jackson");
        usuario.setEmail("jackson@gmail.com");
        usuario.setSenha("2448");
        usuario.setUsuario("michael");
        usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
        
        dao.inserir(usuario);
            
    }
    
    @Test
    public void verificarAtualizacaoUsuarioDB(){
        Usuario usuario;
        UsuarioDao dao = new UsuarioDao();
       
        usuario = dao.recuperar(4L);
        usuario.setNome("Carl");
        usuario.setEmail("cj@gmail.com");
        usuario.setSenha("gtasa");
        usuario.setUsuario("carlos");
        usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
        
        dao.alterar(usuario);
        
        usuario = dao.recuperar(4L);
        Assert.assertEquals("carlos", usuario.getUsuario());
    }
    
    @Test
    public void verificarExclusaoUsuarioDB(){
        Usuario usuario;
        UsuarioDao dao = new UsuarioDao();

        usuario = dao.recuperar(6L);
        
        dao.remover(usuario);
        
    }
    
    @Test
    public void listarTodosUsuariosBD(){
       UsuarioDao dao = new UsuarioDao();
       
       List<Usuario> usuarios = dao.recuperarTodos();
       Assert.assertEquals("izaquias", usuarios.get(0).getNome());
       Assert.assertEquals("Carl", usuarios.get(1).getNome());
    }
    @Test
    public void buscarUsuarioBDPorId(){
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario;
        
        usuario = dao.recuperar(3L);
        
        Assert.assertEquals("izaquias", usuario.getNome());
    }
    @Test
    public void buscarUsuarioBDPorNome(){
        UsuarioDao dao = new UsuarioDao();

        Usuario usuario = dao.recuperarUsuarioNome("Gabliele");
        Assert.assertEquals("Gabliele", usuario.getNome());    
    }
    
//    @Test
//    public void fazerLoginUsuario(){
//         String usuario = "izaquias"; 
//         String senha = "izaquias21";
//         UsuarioDao dao = new UsuarioDao();
//         
//         Usuario u = dao.recuperar(3L);
//         
//         
//         Assert.assertEquals(usuario, u.getUsuario());
//         Assert.assertEquals(senha,Criptografia.encriptografar(u.getSenha()));
//         //usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
////        try {
////            
////            System.out.println("Usuario: " + u.getUsuario());
////            System.out.println("Senha: " + u.getSenha());
////            System.out.println("Logou no sistema!");   
////        } catch (Exception e) {
////          System.out.println("Não logou no sistema!");
////        }
//         
//}
//  
    
}
