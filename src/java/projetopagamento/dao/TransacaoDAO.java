package projetopagamento.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.entidades.Cartao;
import projetopagamento.entidades.Conta;
import projetopagamento.entidades.Transacao;
import projetopagamento.entidades.Usuario;

public class TransacaoDAO extends DAO<Transacao> {
    
    public TransacaoDAO() throws SQLException {
    }

    @Override
    public void salvar(Transacao object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "INSERT INTO "
            + "transacao (data, valor, id_dest, id_rem, id_contaben, id_cartao)"
            + "VALUES(?, ?, ?, ?, ?, ?);"
        );
        
        stmt.setString(1, object.getData());
        stmt.setFloat(2, object.getValor());
        stmt.setInt(3, object.getDestinatario().getId());
        stmt.setInt(4, object.getRemetente().getId());
        stmt.setInt(5, object.getContaBeneficiada().getId());
        stmt.setInt(6, object.getCartao().getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Transacao object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "UPDATE transacao "
            + "SET "
            + "data = ?, valor = ?, id_dest = ?, id_rem = ?, id_contaben = ?, id_cartao = ? "
            + "WHERE id = ?;"
        );
        
        stmt.setString(1, object.getData());
        stmt.setFloat(2, object.getValor());
        stmt.setInt(3, object.getDestinatario().getId());
        stmt.setInt(4, object.getRemetente().getId());
        stmt.setInt(5, object.getContaBeneficiada().getId());
        stmt.setInt(6, object.getCartao().getId());
        stmt.setInt(7, object.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Transacao object) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            "DELETE FROM transacao WHERE id = ?;"
        );
        
        stmt.setInt(1, object.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Transacao> ListarTodos() throws SQLException {
        List<Transacao> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM transacao;"
        );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Transacao t = new Transacao();
            
            UsuarioDAO usuDAO = new UsuarioDAO();
            ContaDAO cctDAO = new ContaDAO();
            CartaoDAO cartDAO = new CartaoDAO();
            
            Usuario dest = new Usuario();
            dest = usuDAO.obterPorId(rs.getInt("id_dest"));
            
            Usuario rem = new Usuario();
            rem = usuDAO.obterPorId(rs.getInt("id_rem"));
            
            Conta cb = new Conta();
            cb = cctDAO.obterPorId(rs.getInt("id_contaben"));
            
            Cartao cartao = new Cartao();
            cartao = cartDAO.obterPorId(rs.getInt("id_cartao"));
            
            t.setId(rs.getInt("id"));
            t.setData(rs.getString("data"));
            t.setValor(rs.getFloat("valor"));
            t.setDestinatario(dest);
            t.setRemetente(rem);
            t.setContaBeneficiada(cb);
            t.setCartao(cartao);
            
            lista.add(t);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Transacao obterPorId(int id) throws SQLException {
        Transacao t = new Transacao();
        
        PreparedStatement stmt = getConnection().prepareStatement(
            "SELECT * FROM transacao WHERE id = ?;"
        );
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
       
        if(rs.next()){
            UsuarioDAO usuDAO = new UsuarioDAO();
            ContaDAO cctDAO = new ContaDAO();
            CartaoDAO cartDAO = new CartaoDAO();

            Usuario dest = new Usuario();
            dest = usuDAO.obterPorId(rs.getInt("id_dest"));

            Usuario rem = new Usuario();
            rem = usuDAO.obterPorId(rs.getInt("id_rem"));

            Conta cb = new Conta();
            cb = cctDAO.obterPorId(rs.getInt("id_contaben"));

            Cartao cart = new Cartao();
            cart = cartDAO.obterPorId(rs.getInt("id_cartao"));

            t.setId(rs.getInt("id"));
            t.setData(rs.getString("data"));
            t.setValor(rs.getFloat("valor"));
            t.setDestinatario(dest);
            t.setRemetente(rem);
            t.setContaBeneficiada(cb);
            t.setCartao(cart);
        }
        
        rs.close();
        stmt.close();
        
        return t;
    }
    
}
