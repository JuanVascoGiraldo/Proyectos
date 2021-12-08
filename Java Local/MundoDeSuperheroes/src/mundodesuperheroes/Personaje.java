
package mundodesuperheroes;

public class Personaje {
    public String nombre;
    public String sexo;
    public String esMutante;
    public Personaje(String unNombre, String unSexo, boolean unMutante){
    nombre= unNombre;
    sexo= unSexo;
    esMutante= String.valueOf(unMutante);
    }
    
    public void golpear(){
        System.out.println("Golpeando");
    }
    public String getNombre(){
    return nombre;
    }
    public void setNombre(String unNombre){
    nombre= unNombre;
    }
    public String getSexo(){
    return sexo;
    }
    public void setSexo(String unSexo){
    sexo= unSexo;
    }
    public String getesMutante(){
    return esMutante;
    }
    public void setesMutante(String Mutante){
    esMutante = Mutante;
    }
}
