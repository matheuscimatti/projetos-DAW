package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Ingresso implements Serializable, PersistentEntity {

    public enum Tipo {
        teatro("Teatro"), show("Show"), cinema("Cinema");
        
        private final String label;
        
        private Tipo(String label) { this.label = label; }
        public String getLabel() { return this.label; }
    };
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String título;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String indicativa;
    private String localidade;
    private String dia;
    private String horário;
    private String valorIngresso;
    private boolean presencial;
    
    @ManyToMany (mappedBy = "ingressos")
    private List<Venda> vendas;
    
    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public String getIndicativa() {
        return indicativa;
    }

    public void setIndicativa(String indicativa) {
        this.indicativa = indicativa;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorário() {
        return horário;
    }

    public void setHorário(String horário) {
        this.horário = horário;
    }

    public String getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(String valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresso)) {
            return false;
        }
        Ingresso other = (Ingresso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return título;
    }
    
}
