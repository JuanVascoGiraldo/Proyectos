
package Servlets;

import Control.AccionesDieta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AgregarDietaUsuario extends HttpServlet {

    private static final String NUMEROS = "[0-9]*";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter() ) {
            HttpSession sesion = request.getSession(true);
            if(request.getParameter("id_die") != null && request.getParameter("id_die")!= null 
                    && sesion.getAttribute("permiso") != null ){
                int id_usu = (Integer)sesion.getAttribute("id");
                Pattern pattern = Pattern.compile(NUMEROS);
                Matcher matcher = pattern.matcher(request.getParameter("id_die"));        
                boolean r = matcher.matches();
                if(r == true && ((Integer)sesion.getAttribute("permiso")) == 0 ){
                    int id_die = Integer.parseInt(request.getParameter("id_die"));
                    int estatus = AccionesDieta.RelacionaDietaUsuario(id_usu, id_die);
                    if(estatus > 0){
                        response.sendRedirect("DietasGuardadas.jsp");
                    }else{
                        response.sendRedirect("error.jsp");
                    }
                }
                else{
                    response.sendRedirect("error.jsp");
                }
            }else{
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