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
        String email = "p12345678@gmail.com";
        String nomeFicticio = "p12345678";
        String senha = "123";

        JSONObject jsonObject = new JSONObject();//instancia um objeto json

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);// mapeia chaves para valores
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
        jsonObject.put("usuario", nomeFicticio);

        Gson gson = new Gson();
//Gson constroi uma instancia para que possa reutilizá-las livremente em vários tópicos.
        String Json = gson.toJson(jsonObject);
        //Este método serializa o objeto especificado em sua representação Json equivalente.
        //representar o estado de um objeto como uma sequência de bytes
        //sendo possivel salvar o objeto em um arquivo de dados


        URL url;

        url = new URL("http://localhost:8084/DivulgueAqui/webresources/webService/usuario/inserir");

        //HttpURLConnection é usada para fazer uma única solicitação
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);//Uma conexão de URL pode ser usada e ele estando true siginifica saida
        connection.setRequestMethod("POST");//Defina o método para a solicitação de URL
        connection.setRequestProperty("Content-Type", "application/json");//Define a propriedade de solicitação geral
                                     //O Content-Type é cabeçalho da entidade é usado para indicar o tipo

        // representa um fluxo de saída de byte
        OutputStream os = connection.getOutputStream();
        //obtém o fluxo de saída do processo.
        os.write(Json.getBytes("UTF-8"));
        os.flush();//Esvazia esse fluxo de saída

        code = connection.getResponseCode();

        //Fecha esse fluxo de saída
        os.close();
        //disconnect, Indica que outros pedidos para o servidor são improváveis ​​no futuro próximo

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
