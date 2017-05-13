/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.session;

import controladores.clases.Bdd;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class Autenticar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String json;
            
            List<Object> param = new ArrayList<>();
            param.add(user);
            param.add(pass);
            try {
                Context initial = new InitialContext();
                Bdd db = new Bdd(initial,"jdbc/AWS");
                db.setCallableQuery("{call LOGIN(?,?)}");
                ResultSet rs = db.executeCallRead(param);
                int i = 0;
                
                if(!rs.next())
                {
                    Exception ex = new Exception("Error al autenticar<br>");
                    throw ex;
                }
                
                
                HttpSession session = request.getSession();
                session.setAttribute("id", rs.getObject("idUsuario"));
                session.setAttribute("tipo", rs.getObject("idTipo"));
                session.setAttribute("nombre", rs.getObject("nombre"));
                session.setAttribute("apellido", rs.getObject("apellido"));
                session.setAttribute("correo", rs.getObject("correo"));
                session.setAttribute("gui", rs.getObject("colorGui"));
                session.setAttribute("autenticado", true);
                
                json = "autenticado:true";
                db.disconnect();
            } catch (Exception e) {
                json = "autenticado:false";
            }
            out.write(json);
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
