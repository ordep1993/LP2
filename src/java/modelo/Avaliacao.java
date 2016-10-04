package modelo;

import dao.AvaliacaoDAO;
import java.util.List;

public class Avaliacao {
    private String codigo;
    private int avaliacao1;
    private int avaliacao2;
    private int avaliacaoFinal;

    public Avaliacao(String codigo, int avaliacao1, int avaliacao2, int avaliacaoFinal) {
        this.codigo = codigo;
        this.avaliacao1 = avaliacao1;
        this.avaliacao2 = avaliacao2;
        this.avaliacaoFinal = avaliacaoFinal;
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

    public void setAvaliacaoFinal(int avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }
    
    public static List<Avaliacao> obterAvaliacao() throws ClassNotFoundException{
        return AvaliacaoDAO.obterAvaliacao();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
