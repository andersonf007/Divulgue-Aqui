/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteUsuario;

import com.google.gson.Gson;
import dao.UsuarioDao;
import entidade.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TesteWebServiceUsuario {
  
    @Ignore
    @Test
    public void inserirUsuario() throws MalformedURLException, IOException{
        int code = 0;
        String nome = "pessoa";
        String email = "p12@gmail.com";
        String nomeFicticio = "p12";
        String senha = "123";
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
        jsonObject.put("usuario", nomeFicticio);
           
        Gson gson = new Gson(); 

        String Json = gson.toJson(jsonObject);
       

        URL url;
      
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/inserir");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            
            
            OutputStream os = connection.getOutputStream();
                                           
            os.write(Json.getBytes("UTF-8"));
            os.flush();

            code = connection.getResponseCode();
            
            os.close();
            
            connection.disconnect();
            
             UsuarioDao dao = new UsuarioDao();
            Usuario u = null;
        
            u = dao.recuperarUsuarioPorNomeFicticio(nomeFicticio);
            
        assertEquals(200,code);
        assertEquals(u.getEmail(),email);
        assertEquals(u.getNome(),nome);
        assertEquals(u.getUsuario(),nomeFicticio);
        
        
    }
    
    @Ignore
    @Test
    public void atualizarUsuario() throws MalformedURLException, IOException{
        int code = 0;
        String nome = "rodrigo";
        String email = "rodrigo@gmail.com.br";
        String senha = "123";
        long codigo = 22;
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
        jsonObject.put("codigo", codigo);
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
     
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/update");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(Json.getBytes("UTF-8"));
            os.flush();

            code = connection.getResponseCode();

            os.close();
            connection.disconnect();

        assertEquals(200,code);
    }

    @Ignore
    @Test
    public void recuperarUsuarioPorNomeFicticio() throws MalformedURLException, IOException, ParseException{
        int code = 0;
        
        String nome = null ;
        String email = null;
        String nomeFicticio = "beta";
        String senha = "123";
        
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("usuario", nomeFicticio);
        jsonObject.put("senha", senha);
       
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);
       
            URL url;
        
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/recuperar/nome?nome="+Json);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
          
            code = connection.getResponseCode();

            InputStream inputStrem = connection.getInputStream();
            BufferedReader br =  new BufferedReader(new InputStreamReader(inputStrem));
            
            String a;
            StringBuilder stringBuilder = new StringBuilder();
            
            while ((a  = br.readLine()) != null){
             stringBuilder.append(a);
            }
            
            connection.disconnect();
            
             JSONParser parser = new JSONParser();  
      
            jsonObject = (JSONObject) parser.parse(stringBuilder.toString());
            
            nome = (String) jsonObject.get("nome");
            email = (String) jsonObject.get("email");
            nomeFicticio = (String) jsonObject.get("usuario");
            
        assertEquals(200, code);
        assertEquals("Roberta Maria Silva Santos", nome);
        assertEquals("robertaMaria@outlook.com.br", email);
        assertEquals("beta", nomeFicticio);
    }

    @Ignore
    @Test
    public void deletarUsuario() throws MalformedURLException, IOException{
        int code = 0;
         URL url;
         
         Integer codigo = 28; 
      
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/delete?id="+codigo);//codigo
        

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
          
            code = connection.getResponseCode();

        assertEquals(204, code);
    }
}
