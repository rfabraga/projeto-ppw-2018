/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetopagamento.dao.CartaoDAO;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Cartao;
import projetopagamento.entidades.Usuario;

/**
 *
 * @author Pichau
 */
public class CartoesServlet extends HttpServlet {

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
        CartaoDAO dao = null;
        RequestDispatcher disp = null;
        
        try {
            dao = new CartaoDAO();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            if (acao.equals("cadastrar")) {
                
                Cartao cartao = new Cartao();
                cartao.setNumero(Integer.parseInt(request.getParameter("numero")));
                cartao.setUsuario(usuarioDAO.obterPorId(Integer.parseInt(request.getParameter("usuario"))));
                cartao.setBandeira(request.getParameter("bandeira"));
                cartao.setCvv(Integer.parseInt(request.getParameter("cvv")));
                cartao.setDataVencimento(request.getParameter("dataVencimento"));
                cartao.setNomeTitular(request.getParameter("nomeTitular"));
                
                dao.salvar(cartao);
                
                disp = request.getRequestDispatcher("/views/contas/cadastrar.jsp");
                
            } else if (acao.equals("editar")) {
                
                Cartao cartao = new Cartao();
                cartao.setId(Integer.parseInt(request.getParameter("id")));
                cartao.setNumero(Integer.parseInt(request.getParameter("numero")));
                cartao.setUsuario(usuarioDAO.obterPorId(Integer.parseInt(request.getParameter("usuario"))));
                cartao.setBandeira(request.getParameter("bandeira"));
                cartao.setCvv(Integer.parseInt(request.getParameter("cvv")));
                cartao.setDataVencimento(request.getParameter("dataVencimento"));
                cartao.setNomeTitular(request.getParameter("nomeTitular"));
                
                dao.atualizar(cartao);
                
                disp = request.getRequestDispatcher("/views/contas/editar.jsp");
                
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                Cartao c = new Cartao();
                c.setId(id);
                
                dao.excluir(c);
                disp = request.getRequestDispatcher("/views/usuarios/editar.jsp");
            } else if (acao.equals("prepAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Cartao c = dao.obterPorId(id);
                request.setAttribute("conta", c);
                
                disp = request.getRequestDispatcher("/views/contas/editar.jsp");
            }
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
