
package figuras;
        
import java.util.Scanner;

public class Figuras {
    public static void main(String[] args) {
        Rectangulo mirectangulo= new Rectangulo(); 
        Cuadrado micuadrado= new Cuadrado();
        Scanner entrada= new Scanner(System.in);
            double alturaRectangulo;
            double baseRectangulo;
            double resultadoPerimetroRectangulo;
            double resultadoAreaRectangulo;
            double ladoCuadrado;
            double resultadoPerimetroCuadrado;
            double resultadoAreaCuadrado;
                System.out.println("Intoroduce la base del rectangulo");
                    baseRectangulo = entrada.nextDouble();
                System.out.println("Introduce la altura del rectangulo");
                    alturaRectangulo=entrada.nextDouble();
                resultadoPerimetroRectangulo= mirectangulo.calcularPerimetro(baseRectangulo, alturaRectangulo);
                resultadoAreaRectangulo= mirectangulo.calcularArea(baseRectangulo, alturaRectangulo);
               
                System.out.println("El perimetro del rectangulo es de:\t" + resultadoPerimetroRectangulo);
                System.out.println("El area del rectangulo es:\t" + resultadoAreaRectangulo);
                
                System.out.println("<---------------------------------------------------->");
                System.out.println("Introduce la mededida del lado de los cuadradodos");
                    ladoCuadrado=entrada.nextDouble();
                resultadoPerimetroCuadrado= micuadrado.calcularPerimetro(ladoCuadrado);
                resultadoAreaCuadrado= micuadrado.calcularAreas(ladoCuadrado);
                System.out.println("El perimetro del cuadrado es de:\t" + resultadoPerimetroCuadrado);
                System.out.println("El area del cuadrado es:\t" + resultadoAreaCuadrado);
    }
}
