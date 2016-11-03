package modelo;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.List;

public class Professor {
     private int matricula;
     private String nome;
     private String dataNasc;
     private int cpf;
     private String dataExpedicao;
     private String orgaoExpedidor;
     private String ufExpedicao;
     private String email;
     private int telefone;
     private int celular;
     private String logradouro;
     private int numero;
     private String complemento;
     private String bairro;
     private int cep;

    public Professor(int matricula, String nome, String dataNasc, int cpf, String dataExpedicao, String orgaoExpedidor, String ufExpedicao, String email, int telefone, int celular, String logradouro, int numero, String complemento, String bairro, int cep) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.dataExpedicao = dataExpedicao;
        this.orgaoExpedidor = orgaoExpedidor;
        this.ufExpedicao = ufExpedicao;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
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

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getUfExpedicao() {
        return ufExpedicao;
    }

    public void setUfExpedicao(String ufExpedicao) {
        this.ufExpedicao = ufExpedicao;
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
    
        public static Professor obterProfessor(int codigo) throws ClassNotFoundException {
        return ProfessorDAO.obterProfessor(codigo);
    }
    
        public static List<Professor> obterProfessores() throws ClassNotFoundException {
        return ProfessorDAO.obterProfessores();
    }
        
    public void gravar() throws SQLException, ClassNotFoundException {
        ProfessorDAO.gravar(this);
    } 

    public void alterar() throws SQLException, ClassNotFoundException {
        ProfessorDAO.alterar(this);
    } 

    public void excluir() throws SQLException, ClassNotFoundException {
        ProfessorDAO.excluir(this);
    }
}
