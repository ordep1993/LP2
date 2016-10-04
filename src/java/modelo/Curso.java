package modelo;

import dao.CursoDAO;
import java.util.List;

public class Curso{
    private int codigo;
    private String descricao;
    private int cargaHoraria;
    private Professor cordenador;
    private String codigoCordenador;

    public Curso(int codigo, String descricao, int cargaHoraria, Professor cordenador, String codigoCordenador) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.cordenador = cordenador;
        this.codigoCordenador = codigoCordenador;
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

    public Professor getCordenador() {
        return cordenador;
    }

    public void setCordenador(Professor cordenador) {
        this.cordenador = cordenador;
    }
    
    public static List<Curso> obterCursos() throws ClassNotFoundException{
        return CursoDAO.obterCursos();
    }

    public String getCodigoCordenador() {
        return codigoCordenador;
    }

    public void setCodigoCordenador(String codigoCordenador) {
        this.codigoCordenador = codigoCordenador;
    }
}
