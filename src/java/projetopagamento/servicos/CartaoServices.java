package projetopagamento.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.dao.CartaoDAO;
import projetopagamento.entidades.Cartao;

public class CartaoServices {
    
    public List<Cartao> getTodos() {
        List<Cartao> lista = new ArrayList<Cartao>();
        CartaoDAO dao = null;
        
        try {
            dao = new CartaoDAO();
            lista = dao.ListarTodos();
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
        }
        
        return lista;
    }
}
