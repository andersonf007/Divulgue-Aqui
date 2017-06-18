
import dao.UsuarioDao;
import entidade.Usuario;
import hibernate.Criptografia;


/**
 *
 * @author Izaquias
 */
public class MainCriptografia {

    public static void main(String[]args){
        
        Usuario usuario = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        
        usuario.setNome("normal2");
        usuario.setEmail("normal2@gmail.com");
        usuario.setSenha("senhaNormal");
        //usuario.setSenha(Criptografia.encriptografar(usuario.getSenha()));//Efetua a criptografia!
        
        //dao.inserir(usuario);
        
            if(usuario.getSenha().equals(Criptografia.encriptografar("senhanormal"))){//Compara senha já criptografada do BD e compara com String passada da possível senha!
                System.out.println("É a mesma senha!");
                System.out.println("Senha:" + usuario.getSenha());
            }else{
                System.out.println("Não é a mesma senha!");
            }
        
    }
    
}
