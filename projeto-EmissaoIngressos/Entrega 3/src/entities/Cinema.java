package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cinema implements Serializable, PersistentEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String filme;
    private String gênero;
    private String indicativa;
    private String localidade;
    private String sala;
    private String dia;
    private String sessão;
    private String valorIngresso;

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getSessão() {
        return sessão;
    }

    public void setSessão(String sessão) {
        this.sessão = sessão;
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

    public String getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(String valorIngresso) {
        this.valorIngresso = valorIngresso;
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
        if (!(object instanceof Cinema)) {
            return false;
        }
        Cinema other = (Cinema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cinema[ id=" + id + " ]";
    }
    
}
