package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;

public class DisciplinaDAO {

    public static List<Disciplina> obterDisciplina() throws ClassNotFoundException {
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
