/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetopagamento.dao.CartaoDAO;
import projetopagamento.dao.ContaDAO;
import projetopagamento.dao.TransacaoDAO;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Conta;
import projetopagamento.entidades.Transacao;
import projetopagamento.entidades.Usuario;

/**
 *
 * @author  Lucas Sercon
 */
public class TransacoesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                
                Transacao transacao = new Transacao();
                transacao.setData(new Date(request.getParameter("data")));
                transacao.setContaBeneficiada(contaDAO.obterPorId(Integer.parseInt(request.getParameter("contaBeneficiada"))));
                transacao.setDestinatario(usuarioDAO.obterPorId(Integer.parseInt(request.getParameter("destinatario"))));
                transacao.setRemetente(usuarioDAO.obterPorId(Integer.parseInt(request.getParameter("remetente"))));
                transacao.setCartao(cartaoDAO.obterPorId(Integer.parseInt(request.getParameter("cartao"))));
                transacao.setValor(Float.valueOf("valor"));
                
                transacaoDAO.salvar(transacao);
                
                disp = request.getRequestDispatcher("/views/transacoes/cadastrar.jsp");
                
            } else if (acao.equals("editar")) {
                
                Transacao transacao = new Transacao();
                
                transacao.setId(Integer.parseInt(request.getParameter("id")));
                transacao.setData(new Date(request.getParameter("data")));
                transacao.setContaBeneficiada(contaDAO.obterPorId(Integer.parseInt(request.getParameter("contaBeneficiada"))));
                transacao.setDestinatario(usuarioDAO.obterPorId(Integer.parseInt(request.getParameter("destinatario"))));
                transacao.setRemetente(usuarioDAO.obterPorId(Integer.parseInt(request.getParameter("remetente"))));
                transacao.setCartao(cartaoDAO.obterPorId(Integer.parseInt(request.getParameter("cartao"))));
                transacao.setValor(Float.valueOf("valor"));        
                
                transacaoDAO.atualizar(transacao);
                
                disp = request.getRequestDispatcher("/views/transacoes/editar.jsp"); 
                
            } else if (acao.equals("excluir")) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                Transacao transacao = new Transacao();
                transacao.setId(id);
                
                transacaoDAO.excluir(transacao);
                
                disp = request.getRequestDispatcher("/views/transacoes/excluir.jsp");
                
            } 
            /*else if (acao.equals("prepAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Conta c = transacaoDAO.obterPorId(id);
                request.setAttribute("conta", c);
                
                disp = request.getRequestDispatcher("/views/contas/editar.jsp");
            } 
            Nao entendi o que era isso entao comentei. Ass: Lucas 
            */
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
