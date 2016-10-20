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
                        rs.getBoolean("estadoAluno"));
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return alunos;
    }

    public static Aluno obterAluno(int matricula) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Aluno aluno = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from aluno where matricula = " + matricula);
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
                    rs.getBoolean("estadoAluno"));
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
            String sql = "insert into aluno (matricula, nome, dataNasc, cpf, dataExpedicao, email, telefone, celular, logradouro, numero, complemento, bairro, cep, anoInicio, semestreInicio, estadoAluno) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            comando.setBoolean(16 , aluno.isEstadoAluno());
            /* if (curso.getCoordenador() == null){ CASO TENHA CHAVE ESTRANGEIRA
                comando.setNull(6 , Types.NULL);
            }else {
                comando.setInt(6, curso.getCoordenador().getMatricula());
            }*/
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
