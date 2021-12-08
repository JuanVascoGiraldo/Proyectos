package abc_arraylist;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ABC_ArrayList {

    public static void main(String[] args) {

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        listaEmpleados.add(new Empleado(9890, "Sergio", "uncorreosergio@ipn.mx"));
        listaEmpleados.add(new Empleado(1212, "Arturo", "uncorreoarturo@ipn.mx"));
        listaEmpleados.add(new Empleado(1213, "Andrea", "uncorreoandrea@ipn.mx"));

        System.out.println("Elementos de la lista");

         /*******************BLOQUE 1****************************************
          * 
          * DESPLEGAMOS LA LISTA DE FORMA RUDIMENTARIA
          * 
          ********************************************************************/
         
        System.out.println("********* BLOQUE 1 ************");
        System.out.println("El primer elemento es:");
        System.out.println(listaEmpleados.get(0));

        System.out.println("El segundo elemento es:");
        System.out.println(listaEmpleados.get(1));

        System.out.println("El el tercer elemento es:");
        System.out.println(listaEmpleados.get(2));

        /**
         * ***********************BLOQUE 2**************************************
         *
         * OBTENEMOS LA CANTIDAD DE ELEMENTOS QUE CONFORMAN LA LISTA Y USAMOS UN
         * FOR PARA DESPLEGAR CADA UNO DE LOS ELEMENTOS
         *
         ********************************************************************/
        System.out.println("*********** BLOQUE 2 ****************");
        int numeroElementos = listaEmpleados.size();
        System.out.println("El número de elementos de la lista son:" + numeroElementos);

        for (int i = 0; i < numeroElementos; i++) {
            System.out.println(listaEmpleados.get(i));
        }

        /**
         * ***********************BLOQUE 3*************************************
         *
         * OBTENEMOS LA CANTIDAD DE ELEMENTOS QUE CONFORMAN LA LISTA Y USAMOS UN
         * FOR PARA BUSCAR UN ELEMENTO EN ESPECIFICO
         *
         ********************************************************************
         */
        System.out.println("*********** BLOQUE 3 ****************");

        System.out.println("El número de elementos de la lista son:" + numeroElementos);
        int idBuscar = 1212;
        System.out.println("El id a buscar es: " + idBuscar);

        for (int i = 0; i < numeroElementos; i++) {
            /*Si el resultado coincide desplegamos la infromación*/
            if (idBuscar == listaEmpleados.get(i).getIdEmpleado()) {
                System.out.println("Se encontro");
                System.out.println(listaEmpleados.get(i));
            }

        }

        /**
         * ***********************BLOQUE 3*************************************
         *
         * OBTENEMOS LA CANTIDAD DE ELEMENTOS QUE CONFORMAN LA LISTA Y USAMOS UN
         * FOR PARA BUSCAR UN ELEMENTO EN ESPECIFICO
         *
         ********************************************************************
         */
        System.out.println("*********** BLOQUE 3 ****************");

        System.out.println("El número de elementos de la lista son:" + numeroElementos);
        int idEliminar = 9890;
        System.out.println("El id a eliminar es: " + idBuscar);

        for (int i = 0; i < numeroElementos; i++) {

            /*Si el resultado coincide Eliminamos el elemento*/
            
            if (idEliminar == listaEmpleados.get(i).getIdEmpleado()) {
                listaEmpleados.remove(i);//se quita el elemento con indice i
                JOptionPane.showMessageDialog(null, "Se ha eliminado el empleado con el id: " + idEliminar + " Exitosamente", "Confirmacion",
                        JOptionPane.OK_OPTION);
                break;
            }

        }

        /**
         * ***********************BLOQUE 2**************************************
         *
         * OBTENEMOS LA CANTIDAD DE ELEMENTOS QUE CONFORMAN LA LISTA Y USAMOS UN
         * FOR PARA DESPLEGAR CADA UNO DE LOS ELEMENTOS
         *
         *********************************************************************
         */
        System.out.println("***** REPETIMOS  BLOQUE 2 ****************");
        System.out.println("El número de elementos de la lista son:" + numeroElementos);

        int numElem = listaEmpleados.size();
        for (int i = 0; i < numElem; i++) {
            System.out.println(listaEmpleados.get(i));
        }

    }

}
