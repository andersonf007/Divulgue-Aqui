package controller;

import dao.PublicacaoDao;
import dao.UsuarioDao;
import entidade.Publicacao;
import entidade.Usuario;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Izaquias
 */
@ViewScoped
@ManagedBean
public class RelatorioBean implements Serializable{
    private static final long serialVersionUID = 5788118955672718405L;
    
    private Usuario usuario;
    private Publicacao publicacao;
    private UsuarioDao daoUsuario;
    private PublicacaoDao daoPublicacao;

    private PieChartModel graficoPizzaPublicacoes;
    public RelatorioBean() {
    }
    @PostConstruct
    public void iniciar(){
        usuario = new Usuario();
        
    }
    
}
