package projetopagamento.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MasterDAO extends DAO{
    
    public MasterDAO() throws SQLException {}    

    public int contarUsuarios() throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT COUNT(id) as usuarios FROM usuario;"
        );
        int usuarios = 0;
        
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
           usuarios  = rs.getInt("usuarios");
        }
        
        rs.close();
        stmt.close();
        
        return usuarios;
    }
    
    public int contarTransacoes() throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT COUNT(id) as transacoes FROM transacao;"
        );
        int transacoes = 0;
        
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
           transacoes  = rs.getInt("transacoes");
        }
        
        rs.close();
        stmt.close();
        
        return transacoes;
    }
    
    public float somarTotal() throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT SUM(valor) as total FROM transacao;"
        );
        float total = 0;
        
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
           total  = rs.getInt("total");
        }
        
        rs.close();
        stmt.close();
        
        return total;
    }

    @Override
    public void salvar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List ListarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}