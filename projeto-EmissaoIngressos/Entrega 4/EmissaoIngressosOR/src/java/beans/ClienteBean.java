package beans;

import entities.Cliente;
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
import services.ClienteService;

@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {
    @EJB
    private ClienteService clienteService;
    
    @Inject
    private RequestParameters parameters;
    
    private Cliente value;
    private boolean consultar;
    private List<Cliente> clientesFiltrados;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Cliente();
        else value = clienteService.find(Long.valueOf(id));
    }
    
    public Cliente getValue() { return value; }
    public void setValue(Cliente value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Cliente> getClientesFiltrados() {
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
        this.clientesFiltrados = clientesFiltrados;
    }
    
    public void reset () { value = new Cliente(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<Cliente> getAll() { return clienteService.getAll(); }
    
    public String save() {
        clienteService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        clienteService.edit(value);
        return null;
    }
    
    public String delete() {
        clienteService.remove(value);
        return null;
    }
    
    public void consultar(Cliente value) { 
        consultar = true;
        setValue(value);
    }
    
    public SelectItem[] getEstadosCivis(boolean filtrar) {
        SelectItem[] items;
        int length = Cliente.EstadoCivil.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else items = new SelectItem[length];
        for(Cliente.EstadoCivil estado_civil : Cliente.EstadoCivil.values()) {
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
    
    public List<Cliente> completaClientes(String prefixo) { return clienteService.filter(prefixo); }
    
    public String onFlowProcess(FlowEvent event) { return event.getNewStep(); }
    
}
