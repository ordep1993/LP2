package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Turma;

public class TurmaDAO {

    public static List<Turma> obterTurma() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Turma> turmas = new ArrayList<Turma>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from turma");
            while (rs.next()) {
                Turma turma = new Turma(rs.getString("codigo"),
                        rs.getInt("ano"),
                        rs.getInt("semestre"),
                        rs.getInt("maxAlunos"));
                        turmas.add(turma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return turmas;
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
