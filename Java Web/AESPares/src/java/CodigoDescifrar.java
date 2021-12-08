import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
public class CodigoDescifrar {
    private static final String instancia = "AES";
    
    public static String decrypt(String valoresencriptados, String llave) throws Exception {
        //para poder cifrar debemos de generar las llaves
        //pero vamos a crear un metodo para dicha generacion
        Key key = generateKey(llave.getBytes());
        
        //inicializamos el cifrado
        Cipher cifrado = Cipher.getInstance(instancia);
        cifrado.init(Cipher.DECRYPT_MODE, key);
        
        //primero debemos de saber con que formato viene
        byte [] decodificadorvalores = new BASE64Decoder().decodeBuffer(valoresencriptados);

        
        //vamos a obtener el mensaje y transformarlo en bytes
        byte[] decValores = cifrado.doFinal(decodificadorvalores);
        
        //vamos aplicar un formato para que pueda ser leido el mensaje cifrado
        //vamos aplicar el forma de codificacion base 64
        System.out.println("Valores sin formato: " + decValores);
        
        String valoresdescifrados = new String(decValores);
        
        return valoresdescifrados;
    }
    
    private static Key generateKey(byte[] keyvalue) throws Exception {
        //vamos a ocupar las llaves de aes
        //de la clase SecretKeySpec
        
        Key key = new SecretKeySpec(keyvalue, instancia);
        return key;
    }
}
