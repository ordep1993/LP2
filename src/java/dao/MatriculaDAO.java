package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Matricula;

public class MatriculaDAO {

    public static List<Matricula> obterMatricula() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Matricula> matriculas = new ArrayList<Matricula>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from matricula");
            while (rs.next()) {
                Matricula matricula = new Matricula(rs.getInt("codigo"),
                null,
                null,
                null,
                null,
                rs.getString("codigoCurso"),
                rs.getString("codigoDisciplina"),
                rs.getString("codigoTurma"),
                rs.getString("codigoAluno"));        
                matricula.setCodigoCurso(rs.getString("curso"));
                matricula.setCodigoDisciplina(rs.getString("disciplina"));
                matricula.setCodigoTurma(rs.getString("turma"));
                matricula.setCodigoAluno(rs.getString("aluno"));
                matriculas.add(matricula);        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return null;
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
}
