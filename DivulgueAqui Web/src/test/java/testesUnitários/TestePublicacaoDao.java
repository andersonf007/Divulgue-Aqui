
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
    
    
    @Test 
    public void verificarInsercaoPublicacaoDB(){
        Publicacao publicacao = new Publicacao();
        PublicacaoDao dao = new PublicacaoDao();
        
        UsuarioDao usuDao = new UsuarioDao(); 
        Usuario usuario = usuDao.recuperar(4L);
        
        Date data = Date.from(Instant.now());
        publicacao.setCategoria("Segurança");
        publicacao.setDescricao("Professores violentos");
        publicacao.setLocalidade("Manuel chel");
        publicacao.setData(data);
        publicacao.setStatus("PENDENTE");
        publicacao.setUsuario(usuario);
        
        try {
            dao.inserir(publicacao);
            System.out.println("Publicação salva com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar salvar a publicação!" + e);
        }
        
    }
  
   
    @Test
    public void verificarAtualizacaoPublicacaoDB(){
        Publicacao publicacao;
        PublicacaoDao dao = new PublicacaoDao();
        
         publicacao  =  dao.recuperar(3L);
        
        publicacao.setCategoria("Saneamento");
        publicacao.setDescricao("Descaso social");
        publicacao.setLocalidade("Garanhuns");
        publicacao.setStatus("PENDENTE");
        
        try {
            dao.alterar(publicacao);
            System.out.println("Publicação altereda com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar alterar a publicação!" + e);
        }
        
    }
  
  
    @Test
    public void verificarExclusaoPublicacaoDB(){
        Publicacao publicacao;
        PublicacaoDao dao = new PublicacaoDao();
        
        publicacao  =  dao.recuperar(6L);
        
        try {
            dao.remover(publicacao);
            System.out.println("Publicação excluida com sucesso!");
        } catch (Exception e) {
            fail("Erro ao tentar excluida a publicação!"+e);
        }
    }
    
   //@Ignore
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
   
   //@Ignore
    @Test
    public void buscarPublicacaoPorId(){
        PublicacaoDao dao = new PublicacaoDao();
        

        Publicacao p =  dao.recuperar(2L);
        
        System.out.println("Categoria:" + p.getCategoria());
        System.out.println("Descrição:" + p.getDescricao());
        System.out.println("Localidade:" + p.getLocalidade());
        System.out.println("Data:" + p.getData());
        System.out.println("Status:" + p.getStatus());
        
    }
  
    //@Ignore
    @Test
    public void buscarPublicacaoPorStatus(){
        PublicacaoDao dao = new PublicacaoDao();
        List<Publicacao> publicacoes = dao.contaStatusPublicacao("Pendente");
        
        for (Publicacao p : publicacoes) {
           
               
            System.out.println("ID da Consulta:" + p.getId());
            System.out.println("Status da Consulta:" + p.getStatus());
                   
        }
    }
    
    //@Ignore
    @Test
    public void buscarProblemasPorStatusPendente(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaPendente();
        System.out.println("Número de Status pendente: " + quantidade);

    }
    @Ignore
    @Test
    public void buscarProblemasPorStatusAnalizando(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaAnalizando();
        System.out.println("Número de Status analizando: " + quantidade);
        
    }
    
    @Test
    public void buscarProblemasPorStatusResolvendo(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaResolvendo();
        System.out.println("Número de Status Resolvendo: " + quantidade);
    }
    
    @Test
    public void buscarProblemasPorStatusResolvido(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaResolvido();
        System.out.println("Número de Status Resolvido: " + quantidade);
    }
    @Test
    public void buscarProblemasPorStatusIgonaro(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaIgnorado();
        System.out.println("Número de Status Resolvido: " + quantidade);
    }
    
}
