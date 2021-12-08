package Servlets;

import Control.AccionesComida;
import Modelo.Comidas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrarComida extends HttpServlet {
    
    private static final String DESCRIPCION = "[a-zA-z0-9 ]*";
    private static final String LETRAS = "[a-zA-z ]*";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession(true);
            String nombre, descripcion;
            if(request.getParameter("nombre") != null && request.getParameter("descripcion") !=null
                    && sesion.getAttribute("id") != null){
                Pattern pattern = Pattern.compile(LETRAS);
                Matcher matcher = pattern.matcher(request.getParameter("nombre"));        
                boolean r = matcher.matches();
                pattern = Pattern.compile(DESCRIPCION);
                matcher = pattern.matcher(request.getParameter("descripcion"));        
                boolean r2 = matcher.matches();
                if(r == true && r2 == true && ((Integer)sesion.getAttribute("permiso")) == 1){
                    nombre = request.getParameter("nombre");
                    descripcion = request.getParameter("descripcion");
                    Comidas c = new Comidas();
                    c.setNombre(nombre);
                    c.setDescripcion(descripcion);
                    int estatus = AccionesComida.agregarcomida(c);
                    if(estatus > 0){
                        response.sendRedirect("ComidasAdmin.jsp");
                    }else{
                        response.sendRedirect("error.jsp");
                    }
                }
                else{
                        response.sendRedirect("error.jsp");
                    }
            }
            else{
                        response.sendRedirect("error.jsp");
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
