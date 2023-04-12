package beans;

import entities.Cinema;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.CinemaService;

@Named(value = "cinemaBean")
@ViewScoped
public class CinemaBean implements Serializable {
    @EJB
    private CinemaService cinemaService;
    
    @Inject
    private RequestParameters parameters;
    
    private Cinema value;
    private boolean consultar;
    List<Cinema> cinemasFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Cinema();
        else value = cinemaService.find(Long.valueOf(id));
    }
    
    public Cinema getValue() { return value; }
    public void setValue(Cinema value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Cinema> getCinemasFiltrados() {
        return cinemasFiltrados;
    }

    public void setCinemasFiltrados(List<Cinema> cinemasFiltrados) {
        this.cinemasFiltrados = cinemasFiltrados;
    }
    
    public void reset () { value = new Cinema(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<Cinema> getAll() { return cinemaService.getAll(); }
    
    public String save() {
        cinemaService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        cinemaService.edit(value);
        return null;
    }
    
    public String delete() {
        cinemaService.remove(value);
        return null;
    }
    
    public void consultar(Cinema value) { 
        consultar = true;
        setValue(value);
    }
}
