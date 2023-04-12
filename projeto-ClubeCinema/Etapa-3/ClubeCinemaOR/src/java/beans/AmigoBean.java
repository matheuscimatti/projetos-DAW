package beans;

import entities.Amigo;
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
import services.AmigoService;

@Named(value = "amigoBean")
@ViewScoped
public class AmigoBean implements Serializable {
    @EJB
    private AmigoService amigoService;
    
    @Inject
    private RequestParameters parameters;
    
    private Amigo value;
    private boolean consultar;
    private List<Amigo> amigosFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Amigo();
        else value = amigoService.find(Long.valueOf(id));
    }
    
    public Amigo getValue() { return value; }
    public void setValue(Amigo value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Amigo> getAmigosFiltrados() {
        return amigosFiltrados;
    }

    public void setAmigosFiltrados(List<Amigo> amigosFiltrados) {
        this.amigosFiltrados = amigosFiltrados;
    }
    
    public void reset () { value = new Amigo(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<Amigo> getAll() { return amigoService.getAll(); }
    
    public String save() {
        amigoService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        amigoService.edit(value);
        return null;
    }
    
    public String delete() {
        amigoService.remove(value);
        return null;
    }
    
    public void consultar(Amigo value) { 
        consultar = true;
        setValue(value);
    }
    
    public SelectItem[] getEstadosCivis(boolean filtrar) {
        SelectItem[] items;
        int length = Amigo.EstadoCivil.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else items = new SelectItem[length];
        for(Amigo.EstadoCivil estado_civil : Amigo.EstadoCivil.values()) {
            items[n++] = new SelectItem(estado_civil, estado_civil.getLabel());
        }
        return items;
    }
    
    public SelectItem[] getSexos(boolean filtrar) {
        SelectItem[] items;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[3];
            items[0] = new SelectItem("", "");
            items[1] = new SelectItem("feminino", "Feminino");
            items[2] = new SelectItem("masculino", "Masculino");
        } else {
            items = new SelectItem[2];
            items[0] = new SelectItem("feminino", "Feminino");
            items[1] = new SelectItem("masculino", "Masculino");
        }
        return items;
    }
    
    public String onFlowProcess(FlowEvent event) { return event.getNewStep(); }
    
}
