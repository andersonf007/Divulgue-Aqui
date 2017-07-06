
package testesUnitários;

import dao.PublicacaoDao;
import dao.UsuarioDao;
import entidade.Publicacao;
import entidade.Usuario;
import java.time.Instant;
import java.util.Date;
import java.util.List;
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
        
        UsuarioDao usuDao = new UsuarioDao(); 
        Usuario usuario = usuDao.recuperar(1L);
        
        Date data = Date.from(Instant.now());
        publicacao.setCategoria("Segurança");
        publicacao.setDescricao("Aumento de furtos");
        publicacao.setLocalidade("Vila do Quartel");
        publicacao.setData(data);
        publicacao.setStatus("Pendente");
        publicacao.setUsuario(usuario);
        
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
        
         publicacao  =  dao.recuperar(8L);
        
        publicacao.setCategoria("Saneamento");
        publicacao.setDescricao("Descaso social");
        publicacao.setLocalidade("Garanhuns");
        publicacao.setStatus("Pendente");
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
        
        publicacao  =  dao.recuperar(2L);
        
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
        
        Publicacao p =  dao.recuperar(9L);
        
        System.out.println("Categoria:" + p.getCategoria());
        System.out.println("Descrição:" + p.getDescricao());
        System.out.println("Localidade:" + p.getLocalidade());
        System.out.println("Data:" + p.getData());
        System.out.println("Status:" + p.getStatus());
        
    }
    @Ignore
    @Test
    public void buscarPublicacaoPorStatus(){
        PublicacaoDao dao = new PublicacaoDao();
        List<Publicacao> publicacoes = dao.contaStatusPublicacao("PENDENTE");
        
        for (Publicacao p : publicacoes) {
           
               
            System.out.println("ID da Consulta:" + p.getId());
            System.out.println("Status da Consulta:" + p.getStatus());
                   
        }
    }
}
