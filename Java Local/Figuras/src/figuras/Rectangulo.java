
package figuras;

public class Rectangulo {
    double base=0; 
    double altura=0;
    double perimetro=0;
    double area=0;

    public double calcularPerimetro(double unaBase, double unaAltura){
        base= unaBase;
        altura= unaAltura;
        perimetro= (unaBase*2)+(unaAltura*2);
        return perimetro;
    }
    public double calcularArea(double unaBase, double unaAltura){
    base= unaBase;
    altura= unaAltura;
    area= base*altura;
    return area;
    }
    
}
