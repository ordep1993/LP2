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
                null);      
                matricula.setCodigoCurso(rs.getString("codigoCurso"));
                matricula.setCodigoDisciplina(rs.getString("codigoDisciplina"));
                matricula.setCodigoTurma(rs.getString("codigoTurma"));
                matricula.setCodigoAluno(rs.getString("codigoAluno"));
                matriculas.add(matricula);        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return matriculas;
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
