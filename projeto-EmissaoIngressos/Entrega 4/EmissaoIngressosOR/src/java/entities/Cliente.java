package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

@Entity
public class Cliente implements Serializable, PersistentEntity {
    
    public enum EstadoCivil {
        solteiro("solteiro"), casado("casado"), divorciado("divorciado"), viúvo("viúvo");
        
        private final String label;
        
        private EstadoCivil(String label) { this.label = label; }
        public String getLabel() { return this.label; }
    };

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String sexo;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Pattern(regexp = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")
    private String email;
    @Pattern(regexp = "((\\(\\s{2}\\) ?)|(\\d{2}-))?(\\d{5}|\\d{4})-\\d{4}")
    private String telefone;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereço endereço;
    
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereço getEndereço() {
        if (endereço == null) endereço = new Endereço();
        return endereço;
    }

    public void setEndereco(Endereço endereço) {
        this.endereço = endereço;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
