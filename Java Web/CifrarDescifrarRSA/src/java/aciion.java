

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class aciion extends HttpServlet {

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
            String texto = request.getParameter("texto");
            String accio = request.getParameter("accion");
            String res = "";
            HttpSession sesion = request.getSession(true);
            BigInteger n = new BigInteger(String.valueOf(sesion.getAttribute("n")));
            if(accio.equals("cifrar")){
                BigInteger e = new BigInteger(String.valueOf(sesion.getAttribute("e")));
                for(int i= 0; i<texto.length(); i++){
                    if(i > 0){
                        res += ",";
                    }
                    char car = texto.charAt(i);
                    BigInteger caf = new BigInteger(String.valueOf(car));
                    res += String.valueOf(caf.modPow(e, n));
                }
                response.sendRedirect("resultado.jsp?texto="+res);
            }else if(accio.equals("descifrar")){
                BigInteger d = new BigInteger(String.valueOf(sesion.getAttribute("d")));
                String[] descifrar = texto.split(",");
                for(int i=0; i<descifrar.length; i++){
                    BigInteger de = new BigInteger(descifrar[i]);
                    res += String.valueOf(de.modPow(d, n));
                }
                response.sendRedirect("resultado.jsp?texto="+res);
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
