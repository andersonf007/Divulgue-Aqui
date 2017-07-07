 
package testesUnitários;
import dao.UsuarioDao;
import entidade.Usuario;
import hibernate.Criptografia;
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
        
        try {
            dao.inserir(usuario);
            System.out.println("Usuário salvo com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar salvar");
        }
    }
    
    @Test
    public void verificarAtualizacaoUsuarioDB(){
        Usuario usuario;
        UsuarioDao dao = new UsuarioDao();
       
        usuario = dao.recuperar(4L);
        usuario.setNome("Carl");
        usuario.setEmail("cj@gmail.com");
        usuario.setSenha("gtasa");
        usuario.setUsuario("carl");
        usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
        try {
            dao.alterar(usuario);
            System.out.println("Usuário alterado com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar alterar o usuário!");
        }
    }
    
    @Test
    public void verificarExclusaoUsuarioDB(){
        Usuario usuario;
        UsuarioDao dao = new UsuarioDao();
        
        usuario = dao.recuperar(6L);
        
        try {
            dao.remover(usuario);
            System.out.println("Usuario excluido com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar excluir o usuário!");
        }
    }
    
    
    @Test
    public void listarTodosUsuariosBD(){
       UsuarioDao dao = new UsuarioDao();
       
       for(Usuario u: dao.recuperarTodos()){
           System.out.println("Nome:" + u.getNome());
           System.out.println("E-mail:" + u.getEmail());
           System.out.println("Senha:" + u.getSenha());
           System.out.println("Ficticio:" + u.getUsuario());
           System.out.println("---------------------------");
       }
    }
    
    @Test
    public void buscarUsuarioBDPorId(){
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario;
        
        usuario = dao.recuperar(4L);
        System.out.println("Id:" + usuario.getId());
        System.out.println("Nome:" + usuario.getNome());
        System.out.println("E-mail:" + usuario.getEmail());
        System.out.println("Senha:" + usuario.getSenha());
        System.out.println("Ficticio:" + usuario.getUsuario());
    }
   
    @Test
    public void buscarUsuarioBDPorNome(){
        UsuarioDao dao = new UsuarioDao();
        

        Usuario usuario = dao.recuperarUsuarioNome("Gabliele");
        
        System.out.println("Nome:" + usuario.getNome());
        System.out.println("Email:" + usuario.getEmail());
        System.out.println("Senha:" + usuario.getSenha()); 
        System.out.println("Ficticio:" + usuario.getUsuario());    
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
