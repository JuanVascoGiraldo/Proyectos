
package Serlvlet;

import Control.Acciones;
import Control.Validar;
import Modelo.MReporte;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Rereporte extends HttpServlet {

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
                    int maq = Integer.valueOf(request.getParameter("maq"));
                    int id = Integer.valueOf(request.getParameter("id"));
                    String solucion = request.getParameter("solucion");
                    if(Validar.ValidarTexto(solucion)){
                        String getfecha= Acciones.getFecha();
                        String[] fecha= getfecha.split(" ");
                        String fecha_so = fecha[0];
                        String hora_so= fecha[1] + fecha[2];
                        MReporte re = new MReporte();
                        re.setFecha_so(fecha_so);
                        re.setHora_so(hora_so);
                        re.setId(id);
                        re.setSolucion(solucion);
                        if(Acciones.DarSolucion(re)){
                            response.sendRedirect("./verReporte.jsp?id="+maq);
                        }else{
                            response.sendRedirect("./verReporte.jsp?id="+maq);
                        }
                    }else{
                        response.sendRedirect("equipos.jsp");
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
