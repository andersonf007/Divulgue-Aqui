package excecao;

/**
 *
 * @author Izaquias
 */


public class TransacaoException extends Exception{
    private static final long serialVersionUID = -7136158426337431534L;
    
    public static final String NAOCADASTROU = "Não conseguiu salvar  os dados!";
    public static final String NAOATUALIZOU = "Não conseguiu atualizar  os dados!";
    public static final String NAODELETOU = "Não conseguiu apagar os dados!";

    public TransacaoException(String msg) {
        super(msg);
    }
}
