package controller;

import dao.PublicacaoDao;
import entidade.Publicacao;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
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
        resolvido = daoPublicacao.contarStatusProblemaResolvido();
        ignorado = daoPublicacao.contarStatusProblemaIgnorado();
    }

    
    
    public PieChartModel getGraficoPizzaPublicacao(){
        if(publicacao != null){
                graficoPizzaPublicacoes = new PieChartModel();
                graficoPizzaPublicacoes.set("Pendente", pendente);
                graficoPizzaPublicacoes.set("Analizando", analizando);
                graficoPizzaPublicacoes.set("Resolvendo", resolvendo);
                graficoPizzaPublicacoes.set("Resolvido", resolvido);
                graficoPizzaPublicacoes.set("Ignorado", ignorado);
            }
        
            graficoPizzaPublicacoes.setTitle("Estado do Poblema");
            graficoPizzaPublicacoes.setLegendPosition("w");
            graficoPizzaPublicacoes.setShowDataLabels(true);
            graficoPizzaPublicacoes.setSeriesColors("E7E658,1a85ba,66cc66,fff00,DCDCDC");
            graficoPizzaPublicacoes.setDiameter(230);
            graficoPizzaPublicacoes.setDataFormat("percent");
            return graficoPizzaPublicacoes;
        
    }
    
    public BarChartModel getGraficoBarrasPublicacao() {
        BarChartModel model = new BarChartModel();
        BarChartSeries barra = new BarChartSeries();
        if(publicacao != null){
            barra.setLabel("Problemas");
            barra.set("Pendente", pendente);
            barra.set("Analizando", analizando);
            barra.set("Resolvendo", resolvendo);
            barra.set("Resolvido", resolvido);
            barra.set("Ignorado", ignorado);
        }
        
        model.addSeries(barra);
        return model;
    }
}
