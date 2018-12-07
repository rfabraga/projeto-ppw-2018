/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.entidades.Cartao;

/**
 *
 * @author Pichau
 */
public class CartaoDAO extends DAO<Cartao> {
    
    public CartaoDAO() throws SQLException {
    }
    
    @Override
    public void salvar(Cartao object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "INSERT INTO "
            + "cartao (numero, nome_titular, data_vencimento, cvv, bandeira, id_usu)"
            + "VALUES(?, ?, ?, ?, ?, ?);"
        );
        
        stmt.setInt(1, object.getNumero());
        stmt.setString(2, object.getNomeTitular());
        stmt.setString(3, object.getDataVencimento());
        stmt.setInt(4, object.getCvv());
        stmt.setString(5, object.getBandeira());
        stmt.setInt(6, object.getUsuario().getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Cartao object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "UPDATE cartao"
            + "SET "
            + "numero = ?, nome_titular = ?, data_vencimento = ?, cvv = ?, bandeira = ? "
            + "WHERE id = ?;"
        );
        
        stmt.setInt(1, object.getNumero());
        stmt.setString(2, object.getNomeTitular());
        stmt.setString(3, object.getDataVencimento());
        stmt.setInt(4, object.getCvv());
        stmt.setString(5, object.getBandeira());
        stmt.setInt(4, object.getId());
        
        stmt.executeUpdate();
        stmt.close(); 
    }

    @Override
    public void excluir(Cartao object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "DELETE FROM cartao WHERE id = ?;"
        );
        
        stmt.setInt(1, object.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Cartao> ListarTodos() throws SQLException {
        List<Cartao> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM cartao;"
        );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Cartao c = new Cartao();
            
            c.setId(rs.getInt("id"));
            c.setNumero(rs.getInt("numero"));
            c.setNomeTitular(rs.getString("nome_titular"));
            c.setDataVencimento(rs.getString("data_vencimento"));
            c.setCvv(rs.getInt("cvv"));
            c.setBandeira(rs.getString("bandeira"));
            
            lista.add(c);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Cartao obterPorId(int id) throws SQLException {
        Cartao c = new Cartao();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM cartao WHERE id = ?;"
        );
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
       
        if(rs.next()){
            c.setId(rs.getInt("id"));
            c.setNumero(rs.getInt("numero"));
            c.setNomeTitular(rs.getString("nome_titular"));
            c.setDataVencimento(rs.getString("data_vencimento"));
            c.setCvv(rs.getInt("cvv"));
            c.setBandeira(rs.getString("bandeira"));
        }
        
        rs.close();
        stmt.close();
        
        return c;
    }
    
    public List<Cartao> ListarPorUsuario(int id_usu) throws SQLException {
        List<Cartao> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM cartao WHERE id_usu = ?;"
        );
        stmt.setInt(1, id_usu);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Cartao c = new Cartao();
            
            c.setId(rs.getInt("id"));
            c.setNumero(rs.getInt("numero"));
            c.setNomeTitular(rs.getString("nome_titular"));
            c.setDataVencimento(rs.getString("data_vencimento"));
            c.setCvv(rs.getInt("cvv"));
            c.setBandeira(rs.getString("bandeira"));
            
            lista.add(c);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }
}
