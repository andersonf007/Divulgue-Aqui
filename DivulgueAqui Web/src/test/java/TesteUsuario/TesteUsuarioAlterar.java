/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteUsuario;

import com.google.gson.Gson;
import dao.UsuarioDao;
import entidade.Usuario;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TesteUsuarioAlterar {
    
    //@Ignore
    @Test
    public void atualizarUsuario() throws MalformedURLException, IOException{
        int code = 0;
        String nome = "sonia23";
        String email = "sonia23@gmail.com.br";
        String senha = "1232";
        long codigo = 37;
        
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
        jsonObject.put("codigo", codigo);
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
     
            url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/update");

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
            
            UsuarioDao dao = new UsuarioDao();
            Usuario u = null;

            u = dao.recuperarUsuarioNome(nome);

        assertEquals(200,code);
        assertEquals(nome,u.getNome());
        assertEquals(email,u.getEmail());
    }
}
