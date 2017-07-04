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
    
    private Usuario usuario;
    private Publicacao publicacao;
    private UsuarioDao daoUsuario;
    private PublicacaoDao daoPublicacao;

    private String Status = "PENDENTE";
    private String Status2 = "VISTO";
    private String Status3 = "RESOLVENDO";
    private String Status4 = "RESOLVIDO";
    private String Status5 = "IGNORADO";
    
    private PieChartModel graficoPizzaPublicacoes;
    
    public RelatorioBean() {
         
    }
    @PostConstruct
    public void iniciar(){
        usuario = new Usuario();
        publicacao = new Publicacao();
        daoUsuario = new UsuarioDao();
        daoPublicacao = new PublicacaoDao();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public PieChartModel getGraficoPizzaPublicacao(){
        if(publicacao != null){
             graficoPizzaPublicacoes = new PieChartModel();
             List<Publicacao> listaPublicacao = daoPublicacao.contaStatusPublicacao(Status);
             List<Publicacao> listaPublicacao2 = daoPublicacao.contaStatusPublicacao(Status2);
             List<Publicacao> listaPublicacao3 = daoPublicacao.contaStatusPublicacao(Status3);
             List<Publicacao> listaPublicacao4 = daoPublicacao.contaStatusPublicacao(Status4);
             List<Publicacao> listaPublicacao5 = daoPublicacao.contaStatusPublicacao(Status5);
             for (Publicacao lista : listaPublicacao) {
                graficoPizzaPublicacoes.set(lista.getStatus(), serialVersionUID);
            }
             for (Publicacao lista2 : listaPublicacao2) {
                graficoPizzaPublicacoes.set(Status2, listaPublicacao2.hashCode());
            }
             for (Publicacao lista3 : listaPublicacao3) {
                graficoPizzaPublicacoes.set(Status3, listaPublicacao3.hashCode());
            }
             for (Publicacao lista4 : listaPublicacao4) {
                graficoPizzaPublicacoes.set(Status4, listaPublicacao4.hashCode());
            }
            for (Publicacao lista5 : listaPublicacao5) {
                graficoPizzaPublicacoes.set(Status5, listaPublicacao5.hashCode());
            }
            graficoPizzaPublicacoes.setTitle("Estado do Poblema");
            graficoPizzaPublicacoes.setLegendPosition("w");
            graficoPizzaPublicacoes.setShowDataLabels(true);
            graficoPizzaPublicacoes.setSeriesColors("E7E658,1a85ba,66cc66");
            graficoPizzaPublicacoes.setDiameter(230);
            graficoPizzaPublicacoes.setDataFormat("percent");
            return graficoPizzaPublicacoes;
        }else{
            return null;
        }
    }
    public List<Publicacao> listarTodos(){
        return daoPublicacao.recuperarTodos();
    }
    public Publicacao getPublicacao() {
        return publicacao;
    }

    public UsuarioDao getDaoUsuario() {
        return daoUsuario;
    }

    public PublicacaoDao getDaoPublicacao() {
        return daoPublicacao;
    }

    public String getStatus() {
        return Status;
    }

    public String getStatus2() {
        return Status2;
    }

    public String getStatus3() {
        return Status3;
    }

    public String getStatus4() {
        return Status4;
    }

    public String getStatus5() {
        return Status5;
    }

    public PieChartModel getGraficoPizzaPublicacoes() {
        return graficoPizzaPublicacoes;
    }
    
}
