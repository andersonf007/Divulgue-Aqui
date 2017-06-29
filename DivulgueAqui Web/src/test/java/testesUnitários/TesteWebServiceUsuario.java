/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesUnitários;

import com.google.gson.Gson;
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
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TesteWebServiceUsuario {
  
    @Ignore
    @Test
    public void inserirUsuario(){
        int code = 0;
        
        String nome = "junior";
        String email = "junior@gmail.com";
        String nomeFicticio = "jr";
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
        
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/inserir");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(Json.getBytes("UTF-8"));
            os.flush();

            code = connection.getResponseCode();
            System.out.println(code + " - " + Json);

            os.close();
            connection.disconnect();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar cliente)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar cliente) \n" + ex);
            }
        
        assertEquals(200,code);
    }
    
    @Ignore
    @Test
    public void atualizarUsuario(){
        int code = 0;
        String nome = "Anderson";
        String email = "anderson@gmail.com.br";
        String senha = "123";
        long codigo = 1;
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
        jsonObject.put("codigo", codigo);
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/update");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(Json.getBytes("UTF-8"));
            os.flush();

            code = connection.getResponseCode();
            System.out.println(code + " - " + Json);

            os.close();
            connection.disconnect();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar cliente)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar cliente) \n" + ex);
            }  
        
        assertEquals(200,code);
    }

    @Ignore
    @Test
    public void recuperarUsuarioPorNomeFicticio(){
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
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/recuperar/nome?nome="+Json);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
          
            code = connection.getResponseCode();
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
            
             JSONParser parser = new JSONParser();  
      
            jsonObject = (JSONObject) parser.parse(stringBuilder.toString());
            
            nome = (String) jsonObject.get("nome");
            email = (String) jsonObject.get("email");
           // senha = (String) jsonObject.get("senha");
            nomeFicticio = (String) jsonObject.get("usuario");
                        
            System.out.println("o  nome : " + nome + " usuario: " + nomeFicticio
            + " email : " + email /*+ " senha : " + senha*/);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar usuario)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar usuario) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar usuario) \n" + ex);
        }
        assertEquals(200, code);
        assertEquals("Roberta", nome);
        assertEquals("roberta@gmail.com", email);
        assertEquals("beta ", nomeFicticio);
    }
    
    @Ignore
    @Test
    public void recuperarUsuarioPorId(){
        int code = 0;
        
        String nome = null;
        String email = null;
        String senha = null;
        String nomeFicticio = null;
        long codigo = 2;
            URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/recuperarPorId?id="+codigo);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
          
            code = connection.getResponseCode();
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
            
             JSONObject jsonObject;
       
             JSONParser parser = new JSONParser();  
      
            jsonObject = (JSONObject) parser.parse(stringBuilder.toString());
         
            nome = (String) jsonObject.get("nome");
            email = (String) jsonObject.get("email");
            //senha = (String) jsonObject.get("senha");
            nomeFicticio = (String) jsonObject.get("usuario");
                        
            System.out.println("o  nome : " + nome + " usuario: " + nomeFicticio
            + " email : " + email /*+ " senha : " + senha*/);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar usuario)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar usuario) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar usuario) \n" + ex);
        }
        
        assertEquals(200, code);
        assertEquals("Roberta", nome);
        assertEquals("roberta@gmail.com", email);
        assertEquals("beta ", nomeFicticio);
    }
    
    @Ignore
    @Test
    public void deletarUsuario(){
        int code = 0;
         URL url;
         
         Integer codigo = 4; 
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/delete?id="+codigo);//codigo
        

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
          
            code = connection.getResponseCode();
            System.out.println(code);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest (deletar usuario)\n" + ex);
        } catch (ProtocolException ex) {
            JOptionPane.showMessageDialog(null, "erro de ProtocolException conexao ao rest (deletar usuario) \n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( deletar usuario ) \n" + ex);
        }
        assertEquals(204, code);
    }
}
