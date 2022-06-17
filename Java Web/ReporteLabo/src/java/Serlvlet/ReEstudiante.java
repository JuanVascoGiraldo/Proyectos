
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


public class ReEstudiante extends HttpServlet {

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
                    String boleta = request.getParameter("boleta"); 
                    String grupo = request.getParameter("grupo"); 
                    String nombre = request.getParameter("nombre");
                    if(Validar.ValidarBoleta(boleta)&&Validar.ValidarNombre(nombre)){
                        MUsuario estu = new MUsuario();
                        estu.setBoleta(Long.valueOf(boleta));
                        estu.setContra("Estudiante12345");
                        estu.setId_grupo(Integer.valueOf(grupo));
                        estu.setNombre(nombre);
                        if(Acciones.RegistrarEstudiante(estu)){
                            out.println("<script>");
                                out.println("VerEstudiantes();");
                                out.println("crm();");
                            out.println("</script>");
                        }else{
                            out.println("<script>");
                                out.println("Swal.fire({");
                                      out.println("icon: 'error',");
                                     out.println("title: 'Oops...',");
                                     out.println("text: 'Boleta ya Registrada'");
                                out.println(" });");
                            out.println("</script>");
                        }
                    }else{
                        out.println("<script>");
                        out.println("Swal.fire({");
                              out.println("icon: 'error',");
                             out.println("title: 'Oops...',");
                             out.println("text: 'Ingresa Datos Validos'");
                        out.println(" });");
                        out.println("</script>");
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
