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
public class TesteUsuarioInserir {

    //@Ignore
    @Test
    public void inserirUsuario() throws MalformedURLException, IOException {
        int code = 0;
        String nome = "pessoa";
        String email = "p1234@gmail.com";
        String nomeFicticio = "p1234";
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

        url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/inserir");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");

        OutputStream os = connection.getOutputStream();
        os.write(Json.getBytes("UTF-8"));
        os.flush();

        code = connection.getResponseCode();

        os.close();
        connection.disconnect();

        UsuarioDao dao = new UsuarioDao();
        Usuario u = null;

        u = dao.recuperarUsuarioPorNomeFicticio(nomeFicticio);

        assertEquals(200, code);
        assertEquals(email, u.getEmail());
        assertEquals(nome, u.getNome());
        assertEquals(nomeFicticio, u.getUsuario());

    }

}
