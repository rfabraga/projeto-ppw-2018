package projetopagamento.servicos;

import java.sql.SQLException;
import projetopagamento.dao.MasterDAO;

public class MasterServices {
    
    public int getUsuarios() {
        int usuarios = 0;
        MasterDAO dao = null;
        
        try {
            dao = new MasterDAO();
            usuarios = dao.contarUsuarios();
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
        
        return usuarios;
    }
    
    public int getTransacoes() {
        int transacoes = 0;
        MasterDAO dao = null;
        
        try {
            dao = new MasterDAO();
            transacoes = dao.contarTransacoes();
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
        
        return transacoes;
    }
    
    public float getTotal() {
        float total = 0;
        MasterDAO dao = null;
        
        try {
            dao = new MasterDAO();
            total = dao.somarTotal();
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
        
        return total;
    }
    
}
