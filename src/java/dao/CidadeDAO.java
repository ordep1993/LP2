package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidade;

public class CidadeDAO {

    public static List<Cidade> obterCidades() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Cidade> cidades = new ArrayList<Cidade>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cidade");
            while (rs.next()) {
                Cidade cidade = new Cidade(rs.getInt("codCidade"),
                        rs.getString("nome"));
                        cidades.add(cidade);
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