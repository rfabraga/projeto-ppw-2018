package projetopagamento.testes;

import java.sql.SQLException;

import java.util.List;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Cartao;
import projetopagamento.entidades.Conta;
import projetopagamento.entidades.Usuario;

public class TesteUsuario {
    
    static void testeSalvar() {
        Usuario usuario = new Usuario();
        usuario.setNome("Nome");
        usuario.setSobrenome("Sobrenome");
        usuario.setCpf("000.000.000-00");
        usuario.setDataNascimento("00/00/0000");
        usuario.setEmail("teste@email.com.br");
        usuario.setSenha("testesenha");
        
        UsuarioDAO dao = null;
        
        try {
            dao = new UsuarioDAO();
            dao.salvar(usuario);
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
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome("atualização");
        usuario.setSobrenome("att");
        usuario.setCpf("000.000.000-00");
        usuario.setDataNascimento("00/00/0000");
        usuario.setEmail("testeupdate@email.com.br");
        usuario.setSenha("testesenhaupdate");
        
        UsuarioDAO dao = null;
        
        try {
            dao = new UsuarioDAO();
            dao.atualizar(usuario);
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
        Usuario usuario = new Usuario();
        usuario.setId(id);
        UsuarioDAO dao = null;
        
        try {
            dao = new UsuarioDAO();
            dao.excluir(usuario);
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
        UsuarioDAO dao = null;
        
        try {
            dao = new UsuarioDAO();
            List<Usuario> usuarios = dao.ListarTodos();
           
            System.out.println("Usuários:");
            usuarios.forEach(item -> {
                List<Conta> contas = item.getContas();
                List<Cartao> cartoes = item.getCartoes();
                
                System.out.println("Nome: " + item.getNome());
                System.out.println("Sobrenome: " + item.getSobrenome());
                System.out.println("CPF: " + item.getCpf());
                System.out.println("Data Nascimento: " + item.getDataNascimento());
                System.out.println("E-mail: " + item.getEmail());
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
        UsuarioDAO dao = null;
        
        try {
            dao = new UsuarioDAO();
            Usuario usuario = dao.obterPorId(id);
           
            System.out.println("Usuário:");
            List<Conta> contas = usuario.getContas();
            List<Cartao> cartoes = usuario.getCartoes();

            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Sobrenome: " + usuario.getSobrenome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("Data Nascimento: " + usuario.getDataNascimento());
            System.out.println("E-mail: " + usuario.getEmail());

            System.out.println("=============================");

            System.out.println("Contas:");
            System.out.println("-----------------------------");
            contas.forEach((conta) -> {
                System.out.println("Número: " + conta.getNumero());
                System.out.println("Agência: " + conta.getAgencia());
                System.out.println("-----------------------------");
            });

            System.out.println("=============================");

            System.out.println("Cartões:");
            System.out.println("-----------------------------");
            cartoes.forEach((cartao) -> {
                System.out.println("Número: " + cartao.getNumero());
                System.out.println("Nome do Titular: " + cartao.getNomeTitular());
                System.out.println("Data de Vencimento: " + cartao.getDataVencimento());
                System.out.println("CVV: " + cartao.getCvv());
                System.out.println("Bandeira: " + cartao.getBandeira());
                System.out.println("-----------------------------");
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
    
    public static void main(String[] args) {
        testeSalvar();
        
//        testeAtualizar(1);

//        testeExcluir(2);
        
//        testeListar();

//        testeObterPorId(1);
    }
}
