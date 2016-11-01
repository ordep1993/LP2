package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;

public class DisciplinaDAO {

    public static List<Disciplina> obterDisciplinas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from disciplina");
            while (rs.next()) {
                Disciplina disciplina = new Disciplina(rs.getInt("codigo"),
                        rs.getString("descricao"),
                        rs.getInt("numAula"),
                        rs.getString("ementa"),
                        rs.getString("bibliografia"));
                        disciplinas.add(disciplina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return disciplinas;
    }
    
        public static Disciplina obterDisciplina(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Disciplina disciplina = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from disciplina where codigo = " + codigo);
            rs.first();
            disciplina = new Disciplina(rs.getInt("codigo"),
                    rs.getString("descricao"),
                    rs.getInt("numAula"),
                    rs.getString("ementa"),
                    rs.getString("bibliografia"));
                    //NULL PARA SER SETADO
                //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao(conexao , comando);
        }
        return disciplina;
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

    public static void gravar(Disciplina disciplina) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into disciplina(codigo, descricao, numAula, ementa, bibliografia) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1,disciplina.getCodigo());
            comando.setString(2, disciplina.getDescricao());
            comando.setInt(3, disciplina.getNumAula());
            comando.setString(4, disciplina.getEmenta());
            comando.setString(5, disciplina.getBibliografia());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
        
    }

    public static void alterar(Disciplina disciplina) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update disciplina set descricao = ?, numAula = ?, ementa = ?, bibliografia = ? where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, disciplina.getDescricao());
            comando.setInt(2, disciplina.getNumAula());
            comando.setString(3, disciplina.getEmenta());
            comando.setString(4, disciplina.getBibliografia());
            comando.setInt(5, disciplina.getCodigo());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
        
    }
}
