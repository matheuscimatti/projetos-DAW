
package beans;

import entities.Filme;
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
import services.FilmeService;


@Named(value = "filmeBean")
@ViewScoped
public class FilmeBean implements Serializable {
    @EJB
    private FilmeService filmeService;
    
    @Inject
    private RequestParameters parameters;
    
    private Filme value;
    private boolean consultado;
    private List<Filme> filmesFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Filme();
        else value = filmeService.find(Long.valueOf(id));
    }
    
    public Filme getValue() { return value; }
    public void setValue(Filme value) { this.value = value; }
    
    public boolean isConsultado() { return consultado; }
    public void setConsultado(boolean consultado) { this.consultado = consultado; }

    public List<Filme> getFilmesFiltrados() { return filmesFiltrados; }
    public void setFilmesFiltrados(List<Filme> filmesFiltrados) { 
        this.filmesFiltrados = filmesFiltrados;
    }
    
    public SelectItem[] getOptionsOscarMelhorFilme() {
        return new SelectItem[] {
            new SelectItem(String.valueOf(""), ""),
            new SelectItem(Boolean.TRUE.toString(), "sim"),
            new SelectItem(Boolean.FALSE.toString(), "não")
        };
    }
    public SelectItem[] getGeneros(boolean filtrar) {
        SelectItem[] items;
        int length = Filme.Genero.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else items = new SelectItem[length];
        for(Filme.Genero genero : Filme.Genero.values()) {
            items[n++] = new SelectItem(genero, genero.getLabel());
        }    
        return items;
    }
    
    public void reset() { 
        value = new Filme(); 
    }
    public void inserir() { 
        reset(); 
        consultado = false;
    }
    public void consultar(Filme value) { 
        setValue(value); 
        consultado = true;
    }
    
    public String onFlowProcess(FlowEvent event) { return event.getNewStep(); }
    
    public List<Filme> getAll() { return filmeService.getAll(); }
    
    public String save() {
        filmeService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        filmeService.edit(value);
        return null;
    }
    
    public String delete() {
        filmeService.remove(value);
        return null;
    }
    
}
