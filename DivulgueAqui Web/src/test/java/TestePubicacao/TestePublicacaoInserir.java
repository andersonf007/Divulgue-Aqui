/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestePubicacao;

import com.google.gson.Gson;
import dao.PublicacaoDao;
import entidade.Publicacao;
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
public class TestePublicacaoInserir {
    
    //@Ignore
    @Test
    public void inserirPublicacao() throws MalformedURLException, IOException{
        int code = 0;
        
        PublicacaoDao dao = new PublicacaoDao();
        Publicacao pb = null;
            
        String localidade = "br 22";
        String descricao = "animais vivos na estrada";
        long idUsuario = 3;
        
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("localidade", localidade);
        jsonObject.put("descricao", descricao);
        jsonObject.put("codigo", idUsuario);    
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/pb/inserir");

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

            pb = dao.recuperar((long)44);
            
        assertEquals(200,code);
        assertEquals(descricao,pb.getDescricao());
        assertEquals(localidade,pb.getLocalidade());
    }
    
}
