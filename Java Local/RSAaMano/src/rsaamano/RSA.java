
package rsaamano;

import java.math.BigInteger;

import java.util.*;

import java.io.*;

public class RSA {
    int tamprimo = 3; //2, 3, 4 etc
    BigInteger p, q, n;
    BigInteger fi;
    BigInteger e, d;
    
     public void generarPrimos(){
    
        p = new BigInteger(tamprimo, 10, new Random());
        
        do q = new BigInteger(tamprimo, 10, new Random());
         while(q.compareTo(p)==0); 
        
         System.out.println(p);
         System.out.println(q);
    }
     
     public void generarClaves(){
        /*
        Recordar que n = p*q
        fi = (p-1)*(q-1)
        */
        
        n = p.multiply(q);
        
        //(p-1)
        fi = p.subtract(BigInteger.valueOf(1));
        
        fi = fi.multiply(q.subtract(BigInteger.valueOf(1)));
        
        /*
        como calculabamos a e
        
        e debe de ser un coprimo de n de tal que
        1<e<fi(n)
        */
        
        do e = new BigInteger(2*tamprimo, new Random());
        while((e.compareTo(fi) != -1) || (e.gcd(fi).compareTo(BigInteger.valueOf(1)) != 0));
        
        //calcular a d = e ^ 1 mod fi   inverso multiplicativo de e
        
        d = e.modInverse(fi);
        System.out.println(n);
        System.out.println(d);
        System.out.println(e);
        //num.modPow(e, n);
        /*BigInteger[] array= new BigInteger[10];
        String res  = "";
        for(int i=0; i<array.length; i++){
            BigInteger cif = BigInteger.valueOf(i);
            array[i] = cifrar(cif);
            res += String.valueOf(array[i]);
        }
        System.out.println(res);
        BigInteger[] array2 = new BigInteger[10];
        String res2 = "";
        for(int i=0; i<array2.length; i++){
            BigInteger des = array[i];
            array2[i] = descifrar(des);
            res2 += String.valueOf(array2[i]);
        }
         System.out.println(res2);*/
        String valorcifrar = "123456789";
        String resultado = "";
        for(int i= 0; i<valorcifrar.length(); i++){
            if(i > 0){
                resultado += ",";
            }
            char car = valorcifrar.charAt(i);
            BigInteger caf = new BigInteger(String.valueOf(car));
            resultado += String.valueOf(cifrar(caf));
            System.out.println(caf.modPow(e, n));
        }
        System.out.println(resultado);
        String[] descifrar = resultado.split(",");
        String valordescifrado = "";
        for(int i=0; i<descifrar.length; i++){
            
            valordescifrado += String.valueOf(descifrar(new BigInteger(descifrar[i])));
        }
        System.out.println(valordescifrado);
    }
     
    /*public BigInteger[] cifrar(BigInteger num){
        
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = String.valueOf(num).getBytes();
        
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        
        for(i = 0; i < bigdigitos.length; i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }
        
        BigInteger[] cifrado = new BigInteger[bigdigitos.length];
        
        for(i = 0; i < bigdigitos.length; i++){
            //formula
            // c = M ^ e mod n
            cifrado[i] = bigdigitos[i].modPow(e, n);
        }
        return cifrado;
    }
    
     public BigInteger[] descifrar(BigInteger[] cifrado){
        
        BigInteger[] descifrado = new BigInteger[cifrado.length];
        
        //vamos a descifrar con la formula
        // Md = C ^d mod n
        
        for(int j = 0; j < descifrado.length; j++){
            descifrado[j] = cifrado[j].modPow(d, n);
        }
        
        byte [] arraybyte = new byte[descifrado.length];
        for(int i=0; i<arraybyte.length; i++){
            BigInteger temp = descifrado[i];
            arraybyte[i] = new byte (temp);
        }
        return descifrado;
    }*/
     
    public BigInteger cifrar(BigInteger num){
        BigInteger resultado = num.modPow(e, n);
        return resultado;
     }
     
    public BigInteger descifrar(BigInteger num){
        BigInteger resultado = num.modPow(d, n);
        return resultado;
    }
    
    //desciframos con clave privada
    // d n
    
}
