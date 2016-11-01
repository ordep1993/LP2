package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Matricula;

public class MatriculaDAO {

    public static List<Matricula> obterMatriculas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Matricula> matriculas = new ArrayList<Matricula>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from matricula");
            while (rs.next()) {
                Matricula matricula = new Matricula(rs.getInt("codigo"),
                        null,
                        null,
                        null,
                        null);
                matricula.setCodigoCurso(rs.getInt("codigoCurso"));
                matricula.setCodigoDisciplina(rs.getInt("codigoDisciplina"));
                matricula.setCodigoTurma(rs.getInt("codigoTurma"));
                matricula.setCodigoAluno(rs.getInt("codigoAluno"));
                matriculas.add(matricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return matriculas;
    }

    public static Matricula obterMatricula(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Matricula matricula = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from matricula where codigo = " + codigo);
            rs.first();
            matricula = new Matricula(rs.getInt("codigo"), null, null, null, null);
            matricula.setCodigoCurso(rs.getInt("codigoCurso"));
            matricula.setCodigoDisciplina(rs.getInt("codigoDisciplina"));
            matricula.setCodigoTurma(rs.getInt("codigoTurma"));
            matricula.setCodigoAluno(rs.getInt("codigoAluno"));
            //NULL PARA SER SETADO
            //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return matricula;
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

    public static void gravar(Matricula matricula) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into matricula (codigo , codigoCurso , codigoDisciplina , codigoTurma , codigoAluno) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, matricula.getCodigo());

            // comando.setString(2, matricula.getCodigoCurso());
            if (matricula.getCurso() == null) { //CASO TENHA CHAVE ESTRANGEIRA
                comando.setNull(2, Types.NULL);
            } else {
                comando.setInt(2, matricula.getCurso().getCodigo());
            }
            //comando.setString(3, matricula.getCodigoDisciplina());
            if (matricula.getDisciplina() == null) { //CASO TENHA CHAVE ESTRANGEIRA
                comando.setNull(3, Types.NULL);
            } else {
                comando.setInt(3, matricula.getDisciplina().getCodigo());
            }
            //comando.setString(4, matricula.getCodigoTurma());
            if (matricula.getTurma() == null) { //CASO TENHA CHAVE ESTRANGEIRA
                comando.setNull(4, Types.NULL);
            } else {
                comando.setInt(4, matricula.getTurma().getCodigo());
            }
            //comando.setString(5, matricula.getCodigoAluno());
            if (matricula.getAluno() == null) { //CASO TENHA CHAVE ESTRANGEIRA
                comando.setNull(5, Types.NULL);
            } else {
                comando.setInt(5, matricula.getAluno().getMatricula());
            }
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }
}
