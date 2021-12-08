
package matrices;

import java.util.Scanner;

public class Matrices {
    
    public static void main(String[] args) {
      Scanner entrada= new Scanner(System.in);
      Scanner entrada1= new Scanner(System.in);
      int j=0;
        System.out.println("cuantos nombre quiere ingresar?");
        j= entrada.nextInt();
      String nombres[]= new String[j];
      for(int i=0; i<j; i++){
          System.out.println("que nombre deseas ingresar");
          nombres[i]=entrada1.next();
          System.out.println(nombres[i]);
      }
    }
    
}
