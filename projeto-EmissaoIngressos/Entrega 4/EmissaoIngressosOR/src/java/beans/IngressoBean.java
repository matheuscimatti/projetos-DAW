package beans;

import entities.Ingresso;
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
import services.IngressoService;

@Named(value = "ingressoBean")
@ViewScoped
public class IngressoBean implements Serializable {
    @EJB
    private IngressoService ingressoService;
    
    @Inject
    private RequestParameters parameters;
    
    private Ingresso value;
    private boolean consultar;
    private List<Ingresso> ingressosFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Ingresso();
        else value = ingressoService.find(Long.valueOf(id));
    }
    
    public Ingresso getValue() { return value; }
    public void setValue(Ingresso value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Ingresso> getIngressosFiltrados() {
        return ingressosFiltrados;
    }

    public void setIngressosFiltrados(List<Ingresso> ingressosFiltrados) {
        this.ingressosFiltrados = ingressosFiltrados;
    }
    
    public SelectItem[] getTipos(boolean filtrar) {
        SelectItem[] items;
        int length = Ingresso.Tipo.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else items = new SelectItem[length];
        for(Ingresso.Tipo tipo : Ingresso.Tipo.values()) {
            items[n++] = new SelectItem(tipo, tipo.getLabel());
        }
        return items;
    }
    
    public void reset () { value = new Ingresso(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<Ingresso> getAll() { return ingressoService.getAll(); }
    
    public String save() {
        ingressoService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        ingressoService.edit(value);
        return null;
    }
    
    public String delete() {
        ingressoService.remove(value);
        return null;
    }
    
    public void consultar(Ingresso value) { 
        consultar = true;
        setValue(value);
    }
    
    public List<Ingresso> completaIngressos(String prefixo) { return ingressoService.filter(prefixo); }
    
    public String onFlowProcess(FlowEvent event) { return event.getNewStep(); }
    
}
