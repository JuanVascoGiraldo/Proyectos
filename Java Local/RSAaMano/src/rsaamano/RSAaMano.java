/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsaamano;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.math.BigInteger;

public class RSAaMano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        RSA rs = new RSA();
        rs.generarPrimos();
        rs.generarClaves();
        /*
        String valorcifrar = "123456789";
        String resultado = "";
        for(int i= 0; i<valorcifrar.length(); i++){
            if(i > 0){
                resultado += ",";
            }
            resultado += String.valueOf(rs.cifrar(BigInteger.valueOf(valorcifrar.charAt(i))));
        }
        System.out.println(resultado);
        String[] descifrar = resultado.split(",");
        String valordescifrado = "";
        for(int i=0; i<descifrar.length; i++){
            
            valordescifrado += String.valueOf(rs.descifrar(new BigInteger(descifrar[i])));
        }
        System.out.println(valordescifrado);
        /*String mensaje = "1";
        BigInteger[] cifrado = rs.cifrar(Base64.encode(mensaje.getBytes()));
        String descifrado = rs.descifrar(cifrado);
        String cifra = "";
        for(int i=0; i<cifrado.length; i++){
            cifra += String.valueOf(cifrado[i]);
        }
        String descifra = "";
        for(int i=0; i<descifrado.length; i++){
            descifra += String.valueOf(descifrado[i]);
        }
        System.out.println(cifra);
        System.out.println(Base64.decode(descifrado));*/
    }
    
}
