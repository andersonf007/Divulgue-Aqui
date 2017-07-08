/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesUnitários;

import WS.webService;
import com.google.gson.Gson;
import dao.UsuarioDao;
import entidade.Usuario;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONObject;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author ander
 */
public class TesteWebService {
    
    webService WebService = new webService();
    
    @BeforeClass
    public void before(){
        
    }
    @Ignore
    @Test
    public void inserirUsuario(){
        
        String nome = "Sagfntas";
        String usuario = "aldgsient";
        String email = "Marigrasroberta@outlook.com.br";
        String senha = "123";
          
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("nome", nome);
        jsonObject.put("email", email);
        jsonObject.put("senha", senha);
        jsonObject.put("usuario", usuario);   
        
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);
        
        String resultado = WebService.insertUsuario(Json);
        
        UsuarioDao dao = new UsuarioDao();
        Usuario u = null;

        u = dao.recuperarUsuarioPorNomeFicticio(usuario);

        assertEquals(resultado, "200");
        assertEquals(email, u.getEmail());
        assertEquals(nome, u.getNome());
        assertEquals(usuario, u.getUsuario());

    }
   
}
