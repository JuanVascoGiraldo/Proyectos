
package Servlets;

import Control.AccionesComida;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EliminarComidaDieta extends HttpServlet {
    
    private static final String NUMEROS = "[0-9]*";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession(true);
            int id_die , id_comi;
            if( request.getParameter("id_die") != null && request.getParameter("id_comi") !=null
                   && sesion.getAttribute("id") != null){
                Pattern pattern = Pattern.compile(NUMEROS);
                Matcher matcher = pattern.matcher(request.getParameter("id_die"));        
                boolean r = matcher.matches();
                pattern = Pattern.compile(NUMEROS);
                matcher = pattern.matcher(request.getParameter("id_comi"));        
                boolean r2 = matcher.matches();
                if(r == true && r2 == true && ((Integer)sesion.getAttribute("permiso")) == 1){
                    id_die = Integer.parseInt(request.getParameter("id_die"));
                    id_comi = Integer.parseInt(request.getParameter("id_comi"));
                    int estatus = AccionesComida.ElimininarComidadeDieta(id_die, id_comi);
                    if(estatus > 0){
                        String link = "vermasadmin.jsp?id="+String.valueOf(id_die);
                        response.sendRedirect(link);
                    }else{
                        response.sendRedirect("error.jsp");
                    }
                }else{
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
