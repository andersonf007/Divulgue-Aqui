
package excecoes;

/**
 *
 * @author Izaquias
 */


public class ViolacaoInsercaoException extends IllegalStateException{
    private static final long serialVersionUID = -7167410876701659109L;

    public ViolacaoInsercaoException(String s) {
        super("ERRO, Operação indesejada: ID não existe, houve uma inserção ao invés de uma atualização!");
    }

}
