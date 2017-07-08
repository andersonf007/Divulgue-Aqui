package testesUnitarios.modelo;

import entidade.Pessoa;
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
        new Pessoa(null, "Brejão");
    }
    
    @Test
    public void naoPermitirCriarPessoaNomeVazio(){
        excecao.expect(IllegalArgumentException.class);
        new Pessoa("", "Brejão");
    }
    
    @Test
    public void naoPermitirCriarPessoaComEnderecoNulo(){
        excecao.expect(IllegalArgumentException.class);
        new Pessoa("Izaquias", null);
    }
    
    @Test
    public void naoPermitirCriarPessoaComEnderecoVazio(){
        excecao.expect(IllegalArgumentException.class);
        new Pessoa("Izaquias", "");
    }
    
}
