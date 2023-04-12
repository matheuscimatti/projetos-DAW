package beans;

import entities.Teatro;
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
    
    private Teatro value;
    private boolean consultar;
    List<Teatro> teatrosFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Teatro();
        else value = teatroService.find(Long.valueOf(id));
    }
    
    public Teatro getValue() { return value; }
    public void setValue(Teatro value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Teatro> getTeatrosFiltrados() {
        return teatrosFiltrados;
    }

    public void setTeatrosFiltrados(List<Teatro> teatrosFiltrados) {
        this.teatrosFiltrados = teatrosFiltrados;
    }
    
    public void reset () { value = new Teatro(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<Teatro> getAll() { return teatroService.getAll(); }
    
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
    
    public void consultar(Teatro value) { 
        consultar = true;
        setValue(value);
    }
}
