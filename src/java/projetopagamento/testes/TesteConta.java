package projetopagamento.testes;

import java.sql.SQLException;
import projetopagamento.dao.ContaDAO;
import projetopagamento.entidades.Conta;

public class TesteConta {
     static void testeObterPorId(int id) {
        ContaDAO dao = null;
        
       try {
            dao = new ContaDAO();
            Conta conta = dao.obterPorId(id);                
           
            System.out.println("Id: " + conta.getId());
            System.out.println("Número: " + conta.getNumero());
            System.out.println("Agência: " + conta.getAgencia());
           
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    System.out.println("Erro ao fechar conexão.");
                    exc.printStackTrace();
                }
            }
        }
    }
     
     
    public static void main(String[] args) {
        testeObterPorId(3);
    }
            
}
