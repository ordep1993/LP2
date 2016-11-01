package modelo;

import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.List;

public class Turma {

    private int codigo;
    private int ano;
    private int semestre;
    private int maxAlunos;

    public Turma(int codigo, int ano, int semestre, int maxAlunos) {
        this.codigo = codigo;
        this.ano = ano;
        this.semestre = semestre;
        this.maxAlunos = maxAlunos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(int maxAlunos) {
        this.maxAlunos = maxAlunos;
    }
    
    public static Turma obterTurma(int codigo) throws ClassNotFoundException {
        return TurmaDAO.obterTurma(codigo);
    }

    public static List<Turma> obterTurmas() throws ClassNotFoundException {
        return TurmaDAO.obterTurmas();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        TurmaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        TurmaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        //  TurmaDAO.excluir(this);
    }
}
