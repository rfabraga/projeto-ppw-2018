package projetopagamento.testes;

import java.sql.SQLException;
import java.util.List;
import projetopagamento.dao.CartaoDAO;
import projetopagamento.dao.ContaDAO;
import projetopagamento.dao.TransacaoDAO;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Cartao;
import projetopagamento.entidades.Conta;
import projetopagamento.entidades.Transacao;
import projetopagamento.entidades.Usuario;

public class TesteTransacao {
    
    static void testeSalvar() {
        
        TransacaoDAO dao = null;
        
        try {
            Usuario remetente = new Usuario();
            Usuario destinatario = new Usuario();
            Conta cct = new Conta();
            Cartao cart = new Cartao();
            
            UsuarioDAO usDAO = new UsuarioDAO();    
            ContaDAO cctDAO = new ContaDAO();    
            CartaoDAO cartDAO = new CartaoDAO();
            dao = new TransacaoDAO();


            remetente = usDAO.obterPorId(1);
            destinatario = usDAO.obterPorId(2);
            cct = cctDAO.obterPorId(1);
            cart = cartDAO.obterPorId(1);

            Transacao transacao = new Transacao();
            transacao.setData("00/00/0000");
            transacao.setRemetente(remetente);
            transacao.setDestinatario(destinatario);
            transacao.setContaBeneficiada(cct);
            transacao.setCartao(cart);
            transacao.setValor(500);
            
            dao.salvar(transacao);
            
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
    
    static void testeAtualizar(int id) {
        
        TransacaoDAO dao = null;
        
        try {
            Transacao transacao = new Transacao();                       
            Usuario remetente = new Usuario();
            Usuario destinatario = new Usuario();
            Conta cct = new Conta();
            Cartao cart = new Cartao();
            
            UsuarioDAO usDAO = new UsuarioDAO();    
            ContaDAO cctDAO = new ContaDAO();    
            CartaoDAO cartDAO = new CartaoDAO();
            dao = new TransacaoDAO();
            
            remetente = usDAO.obterPorId(1);
            destinatario = usDAO.obterPorId(2);
            cct = cctDAO.obterPorId(1);
            cart = cartDAO.obterPorId(1);
            
            transacao.setId(id);
            transacao.setData("00/00/0000");
            transacao.setRemetente(remetente);
            transacao.setDestinatario(destinatario);
            transacao.setContaBeneficiada(cct);
            transacao.setCartao(cart);
            transacao.setValor(500);
            
            dao = new TransacaoDAO();
            dao.atualizar(transacao);
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
    
    static void testeExcluir(int id) {
        Transacao transacao = new Transacao();
        transacao.setId(id);
        TransacaoDAO dao = null;
        
        try {
            dao = new TransacaoDAO();
            dao.excluir(transacao);
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
    
    static void testeListar() {
        TransacaoDAO dao = null;
        
        try {
            dao = new TransacaoDAO();
            List<Transacao> transacoes = dao.ListarTodos();
           
            System.out.println("Transacoes:");
            transacoes.forEach(item -> {                
                System.out.println("Id: " + item.getId());
                System.out.println("Remetente: " + item.getRemetente().getNome());
                System.out.println("Destinatario: " + item.getDestinatario().getNome());
                System.out.println("Cartao: " + item.getCartao().getNumero());
                System.out.println("Conta Beneficiada: " + item.getContaBeneficiada().getNumero());
                System.out.println("Data: " + item.getData());
                System.out.println("Valor: " + item.getValor());
            });
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
    
    static void testeObterPorId(int id) {
        TransacaoDAO dao = null;
        
        try {
            dao = new TransacaoDAO();
            Transacao transacao = dao.obterPorId(id);                
           
            System.out.println("Id: " + transacao.getId());
            System.out.println("Remetente: " + transacao.getRemetente().getNome());
            System.out.println("Destinatario: " + transacao.getDestinatario().getNome());
            System.out.println("Cartao: " + transacao.getCartao().getNumero());
            System.out.println("Conta Beneficiada: " + transacao.getContaBeneficiada().getNumero());
            System.out.println("Data: " + transacao.getData());
            System.out.println("Valor: " + transacao.getValor());
           
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
//        testeSalvar();
        
//        testeAtualizar(1);

//        testeExcluir(2);
        
        testeListar();

//        testeObterPorId(1);
    }
}
