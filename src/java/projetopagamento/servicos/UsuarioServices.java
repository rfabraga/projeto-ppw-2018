package projetopagamento.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Usuario;

public class UsuarioServices {
    
    public List<Usuario> getTodos() {
        List<Usuario> lista = new ArrayList<Usuario>();
        UsuarioDAO dao = null;
        
        try {
            dao = new UsuarioDAO();
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
