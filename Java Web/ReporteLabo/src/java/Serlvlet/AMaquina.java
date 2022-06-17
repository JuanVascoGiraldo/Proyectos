
package Serlvlet;

import Control.Acciones;
import Modelo.CCatalogo;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AMaquina extends HttpServlet {

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
                    System.out.println("miau");
                    int id = Integer.valueOf(request.getParameter("estudiante"));
                    int materia = Integer.valueOf(request.getParameter("id"));
                    int LBD = Integer.valueOf(request.getParameter("LBD"));
                    int LNV = Integer.valueOf(request.getParameter("LNV"));
                    int LDS = Integer.valueOf(request.getParameter("LDS"));
                    int cuatro = Integer.valueOf(request.getParameter("Cuatro"));
                    boolean seg = true;
                    if(LBD!=0){
                        seg = Acciones.Asignarcomputadora(id, LBD, materia);
                    }
                    if(LNV!=0){
                        seg = Acciones.Asignarcomputadora(id, LNV, materia);
                    }
                    if(LDS!=0){
                        seg = Acciones.Asignarcomputadora(id, LDS, materia);
                    }
                    if(cuatro!=0){
                        seg = Acciones.Asignarcomputadora(id, cuatro, materia);
                    }
                    if(seg){
                        response.sendRedirect("asignarmaquina.jsp?id="+id);
                    }else{
                        response.sendRedirect("asignarmaquina.jsp?id="+id);
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
