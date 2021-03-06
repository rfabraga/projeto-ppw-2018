package projetopagamento.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetopagamento.dao.ContaDAO;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Conta;
import projetopagamento.entidades.Usuario;

public class ContasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        ContaDAO dao = null;
        RequestDispatcher disp = null;
        
        try {
            dao = new ContaDAO();
            
            if (acao.equals("cadastrar")) {
                String  numero  = request.getParameter("numero");
                String  agencia  = request.getParameter("agencia");
                int id_usu  = Integer.parseInt(request.getParameter("id_usu"));
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.obterPorId(id_usu);
                
                Conta c = new Conta();
                c.setNumero(numero);
                c.setAgencia(agencia);
                c.setUsuario(usuario);
                
                dao.salvar(c);
                
                String redirect = "/processaUsuarios?acao=prepEdicao&id=" + id_usu;
                disp = request.getRequestDispatcher(redirect);
            } else if (acao.equals("editar")) {
                int id  = Integer.parseInt(request.getParameter("id"));
                String  numero  = request.getParameter("numero");
                String  agencia  = request.getParameter("agencia");
                int id_usu  = Integer.parseInt(request.getParameter("id_usu"));
                
                Conta c = new Conta();
                c.setId(id);
                c.setNumero(numero);
                c.setAgencia(agencia);
                
                dao.atualizar(c);
                
                String redirect = "/processaUsuarios?acao=prepEdicao&id=" + id_usu;
                disp = request.getRequestDispatcher(redirect); 
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                Conta c = new Conta();
                c.setId(id);
                
                dao.excluir(c);
                disp = request.getRequestDispatcher("/views/usuarios/editar.jsp");
            } else if (acao.equals("prepEdicao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                int id_usu = Integer.parseInt(request.getParameter("id_usu"));
                Conta conta = dao.obterPorId(id);
                request.setAttribute("conta", conta);
                request.setAttribute("id_usu", id_usu);
                
                disp = request.getRequestDispatcher("/views/contas/editar.jsp");
            } else if (acao.equals("prepCadastro")) {
                int id = Integer.parseInt(request.getParameter("id_usu"));
                request.setAttribute("id_usu", id);
                
                disp = request.getRequestDispatcher("/views/contas/cadastrar.jsp");
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
