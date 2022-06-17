
package Serlvlet;

import Control.Acciones;
import Control.Validar;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IniciarSesion extends HttpServlet {

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
            if(sesion.getAttribute("usuario")== null){
                String boleta  = request.getParameter("boleta"); 
                String contra  = request.getParameter("contra");
                if(Validar.ValidarBoleta(boleta)&& Validar.ValidarContra(contra)){
                    MUsuario usu = Acciones.IniciarSesion(Long.valueOf(boleta), contra);
                    if(!usu.getNombre().equals("no encontrado")){
                        sesion.setAttribute("usuario", usu);
                        if(usu.getRol() == 2){
                            out.println("<script>");
                                out.println("location.href = 'equipos.jsp'");
                            out.println("</script>");
                        }else{
                            out.println("<script>");
                                out.println("location.href = 'MisEquipos.jsp'");
                            out.println("</script>");
                        }
                    }else{
                        out.println("<script>");
                        out.println("Swal.fire({");
                            out.println("icon: 'error',");
                            out.println("title: 'Oops...',");
                            out.println("text: 'Usuario no encontrado'");
                        out.println(" });");
                        out.println("</script>");
                    }
                }else{
                    out.println("<script>");
                        out.println("Swal.fire({");
                              out.println("icon: 'error',");
                             out.println("title: 'Oops...',");
                             out.println("text: 'Caracteres Invalidos'");
                        out.println(" });");
                    out.println("</script>");
                }
            }else{
                MUsuario usu = (MUsuario)sesion.getAttribute("usuario");
                if(usu.getRol()==2){
                    response.sendRedirect("equipos.jsp");
                }else if(usu.getRol()==1){
                    response.sendRedirect("MisEquipos.jsp");
                }
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
