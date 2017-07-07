
import dao.AdministradorDao;
import dao.UsuarioDao;
import entidade.Administrador;
import entidade.Usuario;
import hibernate.Criptografia;


/**
 *
 * @author Izaquias
 */
public class MainCriptografia {

    public static void main(String[]args){
        
        Administrador adm = new Administrador();
        AdministradorDao dao = new AdministradorDao();
        
        adm.setNome("master");
        adm.setEmail("master@gmail.com");
        adm.setSenha("123");
        adm.setSenha(Criptografia.encriptografar(adm.getSenha()));//Efetua a criptografia!
        
        dao.inserir(adm);
       ///* 
//            if(adm.getSenha().equals(Criptografia.encriptografar("123"))){//Compara senha já criptografada do BD e compara com String passada da possível senha!
//                System.out.println("É a mesma senha!");
//                System.out.println("Senha:" + adm.getSenha());
//            }else{
//                System.out.println("Não é a mesma senha!");
//            }
        //*/
    }
    
}
