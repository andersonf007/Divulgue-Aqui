package testesUnitários;

import entidade.Publicacao;
import java.time.Instant;
import java.util.Date;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Izaquias
 */


public class TestePublicacao {
    
    @Rule
    public ExpectedException excecao = ExpectedException.none();
    
    @Test
    public void naoDevePermitirCriarPublicacaoComDescricaoNula(){
        excecao.expect(IllegalArgumentException.class);
        Date data = Date.from(Instant.now());
        new Publicacao("categoria x", "tal", data, null, "PENDENTE");
    }
    @Test
    public void naoDevePermitirCriarPublicacaoComDescricaoVazia(){
        excecao.expect(IllegalArgumentException.class);
        Date data = Date.from(Instant.now());
        new Publicacao("categoria x", "tal", data, "", "PENDENTE");
    }
    @Test
    public void naoDevePermitirCriarPublicacaoComLocalidadeNula(){
        excecao.expect(IllegalArgumentException.class);
        Date data = Date.from(Instant.now());
        new Publicacao("categoria x", null, data, "descrição x", "PENDENTE");
    }
    @Test
    public void naoDevePermitirCriarPublicacaoComLocalidadeVazia(){
        excecao.expect(IllegalArgumentException.class);
        Date data = Date.from(Instant.now());
        new Publicacao("categoria x", "", data, "descrição x", "PENDENTE");
    }
}
