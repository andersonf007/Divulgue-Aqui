 package excecoes;

/**
 *
 * @author Izaquias
 */


public class UsuarioMenorDeIdadeException extends IllegalStateException{
    private static final long serialVersionUID = 1L;
    
    public UsuarioMenorDeIdadeException(){
         super("Não é permitido um usuário com idade menor que 18 anos!");
    }
    
}
