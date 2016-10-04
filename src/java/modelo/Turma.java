package modelo;

import dao.TurmaDAO;
import java.util.List;

public class Turma {
    private String codigo;
    private int ano;
    private int semestre;
    private int maxAlunos;

    public Turma(String codigo, int ano, int semestre, int maxAlunos) {
        this.codigo = codigo;
        this.ano = ano;
        this.semestre = semestre;
        this.maxAlunos = maxAlunos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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
       public static List<Turma> obterTurma() throws ClassNotFoundException {
        return TurmaDAO.obterTurma();
    }
}
