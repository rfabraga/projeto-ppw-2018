package projetopagamento.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.entidades.Conta;

public class ContaDAO extends DAO<Conta> {

    public ContaDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Conta object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "INSERT INTO "
            + "conta (numero, agencia, id_usu)"
            + "VALUES(?, ?, ?);"
        );
        
        stmt.setString(1, object.getNumero());
        stmt.setString(2, object.getAgencia());
        stmt.setInt(3, object.getUsuario().getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Conta object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "UPDATE conta "
            + "SET "
            + "numero = ?, agencia = ? "
            + "WHERE id = ?;"
        );
        
        stmt.setString(1, object.getNumero());
        stmt.setString(2, object.getAgencia());
        stmt.setInt(3, object.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Conta object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "DELETE FROM conta WHERE id = ?;"
        );
        
        stmt.setInt(1, object.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Conta> ListarTodos() throws SQLException {
        List<Conta> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM conta;"
        );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Conta c = new Conta();
            
            c.setId(rs.getInt("id"));
            c.setNumero(rs.getString("numero"));
            c.setAgencia(rs.getString("agencia"));
            
            lista.add(c);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Conta obterPorId(int id) throws SQLException {
        Conta c = new Conta();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM conta WHERE id = ?;"
        );
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
       
        if(rs.next()){
            c.setId(rs.getInt("id"));
            c.setNumero(rs.getString("numero"));
            c.setAgencia(rs.getString("agencia"));
        }
        
        rs.close();
        stmt.close();
        
        return c;
    }
    
    public List<Conta> ListarPorUsuario(int id_usu) throws SQLException {
        List<Conta> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM conta WHERE id_usu = ?;"
        );
        stmt.setInt(1, id_usu);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Conta c = new Conta();
            
            c.setId(rs.getInt("id"));
            c.setNumero(rs.getString("numero"));
            c.setAgencia(rs.getString("agencia"));
            
            lista.add(c);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }
    
}
