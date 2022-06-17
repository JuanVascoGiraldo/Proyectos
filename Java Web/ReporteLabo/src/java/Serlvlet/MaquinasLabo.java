
package Serlvlet;

import Control.Acciones;
import Modelo.CCatalogo;
import Modelo.MEquipo;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MaquinasLabo extends HttpServlet {

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
                    String grupo = request.getParameter("grupo");
                    int materia = Integer.valueOf(request.getParameter("materia"));
                    List<CCatalogo> LBD = Acciones.MaquinasLabo(1, grupo,materia);
                    List<CCatalogo> LNV = Acciones.MaquinasLabo(2, grupo,materia);
                    List<CCatalogo> LDS = Acciones.MaquinasLabo(3, grupo,materia);
                    List<CCatalogo> Cuatro = Acciones.MaquinasLabo(4, grupo,materia);
                    
                    out.println("<div class=\"materia-c\">");
                        out.println("LBD: Numero de Maquina");
                        out.println("<br>");
                        out.println("<select name=\"LBD\" id=\"LBD\">");
                             out.println("<option value=\"0\">No aplica</option>");
                            for(CCatalogo m:LBD){
                                out.println("<option value=\""+m.getId()+"\">"+m.getMaquina()+"</option>");
                            }
                        out.println("</select>");
                    out.println("</div>");
                    out.println(" <div class=\"materia-c\">");
                        out.println("LNV: Numero de Maquina");
                        out.println("<br>");
                        out.println("<select name=\"LNV\" id=\"LNV\">");
                            out.println("<option value=\"0\">No aplica</option>");
                            for(CCatalogo m:LNV){
                                out.println("<option value=\""+m.getId()+"\">"+m.getMaquina()+"</option>");
                            }
                        out.println("</select>");
                    out.println("</div>");
                    out.println("<div class=\"materia-c\">");
                        out.println("LDS: Numero de Maquina");
                        out.println("<br>");
                        out.println("<select name=\"LDS\" id=\"LDS\">");
                            out.println("<option value=\"0\">No aplica</option>");
                            for(CCatalogo m:LDS){
                                out.println("<option value=\""+m.getId()+"\">"+m.getMaquina()+"</option>");
                            }
                        out.println("</select>");
                    out.println("</div>");
                    out.println("<div class=\"materia-c\">");
                        out.println("4.0: Numero de Maquina");
                        out.println("<br>");
                        out.println("<select name=\"Cuatro\" id=\"Cuatro\">");
                            out.println("<option value=\"0\">No aplica</option>");
                            for(CCatalogo m:Cuatro){
                                out.println("<option value=\""+m.getId()+"\">"+m.getMaquina()+"</option>");
                            }
                        out.println("</select>");
                    out.println("</div>");
                    out.println("<div class=\"materia-c\">");
                        out.println("<button class=\"boton\" onclick=\"AsignarMaquina()\" type=\"button\">Asignar Maquinas</button>");
                    out.println("</div>");
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
