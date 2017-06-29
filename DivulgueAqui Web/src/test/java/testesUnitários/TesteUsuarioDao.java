 
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
        
        usuario.setNome("usuarioComum");
        usuario.setEmail("usuario@gmail.com");
        usuario.setSenha("0000");
        
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
       
        usuario = dao.recuperar(4L);
        usuario.setNome("Carl Jonhson");
        usuario.setEmail("cj@gmail.com");
        usuario.setSenha("gta");
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
        
        usuario = dao.recuperar(6L);
        
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
           System.out.println("---------------------------");
       }
    }
    @Ignore
    @Test
    public void buscarUsuarioBDPorId(){
        UsuarioDao dao = new UsuarioDao();
        Usuario usuario;
        
        usuario = dao.recuperar(6L);
        System.out.println("Id:" + usuario.getId());
        System.out.println("Nome:" + usuario.getNome());
        System.out.println("E-mail:" + usuario.getEmail());
        System.out.println("Senha:" + usuario.getSenha());
        
    }
    @Test
    public void buscarUsuarioBDPorNome(){
        UsuarioDao dao = new UsuarioDao();
        
        Usuario usuario = dao.recuperarUsuarioIdNome("izaquias");
        System.out.println("Nome:" + usuario.getNome());
        System.out.println("Email:" + usuario.getEmail());
        System.out.println("Senha:" + usuario.getSenha()); 
    }
}
