import excecoes.UsuarioMenorDeIdadeException;
import entidade.UsuarioEntidade;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Izaquias
 */
public class TesteUsuario {
    
    @Rule
    public ExpectedException excecao = ExpectedException.none();
    
    @Test
    public void naoPermitirCriarUsuarioNomeNulo(){
        excecao.expect(IllegalArgumentException.class);
        new UsuarioEntidade(null, "izaquias@gmail.com", "izaquais20");
        
    }
    
    @Test
    public void naoPermitirCriarUsuarioNomeVazio(){
        excecao.expect(IllegalArgumentException.class);
        new UsuarioEntidade("", "izaquias@gmail.com", "izaquais20");
        
    }
    
    @Test
    public void naoPermitirCriarUsuarioEmailNulo(){
        excecao.expect(IllegalArgumentException.class);
        new UsuarioEntidade("izaquias", null, "izaquias21");
    }
    
    @Test
    public void naoPermitirCriarUsuarioEmailVazio(){
        excecao.expect(IllegalArgumentException.class);
        new UsuarioEntidade("izaquias", "", "izaquias21");
    } 
    
    @Test
    public void naoPermitirCriarUsuarioSenhaNula(){
        excecao.expect(IllegalArgumentException.class);
        new UsuarioEntidade("izaquias", "izaquias@gmail.com", null);
    }
    
    @Test
    public void naoPermitirCriarUsuarioSenhaVazia(){
        excecao.expect(IllegalArgumentException.class);
        new UsuarioEntidade("izaquias", "izaquias@gmail.com", "");
    }
    @Ignore
    @Test
    public void naoPermitirCriarUsuarioMenorDeIdade(){
        excecao.expect(UsuarioMenorDeIdadeException.class);
        new UsuarioEntidade("izaquias", "izaquias@gmail.com", "izaquias21");
    }
}
