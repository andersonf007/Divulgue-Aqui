package controller;

import dao.PublicacaoDao;
import dao.UsuarioDao;
import entidade.Publicacao;
import entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Izaquias
 */
@ViewScoped
@ManagedBean(name = "relatorioGrafico")
public class RelatorioBean implements Serializable{
    private static final long serialVersionUID = 5788118955672718405L;
    
    
    private Publicacao publicacao;
    private PublicacaoDao daoPublicacao;
    
    private PieChartModel graficoPizzaPublicacoes;
    private long pendente;
    private long analizando;
    private long resolvendo;
    private long resolvido;
    private long ignorado;
    
    public RelatorioBean() {
    }
    @PostConstruct
    public void iniciar(){
        publicacao = new Publicacao();
        daoPublicacao = new PublicacaoDao();
        pendente = daoPublicacao.contarStatusProblemaPendente();
        analizando = daoPublicacao.contarStatusProblemaAnalizando();
        resolvendo = daoPublicacao.contarStatusProblemaResolvendo();
    }

    
    
    public PieChartModel getGraficoPizzaPublicacao(){
        if(publicacao != null){
                graficoPizzaPublicacoes = new PieChartModel();
                graficoPizzaPublicacoes.set("Pendente", pendente);
                graficoPizzaPublicacoes.set("Analizando", analizando);
                graficoPizzaPublicacoes.set("Resolvendo", resolvendo);
            }
        
            graficoPizzaPublicacoes.setTitle("Estado do Poblema");
            graficoPizzaPublicacoes.setLegendPosition("w");
            graficoPizzaPublicacoes.setShowDataLabels(true);
            graficoPizzaPublicacoes.setSeriesColors("E7E658,1a85ba,66cc66");
            graficoPizzaPublicacoes.setDiameter(230);
            graficoPizzaPublicacoes.setDataFormat("percent");
            return graficoPizzaPublicacoes;
        
    }
    
}
