
package testesUnitarios.DAO;

import dao.PublicacaoDao;
import dao.UsuarioDao;
import entidade.Publicacao;
import entidade.Usuario;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
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
        publicacao.setDescricao("Aumento de Furtos!");
        publicacao.setLocalidade("Centro");
        publicacao.setData(data);
        publicacao.setStatus("PENDENTE");
        publicacao.setUsuario(usuario);
        
        dao.inserir(publicacao);
        
        List<Publicacao> problemas = dao.recuperarTodos();
        Assert.assertEquals("Centro", problemas.get(problemas.size()-1).getLocalidade());
        
    }
  
    @Test
    public void verificarAtualizacaoPublicacaoDB(){
        Publicacao publicacao;
        PublicacaoDao dao = new PublicacaoDao();
        
         publicacao  =  dao.recuperar(3L);
        
        publicacao.setCategoria("Saúde");
        publicacao.setDescricao("Descaso social");
        publicacao.setLocalidade("Garanhuns");
        publicacao.setStatus("PENDENTE");
        
        dao.alterar(publicacao);
        
        publicacao  =  dao.recuperar(3L);
        Assert.assertEquals("Saúde", publicacao.getCategoria());
        
        
    }
    @Ignore
    @Test
    public void verificarExclusaoPublicacaoDB(){
        Publicacao publicacao;
        PublicacaoDao dao = new PublicacaoDao();
        
        publicacao  =  dao.recuperar(6L);

            dao.remover(publicacao);
        
    }
    
   @Test
    public void listarTodasPublicacoesBD(){
       PublicacaoDao dao = new PublicacaoDao();
       List<Publicacao> publicacoes = dao.recuperarTodos();
       Assert.assertEquals("Saneamento", publicacoes.get(1).getCategoria());
    }
   
    @Test
    public void buscarPublicacaoPorId(){
        PublicacaoDao dao = new PublicacaoDao();
        

        Publicacao p =  dao.recuperar(2L);
        Assert.assertEquals("Saneamento",p.getCategoria());
        
    }
  
    @Test
    public void buscarPublicacaoPorStatus(){
        PublicacaoDao dao = new PublicacaoDao();
        List<Publicacao> publicacoes = dao.contaStatusPublicacao("PENDENTE");
        Assert.assertEquals("PENDENTE", publicacoes.get(3).getStatus());
        
    }
    
    @Ignore
    @Test
    public void buscarProblemasPorStatusPendente(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaPendente();
        Assert.assertEquals(7, quantidade);
        System.out.println("Número de Status pendente: " + quantidade);

    }
    
    //@Ignore
    @Test
    public void buscarProblemasPorStatusAnalizando(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaAnalizando();
        Assert.assertEquals(1, quantidade);
        System.out.println("Número de Status analizando: " + quantidade);
        
    }
    
    //@Ignore
    @Test
    public void buscarProblemasPorStatusResolvendo(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaResolvendo();
        Assert.assertEquals(1, quantidade);
        
        System.out.println("Número de Status Resolvendo: " + quantidade);
    }
    
    //@Ignore
    @Test
    public void buscarProblemasPorStatusResolvido(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaResolvido();
        Assert.assertEquals(1, quantidade);
        
        System.out.println("Número de Status Resolvido: " + quantidade);
    }
    
    //@Ignore
    @Test
    public void buscarProblemasPorStatusIgonaro(){
        PublicacaoDao dao = new PublicacaoDao();
        long quantidade = dao.contarStatusProblemaIgnorado();
        Assert.assertEquals(0, quantidade);
        
        System.out.println("Número de Status Resolvido: " + quantidade);
    }
    
}
