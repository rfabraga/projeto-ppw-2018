package projetopagamento.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetopagamento.dao.CartaoDAO;
import projetopagamento.dao.UsuarioDAO;
import projetopagamento.entidades.Cartao;
import projetopagamento.entidades.Usuario;


public class CartoesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        CartaoDAO dao = null;
        RequestDispatcher disp = null;
        
        try {
            dao = new CartaoDAO();
            
            if (acao.equals("cadastrar")) {
                String numero = request.getParameter("numero");
                String nomeTitular = request.getParameter("nomeTitular");
                String dataVencimento = request.getParameter("dataVencimento");
                int cvv = Integer.parseInt(request.getParameter("cvv"));
                String bandeira = request.getParameter("bandeira");
                int id_usu = Integer.parseInt(request.getParameter("id_usu"));
                System.out.println(request.getParameter("id_usu"));
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = new Usuario();
                usuario = usuarioDAO.obterPorId(id_usu);
                
                Cartao cartao = new Cartao();
                cartao.setNumero(numero);
                cartao.setNomeTitular(nomeTitular);
                cartao.setDataVencimento(dataVencimento);
                cartao.setCvv(cvv);
                cartao.setBandeira(bandeira);
                cartao.setUsuario(usuario);
                
                dao.salvar(cartao);
                
                String redirect = "/processaUsuarios?acao=prepEdicao&id=" + id_usu;
                disp = request.getRequestDispatcher(redirect);   
            } else if (acao.equals("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String numero = request.getParameter("numero");
                String nomeTitular = request.getParameter("nomeTitular");
                String dataVencimento = request.getParameter("dataVencimento");
                int cvv = Integer.parseInt(request.getParameter("cvv"));
                String bandeira = request.getParameter("bandeira");
                int id_usu = Integer.parseInt(request.getParameter("id_usu"));
                
                Cartao cartao = new Cartao();
                cartao.setId(id);
                cartao.setNumero(numero);
                cartao.setNomeTitular(nomeTitular);
                cartao.setDataVencimento(dataVencimento);
                cartao.setCvv(cvv);
                cartao.setBandeira(bandeira);
                
                
                dao.atualizar(cartao);
                
                String redirect = "/processaUsuarios?acao=prepEdicao&id=" + id_usu;
                disp = request.getRequestDispatcher(redirect);   
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                
                Cartao c = new Cartao();
                c.setId(id);
                
                dao.excluir(c);
                disp = request.getRequestDispatcher("/views/usuarios/editar.jsp");
            } else if (acao.equals("prepEdicao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                int id_usu = Integer.parseInt(request.getParameter("id_usu"));
                Cartao cartao = dao.obterPorId(id);
                request.setAttribute("cartao", cartao);
                request.setAttribute("id_usu", id_usu);
                
                disp = request.getRequestDispatcher("/views/cartoes/editar.jsp");
            } else if (acao.equals("prepCadastro")) {
                int id = Integer.parseInt(request.getParameter("id_usu"));
                request.setAttribute("id_usu", id);
                
                disp = request.getRequestDispatcher("/views/cartoes/cadastrar.jsp");
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
