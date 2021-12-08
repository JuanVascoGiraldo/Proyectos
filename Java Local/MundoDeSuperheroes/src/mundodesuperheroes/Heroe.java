
package mundodesuperheroes;

public class Heroe extends Personaje{

    private String tipo;

    public Heroe(String Nombre, String Sexo, boolean esMutante, String unTipo) {
        super(Nombre, Sexo, esMutante);
        tipo= unTipo;
    }

    public String getTipo(){
    return tipo;
    }
    public void setTipo(String unTipo){
    tipo = unTipo;
    }
    public String volar(){   
        return "Volando recio";
    }       
    public String tenerRayosX(){
      return "mirando";
    }
}
