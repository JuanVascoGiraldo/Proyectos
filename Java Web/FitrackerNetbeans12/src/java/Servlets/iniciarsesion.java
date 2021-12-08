
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.accionesUsuario;
import java.util.List;
import javax.servlet.http.HttpSession;

public class iniciarsesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String correo, contraseña;
            correo = request.getParameter("correo");
            contraseña = request.getParameter("contraseña");
            List <Integer> respuesta = accionesUsuario.iniciarsesion(correo, contraseña);
            int entro= respuesta.get(0);
            int permiso=respuesta.get(1);
            int id= respuesta.get(2);
            //redireccionar si coincide o no coincide la contraseña
            if(entro == 1){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("id", id);
                sesion.setAttribute("permiso", permiso);
                //si coincide
                //redireccionar segun la vista
                if(permiso == 1){
                    response.sendRedirect("");
                    //redireccionar vista adminitrador
                }
                else{
                    response.sendRedirect("");
                    //redireccionar vista usuario
                }
            }
            else{
                // no coincide
                response.sendRedirect("Isesion.html");
                //volver a inicio de sesion
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
