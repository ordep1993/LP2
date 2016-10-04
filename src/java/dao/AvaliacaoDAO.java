package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Avaliacao;

public class AvaliacaoDAO {
    public static List<Avaliacao> obterAvaliacao() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from avaliacao");
            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao(rs.getInt("codigo"),                     
                        rs.getInt("avaliacao1"),                        
                        rs.getInt("avaliacao2"),
                        rs.getInt("avaliacaoFinal"));                  
                        avaliacoes.add(avaliacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return avaliacoes;
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