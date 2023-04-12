package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teatro implements Serializable, PersistentEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String peça;
    private String gênero;
    private String indicativa;
    private String localidade;
    private String dia;
    private String horário;
    private String valorIngresso;
    private boolean presencial;

    public String getPeça() {
        return peça;
    }

    public void setPeça(String peça) {
        this.peça = peça;
    }

    public String getGênero() {
        return gênero;
    }

    public void setGênero(String gênero) {
        this.gênero = gênero;
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
        if (!(object instanceof Teatro)) {
            return false;
        }
        Teatro other = (Teatro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teatro[ id=" + id + " ]";
    }
    
}
