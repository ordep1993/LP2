package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Estado;

public class EstadoDAO {
   public static List<Estado> obterEstado() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Estado> estados = new ArrayList<Estado>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from estado");
            while (rs.next()) {
                Estado estado = new Estado(rs.getInt("codigo"),                       
                        rs.getString("nome"));
                        estados.add(estado);
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

