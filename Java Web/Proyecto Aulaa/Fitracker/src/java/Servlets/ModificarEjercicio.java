package Servlets;

import Modelo.Ejercicio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Control.AccionesEjercicio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class ModificarEjercicio extends HttpServlet {

    private static final String NUMEROS = "[0-9]*";
    private static final String LETRAS = "[a-zA-z ]*";
    private static final String NUMEROSD = "^[0-9]+([.][0-9]+)?$";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession(true);
            String nombre;
            int clasificacion, id;
            Double calorias;
            if(request.getParameter("nombre")!=null && request.getParameter("clasificacion")!=null 
                    && request.getParameter("id")!= null && request.getParameter("calorias")!= null ){
                Pattern pattern = Pattern.compile(LETRAS);
                Matcher matcher = pattern.matcher(request.getParameter("nombre"));        
                boolean r = matcher.matches();
                pattern = Pattern.compile(NUMEROSD);
                matcher = pattern.matcher(request.getParameter("calorias"));        
                boolean r2 = matcher.matches();
                pattern = Pattern.compile(NUMEROS);
                matcher = pattern.matcher(request.getParameter("id"));        
                boolean r3 = matcher.matches();
                pattern = Pattern.compile(NUMEROS);
                matcher = pattern.matcher(request.getParameter("clasificacion"));        
                boolean r4 = matcher.matches();
                if(r == true && r2 == true && r3 == true && r4 == true && ((Integer)sesion.getAttribute("permiso")) == 1){
                    nombre = request.getParameter("nombre");
                    clasificacion = Integer.parseInt(request.getParameter("clasificacion"));
                    id = Integer.parseInt(request.getParameter("id"));
                    calorias = Double.parseDouble(request.getParameter("calorias"));
                    Ejercicio e = new Ejercicio ();
                    e.setCantidad(calorias);
                    e.setNombre(nombre);
                    e.setClasificacion(clasificacion);
                    e.setId(id);
                    int estatus = AccionesEjercicio.actualizarEjercicio(e);
                    if(estatus > 0){
                        response.sendRedirect("EjerciciosAdmin.jsp");
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
