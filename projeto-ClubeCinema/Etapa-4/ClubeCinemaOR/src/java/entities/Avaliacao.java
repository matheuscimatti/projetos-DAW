
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Avaliacao implements Serializable, PersistentEntity {

    public enum Classificacao {
        pessima("péssima"), fraca("fraca"), regular("regular"), boa("boa"),
        excelente("excelente");
        
        private final String label;
        
        private Classificacao(String label) { this.label = label; }
        public String getLabel() { return this.label; }
    } 
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //Variaveis
    @Temporal(TemporalType.TIME) 
    private Date dataHora = new Date();
    @Enumerated(EnumType.STRING)
    private Classificacao classificacaoTrama;
    @Enumerated(EnumType.STRING)
    private Classificacao classificacaoDirecao;
    @Enumerated(EnumType.STRING)
    private Classificacao classificacaoAtuacao;
    private Boolean entreMeusDezPreferidos;
    @ManyToOne
    private Amigo amigo;
    @ManyToOne
    private Filme filme;

    //Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    public Classificacao getClassificacaoTrama() {
        return classificacaoTrama;
    }
    public void setClassificacaoTrama(Classificacao classificacaoTrama) {
        this.classificacaoTrama = classificacaoTrama;
    }
    public Classificacao getClassificacaoDirecao() {
        return classificacaoDirecao;
    }
    public void setClassificacaoDirecao(Classificacao classificacaoDirecao) {
        this.classificacaoDirecao = classificacaoDirecao;
    }
    public Classificacao getClassificacaoAtuacao() {
        return classificacaoAtuacao;
    }
    public void setClassificacaoAtuacao(Classificacao classificacaoAtuacao) {
        this.classificacaoAtuacao = classificacaoAtuacao;
    }
    public Boolean getEntreMeusDezPreferidos() {
        return entreMeusDezPreferidos;
    }
    public void setEntreMeusDezPreferidos(Boolean entreMeusDezPreferidos) {
        this.entreMeusDezPreferidos = entreMeusDezPreferidos;
    }
    public Amigo getAmigo() {
        return amigo;
    }
    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
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
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Avaliacao[ id=" + id + " ]";
    }
    
}
