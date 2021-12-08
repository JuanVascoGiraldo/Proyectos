

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;


public class api extends HttpServlet {

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
        String url = "http://localhost:4000/api/producto";
        String respuesta = "";
        try {
                respuesta = peticionHttpGet(url);
                //System.out.println("La respuesta es:\n" + respuesta);
                JSONArray arregloJson = new JSONArray(respuesta);
                ArrayList<Producto> productos = new ArrayList<>();
                for (int indice = 0; indice < arregloJson.length(); indice++) {
                    JSONObject posibleProducto = arregloJson.getJSONObject(indice);

                    // Acceder como accedíamos al jsonObjec
                    int id = posibleProducto.getInt("id_producto");
                    int sabor = posibleProducto.getInt("id_sabor");
                    int tamano = posibleProducto.getInt("id_tamano");
                    int descuento = posibleProducto.getInt("id_descuento");
                    int presentación = posibleProducto.getInt("id_presentacion");
                    int cantidad = posibleProducto.getInt("cantidad_unidades");
                    int precio = posibleProducto.getInt("precio");
                    // Luego de eso podemos crear la clase y obtener los beneficios
                    // de la POO o usar los datos como nos plazca
                    Producto producto = new Producto();
                    producto.setId(id);
                    producto.setCantidad(cantidad);
                    producto.setDescuento(descuento);
                    producto.setPrecio(precio);
                    producto.setTamano(tamano);
                    producto.setPresentacion(presentación);
                    producto.setSabor(sabor);
                    // Agregar a la lista, solo para ilustrar
                    productos.add(producto);
                }
                for(int i= 0; i < productos.size(); i++){
                    Producto pro = productos.get(i);
                    System.out.println(pro.getId() + " " 
                            + pro.getId() + " " 
                            + pro.getPrecio() + " " 
                            + pro.getCantidad() + " " 
                            + pro.getDescuento() + " " 
                            + pro.getTamano() + " " 
                            + pro.getPresentacion() + " "
                            + pro.getSabor() + " ");
                }
                Producto producto = new Producto();
                producto.setCantidad(5);
                producto.setDescuento(10);
                producto.setPrecio(100);
                producto.setTamano(3);
                producto.setPresentacion(1);
                producto.setSabor(9);
                JSONObject productoj = new  JSONObject();
                productoj.put("id_sabor", producto.getSabor());
                productoj.put("id_tamano", producto.getTamano());
                productoj.put("id_descuento", producto.getDescuento());
                productoj.put("id_presentacion", producto.getPresentacion());
                productoj.put("cantidad_unidades", producto.getCantidad());
                productoj.put("precio", producto.getPrecio());
                /*DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost post = new HttpPost(url);*/
                String charset = "UTF-8"; 
                URLConnection connection = new URL(url).openConnection();
                connection.setDoOutput(true); // Triggers POST.
                connection.setRequestProperty("Accept-Charset", charset);
                connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);
                try (OutputStream output = connection.getOutputStream()) {
                  output.write(productoj.toString().getBytes(charset));
                }
                InputStream responses = connection.getInputStream();
                System.out.println(responses.toString());
                
                JSONObject productojj = new  JSONObject();
                productojj.put("id_sabor", 1);
                productojj.put("id_tamano", 1);
                productojj.put("id_descuento", 1);
                productojj.put("id_presentacion", 1);
                productojj.put("cantidad_unidades", 1);
                productojj.put("precio", 1);
                URLConnection connectionn = new URL(url+"/modificar/275").openConnection();
                connectionn.setDoOutput(true); // Triggers POST.
                connectionn.setRequestProperty("Accept-Charset", charset);
                connectionn.setRequestProperty("Content-Type", "application/json;charset=" + charset);
                try (OutputStream output = connectionn.getOutputStream()) {
                  output.write(productojj.toString().getBytes(charset));
                }
                InputStream responsess = connectionn.getInputStream();
                response.sendRedirect("index.html");
        }catch(Exception e){
                System.out.println(e.getMessage());
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

    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}
    
    public static String peticionPost(String url, JSONObject data)throws Exception{
        String charset = "UTF-8"; 
        StringBuilder resultado = new StringBuilder();
        URLConnection connection = new URL(url).openConnection();
        connection.setDoOutput(true); // Triggers POST.
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);
        try (OutputStream output = connection.getOutputStream()) {
          output.write(data.toString().getBytes(charset));
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader (connection.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }
}
