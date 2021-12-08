
package archivosymatrices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivosYMatrices {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        listaEmpleados.add(new Empleado(9890, "Sergio", "uncorreosergio@ipn.mx"));
        listaEmpleados.add(new Empleado(1212, "Arturo", "uncorreoarturo@ipn.mx"));
        listaEmpleados.add(new Empleado(1213, "Andrea", "uncorreoandrea@ipn.mx"));

        /*GUARDAR LA LISTA EN UN ARCHIVO*/
        ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream("Hola.poke"));
        salida.writeObject (listaEmpleados);
        salida.close();
        
        /*LEER EL ARCHIVO Y CARGAR LA LISTA*/
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Hola.poke"));
        ArrayList<Empleado> listaEmpleados_2 = (ArrayList <Empleado>) entrada.readObject();
        entrada.close();

         //DESPLEGAR LA INFORMACIÓN DEL PRIMER ARRAYLIST
         System.out.println("DESPLEGAR LA INFORMACIÓN DEL PRIMER ARRAYLIST");
        for(Empleado e: listaEmpleados){
             System.out.println(e);
        }
        
         //DESPLEGAR LA INFORMACIÓN RECUPERADA EN EL 2DO ARRAYLIST
         System.out.println("DESPLEGAR LA INFORMACIÓN DEL SEGUNDO ARRAYLIST");
        int longitudLista = listaEmpleados_2.size();
        for(int i=0; i<longitudLista; i++){
             System.out.println(listaEmpleados_2.get(i));
        }
        
    }
}
