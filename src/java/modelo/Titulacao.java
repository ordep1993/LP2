package modelo;

public class Titulacao {

    private int codigo;
    private String descricao;

    public Titulacao(int codigo,String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}