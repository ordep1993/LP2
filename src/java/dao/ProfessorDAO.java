package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Professor;

public class ProfessorDAO {

    public static List<Professor> obterProfessores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Professor> professores = new ArrayList<Professor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from professor");
            while (rs.next()) {
                Professor professor = new Professor(rs.getInt("matricula"),
                        rs.getString("nome"),
                        rs.getString("dataNasc"),
                        rs.getInt("cpf"),
                        rs.getString("dataExpedicao"),
                        rs.getString("orgaoExpedidor"),
                        rs.getString("ufExpedicao"),
                        rs.getString("email"),
                        rs.getInt("telefone"),
                        rs.getInt("celular"),
                        rs.getString("logradouro"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getInt("cep"));
                professores.add(professor);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return professores;
    }

        public static Professor obterProfessor(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Professor professor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from professor where matricula = " + codigo);
            rs.first();
            professor = new Professor(rs.getInt("matricula"),
                    rs.getString("nome"),
                    rs.getString("dataNasc"),
                    rs.getInt("cpf"),
                    rs.getString("dataExpedicao"),
                    rs.getString("orgaoExpedidor"),
                    rs.getString("ufExpedicao"),
                    rs.getString("email"),
                    rs.getInt("telefone"),
                    rs.getInt("celular"),
                    rs.getString("logradouro"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getInt("cep"));
          
                    //NULL PARA SER SETADO
                //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao(conexao , comando);
        }
        return professor;
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

    public static void gravar(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into professor ( matricula , nome , dataNasc , cpf , dataExpedicao , orgaoExpedidor , ufExpedicao , email , telefone , celular , logradouro , numero , complemento , bairro, cep) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, professor.getMatricula());
            comando.setString(2, professor.getNome());
            comando.setString(3, professor.getDataNasc());
            comando.setInt(4, professor.getCpf());
            comando.setString(5, professor.getDataExpedicao());
            comando.setString(6, professor.getOrgaoExpedidor());
            comando.setString(7, professor.getUfExpedicao());
            comando.setString(8, professor.getEmail());
            comando.setInt(9, professor.getTelefone());
            comando.setInt(10, professor.getCelular());
            comando.setString(11, professor.getLogradouro());
            comando.setInt(12, professor.getNumero());
            comando.setString(13, professor.getComplemento());
            comando.setString(14, professor.getBairro());
            comando.setInt(15, professor.getCep());
        
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update professor set nome = ? , dataNasc = ? , cpf = ? , dataExpedicao = ? , orgaoExpedidor = ? , ufExpedicao = ?, email = ?, telefone = ?, celular = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cep = ? where matricula = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, professor.getNome());
            comando.setString(2, professor.getDataNasc());
            comando.setInt(3, professor.getCpf());
            comando.setString(4, professor.getDataExpedicao());
            comando.setString(5, professor.getOrgaoExpedidor());
            comando.setString(6, professor.getUfExpedicao());
            comando.setString(7, professor.getEmail());
            comando.setInt(8, professor.getTelefone());
            comando.setInt(9, professor.getCelular());
            comando.setString(10, professor.getLogradouro());
            comando.setInt(11, professor.getNumero());
            comando.setString(12, professor.getComplemento());
            comando.setString(13, professor.getBairro());
            comando.setInt(14, professor.getCep());
            comando.setInt(15, professor.getMatricula());
            
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
    public static void excluir(Professor professor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from professor where matricula = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, professor.getMatricula());
            
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
