
import dao.PublicacaoDao;
import entidade.Publicacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 *
 * @author Izaquias
 */
public class PublicacaoNamedQuerie {
     public static void main(String[]args){
         
         PublicacaoDao dao = new PublicacaoDao();
         List<Publicacao> publicacaoes =  dao.consultarPorUsuario(4L);
         
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
          for (Publicacao p : publicacaoes) {
              System.out.println("Categoria:" + p.getCategoria());
              System.out.println("Descricao:" + p.getDescricao());
              System.out.println("Localidade:" + p.getLocalidade());
              System.out.println("Data:" + df.format(p.getData()));
              System.out.println("Status:" + p.getStatus());
         }
     }    
}
