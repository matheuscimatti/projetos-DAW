package beans;

import entities.ClasseShow;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.ShowService;

@Named(value = "showBean")
@ViewScoped
public class ShowBean implements Serializable {
    @EJB
    private ShowService showService;
    
    @Inject
    private RequestParameters parameters;
    
    private ClasseShow value;
    private boolean consultar;
    List<ClasseShow> showsFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new ClasseShow();
        else value = showService.find(Long.valueOf(id));
    }
    
    public ClasseShow getValue() { return value; }
    public void setValue(ClasseShow value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<ClasseShow> getShowsFiltrados() {
        return showsFiltrados;
    }

    public void setShowsFiltrados(List<ClasseShow> showsFiltrados) {
        this.showsFiltrados = showsFiltrados;
    }
    
    public void reset () { value = new ClasseShow(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<ClasseShow> getAll() { return showService.getAll(); }
    
    public String save() {
        showService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        showService.edit(value);
        return null;
    }
    
    public String delete() {
        showService.remove(value);
        return null;
    }
    
    public void consultar(ClasseShow value) { 
        consultar = true;
        setValue(value);
    }
}
