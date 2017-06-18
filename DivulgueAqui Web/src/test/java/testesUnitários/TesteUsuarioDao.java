 
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
        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        
        usuario.setId((long)5);
        usuario.setNome("usuariodiferente");
        usuario.setEmail("usuario@gmail.com");
        usuario.setSenha("000");
        
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
        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        
        usuario.setId((long)5);
        usuario.setNome("usuariodiferente");
        usuario.setEmail("usuario@gmail.com");
        usuario.setSenha("000");
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
}
