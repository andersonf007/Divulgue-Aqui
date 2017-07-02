package WS;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import hibernate.Criptografia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("oi")
    public String oi(){  
        return "Olá mundo!";
    }

    static EntityManager manager;
     
    @Context
    private UriInfo context;

    
    public webService(){}
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////USUARIO////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
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
        String usuario;
        boolean validacao;
        
        try {
             jsonObject = (JSONObject) parser.parse(json);

             nome = (String) jsonObject.get("nome");
             email = (String)jsonObject.get("email");
             senha = (String) jsonObject.get("senha");
             usuario = (String) jsonObject.get("usuario");

            validacao = dao.verificarUsuarioPorNomeFicticio(usuario);

                if (validacao == true){

                 u.setNome(nome);              
                 u.setEmail(email);
                 u.setSenha(senha);
                 u.setSenha(Criptografia.encriptografar(u.getSenha()));
                 u.setUsuario(usuario);

                     try{
                         dao.inserir(u);
                         return "200";
                     }catch(Exception e){
                         System.out.println("nao foi possivel inserir o usuario (web service inserir usuario\n " + e);
                         return "301";
                     }

                } 

         } catch (ParseException ex) {
             Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return "301";
  
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
       
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/recuperar/nome")
    public String recuperarUsuarioPorNome(@QueryParam("nome") String json){
        
        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario();
        Gson g = new Gson();
        JSONObject jsonObject;
        JSONParser parser = new JSONParser(); 
        
        String usuario = null;
        String senha = null;
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
                   
            usuario = (String) jsonObject.get("usuario");
            senha = (String) jsonObject.get("senha");
       
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        u = dao.recuperarUsuarioPorNomeFicticio(usuario);
        //u = dao.recuperarUsuarioNome(usuario);
        
        if(u.getSenha().equals(Criptografia.encriptografar(senha))){
            return g.toJson(u);
        }else{
            return "305";
        }
    }
    
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
       // String usuario;
        long codigo;
	
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            nome = (String) jsonObject.get("nome");
            email = (String)jsonObject.get("email");
            senha = (String) jsonObject.get("senha");
           // usuario = (String) jsonObject.get("usuario");
            codigo = (Long) jsonObject.get("codigo");
            
            u = dao.recuperar(codigo);
           
            u.setEmail(email);
            u.setNome(nome);
            //u.setUsuario(usuario);
            u.setSenha(Criptografia.encriptografar(senha));
            
            try{
            dao.alterar(u);
            return "200";
            }catch(Exception e){
                System.out.println("nao foi possivel alterar o usuario ( rest atualizar) \n"+e);
            }
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
        
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/delete")
    public String deletarUsuario(@QueryParam("id") Integer json){
      
        PublicacaoDao daopb = new PublicacaoDao();
        Publicacao pb = new Publicacao();
       
        pb.setId((long)json);
        daopb.remover(pb);
        
        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario();
        
        u.setId((long)json);
        dao.remover(u);
  
        return null;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////ORGAO//////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
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
    @Path("orgao/recuperarId")
    public String recuperarId(@QueryParam("id") Long json){
        
        OrgaoDao dao = new OrgaoDao();
       Orgao o = new Orgao(); 
        
       o = dao.recuperar(json);
        
       Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
       String resultadoJson = g.toJson(o);
       return resultadoJson;
       
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
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////PUBLICACAO///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //colocar tratamento para mostrar msg pra quando nao tiver usuario
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("pb/inserir")
    public String insertPublicacao(String json){
    
       PublicacaoDao dao = new PublicacaoDao();
       Publicacao pb = new Publicacao();
       
       UsuarioDao daoUsuario = new UsuarioDao();
        Usuario u = new Usuario();
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String localidade;
        String descricao;
        String categoria;
        long idUsuario;
     
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            localidade = (String) jsonObject.get("localidade");
            descricao = (String) jsonObject.get("descricao");
            idUsuario =  (long) jsonObject.get("codigo");
            //categoria =  (String) jsonObject.get("categoria");
                    
            u = daoUsuario.recuperar(idUsuario);
           
            pb.setLocalidade(localidade);
            pb.setDescricao(descricao);
            //pb.setCategoria(categoria);
            pb.setStatus("Pendente");
            pb.setUsuario(u);
            
            try{
                dao.inserir(pb);
                return "204";
            }catch(Exception e){
                System.out.println("WS.webService.insertPublicacao()" + e);
            }
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pb/update")
    public String updatePublicacao(String json){
    
        PublicacaoDao dao = new PublicacaoDao();
        Publicacao p = new Publicacao();
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        //String categoria;
        String descricao;
        String localidade;
	long codigo;
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            //categoria = (String) jsonObject.get("categoria");
            descricao = (String) jsonObject.get("descricao");
            localidade = (String) jsonObject.get("localidade");
            codigo = (long) jsonObject.get("codigo");
            
            p = dao.recuperar(codigo);
            
            //p.setCategoria(categoria);
            p.setDescricao(descricao);
            p.setLocalidade(localidade);
            dao.alterar(p);
           
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pb/recuperarId")
    public String recuperarPublicacaoId(@QueryParam("id") Long json){
        
       PublicacaoDao dao = new PublicacaoDao();
       Publicacao pb = new Publicacao();
        
       pb = dao.recuperar(json);
        
       Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
       String resultadoJson = g.toJson(pb);
       return resultadoJson;
       
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pb/recuperarTodos")
    public String recuperarTodasPublicacoes(@QueryParam("id") Long json){
         
       PublicacaoDao dao = new PublicacaoDao();
       List<Publicacao> pb = dao.recuperarTodos();
       
       Gson g = new Gson();
       return g.toJson(pb);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pb/listaTodasPorIdUsuario")
    public String listarTodasPublicacoes(@QueryParam("id") Long json){
      
      PublicacaoDao dao = new PublicacaoDao();
      ArrayList<Publicacao> pbl = new ArrayList<>();
        
       pbl = (ArrayList<Publicacao>) dao.buscarPublicacaoPorIdUsuario(json);
    
        Gson g = new Gson();
       try{
            String resultado = g.toJson(pbl);
            return resultado;
        }catch(Exception e ){
            System.out.println("WS.webService.listarTodasPublicacoes()"+e);
        }
      return null;
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("pb/delete")
    public String deletarPublicacao(@QueryParam("id") Integer json){
      
        PublicacaoDao dao = new PublicacaoDao();
        Publicacao pb = new Publicacao();
       
        pb.setId((long)json);
        dao.remover(pb);
  
        return null;
    }
}
