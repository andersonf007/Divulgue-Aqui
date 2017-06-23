/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ander
 */
public class RecuperarNome {
    
    public static void main(String[] args) {
        
        String nome = "izaquias" ;
        String email;
        String senha;
        long codigo;
            URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/recuperar/nome?nome="+nome);

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
            
            //codigo = (long) jsonObject.get("codigo");
            //nome = (String) jsonObject.get("nome");
            email = (String) jsonObject.get("email");
            senha = (String) jsonObject.get("senha");
                        
            System.out.println("o  nome : " + nome 
            + " email : " + email + " senha : " + senha);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar usuario)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar usuario) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar usuario) \n" + ex);
        }
    }
}
