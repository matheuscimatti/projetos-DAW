package beans;

import entities.Ingresso;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.TeatroService;

@Named(value = "teatroBean")
@ViewScoped
public class TeatroBean implements Serializable {
    @EJB
    private TeatroService teatroService;
    
    @Inject
    private RequestParameters parameters;
    
    private Ingresso value;
    private boolean consultar;
    private List<Ingresso> teatrosFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Ingresso();
        else value = teatroService.find(Long.valueOf(id));
    }
    
    public Ingresso getValue() { return value; }
    public void setValue(Ingresso value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Ingresso> getTeatrosFiltrados() {
        return teatrosFiltrados;
    }

    public void setTeatrosFiltrados(List<Ingresso> teatrosFiltrados) {
        this.teatrosFiltrados = teatrosFiltrados;
    }
    
    public void reset () { value = new Ingresso(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<Ingresso> getAll() { return teatroService.getAll(); }
    
    public String save() {
        teatroService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        teatroService.edit(value);
        return null;
    }
    
    public String delete() {
        teatroService.remove(value);
        return null;
    }
    
    public void consultar(Ingresso value) { 
        consultar = true;
        setValue(value);
    }
}
