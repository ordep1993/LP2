package modelo;

import dao.AvaliacaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Avaliacao {

    private int codigo;
    private int avaliacao1;
    private int avaliacao2;
    private int avaliacaoFinal;
    private int codigoDisciplina;
    private int codigoAluno;
    private Aluno aluno;
    private Disciplina disciplina;

    public Avaliacao(int codigo, int avaliacao1, int avaliacao2, int avaliacaoFinal, Aluno aluno, Disciplina disciplina) {
        this.codigo = codigo;
        this.avaliacao1 = avaliacao1;
        this.avaliacao2 = avaliacao2;
        this.avaliacaoFinal = avaliacaoFinal;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina() throws ClassNotFoundException {
        if ((this.codigoDisciplina != 0) && (this.disciplina == null)){
            this.disciplina = Disciplina.obterDisciplina(this.codigoDisciplina);
        }
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public Aluno getAluno() throws ClassNotFoundException {
        if ((this.codigoAluno != 0) && (this.aluno == null)){
            this.aluno = Aluno.obterAluno(this.codigoAluno);
        }
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public int getAvaliacao1() {
        return avaliacao1;
    }

    public void setAvaliacao1(int avaliacao1) {
        this.avaliacao1 = avaliacao1;
    }

    public int getAvaliacao2() {
        return avaliacao2;
    }

    public void setAvaliacao2(int avaliacao2) {
        this.avaliacao2 = avaliacao2;
    }

    public int getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAvaliacaoFinal(int avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }

    public static Avaliacao obterAvaliacao(int codigo) throws ClassNotFoundException {
        return AvaliacaoDAO.obterAvaliacao(codigo);
    }

    public static List<Avaliacao> obterAvaliacoes() throws ClassNotFoundException {
        return AvaliacaoDAO.obterAvaliacoes();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AvaliacaoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AvaliacaoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AvaliacaoDAO.excluir(this);
    }
}
