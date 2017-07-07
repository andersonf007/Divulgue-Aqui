/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestePubicacao;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TestePublicacaoAtualizar {
    
    
    //@Ignore
    @Test
    public void atualizarPublicacao() throws MalformedURLException, IOException{
        
        int code = 0;
        String descricao = "nevasca gigante";
        String localidade = "nunca menos";
        long codigo = 14;//codigo da publicacao
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("descricao", descricao);
        jsonObject.put("localidade", localidade);
        jsonObject.put("codigo", codigo);
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/pb/update");

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
    
}
