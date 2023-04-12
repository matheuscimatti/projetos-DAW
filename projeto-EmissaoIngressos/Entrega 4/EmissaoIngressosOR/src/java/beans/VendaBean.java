package beans;

import entities.Venda;
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
import services.VendaService;

@Named(value = "vendaBean")
@ViewScoped
public class VendaBean implements Serializable {
    @EJB
    private VendaService vendaService;
    
    @Inject
    private RequestParameters parameters;
    
    private Venda value;
    private boolean consultar;
    private List<Venda> vendasFiltradas;
    
    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) value = new Venda();
        else value = vendaService.find(Long.valueOf(id));
    }
    
    public Venda getValue() { return value; }
    public void setValue(Venda value) { this.value = value; }

    public boolean isConsultar() {
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public List<Venda> getVendasFiltradas() {
        return vendasFiltradas;
    }

    public void setVendasFiltradas(List<Venda> vendasFiltradas) {
        this.vendasFiltradas = vendasFiltradas;
    }
    
    public SelectItem[] getPagamentos(boolean filtrar) {
        SelectItem[] items;
        int length = Venda.Pagamento.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else items = new SelectItem[length];
        for(Venda.Pagamento pagamento : Venda.Pagamento.values()) {
            items[n++] = new SelectItem(pagamento, pagamento.getLabel());
        }
        return items;
    }
    
    public SelectItem[] getOptionsMeiaEntrada() {
        return new SelectItem[]{
            new SelectItem(String.valueOf(""), ""),
            new SelectItem(Boolean.TRUE.toString(), "sim"),
            new SelectItem(Boolean.FALSE.toString(), "não")
        };
    }
    
    public void reset () { value = new Venda(); }
    public void inserir() { 
        reset();
        consultar = false;
    }
    
    public List<Venda> getAll() { return vendaService.getAll(); }
    
    public String save() {
        vendaService.create(value);
        reset();
        return null;
    }
    
    public String update() {
        vendaService.edit(value);
        return null;
    }
    
    public String delete() {
        vendaService.remove(value);
        return null;
    }
    
    public void consultar(Venda value) { 
        consultar = true;
        setValue(value);
    }
    
    public String onFlowProcess(FlowEvent event) { return event.getNewStep(); }
    
}
