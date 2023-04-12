package entidades;

public class Filme {
    
    private String título;
    private String diretor;
    private String ano;
    private String gênero;
    private String oscarMelhorFilme;
    
    public Filme() { }
    
    public String toString(boolean sem_diretor) {
        if (sem_diretor) return ano + " - " + título + " - " + oscarMelhorFilme;
        else return ano + " - " + título + " - " + diretor + " - " + oscarMelhorFilme;
    }
    
    public String getDiretor() {
        return this.diretor;
    }
    
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    public String getAno() {
        return this.ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }
    
    public String getTítulo() {
        return this.título;
    }
    
    public void setTítulo(String título) {
        this.título = título;
    }
    
    public String getGênero() {
        return this.gênero;
    }
    
    public void setGênero(String gênero) {
        this.gênero = gênero;
    }
    
    public String getOscarMelhorFilme() {
        return this.oscarMelhorFilme;
    }
    
    public void setOscarMelhorFilme(String oscarMelhorFilme) {
        this.oscarMelhorFilme = oscarMelhorFilme;
    }
    
}
