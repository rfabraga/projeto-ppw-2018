package projetopagamento.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.dao.ContaDAO;
import projetopagamento.entidades.Conta;

public class ContaServices {
    
    public List<Conta> getTodos() {
        List<Conta> lista = new ArrayList<Conta>();
        ContaDAO dao = null;
        
        try {
            dao = new ContaDAO();
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
