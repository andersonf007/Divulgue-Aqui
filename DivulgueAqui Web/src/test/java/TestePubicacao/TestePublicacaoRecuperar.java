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
public class TestePublicacaoRecuperar {
    
    //@Ignore
    @Test
    public void recuperarPublicacoesPorIdDoUsuario() throws MalformedURLException, IOException{
        int code = 0;
       
        long codigo = 3; // id do usuario
            URL url;
        
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/pb/listaTodasPorIdUsuario?id="+codigo);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
          
            code = connection.getResponseCode();
       
        assertEquals(200,code);
    }
    
}
