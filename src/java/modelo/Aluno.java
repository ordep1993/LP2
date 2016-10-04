package modelo;

import dao.AlunoDAO;
import java.util.List;

public class Aluno {
     private int matricula;
     private String nome;
     private String dataNasc;
     private int cpf;
     private String dataExpedicao;
     private String email;
     private int telefone;
     private int celular;
     private String logradouro;
     private int numero;
     private String complemento;
     private String bairro;
     private int cep;
     private int anoInicio;
     private int semestreInicio;
     private boolean estadoAluno;
     
     public Aluno(int matricula, String mome, String dataNasc, int cpf, String dataExpedicao, String email, int telefone, int celular, String logradouro, int numero, String complemento, String bairro, int cep, int anoInicio, int semestreInicio, boolean estadoAluno) {
        this.matricula = matricula;
        this.nome = mome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.dataExpedicao = dataExpedicao;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.anoInicio = anoInicio;
        this.semestreInicio = semestreInicio;
        this.estadoAluno = estadoAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public int getSemestreInicio() {
        return semestreInicio;
    }

    public void setSemestreInicio(int semestreInicio) {
        this.semestreInicio = semestreInicio;
    }

    public boolean isEstadoAluno() {
        return estadoAluno;
    }

    public void setEstadoAluno(boolean estadoAluno) {
        this.estadoAluno = estadoAluno;
    }
    
    public static List<Aluno> obterAluno() throws ClassNotFoundException{
        return AlunoDAO.obterAluno();
    }
}
