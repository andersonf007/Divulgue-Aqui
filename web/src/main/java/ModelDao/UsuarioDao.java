/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.BeansUsuario;
import ModelConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class UsuarioDao {
    
    ConexaoBD conex = new ConexaoBD();
    BeansUsuario mod = new BeansUsuario();
    
    public void salvar(BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO usuario(nome, email, senha) VALUES (?, ?, ?);");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEmail());
            pst.setString(3, mod.getSenha());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "não foi possivel inserir o usuario (usuarioDao)\n"+ex);
        }
        conex.desconecta();
    }
    
    public void editar(BeansUsuario mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?;");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEmail());
            pst.setString(3, mod.getSenha());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "não foi possivel atualizar o usuario (usuarioDao)\n"+ex);
        }
        conex.desconecta();
    }
    
    public BeansUsuario buscarPorId(BeansUsuario mod){
        conex.conexao();
        conex.executaSql("SELECT * FROM usuario WHERE id = '" + mod.getPesquisarPorId() + "'");
        
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("id"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setSenha(conex.rs.getString("senha"));
            
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "nao foi possivel buscar o usuario (usuarioDao) \n" + ex);
        }
        conex.desconecta();
        return mod;
    }
    
     public BeansUsuario buscarPorNome(BeansUsuario mod){
        conex.conexao();
        conex.executaSql("SELECT * FROM usuario WHERE nome = '" + mod.getPesquisarPorNome() + "'");
        
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("id"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setSenha(conex.rs.getString("senha"));
            
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "nao foi possivel buscar o usuario (usuarioDao) \n" + ex);
        }
        conex.desconecta();
        return mod;
    }
     public void excluir(BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareCall("DELETE FROM usuario WHERE id=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados deletados com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "nao foi possivel excluir os dados \n" + ex);
        }
        
        conex.desconecta();
        
    }
}
