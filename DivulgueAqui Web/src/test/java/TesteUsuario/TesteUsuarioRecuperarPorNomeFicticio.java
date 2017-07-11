/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteUsuario;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TesteUsuarioRecuperarPorNomeFicticio {
    
    //@Ignore
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
        assertEquals("robertaMaria@outlook.com", email);
        assertEquals("beta", nomeFicticio);
    }

}
