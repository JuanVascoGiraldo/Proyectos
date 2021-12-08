
package adae;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GyLAAyU {
    
    
    public void GuardarActividad(ArrayList<Actividad> Act, String NombreArchivo){
    
       try{
            ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream(NombreArchivo));
            salida.writeObject (Act);
            salida.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
    
    public ArrayList<Actividad> LeerActividad(String NombreArchivo){
        
        ArrayList<Actividad> Act= new ArrayList<Actividad>();
        try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NombreArchivo));
            ArrayList<Actividad> guardado = (ArrayList<Actividad>) entrada.readObject();
            Act= guardado;
            entrada.close();  
       }
        catch(Exception e){
           
       }
        return Act;
    }
    
    public void GuardarUnidad(ArrayList<Unidad> Uni, String NombreArchivo2){
        try{
            ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream(NombreArchivo2));
            salida.writeObject (Uni);
            salida.close();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
    
   public ArrayList<Unidad> LeerUnidad(String NombreArchivo2){
        
        ArrayList<Unidad> uni= new ArrayList<Unidad>();
        try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NombreArchivo2));
            ArrayList<Unidad> guardado = (ArrayList<Unidad>) entrada.readObject();
            uni= guardado;
            entrada.close();  
       }
        catch(Exception e){
           
       }
        return uni;
    }
}
