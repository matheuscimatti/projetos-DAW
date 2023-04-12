
package beans;

import entities.Ator;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.AtorService;


@Named(value = "atorBean")
@ViewScoped
public class AtorBean implements Serializable {
    @EJB
    private AtorService atorService;
    
    @Inject
    private RequestParameters parameters;
    
    private Ator value;
    private boolean consultado;
    private List<Ator> atoresFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Ator();
        else value = atorService.find(Long.valueOf(id));
    }
    
    public Ator getValue() { return value; }
    public void setValue(Ator value) { this.value = value; }
    
    public boolean isConsultado() { return consultado; }
    public void setConsultado(boolean consultado) { this.consultado = consultado; }

    public List<Ator> getAtoresFiltrados() { return atoresFiltrados; }
    public void setAtoresFiltrados(List<Ator> atoresFiltrados) { 
        this.atoresFiltrados = atoresFiltrados;
    }
    
    public List<Ator> completaAtores(String prefixo) {
        return atorService.filter(prefixo);
    }
    
    public void reset() { value = new Ator(); }
    public void inserir() { 
        reset(); 
        consultado = false;
    }
    public void consultar(Ator value) { 
        setValue(value); 
        consultado = true;
    }
    
    public List<Ator> getAll() { return atorService.getAll(); }
    
    public String save() {
        atorService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        atorService.edit(value);
        return null;
    }
    
    public String delete() {
        atorService.remove(value);
        return null;
    }
    
}
