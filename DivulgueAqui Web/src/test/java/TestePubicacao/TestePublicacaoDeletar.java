/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestePubicacao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TestePublicacaoDeletar {
    
    
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
