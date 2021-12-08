
package casadeadopcion;

public class Loro extends Mascota{
    protected String Color;
    protected String Vuela;
    protected String Cantar;
    protected String Hablar;
    
    public Loro(String unNombre,  String unGenero, boolean unaDiscapacidad,
             int unaEdad, String unColor, boolean pVuela, boolean pCantar, boolean pHablar){
    super(unNombre, unGenero, unaDiscapacidad, unaEdad);
    Color= unColor;
    Vuela= String.valueOf(pVuela);
    Cantar= String.valueOf(pCantar);
    Hablar= String.valueOf(pHablar);
    }
    public String getColor() {
        return Color;
    }

    public void setColor(String unColor) {
       Color = unColor;
    }

    public String getVuela() {
        return Vuela;
    }

    public void setVuela(String pVuela) {
        Vuela = pVuela;
    }

    public String getCantar() {
        return Cantar;
    }

    public void setCantar(String pCantar) {
     Cantar = pCantar;
    }

    public String getHablar() {
        return Hablar;
    }

    public void setHablar(String pHablar) {
      Hablar = pHablar;
    }
    public String DecirCosasSinContexto(){
    return Nombre + " -el socialismo si funciona";
    }
    public String Repetircosas(){
    return Nombre +" -Hola";
    }
    
}
