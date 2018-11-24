/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import projetopagamento.jdbc.ConnectionFactory;

/**
 *
 * @author Rafael
 */

public abstract class DAO<T extends Object> {
    private Connection conexao;
    
    public DAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    
    public Connection getConnection() {
        return conexao;
    }
    
    public void fecharConexao() throws SQLException {
        conexao.close();
    }
    
    public abstract void salvar(T object) throws SQLException;
    
    public abstract void atualizar(T object) throws SQLException;
    
    public abstract void excluir(T object) throws SQLException;
    
    public abstract List<T> ListarTodos() throws SQLException;
    
    public abstract T obterPorId(int id) throws SQLException;
}
