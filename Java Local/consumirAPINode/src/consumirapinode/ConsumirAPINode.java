
package consumirapinode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONArray;
import org.json.JSONObject;


public class ConsumirAPINode {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String url = "https://appiconnode.herokuapp.com/api/producto";
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
                Collections.sort(productos,  new Comparator<Producto>() {
                        @Override
                        public int compare(Producto p1, Producto p2) {
                                // Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
                                return new Integer(p2.getCantidad()).compareTo(new Integer(p1.getCantidad()));
                        }
                });
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
                JSONObject productoj = new  JSONObject();
                productoj.put("id_sabor",1);
                productoj.put("id_tamano", 2);
                productoj.put("id_descuento", 1);
                productoj.put("id_presentacion", 1);
                productoj.put("cantidad_unidades", 1);
                productoj.put("precio", 100);
                JSONObject respuestas= new JSONObject(peticionPost(url,productoj));
                System.out.println(respuestas.getString("status"));
                
                JSONObject productojj = new  JSONObject();
                productojj.put("id_sabor", 2);
                productojj.put("id_tamano", 3);
                productojj.put("id_descuento", 3);
                productojj.put("id_presentacion", 1);
                productojj.put("cantidad_unidades", 1);
                productojj.put("precio", 10);
                JSONObject respuestasM= new JSONObject(peticionPost(url+"/modificar/275",productojj));
                System.out.println(respuestasM.getString("status"));
                
    }catch(Exception e){
            System.out.println(e.getMessage());
    }
    }
    
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
    public static String peticionPost(String urll, JSONObject data)throws Exception{
        String charset = "UTF-8"; 
        StringBuilder resultado = new StringBuilder();
        URLConnection connection = new URL(urll).openConnection();
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
