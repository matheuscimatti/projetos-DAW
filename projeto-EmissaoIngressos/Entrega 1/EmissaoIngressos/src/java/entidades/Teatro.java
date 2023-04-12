package entidades;

public class Teatro {
    
    private String peça;
    private String gênero;
    private String indicativa;
    private String localidade;
    private String dia;
    private String horário;
    private String valorIngresso;
    
    public Teatro() { }
    
    public Teatro(String peça, String gênero, String indicativa, String localidade,
                    String dia, String horário, String valorIngresso) {
        this.peça = peça;
        this.gênero = gênero;
        this.indicativa = indicativa;
        this.localidade = localidade;
        this.dia = dia;
        this.horário = horário;
        this.valorIngresso = valorIngresso;
    }
    
    public String toString(boolean local_genero) {
        if (local_genero) return peça + " - " + dia + " - " + horário + " - " + indicativa + " - " + valorIngresso;
        else return peça + " - " + dia + " - " + horário + " - " + gênero + " - " + indicativa + " - " + localidade + " - " + valorIngresso;
    }
    
    public String getPeça() {
        return this.peça;
    }
    
    public void setPeça(String peça) {
        this.peça = peça;
    }
    
    public String getGênero() {
        return this.gênero;
    }
    
    public void setGênero(String gênero) {
        this.gênero = gênero;
    }

    public String getIndicativa() {
        return this.indicativa;
    }
    
    public void setIndicativa(String indicativa) {
        this.indicativa = indicativa;
    }

    public String getLocalidade() {
        return this.localidade;
    }
    
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDia() {
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorário() {
        return this.horário;
    }
    
    public void setHorário(String horário) {
        this.horário = horário;
    }

    public String getValorIngresso() {
        return this.valorIngresso;
    }
    
    public void setValorIngresso(String valorIngresso) {
        this.valorIngresso = valorIngresso;
    }
    
}
