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
            String id = "", tipo = "", nombre = "", apellido = "", correo = "", gui = "";
            Bdd db = new Bdd();
            
            List<Permiso> permisos = new ArrayList<>();
            List<Object> param = new ArrayList<>();
            param.add(user);
            param.add(pass);
            try {
                Context initial = new InitialContext();
                db = new Bdd(initial,"jdbc/AWS");
                db.setCallableQuery("{call LOGIN(?,?)}");
                ResultSet rs = db.executeCallRead(param);
                int i = 0;
                
                while(rs.next())
                {
                    if(i == 0 && rs.getString("result").equals("0"))
                    {
                        Exception ex = new Exception("Error al autenticar<br>");
                        throw ex;
                    }
                    else if(i==0)
                    {
                        id =  String.valueOf(rs.getObject("idUsuario"));
                        tipo = String.valueOf(rs.getObject("idTipo"));
                        nombre = String.valueOf(rs.getObject("nombre"));
                        apellido = String.valueOf(rs.getObject("apellido"));
                        correo = String.valueOf(rs.getObject("correo"));
                        apellido = String.valueOf(rs.getObject("apellido"));
                        gui = String.valueOf(rs.getObject("colorGui"));
                    }
                    Permiso aux = new Permiso(rs.getString("idPermiso"), rs.getString("idModulo"), rs.getString("agregar"), rs.getString("borrar"), rs.getString("modificar"), rs.getString("ingresar"));
                    permisos.add(aux);
                }
                
                HttpSession session = request.getSession();
                session.setAttribute("id", id);
                session.setAttribute("tipo", tipo);
                session.setAttribute("nombre", nombre);
                session.setAttribute("apellido", apellido);
                session.setAttribute("correo", correo);
                session.setAttribute("gui", gui);
                session.setAttribute("permisos", permisos);
                session.setAttribute("autenticado", true);
                rs.close();
                json = "autenticado:true";
                
            } catch (Exception e) {
                json = "autenticado:false" + e.getMessage();
            }
            try {
               db.disconnect();
            } catch (Exception e) {
                out.write("Error al cerrar");
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
