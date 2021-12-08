
package Servlets;

import Control.AccionesEjercicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AgregarEjercicioRutina extends HttpServlet {
    
    private static final String NUMEROS = "[0-9]*";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession(true);
            int id_eje, repeticiones;
            if(sesion.getAttribute("id") != null && request.getParameter("id_eje") != null 
                    && request.getParameter("repeticiones") != null && sesion.getAttribute("permiso") != null){
                int id_usu = (Integer)sesion.getAttribute("id");
                Pattern pattern = Pattern.compile(NUMEROS);
                Matcher matcher = pattern.matcher(request.getParameter("id_eje"));        
                boolean r = matcher.matches();
                pattern = Pattern.compile(NUMEROS);
                matcher = pattern.matcher(request.getParameter("repeticiones"));        
                boolean r2 = matcher.matches();
                if(r == true && r2 == true && ((Integer)sesion.getAttribute("permiso")) == 0){
                    id_eje = Integer.parseInt(request.getParameter("id_eje"));
                    repeticiones = Integer.parseInt(request.getParameter("repeticiones"));
                    int estatus = AccionesEjercicio.RelacionarEjercioUsuario(id_usu, id_eje, repeticiones);
                    if(estatus >0){
                        response.sendRedirect("rutina.jsp");
                    }else{
                        response.sendRedirect("error.jsp");
                        System.out.println("1");
                    }
                }else{
                        System.out.println(r);
                        System.out.println(r2);
                        System.out.println("");
                        response.sendRedirect("error.jsp");
                        System.out.println("2");
                    }
            }else{
                response.sendRedirect("error.jsp");
                System.out.println("3");
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
