/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicacao;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author ander
 */
public class Inserir {
    
    public static void main(String[] args) {
               
        String localidade = "interior do estado";
        String descricao = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        String categoria = "infra Estrutura";
        long idUsuario = 2;
        
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("categoria",categoria);
        jsonObject.put("localidade", localidade);
        jsonObject.put("descricao", descricao);
        jsonObject.put("codigo", idUsuario);    
        jsonObject.put("categoria", categoria); 
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/pb/inserir");

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
    }
}
