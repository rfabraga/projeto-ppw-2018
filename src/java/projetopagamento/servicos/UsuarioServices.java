/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Usuario;

/**
 *
 * @author Pichau
 */
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
