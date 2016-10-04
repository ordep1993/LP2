package modelo;

import dao.MatriculaDAO;
import java.util.List;

public class Matricula {

    private int codigo;
    private Curso curso;
    private Disciplina disciplina;
    private Turma turma;
    private Aluno aluno;
    private String codigoCurso;
    private String codigoDisciplina;
    private String codigoTurma;
    private String codigoAluno;

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

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(String codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    
    public static List<Matricula> obterMatricula() throws ClassNotFoundException {
        return MatriculaDAO.obterMatricula();
    }
}
