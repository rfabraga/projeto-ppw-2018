package projetopagamento.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetopagamento.dao.CartaoDAO;
import projetopagamento.dao.ContaDAO;
import projetopagamento.dao.TransacaoDAO;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Cartao;
import projetopagamento.entidades.Conta;
import projetopagamento.entidades.Transacao;
import projetopagamento.entidades.Usuario;


public class TransacoesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        TransacaoDAO transacaoDAO = null;
        RequestDispatcher disp = null;
        
        try {
            transacaoDAO = new TransacaoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ContaDAO contaDAO = new ContaDAO();
            CartaoDAO cartaoDAO = new CartaoDAO();
            
            
            if (acao.equals("cadastrar")) {   
                
                String data = request.getParameter("data");
                float valor = Float.parseFloat(request.getParameter("valor"));
                int id_dest = Integer.parseInt(request.getParameter("destinatario"));
                int id_rem = Integer.parseInt(request.getParameter("remetente"));
                int id_contaben = Integer.parseInt(request.getParameter("beneficiada"));
                int id_cartao = Integer.parseInt(request.getParameter("cartao"));
                
                Usuario destinatario = new Usuario();
                Usuario remetente = new Usuario();
                Conta beneficiada = new Conta();
                Cartao cartao = new Cartao();
                
                destinatario = usuarioDAO.obterPorId(id_dest);
                remetente = usuarioDAO.obterPorId(id_rem);
                beneficiada = contaDAO.obterPorId(id_contaben);
                cartao = cartaoDAO.obterPorId(id_cartao);
                
                Transacao transacao = new Transacao();
                transacao.setData(request.getParameter("data"));
                transacao.setValor(valor);
                transacao.setDestinatario(destinatario);
                transacao.setRemetente(remetente);
                transacao.setContaBeneficiada(beneficiada);
                transacao.setCartao(cartao);
                
                transacaoDAO.salvar(transacao);
                
                disp = request.getRequestDispatcher("/views/transacoes/index.jsp");
                
            } else if (acao.equals("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String data = request.getParameter("data");
                float valor = Float.parseFloat(request.getParameter("valor"));
                int id_dest = Integer.parseInt(request.getParameter("destinatario"));
                int id_rem = Integer.parseInt(request.getParameter("remetente"));
                int id_contaben = Integer.parseInt(request.getParameter("beneficiada"));
                int id_cartao = Integer.parseInt(request.getParameter("cartao"));
                
                Usuario destinatario = new Usuario();
                Usuario remetente = new Usuario();
                Conta beneficiada = new Conta();
                Cartao cartao = new Cartao();
                
                destinatario = usuarioDAO.obterPorId(id_dest);
                remetente = usuarioDAO.obterPorId(id_rem);
                beneficiada = contaDAO.obterPorId(id_contaben);
                cartao = cartaoDAO.obterPorId(id_cartao);
                
                Transacao transacao = new Transacao();
                transacao.setId(id);
                transacao.setData(request.getParameter("data"));
                transacao.setValor(valor);
                transacao.setDestinatario(destinatario);
                transacao.setRemetente(remetente);
                transacao.setContaBeneficiada(beneficiada);
                transacao.setCartao(cartao);
                
                transacaoDAO.atualizar(transacao);
                
                disp = request.getRequestDispatcher("/views/transacoes/index.jsp");
                 
                
            } else if (acao.equals("excluir")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                Transacao transacao = new Transacao();
                transacao.setId(id);
                
                transacaoDAO.excluir(transacao);
                
                disp = request.getRequestDispatcher("/views/transacoes/index.jsp");
                
            } else if (acao.equals("prepEdicao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Transacao t = transacaoDAO.obterPorId(id);
                request.setAttribute("transacao", t);
                
                disp = request.getRequestDispatcher("/views/transacoes/editar.jsp");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (transacaoDAO != null) {
                try {
                    transacaoDAO.fecharConexao();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
            
            if (disp != null) {
                disp.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
