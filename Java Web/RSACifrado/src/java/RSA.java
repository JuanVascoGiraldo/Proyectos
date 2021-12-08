
import java.math.BigInteger;
import java.util.Random;


public class RSA {
    
    public static BigInteger[] calcular(BigInteger p, BigInteger q){
        BigInteger[] numeros = new BigInteger[6];
        BigInteger fi, n, e, d;
        n = p.multiply(q);
        fi = p.subtract(BigInteger.valueOf(1));
        fi = fi.multiply(q.subtract(BigInteger.valueOf(1)));
        do e = new BigInteger(2*3, new Random());
        while((e.compareTo(fi) != -1) || (e.gcd(fi).compareTo(BigInteger.valueOf(1)) != 0));
            
        d = e.modInverse(fi);
        numeros[0] = p;
        numeros[1] = q;
        numeros[2] = fi;
        numeros[3] = n;
        numeros[4] = e;
        numeros[5] = d;
        return numeros;
    }
    
    public static String cifrar(String text, BigInteger e,  BigInteger n){
        String respuesta = "";
        for(int i= 0; i<text.length(); i++){
            if(i > 0){
                respuesta += ":";
            }
            char car = text.charAt(i);
            BigInteger caf = new BigInteger(String.valueOf(car));
            respuesta += String.valueOf(caf.modPow(e, n));
        }
        return respuesta;
    }
    
    public static String descifrar(String text, BigInteger d,  BigInteger n){
        String respuesta = "";
        String[] descifrar = text.split(":");
        for(int i=0; i<descifrar.length; i++){
            BigInteger de = new BigInteger(descifrar[i]);
            respuesta += String.valueOf(de.modPow(d, n));
        }
        return respuesta;
    }
    
}
