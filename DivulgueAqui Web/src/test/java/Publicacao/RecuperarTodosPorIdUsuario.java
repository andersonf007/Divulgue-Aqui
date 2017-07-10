/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ander
 */
public class RecuperarTodosPorIdUsuario {
    public static void main(String[] args) {
        
        String localidade = "";
        String descricao = "";
        String categoria = "";
        String status = "";
        Date data = null;
        long idPublicacao = 0;
        long codigo = 2;
            URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/pb/listaTodasPorIdUsuario?id="+codigo);

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
            
            ArrayList<JSONObject> jsonObject;
       
            JSONParser parser = new JSONParser();  
      
            jsonObject = (ArrayList<JSONObject>) parser.parse(stringBuilder.toString());
    /*        
            for (JSONObject jsonObject1 : jsonObject) {
                localidade = (String) jsonObject.get("localidade");
                descricao = (String) jsonObject.get("descricao");
                categoria = (String) jsonObject.get("categoria");
                status = (String) jsonObject.get("status");
                data = (Date) jsonObject.get("data");
                idPublicacao = (long) jsonObject.get("idPublicacao");
            }
            //codigo = (long) jsonObject.get("codigo");
                                  
            System.out.println("o codigo é :" + codigo + " localidade : " + localidade 
            + " descricao : " + descricao + " categoria : " + categoria + "status : " + status + "data : " + data + "idPublicacao : " + idPublicacao);
  */      
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest ( recuperar usuario)\n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( Recuperar usuario) \n" + ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "erro de ParseException conexao ao rest ( Recuperar usuario) \n" + ex);
        }
    }
}
