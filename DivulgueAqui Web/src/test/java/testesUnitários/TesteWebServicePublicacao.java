package testesUnitários;

import com.google.gson.Gson;
import dao.PublicacaoDao;
import entidade.Publicacao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TesteWebServicePublicacao {
    
    @Ignore
    @Test
    public void inserirPublicacao() throws MalformedURLException, IOException{
        int code = 0;
        
        PublicacaoDao dao = new PublicacaoDao();
        Publicacao pb = null;
            
        String localidade = "br 2122";
        String descricao = "selvagen na estrada";
        long idUsuario = 1;
        
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

            pb = dao.recuperar((long)14);
            
        assertEquals(204,code);
        assertEquals(pb.getDescricao(),descricao);
        assertEquals(pb.getLocalidade(),localidade);
    }
    
    @Ignore
    @Test
    public void atualizarPublicacao() throws MalformedURLException, IOException{
        
        int code = 0;
        String descricao = "nevasca gigante";
        String localidade = "nunca menos";
        long codigo = 11;//codigo da publicacao
          
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
    
    @Ignore
    @Test
    public void recuperarPublicacoesPorIdDoUsuario() throws MalformedURLException, IOException{
        int code = 0;
       
        long codigo = 2; // id do usuario
            URL url;
        
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/pb/listaTodasPorIdUsuario?id="+codigo);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
          
            code = connection.getResponseCode();
       
        assertEquals(200,code);
    }
    
    @Ignore
    @Test 
    public void deletarPublicacao() throws MalformedURLException, IOException{
        int code = 0;
        URL url;
         
         Integer codigo = 6;   
      
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/pb/delete?id="+codigo);//codigo
        

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
          
            code = connection.getResponseCode();
    
        assertEquals(204,code);
    }
}
