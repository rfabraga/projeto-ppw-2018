package projetopagamento.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.dao.TransacaoDAO;
import projetopagamento.entidades.Transacao;

public class TransacaoServices {
    
    public List<Transacao> getTodos() {
        List<Transacao> lista = new ArrayList<Transacao>();
        TransacaoDAO dao = null;
        
        try {
            dao = new TransacaoDAO();
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
