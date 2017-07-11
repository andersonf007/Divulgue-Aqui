
package hibernate;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Izaquias
 */


public class Criptografia {
    
    public static String encriptografar(String senha){
        
        String retorno = "";
         
          MessageDigest criprografar;
          
        try {
              criprografar = MessageDigest.getInstance("MD5");
              System.out.println("Convertendo senha....");
              BigInteger hashSize = new BigInteger(1, criprografar.digest(senha.getBytes()));
              System.out.println("Concluiu, esperando número de caracteres!");
              return hashSize.toString(32);
        } catch (Exception e) {
              System.out.println("Erro ao tentar ciptografar senha!");
        }finally{
              System.out.println("Fim da Operação!");
          }
          
        return retorno;
    }
}
