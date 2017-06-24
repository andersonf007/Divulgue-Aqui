
package testesUnitários;

import dao.PublicacaoDao;
import entidade.Publicacao;
import java.time.Instant;
import java.util.Date;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Izaquias
 */


public class TestePublicacaoDao {
    
    @Ignore 
    @Test 
    public void verificarInsercaoPublicacaoDB(){
        Publicacao publicacao = new Publicacao();
        PublicacaoDao dao = new PublicacaoDao();
        
        Date data = Date.from(Instant.now());
        publicacao.setCategoria("MinhaCat");
        publicacao.setDescricao("MinhaDesc");
        publicacao.setLocalidade("MinhaLoc");
        publicacao.setData(data);
        publicacao.setStatus("StatusAtu");
        
        try {
            dao.inserir(publicacao);
            System.out.println("Publicação salva com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar salvar a publicação!");
        }
        
    }
    @Ignore
    @Test
    public void verificarAtualizacaoPublicacaoDB(){
        Publicacao publicacao;
        PublicacaoDao dao = new PublicacaoDao();
        
         publicacao  =  dao.recuperar((long)5);
        //publicacao.setId(6);
        publicacao.setCategoria("Segurança X");
        publicacao.setDescricao("Aumento de Furtos 2");
        publicacao.setLocalidade("Magano");
        publicacao.setStatus("Resolvendo");
        //Date data = Date.from(Instant.now());
        //publicacao.setData(data);
        
        try {
            dao.alterar(publicacao);
            System.out.println("Publicação altereda com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar alterar a publicação!");
        }
        
    }
    @Ignore
    @Test
    public void verificarExclusaoPublicacaoDB(){
        Publicacao publicacao;
        PublicacaoDao dao = new PublicacaoDao();
        
        publicacao  =  dao.recuperar((long)5);
        
        //publicacao.setId(5);
        
        try {
            dao.remover(publicacao);
            System.out.println("Publicação excluida com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar excluida a publicação!");
        }
    }
    
    @Ignore
    @Test
    public void listarTodasPublicacoesBD(){
       PublicacaoDao dao = new PublicacaoDao();
       
       for(Publicacao p: dao.recuperarTodos()){
           System.out.println("Categoria" + p.getCategoria());
           System.out.println("Descrição" + p.getDescricao());
           System.out.println("Localidade" + p.getLocalidade());
           System.out.println("Data" + p.getData());
           System.out.println("Status" + p.getStatus());
           System.out.println("------------------------");
       }
    }
    @Ignore
    @Test
    public void buscarPublicacaoPorId(){
        PublicacaoDao dao = new PublicacaoDao();
        
        Publicacao p =  dao.recuperar((long)5);
        
        System.out.println("Categoria:" + p.getCategoria());
        System.out.println("Descrição:" + p.getDescricao());
        System.out.println("Localidade:" + p.getLocalidade());
        System.out.println("Data:" + p.getData());
        System.out.println("Status:" + p.getStatus());
        //System.out.println("Código do Usuario:" + p.getUsuario());
        System.out.println("------------------------");
    }
}
