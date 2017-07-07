 
package testesUnitários;
import dao.UsuarioDao;
import entidade.Usuario;
import hibernate.Criptografia;
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
        
        usuario.setNome("Dracula");
        usuario.setEmail("dracula@gmail.com");
        usuario.setSenha("2048");
        usuario.setUsuario("dracula");
        usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
        
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

    @Ignore
    @Test
    public void verificarExclusaoUsuarioDB(){
        Usuario usuario;
        UsuarioDao dao = new UsuarioDao();
       
        usuario = dao.recuperar(1L);
        
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
        
        usuario = dao.recuperar(4L);

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
        

        Usuario usuario = dao.recuperarUsuarioNome("Gabliele");
        
        System.out.println("Nome:" + usuario.getNome());
        System.out.println("Email:" + usuario.getEmail());
        System.out.println("Senha:" + usuario.getSenha()); 
        System.out.println("Ficticio:" + usuario.getUsuario());    
    }
//    
//    @Test
//    public void fazerLoginUsuario(){
//         UsuarioDao dao = new UsuarioDao();
//         
//         Usuario usuario = dao.recuperar(3L);
//         
//         //Usuario u;
//         
//         
//         //usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));
//        try {
//            Usuario  u = dao.buscarUsuarioPorNomeSenha(usuario.getUsuario(),usuario.getSenha());
//            System.out.println("Usuario: " + u.getUsuario());
//            System.out.println("Senha: " + u.getSenha());
//            System.out.println("Logou no sistema!");   
//        } catch (Exception e) {
//          System.out.println("Não logou no sistema!");
//        }
//         
//}
//    }
    
}
