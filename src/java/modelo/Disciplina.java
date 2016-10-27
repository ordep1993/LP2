package modelo;

import dao.DisciplinaDAO;
import java.sql.SQLException;
import java.util.List;

public class Disciplina {

    private int codigo;
    private String descricao;
    private int numAula;
    private String ementa;
    private String bibliografia;

    public Disciplina(int codigo, String descricao, int numAula, String ementa, String bibliografia) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.numAula = numAula;
        this.ementa = ementa;
        this.bibliografia = bibliografia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumAula() {
        return numAula;
    }

    public void setNumAula(int numAula) {
        this.numAula = numAula;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
    
        public static Disciplina obterDisciplina(int codigo) throws ClassNotFoundException {
        return DisciplinaDAO.obterDisciplina(codigo); 
    }

    public static List<Disciplina> obterDisciplinas() throws ClassNotFoundException {
        return DisciplinaDAO.obterDisciplinas();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        DisciplinaDAO.gravar(this);
    }
}
