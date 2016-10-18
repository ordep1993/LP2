package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
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

    public static void gravar(Disciplina disciplina) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into disciplina(codigo, descricao, numAula, ementa, bibliografia) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1,disciplina.getCodigo());
            comando.setString(2, disciplina.getDescricao());
            comando.setInt(3, disciplina.getNumAula());
            comando.setString(4, disciplina.getEmenta());
            comando.setString(5, disciplina.getBibliografia());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
        
    }
}
