package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Avaliacao;

public class AvaliacaoDAO {

    public static List<Avaliacao> obterAvaliacoes() throws ClassNotFoundException {
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

    public static Avaliacao obterAvaliacao(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Avaliacao avaliacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from avaliacao where codigo = " + codigo);
            rs.first();
            avaliacao = new Avaliacao(rs.getInt("codigo"),
                    rs.getInt("avaliacao1"),
                    rs.getInt("avaliacao2"),
                    rs.getInt("avaliacaoFinal"));
            //NULL PARA SER SETADO
            //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return avaliacao;
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

    public static void gravar(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into avaliacao (codigo , avaliacao1 , avaliacao2 , avaliacaoFinal) values (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, avaliacao.getCodigo());
            comando.setInt(2, avaliacao.getAvaliacao1());
            comando.setInt(3, avaliacao.getAvaliacao2());
            comando.setInt(4, avaliacao.getAvaliacaoFinal());
            /* if (curso.getCoordenador() == null){ CASO TENHA CHAVE ESTRANGEIRA
                comando.setNull(6 , Types.NULL);
            }else {
                comando.setInt(6, curso.getCoordenador().getMatricula());
            }*/
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
