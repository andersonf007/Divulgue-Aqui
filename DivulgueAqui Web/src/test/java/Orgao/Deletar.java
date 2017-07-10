/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orgao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class Deletar {
    
    public static void main(String[] args) {
        
         URL url;
         
         Integer codigo = 2;   
        try {
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/orgao/delete?id="+codigo);//codigo
        

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
          
            int code = connection.getResponseCode();
            System.out.println(code);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "erro de URLException conexao ao rest (deletar usuario)\n" + ex);
        } catch (ProtocolException ex) {
            JOptionPane.showMessageDialog(null, "erro de ProtocolException conexao ao rest (deletar usuario) \n" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "erro de IOException conexao ao rest ( deletar usuario ) \n" + ex);
        }
    }
}
