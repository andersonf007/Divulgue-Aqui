/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ander
 */
public class MainPublicacao {
    public static void main(String[] args) {
          ///////////////////////////feeddenoticia-INSERIR///////////////////////////////////         
    //esta returnando codigo 204 porem inseri
    /*
        String localidade = "centro4";
        String descricao = "buraco";
        String categoria = "infra-estrutura";
        long idUsuario = 1;
        
        JSONObject jsonObject = new JSONObject();

        //Armazena dados em um Objeto JSON
        jsonObject.put("localidade", localidade);
        jsonObject.put("descricao", descricao);
        jsonObject.put("categoria", categoria);
        jsonObject.put("idUsuario", idUsuario);           
           
        Gson gson = new Gson();
        String Json = gson.toJson(jsonObject);

        URL url;
        try {
            url = new URL("http://localhost:8084/web/webresources/webService/feed/inserir");

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
         */   
    }
   
}
