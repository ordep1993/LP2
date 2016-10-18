package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Turma;

public class TurmaDAO {

    public static List<Turma> obterTurmas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Turma> turmas = new ArrayList<Turma>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from turma");
            while (rs.next()) {
                Turma turma = new Turma(rs.getInt("codigo"),
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

    public static Turma obterTurma(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Turma turma = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from turma where codigo = " + codigo);
            rs.first();
            turma = new Turma(rs.getInt("codigo"),
                    rs.getInt("ano"),
                    rs.getInt("semestre"),
                    rs.getInt("maxAlunos"));
                    //NULL PARA SER SETADO
                //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao(conexao , comando);
        }
        return turma;
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

    public static void gravar(Turma turma) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into turma (codigo , ano , semestre , maxAlunos) values (?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, turma.getCodigo());
            comando.setInt(2, turma.getAno());
            comando.setInt(3, turma.getSemestre());
            comando.setInt(4, turma.getMaxAlunos());
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
