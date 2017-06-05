// ALTERAR O LINK DE TODAS AS REQUISICOES!


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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ander
 */
public class main {
    
    public static void main(String[] args) {
         // ALTERAR O LINK DE TODAS AS REQUISICOES!
    ///////////////////////////ORGAO-INSERIR/////////////////////////////////// 
      
        String nome = "caelresfdpe10";
        String senha = "1gfd23";
          
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
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar cliente)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar cliente) \n" + ex);
            }
        
     ///////////////////////////ORGAO-RECUPERAR/////////////////////////////////// 
     /*
        String nome ;
        String senha;
        long codigo = 2;
            URL url;
        try {
            url = new URL("http://localhost:8084/web/webresources/webService/orgao/recuperar?id="+codigo);

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
            
            codigo = (long) jsonObject.get("codigo");
            nome = (String) jsonObject.get("nome");
            senha = (String) jsonObject.get("senha");
                        
            System.out.println("o codigo é :" + codigo + " nome : " + nome 
            + " senha : " + senha);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar usuario)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar usuario) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar usuario) \n" + ex);
        }
         */    
    ///////////////////////////USUARIO-INSERIR///////////////////////////////////         
    //esta returnando codigo 204 porem inseri
        /*
        String nome = "andernmson";
        String email = "cghjhgelp@celp.com";
        String senha = "12hkj3";
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
           
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

            int code = connection.getResponseCode();
            System.out.println(code + " - " + Json);

            os.close();
            connection.disconnect();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar cliente)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar cliente) \n" + ex);
            }
      
    
    ///////////////////////////USUARIO-RECUPERAR POR ID ///////////////////////////////////
    /*
        String nome ;
        String email;
        String senha;
        long codigo = 1;
            URL url;
        try {
            url = new URL("http://localhost:8084/web/webresources/webService/usuario/recuperarPorId?id="+codigo);

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
            
            codigo = (long) jsonObject.get("codigo");
            nome = (String) jsonObject.get("nome");
            email = (String) jsonObject.get("email");
            senha = (String) jsonObject.get("senha");
                        
            System.out.println("o codigo é :" + codigo + " nome : " + nome 
            + " email : " + email + " senha : " + senha);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar usuario)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar usuario) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar usuario) \n" + ex);
        }
    */
    ///////////////////////////USUARIO-RECUPERAR POR NOME ///////////////////////////////////
    /*
        String nome = "marcela" ;
        String email;
        String senha;
        long codigo;
            URL url;
        try {
            url = new URL("http://localhost:8084/web/webresources/webService/usuario/recuperarPorNome?nome="+nome);

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
            
            codigo = (long) jsonObject.get("codigo");
            nome = (String) jsonObject.get("nome");
            email = (String) jsonObject.get("email");
            senha = (String) jsonObject.get("senha");
                        
            System.out.println("O codigo é :" + codigo + " nome : " + nome 
            + " email : " + email + " senha : " + senha);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar usuario)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar usuario) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar usuario) \n" + ex);
        }
    */
    ///////////////////////////USUARIO-ATUALIZAR ///////////////////////////////////
    /*
        String nome = "anderson";
        String email = "anderson@gmail.com.br";
        String senha = "123";
        long codigo = 52;
          
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

            int code = connection.getResponseCode();
            System.out.println(code + " - " + Json);

            os.close();
            connection.disconnect();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar cliente)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar cliente) \n" + ex);
            }
    
    
    ///////////////////////////USUARIO-DELETAR ///////////////////////////////////
    /*
        Integer codigo = 2;
            URL url;
        
        try {
            url = new URL("http://localhost:8084/web/webresources/webService/usuario/delete?id="+codigo);
        

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
          
            int code = connection.getResponseCode();
            System.out.println(code);

        } catch (MalformedURLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
    ///////////////////////////feeddenoticia-INSERIR///////////////////////////////////         
    //esta returnando codigo 204 porem inseri
    /*
        String localidade = "centro4";
        String descricao = "buraco";
        String categoria = "infra-estrutura";
        long idUsuario = 1;
        
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("localidade", localidade);
        jsonObject.put("descricao", descricao);
        jsonObject.put("categoria", categoria);
        jsonObject.put("idUsuario", idUsuario);           
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        try {
            url = new URL("http://localhost:8084/web/webresources/webService/feed/inserir");

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
                JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( salvar cliente)\n" + ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( salvar cliente) \n" + ex);
            }
         */   
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    }
    
}
