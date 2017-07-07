 package testesUnitários;

import entidade.Administrador;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Izaquias
 */


public class TesteAdminstrador {
 
    @Rule
    public ExpectedException excecao = ExpectedException.none();
    
    @Test
    public void naoPermitirCriarAdminComNomeNulo(){
        excecao.expect(IllegalArgumentException.class);
        new Administrador(1L, null, "root@gmail.com", "0123");
    }
    @Test
    public void naoPermitirCriarAdminComNomeVazio(){
        excecao.expect(IllegalArgumentException.class);
        new Administrador(1L, "", "root@gmail.com", "0123");
    }
    @Test
    public void naoPermitirCriarAdminComEmailNulo(){
        excecao.expect(IllegalArgumentException.class);
        new Administrador(1L, "root", null, "0123");
    }
    @Test
    public void naoPermitirCriarAdminComEmailVazio(){
        excecao.expect(IllegalArgumentException.class);
        new Administrador(1L, "root", "", "0123");
    }
    @Test
    public void naoPermitirCriarAdminComSenhaNula(){
        excecao.expect(IllegalArgumentException.class);
        new Administrador(1L, "root", "roo@gmail.com", null);
    }
    @Test
    public void naoPermitirCriarAdminComSenhaVazia(){
        excecao.expect(IllegalArgumentException.class);
        new Administrador(1L, "root", "roo@gmail.com", "");
    }
}
