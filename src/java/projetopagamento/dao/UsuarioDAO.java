/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.entidades.Cartao;
import projetopagamento.entidades.Conta;
import projetopagamento.entidades.Usuario;

/**
 *
 * @author Rafael
 */
public class UsuarioDAO extends DAO<Usuario> {
    
    public UsuarioDAO() throws SQLException {
    }

    @Override
    public void salvar(Usuario object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "INSERT INTO "
            + "usuario(nome, sobrenome, cpf, data_nascimento, email, senha)"
            + "VALUES(?, ?, ?, ?, ?, ?);"
        );
        
        stmt.setString(1, object.getNome());
        stmt.setString(2, object.getSobrenome());
        stmt.setString(3, object.getCpf());
        stmt.setDate(4, new Date(object.getDataNascimento().getTime()));
        stmt.setString(5, object.getEmail());
        stmt.setString(6, object.getSenha());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Usuario object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "UPDATE usuario "
            + "SET "
            + "nome = ?, sobrenome = ?, cpf = ?, data_nascimento = ?, email = ?, senha = ? "
            + "WHERE id = ?;"
        );
        
        stmt.setString(1, object.getNome());
        stmt.setString(2, object.getSobrenome());
        stmt.setString(3, object.getCpf());
        stmt.setDate(4, new Date(object.getDataNascimento().getTime()));
        stmt.setString(5, object.getEmail());
        stmt.setString(6, object.getSenha());
        stmt.setInt(7, object.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Usuario object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "DELETE FROM usuario WHERE id = ?;"
        );
        
        stmt.setInt(1, object.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Usuario> ListarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM usuario;"
        );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setSobrenome(rs.getString("sobrenome"));
            u.setCpf(rs.getString("cpf"));
            u.setDataNascimento(rs.getDate("data_nascimento"));
            u.setEmail(rs.getString("email"));
            u.setSenha(rs.getString("Senha"));
            
            lista.add(u);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Usuario obterPorId(int id) throws SQLException {
        Usuario usuario = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(
//            "SELECT * FROM usuario"
//                + "INNER JOIN conta"
//                + "ON usuario.id = conta.id_usu"
//                + "INNER JOIN cartao"
//                + "ON usuario.id = cartao.id_usu"
//            + "WHERE usuario.id = ?"
            "SELECT * FROM usuario WHERE id = ?;"    
        );
        
        stmt.setInt(1, id);
        ResultSet rs =  stmt.executeQuery();
        
        if (rs.next()) {
            usuario = new Usuario();
            
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSobrenome(rs.getString("sobrenome"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setDataNascimento(rs.getDate("data_nascimento"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
        }
        
        rs.close();
        stmt.close();
        
        // Começo da Gambiarra
        // Essa merda é pq minhas habilidades em SQL são deploráveis
        List<Conta> contas = new ArrayList<>();
        List<Cartao> cartoes = new ArrayList<>();
        
        PreparedStatement stmtContas = getConnection().prepareStatement(
            "SELECT * FROM conta WHERE id_usu = ?;"    
        );
        
        PreparedStatement stmtCartoes = getConnection().prepareStatement(
            "SELECT * FROM cartao WHERE id_usu = ?;"    
        );
        
        stmtContas.setInt(1, id);
        stmtCartoes.setInt(1, id);
        ResultSet rsConta = stmtContas.executeQuery();
        ResultSet rsCartao = stmtCartoes.executeQuery();
        
        while (rsConta.next()) {
            Conta conta = new Conta();
            
            conta.setId(rsConta.getInt("id"));
            conta.setNumero(rsConta.getString("numero"));
            conta.setAgencia(rsConta.getString("agencia"));
            
            contas.add(conta);
        }
        
        while (rsCartao.next()) {
            Cartao cartao = new Cartao();
            
            cartao.setId(rsCartao.getInt("id"));
            cartao.setNumero(rsCartao.getInt("numero"));
            cartao.setNomeTitular(rsCartao.getString("nome_titular"));
            cartao.setDataVencimento(rsCartao.getString("data_vencimento"));
            cartao.setCvv(rsCartao.getInt("cvv"));
            cartao.setBandeira(rsCartao.getString("bandeira"));
            
            cartoes.add(cartao);
        }
        
        rsConta.close();
        rsCartao.close();
        stmtContas.close();
        stmtCartoes.close();
        
        usuario.setContas(contas);
        usuario.setCartoes(cartoes);
        
        return usuario;
    }
    
}
