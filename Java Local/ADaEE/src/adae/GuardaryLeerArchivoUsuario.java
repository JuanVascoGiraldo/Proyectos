
package adae;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GuardaryLeerArchivoUsuario {
       final private String NombreArchivo = "UsuariosPrograma.adae";
       ArrayList<Usuario> usuarios= new ArrayList<Usuario>();

    public GuardaryLeerArchivoUsuario() {
    }
   
   public void Guardar(ArrayList<Usuario> GuardarUsuario){
       
       try{
            ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream(NombreArchivo));
            salida.writeObject (GuardarUsuario);
            salida.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       
   }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
   
   
   public void leer(){
   
       try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NombreArchivo));
            ArrayList<Usuario> guardado = (ArrayList<Usuario>) entrada.readObject();
            setUsuarios(guardado);
            entrada.close();  
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"Se Creara un Archivo Para Guardar Los Datos"
                , "Se creara un Archivo",  JOptionPane.INFORMATION_MESSAGE);
       }
   }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
   
   
    
}
