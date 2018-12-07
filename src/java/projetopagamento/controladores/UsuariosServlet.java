/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopagamento.controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Usuario;

/**
 *
 * @author Pichau
 */
public class UsuariosServlet extends HttpServlet {

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
        UsuarioDAO dao = null;
        RequestDispatcher disp = null;
        
        try {
            dao = new UsuarioDAO();
            
            if (acao.equals("cadastrar")) {
                String  nome  = request.getParameter("nome");
                String  sobrenome  = request.getParameter("sobrenome");
                String  cpf  = request.getParameter("cpf");
                String  data_nascimento = request.getParameter("data_nascimento"); // trocar data por string
                String  email  = request.getParameter("email");
                String  senha  = request.getParameter("senha");
                
                Usuario u = new Usuario();
                u.setNome(nome);
                u.setSobrenome(sobrenome);
                u.setCpf(cpf);
                u.setDataNascimento(new Date(data_nascimento));
                u.setEmail(email);
                u.setSenha(senha);
                
                dao.salvar(u);
                disp = request.getRequestDispatcher("/views/usuarios/cadastrar.jsp");
            } else if (acao.equals("editar")) {
                String  nome  = request.getParameter("nome");
                String  sobrenome  = request.getParameter("sobrenome");
                String  cpf  = request.getParameter("cpf");
                String  data_nascimento = request.getParameter("data_nascimento"); // trocar data por string
                String  email  = request.getParameter("email");
                String  senha  = request.getParameter("senha");
                
                Usuario u = new Usuario();
                u.setNome(nome);
                u.setSobrenome(sobrenome);
                u.setCpf(cpf);
                u.setDataNascimento(new Date(data_nascimento));
                u.setEmail(email);
                u.setSenha(senha);
                
                dao.atualizar(u);
                disp = request.getRequestDispatcher("/views/usuarios/editar.jsp"); 
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                Usuario u = new Usuario();
                u.setId(id);
                
                dao.excluir(u);
                disp = request.getRequestDispatcher("/views/usuarios/index.jsp");
            } else if (acao.equals("prepAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Usuario u = dao.obterPorId(id);
                request.setAttribute("usuario", u);
                
                disp = request.getRequestDispatcher("/views/usuarios/editar.jsp");
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
