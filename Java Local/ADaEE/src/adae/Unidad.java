
package adae;

import java.io.Serializable;

public class Unidad implements Serializable{
    String NombUni;
    int PPP, PSP, PTP;

    public Unidad(String NombUni,int PPP,int PSP,int PTP) {
        this.NombUni = NombUni;
        this.PPP= PPP;
        this.PSP= PSP;
        this.PTP= PTP;
    }
    
    public String getNombUni() {
        return NombUni;
    }

    public void setNombUni(String NombUni) {
        this.NombUni = NombUni;
    }

    public int getPPP() {
        return PPP;
    }

    public void setPPP(int PPP) {
        this.PPP = PPP;
    }

    public int getPSP() {
        return PSP;
    }

    public void setPSP(int PSP) {
        this.PSP = PSP;
    }

    public int getPTP() {
        return PTP;
    }

    public void setPTP(int PTP) {
        this.PTP = PTP;
    }
    
    
}
