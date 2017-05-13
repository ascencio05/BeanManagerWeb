/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.solicitudes;

import controladores.clases.Bdd;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/vistas/solicitudes/calls/UploadServlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {

    private static final String path = "uploadFiles";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String app = request.getServletContext().getInitParameter("uploadDir");
            
            String id = String.valueOf(request.getParameter("id"));
            File saveDir = new File(app + "/Requerimientos/" + id);
            
            if(!saveDir.exists())
            {
                saveDir.mkdirs();
            }
            String file = "req_id"+id+"_n";
            
            File temp = File.createTempFile(file, ".pdf",saveDir);
            Bdd db = new Bdd();
            
            try {
                Part filePart =request.getPart("file");
                InputStream stream = filePart.getInputStream();
                Files.copy(stream, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);

                String tempName = temp.getName() ;
                
                out.write("file=" + tempName);
                out.write("&id=" + id);
                out.write("&server=" + request.getServerName() + ":" + request.getServerPort());
                Context init = new InitialContext();
                db = new Bdd(init, "jdbc/AWS");
                db.setCallableQuery("{call Requerimientos_updateFile(?,?)}");
                List<Object> param = new ArrayList<>();
                param.add(id);
                param.add(tempName);
                db.executeCall(param);
            } catch (Exception e) {
                out.write("error:"+e.getMessage());
            }
            try {
                db.disconnect();
            } catch (Exception e) {
                out.write("error:"+e.getMessage());
            }
        }
    }
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
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
