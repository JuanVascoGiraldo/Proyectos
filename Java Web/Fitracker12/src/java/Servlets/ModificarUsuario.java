
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.accionesUsuario;
import Modelo.Usuario;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class ModificarUsuario extends HttpServlet {
    
    private static final String CORREO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String LETRASYNUMEROS = "^[a-z0-9_-]{3,30}$";
    private static final String LETRAS = "[a-zA-z ]*";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String correo, contrasena, usuario;
            correo = request.getParameter("email");
            contrasena = request.getParameter("contra");
            usuario = request.getParameter("nombre");
            HttpSession sesion = request.getSession(true);
            if(correo != null && contrasena!=null && usuario!=null && sesion.getAttribute("id") != null){
                Pattern pattern = Pattern.compile(CORREO);
                Matcher matcher = pattern.matcher(correo);        
                boolean r = matcher.matches();
                pattern = Pattern.compile(LETRASYNUMEROS);
                matcher = pattern.matcher(contrasena);        
                boolean r2 = matcher.matches();
                pattern = Pattern.compile(LETRAS);
                matcher = pattern.matcher(usuario);        
                boolean r3 = matcher.matches();
                if(r == true && r2==true && r3 == true && ((Integer)sesion.getAttribute("permiso")) == 0){
                    int id = (Integer)sesion.getAttribute("id");
                    Usuario u = new Usuario();
                    u.setId(id);
                    u.setEmail(correo);
                    u.setContrasena(contrasena);
                    u.setUsuario(usuario);
                    int estatus = accionesUsuario.actualizarUsuario(u);
                    if(estatus > 0){
                        response.sendRedirect("Cuenta.jsp");
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
