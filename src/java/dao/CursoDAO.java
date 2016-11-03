package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;

public class CursoDAO {

    public static List<Curso> obterCursos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Curso> cursos = new ArrayList<Curso>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from curso");
            while (rs.next()) {
                Curso curso = new Curso(rs.getInt("codigo"),
                        rs.getString("descricao"),
                        rs.getInt("cargaHoraria"),
                        null);
                curso.setCodigoCoordenador(rs.getString("codigoCoordenador"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cursos;
    }

    public static Curso obterCurso(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from curso where codigo = " + codigo);
            rs.first();
            curso = new Curso(rs.getInt("codigo"),
                    rs.getString("descricao"),
                    rs.getInt("cargaHoraria"),
                    null);
            curso.setCodigoCoordenador(rs.getString("codigoCoordenador"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
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

    public static void gravar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into curso(codigo, descricao, cargaHoraria ,codigoCoordenador) values (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, curso.getCodigo());
            comando.setString(2, curso.getDescricao());
            comando.setInt(3, curso.getCargaHoraria());
            if (curso.getCoordenador() == null) {
                comando.setNull(4, Types.NULL);
            } else {
                comando.setInt(4, curso.getCoordenador().getMatricula());
            }
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update curso set descricao = ?, cargaHoraria = ?, codigoCoordenador = ? where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, curso.getDescricao());
            comando.setInt(2, curso.getCargaHoraria());
            comando.setString(3, curso.getCodigoCoordenador());
            comando.setInt(4, curso.getCodigo());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from curso where codigo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, curso.getCodigo());
            comando.executeUpdate();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
