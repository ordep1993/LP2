package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Servidor;

public class ServidorDAO {

    public static List<Servidor> obterServidores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Servidor> servidores = new ArrayList<Servidor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from servidor");
            while (rs.next()) {
                Servidor servidor = new Servidor(rs.getInt("matricula"),
                        rs.getString("nome"),
                        rs.getString("dataNasc"),
                        rs.getInt("cpf"),
                        rs.getString("dataExpedicao"),
                        rs.getString("orgaoExpedidor"),
                        rs.getString("ufExpedicao"),
                        rs.getString("email"),
                        rs.getInt("telefone"),
                        rs.getInt("celular"),
                        rs.getString("logradouro"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getInt("cep"),
                        rs.getString("dataAdmissao"));
                servidores.add(servidor);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return servidores;
    }
    
     public static Servidor obterServidor(int codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Servidor servidor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from servidor where matricula = " + codigo);
            rs.first();
            servidor = new Servidor(rs.getInt("matricula"),
                    rs.getString("nome"),
                    rs.getString("dataNasc"),
                    rs.getInt("cpf"),
                    rs.getString("dataExpedicao"),
                    rs.getString("orgaoExpedidor"),
                    rs.getString("ufExpedicao"),
                    rs.getString("email"),
                    rs.getInt("telefone"),
                    rs.getInt("celular"),
                    rs.getString("logradouro"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getInt("cep"),
                    rs.getString("dataAdmissao"));
                    //NULL PARA SER SETADO
                //turma.setMatriculaProfessorCoordenador(rs.getInt("professorCoordenador")); CASO TENHA CHAVE ESTRANGEIRA
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            fecharConexao(conexao , comando);
        }
        return servidor;
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
    
    public static void gravar(Servidor servidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into servidor ( matricula, nome, dataNasc, cpf, dataExpedicao, orgaoExpedidor, ufExpedicao, email, telefone, celular, logradouro, numero, complemento, bairro, cep, dataAdmissao) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, servidor.getMatricula());
            comando.setString(2, servidor.getNome());
            comando.setString(3, servidor.getDataNasc());
            comando.setInt(4, servidor.getCpf());
            comando.setString(5, servidor.getDataExpedicao());
            comando.setString(6, servidor.getOrgaoExpedidor());
            comando.setString(7, servidor.getUfExpedicao());
            comando.setString(8, servidor.getEmail());
            comando.setInt(9, servidor.getTelefone());
            comando.setInt(10, servidor.getCelular());
            comando.setString(11, servidor.getLogradouro());
            comando.setInt(12, servidor.getNumero());
            comando.setString(13, servidor.getComplemento());
            comando.setString(14, servidor.getBairro());
            comando.setInt(15, servidor.getCep());
            comando.setString(16, servidor.getDataAdmissao());
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

    public static void alterar(Servidor servidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update servidor set nome = ?, dataNasc = ?, cpf = ?, dataExpedicao = ?, orgaoExpedidor = ?, ufExpedicao = ?, email = ?, telefone = ?, celular = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, dataAdmissao = ? where matricula = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, servidor.getNome());
            comando.setString(2, servidor.getDataNasc());
            comando.setInt(3, servidor.getCpf());
            comando.setString(4, servidor.getDataExpedicao());
            comando.setString(5, servidor.getOrgaoExpedidor());
            comando.setString(6, servidor.getUfExpedicao());
            comando.setString(7, servidor.getEmail());
            comando.setInt(8, servidor.getTelefone());
            comando.setInt(9, servidor.getCelular());
            comando.setString(10, servidor.getLogradouro());
            comando.setInt(11, servidor.getNumero());
            comando.setString(12, servidor.getComplemento());
            comando.setString(13, servidor.getBairro());
            comando.setInt(14, servidor.getCep());
            comando.setString(15, servidor.getDataAdmissao());
            comando.setInt(16, servidor.getMatricula());
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

    public static void excluir(Servidor servidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from servidor where matricula = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, servidor.getMatricula());
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
