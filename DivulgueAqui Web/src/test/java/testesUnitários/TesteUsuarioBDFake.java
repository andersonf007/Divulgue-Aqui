package testesUnitários;

import Fake.UsuariosBDFake;
import entidade.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Izaquias
 */


public class TesteUsuarioBDFake {
     
    private Usuario u,u1, u2, u3;
    
    @Rule
    public ExpectedException excecao = ExpectedException.none();
    
    @Before
    public void carregarAntes(){
        UsuariosBDFake usuFake = new UsuariosBDFake();
        u1 = new Usuario(0L, "Izaquias", "izaquias@gmail.com", "0123", "izaquias");
        u2 = new Usuario(0L, "Anne", "anne@gmail.com", "anne", "anne");
        u3 = new Usuario(1L, "isaias", "isaias@gmail.com", "isaias", "isaias");
    }
    
    @Test
    public void testarCadastroUsuarioBDFake(){
        UsuariosBDFake usuFake = new UsuariosBDFake();
        u = new Usuario(1L, "Izaquias", "izaquias@gmail.com", "0123", "izaquias");
         usuFake.inserir(u);
         Assert.assertEquals("Izaquias",u.getNome());
    }
//    
//    @Test
//    public void testarAtualizacaoUsuarioDBFake(){
//        UsuariosBDFake usuFake = new UsuariosBDFake();
//        
//        u = usuFake.recuperar(1L);
//        u.setNome("izaquias");
//        u.setEmail("izaquias@hotmail.com");
//        u.setSenha("007");
//        u.setUsuario("izaquias");
//        usuFake.alterar(u);
////        Assert.assertEquals("izaquias@hotmail.com" , u.getEmail());
//        
//    }
////    
//    @Test
//    public void deveLancarErroAoTentarCadastrarUsuarioComNomeNull(){
//        
//    }
//        
    
}
