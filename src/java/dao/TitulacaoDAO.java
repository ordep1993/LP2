package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Titulacao;

public class TitulacaoDAO {

    public static List<Titulacao> obterTItulacao() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Titulacao> titulos = new ArrayList<Titulacao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from titulacao");
            while (rs.next()) {
                Titulacao titulacao = new Titulacao(rs.getInt("codigo"),
                    rs.getString("descricao"));
                    titulos.add(titulacao);

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
