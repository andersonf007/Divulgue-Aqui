/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelConection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class ConexaoBD {
    
//conexao com o banco de dados
    
    public Statement stm;// responsavel pelas pesquisas
    public ResultSet rs;//responsavel por guardar as pesquisas
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/DivulgueAqui";
    private String usuario = "postgres";
    private String senha = "1996";
    public Connection con;//resonsavel pela conexao
    
    public void conexao(){//metodo responsavel por realizar conexao com a base de dados
        
        try {
            Class.forName("org.postgresql.Driver");
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho,usuario,senha);
        //  JOptionPane.showMessageDialog(null, "conectado ao banco com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao se conectar com o banco\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "erro ao se conectar com o banco2\n" + ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
        try {                            // cuidado com o ResultSet
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao executar sql ( conexaoBD )\n" + ex.getMessage());           
        }
    }
    
    public void desconecta(){//metodo responsavel por desconectar a conexao com a base de dados
        try {
            con.close();
       //     JOptionPane.showMessageDialog(null, "banco de dados desconectado com sucesso!");
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "erro ao desconectar com o banco\n" + ex.getMessage());
        }
    }
}
