
package figuras;

public class Cuadrado {
    double lado;
    double perimetro;
    double area;
    
    public double calcularPerimetro(double unLado){
    lado= unLado;
    perimetro= 4*lado;
    return perimetro;
    }
    public double calcularAreas(double unLado){
    lado= unLado;
    area= lado*lado;
    return area;
    }
}
