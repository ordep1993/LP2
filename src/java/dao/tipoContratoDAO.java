package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoContrato;

public class tipoContratoDAO {

    public static List<TipoContrato> obterTipoContato() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoContrato> tipoContatos = new ArrayList<TipoContrato>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from tipoContrato");
            while (rs.next()) {
                TipoContrato tipoContrato = new TipoContrato(rs.getInt("codigo"),
                        rs.getString("descricao"));
                tipoContatos.add(tipoContrato);

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
