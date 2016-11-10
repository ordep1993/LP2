package modelo;

import dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

public class Curso {

    private int codigo;
    private String descricao;
    private int cargaHoraria;
    private Professor coordenador;
    private int codigoCoordenador;

    public Curso(int codigo, String descricao, int cargaHoraria, Professor coordenador) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.coordenador = coordenador;
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

    public Professor getCoordenador() throws ClassNotFoundException {
        return coordenador;
    }

    public void setCoordenador(Professor coordenador) {
        this.coordenador = coordenador;
    }

    public int getCodigoCoordenador() {
        return codigoCoordenador;
    }

    public void setCodigoCoordenador(int codigoCoordenador) {
        this.codigoCoordenador = codigoCoordenador;
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
    
    public void alterar() throws SQLException , ClassNotFoundException {
        CursoDAO.alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        CursoDAO.excluir(this);
    }
}
