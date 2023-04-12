package beans;

import entidades.Teatro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.model.SelectItem;
import javax.sql.DataSource;

@Named(value = "emissaoIngressosBean")
@RequestScoped
public class EmissaoIngressosBean {
    
    @Resource(lookup = "java:/EmissaoIngressosDS")
    private DataSource teatroDataSource;
    
    private ArrayList<Teatro> teatros;
    private Teatro teatro;
    private String localSelecionado;
    private String generoSelecionado;
    private boolean cadastrar;
    private boolean pesquisar;
    private ArrayList<String> mensagensErro;
    
    @PostConstruct
    public void init() {
        teatros = new ArrayList();
        teatro = new Teatro();
        mensagensErro = new ArrayList();
        cadastrar = false;
        pesquisar = false;
    }
    
    public String getLocalSelecionado() {
        return localSelecionado;
    }
    
    public void setLocalSelecionado(String localSelecionado) {
        this.localSelecionado = localSelecionado;
    }
    
    public String getGeneroSelecionado() {
        return generoSelecionado;
    }
    
    public void setGeneroSelecionado(String generoSelecionado) {
        this.generoSelecionado = generoSelecionado;
    }
    
    public ArrayList<Teatro> getTeatros() throws SQLException {
        getTeatrosDB();
        return teatros;
    }
    
    public boolean isCadastrar() {
        return cadastrar;
    }
    
    public Teatro getTeatro() {
        return teatro;
    }
    
    public boolean isPesquisar() {
        return pesquisar;
    }
    
    public String cadastrarTeatro() throws SQLException {
        saveTeatroDB();
        reset();
        return "index";
    }
    
    public void pesquisarTeatro() {
        pesquisar = true;
        cadastrar = false;
    }
    
    public void reset() {
        teatro = new Teatro();
        cadastrar = true;
        pesquisar = false;
    }
    
    public Connection getConnectionDB() {
        Connection conexão = null;
        if(teatroDataSource == null) {
            mensagensErro.add("DataSource não acessível");
            return null;
        }
        try { conexão = teatroDataSource.getConnection(); }
        catch (SQLException exception) {mensagensErro.add(exception.getMessage()); }
        return conexão;
    }
    
