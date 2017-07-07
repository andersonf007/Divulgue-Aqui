 
package testesUnitários;
import dao.UsuarioDao;
import entidade.Usuario;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Izaquias
 */


public class TesteUsuarioDao {
    
    @Ignore
    @Test
    public void verificarInsercaoUsuarioDB(){
        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        
        usuario.setNome("Adonaia");
        usuario.setEmail("adonaia@gmail.com");
        usuario.setSenha("2424");
        usuario.setUsuario("adonmaia");
        
        try {
            dao.inserir(usuario);
            System.out.println("Usuário salvo com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar salvar");
        }
    }
   
    @Ignore
    @Test
    public void verificarAtualizacaoUsuarioDB(){
        Usuario usuario;
        UsuarioDao dao = new UsuarioDao();
       
        usuario = dao.recuperar(30L);
        usuario.setNome("Carl Jonhson");
        usuario.setEmail("cj@gmail.com");
        usuario.setSenha("gta");
        usuario.setUsuario("carl");
        try {
            dao.alterar(usuario);
            System.out.println("Usuário alterado com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar alterar o usuário!");
        }
    }
  
    @Ignore
    @Test
    public void verificarExclusaoUsuarioDB(){
        Usuario usuario;
        UsuarioDao dao = new UsuarioDao();
        
        usuario = dao.recuperar(29L);
        
        try {
            dao.remover(usuario);
            System.out.println("Usuario excluido com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar excluir o usuário!");
        }
    }
    
    @Ignore
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
    
    @Ignore
    @Test
    public void buscarUsuarioBDPorId(){
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario;
        
        usuario = dao.recuperar(2L);
        System.out.println("Id:" + usuario.getId());
        System.out.println("Nome:" + usuario.getNome());
        System.out.println("E-mail:" + usuario.getEmail());
        System.out.println("Senha:" + usuario.getSenha());
        System.out.println("Ficticio:" + usuario.getUsuario());
    }
    
    @Ignore
    @Test
    public void buscarUsuarioBDPorNome(){
        UsuarioDao dao = new UsuarioDao();
        

        Usuario usuario = dao.recuperarUsuarioNome("Carl Jonhson");
        
        System.out.println("Nome:" + usuario.getNome());
        System.out.println("Email:" + usuario.getEmail());
        System.out.println("Senha:" + usuario.getSenha()); 
        System.out.println("Ficticio:" + usuario.getUsuario());    
    }
    
    
}
