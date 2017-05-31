
package WS;

import ModelBeans.BeansFeedDeNoticia;
import ModelBeans.BeansOrgao;
import ModelBeans.BeansUsuario;
import ModelDao.FeedDeNoticiaDao;
import ModelDao.OrgaoDao;
import ModelDao.UsuarioDao;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Context
    private UriInfo context;

    
    public webService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       return "meu web service";
    }
    ///////////////////////////USUARIO///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/inserir")
    public String insertUsuario(String json){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
        
        JSONObject jsonObject = null;
        JSONParser parser = new JSONParser();  
        
        String nome = "";
        String email = "";
        String senha;
        String nomeResposta = "";
        String emailResposta = "";
        String senhaResposta;
	
       /* 
        try {
            jsonObject = (JSONObject) parser.parse(json);
      
            
            nome = (String) jsonObject.get("nome");
        
            URL url= new URL("http://localhost:8084/web/webresources/webService/usuario/recuperarPorNome?nome="+nome);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
          
            int code = connection.getResponseCode();
            System.out.println(code);

            InputStream inputStrem = connection.getInputStream();
            BufferedReader br =  new BufferedReader(new InputStreamReader(inputStrem));
            
            String a;
            StringBuilder stringBuilder = new StringBuilder();
           
            while ((a  = br.readLine()) != null){
             //a += br.readLine();
             stringBuilder.append(a);
            }
          //  System.out.println(stringBuilder.toString());
            connection.disconnect();
      
            jsonObject = (JSONObject) parser.parse(stringBuilder.toString());
            
            // codigo = (long) jsonObject.get("codigo");
             nomeResposta = (String) jsonObject.get("nome");
             emailResposta = (String) jsonObject.get("email");
             senhaResposta = (String) jsonObject.get("senha");
            
          //  System.out.print(nomeResposta + emailResposta + senhaResposta);
        
          } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (nomeResposta.equals(nome)){
            // System.out.println("nome igual");
            return "300";
        }else{*/
           // System.out.println("nome diferente");
            
          
            try {
                jsonObject = (JSONObject) parser.parse(json);

                nome = (String) jsonObject.get("nome");
                email = (String)jsonObject.get("email");
                senha = (String) jsonObject.get("senha");


                mod.setNome(nome);
                if (u.validaEmail(email)){
                mod.setEmail(email);
                }else{
                    return "301";
                }
                mod.setSenha(senha);
                u.salvar(mod);           
                
                if(u.verificar() == true){
                    System.out.println("WS.webService.insertUsuario()");
                    return "300";  
                    // System.out.println("WS.webService.insertUsuario()");
                }
                return "200";
            } catch (ParseException ex) {
                Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}
         return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/recuperarPorId")
    public String recuperarUsuarioPorId(@QueryParam("id") Long json){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
      
        mod.setPesquisarPorId(json);
        mod = u.buscarPorId(mod);
        
        Gson g = new Gson();
        return g.toJson(mod);
    }
    
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
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/update")
    public String updateUsuario(String json){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
        
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
            
            
            mod.setNome(nome);
            mod.setEmail(email);
            mod.setSenha(senha);
            mod.setCodigo((int)codigo);
            u.editar(mod);           
           
            
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("usuario/delete")
    public String deletarUsuario(@QueryParam("id") Integer json){
        
        UsuarioDao u = new UsuarioDao();
        BeansUsuario mod = new BeansUsuario();
        
        mod.setCodigo(json);
        u.excluir(mod);
        
        return "";
    }
    ///////////////////////////ORGAO///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("orgao/inserir")
    public String insertOrgao(String json){
    
        OrgaoDao o = new OrgaoDao();
        BeansOrgao mod = new BeansOrgao();
        
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();  
        
        String nome;
        String senha;
	
        
        try {
            jsonObject = (JSONObject) parser.parse(json);
            
            nome = (String) jsonObject.get("nome");
            senha = (String) jsonObject.get("senha");
            
            
            mod.setNome(nome);
            mod.setSenha(senha);
            o.salvar(mod);           
           
            
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("orgao/recuperar")
    public String recuperarUnico(@QueryParam("id") Long json){
        OrgaoDao o = new OrgaoDao();
        BeansOrgao mod = new BeansOrgao();
        
        mod.setPesquisarId(json);
        mod = o.buscarPorId(mod);
        
        Gson g = new Gson();
        return g.toJson(mod);
    }
    
    
    ///////////////////////////FEED///////////////////////////////////
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("feed/inserir")
    public String insertFeed(String json){
    
        FeedDeNoticiaDao f = new FeedDeNoticiaDao();
        BeansFeedDeNoticia mod = new BeansFeedDeNoticia();
        
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
            categoria = (String) jsonObject.get("categoria");
            idUsuario =  (long) jsonObject.get("idUsuario");
            
            mod.setLocalidade(localidade);
            mod.setData(LocalDateTime.MAX);
            mod.setDescricao(descricao);
            mod.setCategoria(categoria);
            mod.setIdUsuario(idUsuario);
            f.salvar(mod);
   
        } catch (ParseException ex) {
            Logger.getLogger(webService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
   
}
