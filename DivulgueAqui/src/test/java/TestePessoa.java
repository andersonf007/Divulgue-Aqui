import entidade.PessoaEntidade;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Izaquias
 */
public class TestePessoa {
    
    
    @Rule
    public  ExpectedException excecao = ExpectedException.none();
    
    @Test
    public void naoPermitirCriarPessoaNomeComNulo(){
        excecao.expect(IllegalArgumentException.class);
        new PessoaEntidade(null, "Brejão");
    }
    
    @Test
    public void naoPermitirCriarPessoaNomeVazio(){
        excecao.expect(IllegalArgumentException.class);
        new PessoaEntidade("", "Brejão");
    }
    
    @Test
    public void naoPermitirCriarPessoaComEnderecoNulo(){
        excecao.expect(IllegalArgumentException.class);
        new PessoaEntidade("Izaquias", null);
    }
    
    @Test
    public void naoPermitirCriarPessoaComEnderecoVazio(){
        excecao.expect(IllegalArgumentException.class);
        new PessoaEntidade("Izaquias", "");
    }
    
}
