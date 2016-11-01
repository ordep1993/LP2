package modelo;

import dao.MatriculaDAO;
import java.sql.SQLException;
import java.util.List;

public class Matricula {

    private int codigo;
    private Curso curso;
    private Disciplina disciplina;
    private Turma turma;
    private Aluno aluno;
    private int codigoCurso;
    private int codigoDisciplina;
    private int codigoTurma;
    private int codigoAluno;

    public Matricula(int codigo, Curso curso, Disciplina disciplina, Turma turma, Aluno aluno) {
        this.codigo = codigo;
        this.curso = curso;
        this.disciplina = disciplina;
        this.turma = turma;
        this.aluno = aluno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public static Matricula obterMatricula(int codigo) throws ClassNotFoundException {
        return MatriculaDAO.obterMatricula(codigo);
    }

    public static List<Matricula> obterMatriculas() throws ClassNotFoundException {
        return MatriculaDAO.obterMatriculas();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        MatriculaDAO.gravar(this);
    }
}
