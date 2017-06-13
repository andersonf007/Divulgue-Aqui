package WS;

import com.google.gson.Gson;
import dao.OrgaoDao;
import dao.PublicacaoDao;
import dao.UsuarioDao;
import entidade.Orgao;
import entidade.Publicacao;
import hibernate.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import entidade.Usuario;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author ander
 */
@Path("webService")
public class webService {

    static EntityManager manager;
     
    @Context
    private UriInfo context;

    
    public webService(){}
  ///////////////////////////USUARIO///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/inserir")
    public String insertUsuario(String json){

        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario();
        
        JSONObject jsonObject = null;
        JSONParser parser = new JSONParser();  
        
        String nome;
        String email;
        String senha;

           try {
                jsonObject = (JSONObject) parser.parse(json);

                nome = (String) jsonObject.get("nome");
                email = (String)jsonObject.get("email");
                senha = (String) jsonObject.get("senha");

                u.setNome(nome);
                u.setEmail(email);
                u.setSenha(senha);
                 try{
                dao.inserir(u);
                 }catch(Exception e){
                     System.out.println("WS.webService.insertUsuario() \n" + e);
                 }
                
            } catch (ParseException ex) {
                System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII" + ex);
                Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
            }
         return null;
  
}
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/recuperarPorId")
    public String recuperarUsuarioPorId(@QueryParam("id") Long json){
           
        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario();
        
        u = dao.recuperar(json);
        
        Gson g = new Gson();
        return g.toJson(u);
    }
    
    /*
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/recuperarPorNome")
    public String recuperarUsuarioPorNome(@QueryParam("nome") String json){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
      
        mod.setPesquisarPorNome(json);
        mod = u.buscarPorNome(mod);
        
        Gson g = new Gson();
        return g.toJson(mod);
    }
    */
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/update")
    public String updateUsuario(String json){
          
        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario();
       
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String nome;
        String email;
        String senha;
        long codigo;
	
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            nome = (String) jsonObject.get("nome");
            email = (String)jsonObject.get("email");
            senha = (String) jsonObject.get("senha");
            codigo = (long) jsonObject.get("codigo");
            
            u.setId(codigo);
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(senha);
                 
            dao.alterar(u);
           
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/delete")
    public String deletarUsuario(@QueryParam("id") Integer json){
      
        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario();
        
        u.setId((long)json);
        dao.remover(u);
  
        return null;
    }
    
    ///////////////////////////ORGAO///////////////////////////////////
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("orgao/inserir")
    public String insertOrgao(String json){
    
       OrgaoDao dao = new OrgaoDao();
       Orgao o = new Orgao(); 
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String nome;
        String senha;
	
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            nome = (String) jsonObject.get("nome");
            senha = (String) jsonObject.get("senha");
            
            
            o.setNome(nome);
            o.setSenha(senha);
            dao.inserir(o);
           
            
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("orgao/recuperar")
    public String recuperarUnico(@QueryParam("id") Long json){
        OrgaoDao dao = new OrgaoDao();
       Orgao o = new Orgao(); 
        
        o = dao.recuperar(json);
        
        Gson g = new Gson();
        return g.toJson(o);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("orgao/update")
    public String updateOrgao(String json){
          
       OrgaoDao dao = new OrgaoDao();
       Orgao o = new Orgao(); 
       
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String nome;
        String senha;
        long codigo;
	
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            nome = (String) jsonObject.get("nome");
            senha = (String) jsonObject.get("senha");
            codigo = (long) jsonObject.get("codigo");
            
            o.setId(codigo);
            o.setNome(nome);
            o.setSenha(senha);
                 
            dao.alterar(o);
           
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("orgao/delete")
    public String deletarOrgao(@QueryParam("id") Integer json){
      
       OrgaoDao dao = new OrgaoDao();
       Orgao o = new Orgao(); 
        
        o.setId((long)json);
        dao.remover(o);
  
        return null;
    }
    
    ///////////////////////////PUBLICACAO///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("publicacao/inserir")
    public String insertFeed(String json){
    
        Publicacao p = new Publicacao();
        PublicacaoDao dao = new PublicacaoDao();
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        UsuarioDao daoUsuario = new UsuarioDao();
        Usuario u = new Usuario();
        
       
        
        String localidade;
        String descricao;
        String categoria;
        long idUsuario;
     
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            localidade = (String) jsonObject.get("localidade");
            descricao = (String) jsonObject.get("descricao");
            categoria = (String) jsonObject.get("categoria");
            idUsuario =  (long) jsonObject.get("idUsuario");
            
            u = daoUsuario.recuperar(idUsuario);// recuperar o objeto do usuario
             
            p.setLocalidade(localidade);
            p.setData(Date.from(Instant.now()));
            p.setDescricao(descricao);
            p.setCategoria(categoria);
            try{
            p.setUsuario((Collection<Usuario>) u);
            }catch(Exception e){
                System.out.println("WS.webService.insertFeed()\n" + e);
            }
            dao.inserir(p);
   
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
   
}
