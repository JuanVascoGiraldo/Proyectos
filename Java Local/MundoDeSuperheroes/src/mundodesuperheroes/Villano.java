
package mundodesuperheroes;

public class Villano extends Personaje{
    private String tipo;
    private String historiatragica;

    public Villano(String Nombre, String Sexo, boolean esMutante, String unTipo, boolean unaHistoria) {
        super(Nombre, Sexo, esMutante);
        tipo= unTipo;
        historiatragica= String.valueOf(unaHistoria);
    }
    
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String unTipo){
    tipo= unTipo;
    }
    
    public String getHistoriaTragica(){
    return historiatragica;
    }
    public void setHistoriaTragica(String unahistoria){
    historiatragica= unahistoria;
    }
    public String matar(){
        return "matando";
    }
    public String hacerCosasMalas(){
        return "haciendo algo malo";
    }
}
