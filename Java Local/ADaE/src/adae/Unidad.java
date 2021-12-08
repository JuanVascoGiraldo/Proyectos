
package adae;

import java.io.Serializable;

public class Unidad implements Serializable{
    String NombUni;

    public Unidad(String NombUni) {
        this.NombUni = NombUni;
    }
    
    public String getNombUni() {
        return NombUni;
    }

    public void setNombUni(String NombUni) {
        this.NombUni = NombUni;
    }
    
}
