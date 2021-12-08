
package Servlets;

import Control.AccionesEjercicio;
import Modelo.Ejercicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmarRutina extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession(true);
            if(sesion.getAttribute("id") != null){
                int id_usu = (Integer)sesion.getAttribute("id");
                List<Ejercicio> lista = new ArrayList<Ejercicio>();
                List<Ejercicio> ejes = AccionesEjercicio.EjerciciosdeUsuario(id_usu);
                boolean seguir = true;
                for(Ejercicio e: ejes){
                    try{
                        Ejercicio ej = new Ejercicio ();
                        ej.setId(e.getId());
                        ej.setRepeticiones(Integer.parseInt(request.getParameter(String.valueOf(e.getId()))));
                        lista.add(ej);
                    }
                    catch(Exception error){
                        seguir = false;
                        break;
                    }
                }
                if(seguir == true && ((Integer)sesion.getAttribute("permiso")) == 0){
                    Calendar fecha = java.util.Calendar.getInstance();
                    String fech=fecha.get(java.util.Calendar.DATE) + "/"
                        + (fecha.get(java.util.Calendar.MONTH)+1) + "/" 
                                + fecha.get(java.util.Calendar.YEAR);
                    int estatus = AccionesEjercicio.confirmarrutina(id_usu, lista, fech);
                    if(estatus >0){
                        response.sendRedirect("rutina.jsp");
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
