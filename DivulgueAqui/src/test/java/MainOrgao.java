
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ander
 */
public class MainOrgao {
    
    public static void main(String[] args) {
         ///////////////////////////ORGAO-INSERIR/////////////////////////////////// 
      /*
        String nome = "compesa";
        String senha = "321";
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("senha", senha);
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/orgao/inserir");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(Json.getBytes("UTF-8"));
            os.flush();

            int code = connection.getResponseCode();
            System.out.println(code + " - " + Json);

            os.close();
            connection.disconnect();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar orgao)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar orgao) \n" + ex);
            }
       */
     ///////////////////////////ORGAO-RECUPERAR/////////////////////////////////// 
     /*
        String nome ;
        String senha;
        long codigo = 2;
            URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/orgao/recuperar?id="+codigo);

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
            
             JSONObject jsonObject;
       
             JSONParser parser = new JSONParser();  
      
            jsonObject = (JSONObject) parser.parse(stringBuilder.toString());
            
          //  codigo = (long) jsonObject.get("codigo");
            nome = (String) jsonObject.get("nome");
            senha = (String) jsonObject.get("senha");
                        
            System.out.println("o codigo é :" + codigo + " nome : " + nome 
            + " senha : " + senha);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar orgao)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar orgao) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar orgao) \n" + ex);
        }*/
     
     //////////////////////////////////////////ATUALIZAR ORGAO /////////////////////////////////////////////////////////
     /*
        String nome = "celpe";
        String senha = "123";
        long codigo = 1;
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("senha", senha);
        jsonObject.put("codigo", codigo);
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/orgao/update");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.write(Json.getBytes("UTF-8"));
            os.flush();

            int code = connection.getResponseCode();
            System.out.println(code + " - " + Json);

            os.close();
            connection.disconnect();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar orgao)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar orgao) \n" + ex);
            }
            */
     
     //////////////////////////////////////////DELETAR///////////////////////////////////////
     /*
     
     Integer codigo = 3;
            URL url;
        
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/orgao/delete?id="+codigo);
        

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
          
            int code = connection.getResponseCode();
            System.out.println(code);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest (deletar orgao)\n" + ex);
        } catch (ProtocolException ex) {
            JOptionPane.showMessageDialog(null, "erro de ProtocolException conexao ao rest (deletar orgao) \n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( deletar orgao ) \n" + ex);
        }*/
    }
}
