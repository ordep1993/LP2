package modelo;

import dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

public class Curso {

    private int codigo;
    private String descricao;
    private int cargaHoraria;
    private Professor professor;
    private int codigoProfessor;

    public Curso(int codigo, String descricao, int cargaHoraria, Professor professor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
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

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() throws ClassNotFoundException {
        if ((this.codigoProfessor != 0) && (this.professor == null)){
            this.professor = Professor.obterProfessor(this.codigoProfessor);
        }
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public static Curso obterCurso(int codigo) throws ClassNotFoundException {
        return CursoDAO.obterCurso(codigo);
    }

    public static List<Curso> obterCursos() throws ClassNotFoundException {
        return CursoDAO.obterCursos();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        CursoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        CursoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        CursoDAO.excluir(this);
    }
}
