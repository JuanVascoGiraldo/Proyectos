
package Serlvlet;

import Control.Acciones;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class verEstudiante extends HttpServlet {

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
            HttpSession sesion = request.getSession(true);
            if(sesion.getAttribute("usuario")!= null){
                 MUsuario usu = (MUsuario)sesion.getAttribute("usuario");
                if(usu.getRol()==2){
                    List<MUsuario> est = Acciones.ConsultarEstudiantes();
                    if(est.size() > 0){
                        for(MUsuario u:est){
                            out.println("<div class=\"cuen\">");
                                out.println("<img src=\"./img/usuario.png\" class=\"imgusua\">");
                                out.println("<div class=\"textoa\">");
                                    out.println("Nombre de Alumno:"+u.getNombre());
                                    out.println("<br>");
                                    out.println("Boleta Alumno:"+u.getBoleta());
                                    out.println("<br>");
                                    out.println("Grupo:"+u.getGrupo());
                                    out.println("<br>");
                                    out.println("<button type=\"button\" id=\"IniciarSesion\" class=\"boton1\" onclick=\"location.href = 'asignarmaquina.jsp?id="+u.getId()+"'\">Asignar Maquinas</button>");
                                out.println("</div>");
                            out.println("</div>");
                        }
                    }else{
                        out.println("<div class=\"cuen\">");
                            out.println("<img src='./img/usuario.png' class='imgusua'>");
                            out.println("<div class='textoa'>");
                                out.println("No hay Alumnos Registrados");
                            out.println("</div>");
                        out.println("</div>");
                    }
                }else if(usu.getRol()==1){
                    response.sendRedirect("MisEquipos.jsp");
                }
            }else{
                response.sendRedirect("index.jsp");
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
