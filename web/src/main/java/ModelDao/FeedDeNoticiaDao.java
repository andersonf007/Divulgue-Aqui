/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import ModelBeans.BeansFeedDeNoticia;
import ModelConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ander
 */
public class FeedDeNoticiaDao {
    
    ConexaoBD conex = new ConexaoBD();
    BeansFeedDeNoticia mod = new BeansFeedDeNoticia();
    
    public void salvar(BeansFeedDeNoticia mod){
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO feeddenoticia(localidade, hora, descricao, categoria, id_usuario) VALUES ( ?, ?, ?, ?, ?);");
            pst.setString(1, mod.getLocalidade());
            pst.setDate(2, new java.sql.Date(mod.getData().toLocalDate().hashCode()));
            pst.setString(3, mod.getDescricao());
            pst.setString(4, mod.getCategoria());
            pst.setLong(5, mod.getIdUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");        
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "nao foi possivel salvar (feedDeNoticiasDao)\n" + ex);
        }
    }
    
    public BeansFeedDeNoticia buscarFeedPorIdDeUsuario(BeansFeedDeNoticia mod){
        
        conex.conexao();
        conex.executaSql("SELECT * FROM feeddenoticia where id_usuario = '" + mod.getPesquisarPeloIdUsuario() + "'");
        
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getLong("id"));
            mod.setLocalidade(conex.rs.getString("localidade"));
            mod.setDescricao(conex.rs.getString("descricao"));
            mod.setData(conex.rs.getTimestamp("hora").toLocalDateTime());
            mod.setCategoria(conex.rs.getString("categoria"));
            mod.setIdUsuario(conex.rs.getLong("id_usuario"));
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "nao foi possivel buscar o os feeds (feedDao) \n" + ex);
        }
        conex.desconecta();
        return mod;
        
    }
    
    public void editar(BeansFeedDeNoticia mod){        
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE feeddenoticia SET localidade=?, hora=?, descricao=?, categoria=? WHERE id=?;");
            pst.setString(1, mod.getLocalidade());
            pst.setDate(2, new java.sql.Date(mod.getData().toLocalDate().hashCode()));
            pst.setString(3, mod.getDescricao());
            pst.setString(4, mod.getCategoria());
            pst.setLong(5, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!!!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "nao foi possivel alterar os dados  (FeedDeNoticiaDao)\n" + ex);
        }
    }    
}
