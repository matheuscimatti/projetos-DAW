
package beans;

import entities.Avaliacao;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import services.AvaliacaoService;


@Named(value = "avaliacaoBean")
@ViewScoped
public class AvaliacaoBean implements Serializable {
    @EJB
    private AvaliacaoService avaliacaoService;
    
    @Inject
    private RequestParameters parameters;
    
    private Avaliacao value;
    private boolean consultado;
    private List<Avaliacao> avaliacoesFiltradas;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Avaliacao();
        else value = avaliacaoService.find(Long.valueOf(id));
    }
    
    public Avaliacao getValue() { return value; }
    public void setValue(Avaliacao value) { this.value = value; }
    
    public boolean isConsultado() { return consultado; }
    public void setConsultado(boolean consultado) { this.consultado = consultado; }

    public List<Avaliacao> getAvaliacoesFiltradas() { return avaliacoesFiltradas; }
    public void setAvaliacoesFiltradas(List<Avaliacao> avaliacoesFiltradas) { 
        this.avaliacoesFiltradas = avaliacoesFiltradas;
    }
    public SelectItem[] getClassificacoes(boolean filtrar) {
        SelectItem[] items;
        int length = Avaliacao.Classificacao.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else items = new SelectItem[length];
        for(Avaliacao.Classificacao classificacao : Avaliacao.Classificacao.values()) {
            items[n++] = new SelectItem(classificacao, classificacao.getLabel());
        }    
        return items;
    }
    public SelectItem[] getOptionsEntreMeusDezPreferidos() {
        return new SelectItem[]{
            new SelectItem(String.valueOf(""), ""),
            new SelectItem(Boolean.TRUE.toString(), "sim"),
            new SelectItem(Boolean.FALSE.toString(), "não")
        };
    }
       
    
    public void reset() { value = new Avaliacao(); }
    public void inserir() { 
        reset(); 
        consultado = false;
    }
    public void consultar(Avaliacao value) { 
        setValue(value); 
        consultado = true;
    }
    public String onFlowProcess(FlowEvent event) { return event.getNewStep(); }
    
    public List<Avaliacao> getAll() { return avaliacaoService.getAll(); }
    
    public String save() {
        avaliacaoService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        avaliacaoService.edit(value);
        return null;
    }
    
    public String delete() {
        avaliacaoService.remove(value);
        return null;
    }
    
}

