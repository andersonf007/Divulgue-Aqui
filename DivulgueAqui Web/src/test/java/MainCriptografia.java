
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
        
        adm.setNome("root");
        adm.setEmail("root@gmail.com");
        adm.setSenha("123");
        //usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));//Efetua a criptografia!
        
        dao.inserir(adm);
        
       /*     if(usuario.getSenha().equals(Criptografia.encriptografar("senhanormal"))){//Compara senha já criptografada do BD e compara com String passada da possível senha!
                System.out.println("É a mesma senha!");
                System.out.println("Senha:" + usuario.getSenha());
            }else{
                System.out.println("Não é a mesma senha!");
            }
        */
    }
    
}
