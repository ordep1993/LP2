package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;

public class AlunoDAO {

    public static List<Aluno> obterAlunos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from aluno");
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("matricula"),
                        rs.getString("nome"),
                        rs.getString("dataNasc"),
                        rs.getInt("cpf"),
                        rs.getString("dataExpedicao"),
                        rs.getString("email"),
                        rs.getInt("telefone"),
                        rs.getInt("celular"),
                        rs.getString("logradouro"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getInt("cep"),
                        rs.getInt("anoInicio"),
                        rs.getInt("semestreInicio"),
                        rs.getInt("estadoAluno"));
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return alunos;
    }

    public static Aluno obterAluno(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Aluno aluno = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from aluno where matricula = " + codigo);
            rs.first();
            aluno = new Aluno(rs.getInt("matricula"),
                    rs.getString("nome"),
                    rs.getString("dataNasc"),
                    rs.getInt("cpf"),
                    rs.getString("dataExpedicao"),
                    rs.getString("email"),
                    rs.getInt("telefone"),
                    rs.getInt("celular"),
                    rs.getString("logradouro"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getInt("cep"),
                    rs.getInt("anoInicio"),
                    rs.getInt("semestreInicio"),
                    rs.getInt("estadoAluno"));
            //NULL PARA SER SETADO
            //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return aluno;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {

        }
    }
    
    public static void gravar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into aluno (matricula, nome, dataNasc, CPF,dataExpedicao, orgaoExpedidor, ufExpedicao, email, telefone, celular, logradouro, numero, complemento, bairro, CEP, anoInicio, semestreInicio, estadoAluno) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, aluno.getMatricula());
            comando.setString(2, aluno.getNome());
            comando.setString(3, aluno.getDataNasc());
            comando.setInt(4, aluno.getCpf());
            comando.setString(5, aluno.getDataExpedicao());
            comando.setString(6, aluno.getEmail());
            comando.setInt(7, aluno.getTelefone());
            comando.setInt(8, aluno.getCelular());
            comando.setString(9, aluno.getLogradouro());
            comando.setInt(10, aluno.getNumero());
            comando.setString(11, aluno.getComplemento());
            comando.setString(12, aluno.getBairro());
            comando.setInt(13, aluno.getCep());
            comando.setInt(14, aluno.getAnoInicio());
            comando.setInt(15, aluno.getSemestreInicio());
            comando.setInt(16 , aluno.getEstadoAluno());
            //comando.setBoolean(16 , aluno.isEstadoAluno());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from aluno where matricula = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, aluno.getMatricula());
            //comando.setBoolean(16 , aluno.isEstadoAluno());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update aluno set nome = ?, dataNasc = ?, CPF = ?,dataExpedicao = ?, orgaoExpedidor = ?, ufExpedicao = ?, email = ?, telefone = ?, celular = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, CEP = ?, anoInicio = ?, semestreInicio = ?, estadoAluno = ? where matricula = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, aluno.getNome());
            comando.setString(2, aluno.getDataNasc());
            comando.setInt(3, aluno.getCpf());
            comando.setString(4, aluno.getDataExpedicao());
            comando.setString(5, aluno.getEmail());
            comando.setInt(6, aluno.getTelefone());
            comando.setInt(7, aluno.getCelular());
            comando.setString(8, aluno.getLogradouro());
            comando.setInt(9, aluno.getNumero());
            comando.setString(10, aluno.getComplemento());
            comando.setString(11, aluno.getBairro());
            comando.setInt(12, aluno.getCep());
            comando.setInt(13, aluno.getAnoInicio());
            comando.setInt(14, aluno.getSemestreInicio());
            comando.setInt(15 , aluno.getEstadoAluno());
            comando.setInt(16, aluno.getMatricula());
            //comando.setBoolean(16 , aluno.isEstadoAluno());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
