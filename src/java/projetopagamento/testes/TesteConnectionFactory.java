/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.testes;

import java.sql.Connection;
import java.sql.SQLException;
import projetopagamento.jdbc.ConnectionFactory;

/**
 *
 * @author Rafael
 */
public class TesteConnectionFactory {
    
    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (SQLException exc) {
            System.out.println("Erro ao tentar estabelecer conexão.");    
            exc.printStackTrace();
        }
    }
    
}