    public void saveTeatroDB() throws SQLException {
        Connection conexão = getConnectionDB();
        if(conexão == null) return;
        PreparedStatement comando = null;
        try {
            comando = conexão.prepareStatement
                ("INSERT INTO Teatros (Peca, Genero, Indicativa, Localidade, Dia, Horario, ValorIngresso)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            comando.setString(1, teatro.getPeça());
            comando.setString(2, teatro.getGênero());
            comando.setString(3, teatro.getIndicativa());
            comando.setString(4, teatro.getLocalidade());
            comando.setString(5, teatro.getDia());
            comando.setString(6, teatro.getHorário());
            comando.setString(7, teatro.getValorIngresso());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exception) {
            if (comando != null) comando.close();
            mensagensErro.add(exception.getMessage());
        }
        conexão.close();
        return;
    }
    
    public String getTeatrosDB() throws SQLException {
        String próxima_página = "";
        ArrayList<Teatro> teatros = new ArrayList();
        Connection conexão = getConnectionDB();
        if (conexão == null) return "";
        PreparedStatement comando = null;
        ResultSet consultas = null;
        try {
            comando = conexão.prepareStatement
                ("SELECT Peca, Genero, Indicativa, Localidade, Dia, Horario, ValorIngresso FROM Teatros");
            consultas = comando.executeQuery();
            while (consultas.next()) {
                Teatro teatro = new Teatro(consultas.getString("Peca"), consultas.getString("Genero"),
                    consultas.getString("Indicativa"), consultas.getString("Localidade"),
                    consultas.getString("Dia"), consultas.getString("Horario"), consultas.getString("ValorIngresso"));
                teatros.add(teatro);
            }
            consultas.close();
            comando.close();
            próxima_página = "index";
        } catch (SQLException exception) {
            if (consultas != null) consultas.close();
            if (comando != null) comando.close();
            mensagensErro.add(exception.getMessage());
        }
        conexão.close();
        this.teatros = teatros;
        return próxima_página;
    }
    
    public ArrayList<String> getLocaisDB() throws SQLException {
        ArrayList<String> locais = new ArrayList();
        Connection conexão = getConnectionDB();
        if (conexão == null) return locais;
        PreparedStatement comando = null;
        ResultSet consultas = null;
        try {
            comando = conexão.prepareStatement("SELECT Localidade FROM Teatros ORDER BY Localidade");
            consultas = comando.executeQuery();
            while (consultas.next()) {
                String localidade = consultas.getString("Localidade");
                int total_locais = locais.size();
                if ((total_locais == 0) || (!localidade.equals(locais.get(total_locais - 1))))
                    locais.add(localidade);
            }
            consultas.close();
            comando.close();
        } catch (SQLException exception) {
            if (consultas != null) consultas.close();
            if (comando != null) comando.close();
            mensagensErro.add(exception.getMessage());
        }
        conexão.close();
        return locais;
    }
    
    public ArrayList<SelectItem> getLocaisItens() throws SQLException {
        ArrayList<SelectItem> itens = new ArrayList();
        for (String localidade : getLocaisDB()) {
            boolean inserido = false;
            for (int n = 0; n < itens.size(); n++) {
                if (localidade.compareTo(itens.get(n).getLabel()) > 0) continue;
                itens.add(n, new SelectItem(localidade, localidade));
                inserido = true;
                break;
            }
            if (!inserido) itens.add(new SelectItem(localidade, localidade));
        }
        return itens;
    }
    
    public void getTeatrosLocalGeneroDB() throws SQLException {
        ArrayList<Teatro> teatros = new ArrayList();
        Connection conexão = getConnectionDB();
        if (conexão == null) return;
        PreparedStatement comando = null;
        ResultSet consultas = null;
        try {
            comando = conexão.prepareStatement("SELECT * FROM Teatros WHERE Localidade = ? AND Genero = ? ORDER BY Peca");
            comando.setString(1, localSelecionado);
            comando.setString(2, generoSelecionado);
            consultas = comando.executeQuery();
            while (consultas.next()) {
                Teatro teatro = new Teatro(consultas.getString("Peca"), consultas.getString("Genero"),
                    consultas.getString("Indicativa"), consultas.getString("Localidade"),
                    consultas.getString("Dia"), consultas.getString("Horario"), consultas.getString("ValorIngresso"));
                teatros.add(teatro);
            }
            consultas.close();
            comando.close();
            this.teatros = teatros;
        } catch (SQLException exception) {
            if (consultas != null) consultas.close();
            if (comando != null) comando.close();
            mensagensErro.add(exception.getMessage());
        }
        conexão.close();
        return;
    }
    
    public ArrayList<String> getInfoTeatrosLocalGenero() throws SQLException {
        getTeatrosLocalGeneroDB();
        ArrayList<String> info_teatros_local_genero = new ArrayList();
        for (Teatro teatro : teatros) {
            String localidade = teatro.getLocalidade();
            String gênero = teatro.getGênero();
            if (localidade.equals(localSelecionado) && gênero.equals(generoSelecionado)) {
                boolean inserido = false;
                String peça_teatro = teatro.getPeça();
                for (int n = 0; n < info_teatros_local_genero.size(); n++) {
                    String peça = info_teatros_local_genero.get(n).split(" - ")[0];
                    if (peça_teatro.compareTo(peça) < 0) continue;
                    info_teatros_local_genero.add(n, teatro.toString(true));
                    inserido = true;
                    break;
                }
                if (!inserido) info_teatros_local_genero.add(teatro.toString(true));
            }
        }
        return info_teatros_local_genero;
    }
    
}