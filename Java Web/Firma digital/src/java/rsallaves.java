import java.io.*;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class rsallaves {
    
    public static void Guardarllaves()throws Exception{
        KeyPairGenerator generadorRSA = KeyPairGenerator.getInstance("RSA");
        generadorRSA.initialize(4096);
        KeyPair llaves = generadorRSA.genKeyPair();
        PublicKey llavePublica = llaves.getPublic();
        PrivateKey llavePrivada = llaves.getPrivate();
        FileOutputStream fos = new FileOutputStream("publicKey.key");
        fos.write(llavePublica.getEncoded());
        fos.close();
        FileOutputStream foss = new FileOutputStream("privateKey.key");
        foss.write(llavePrivada.getEncoded());
        foss.close();
        
    }
    
    public static PublicKey loadPublicKey() throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
       
        FileInputStream fis = new FileInputStream("publicKey.key");
        int numbytes = fis.available();
        byte[] bytes = new byte[numbytes];
        fis.read(bytes);
        fis.close();
        
        KeyFactory fabricallaves = KeyFactory.getInstance("RSA");
        KeySpec keyspec = new X509EncodedKeySpec(bytes);
        PublicKey llavedelarchivo = fabricallaves.generatePublic(keyspec);
        return llavedelarchivo;
    }
    
    public static PrivateKey loadPrivateKey() throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileInputStream fis = new FileInputStream("privateKey.key");
        int numbytes = fis.available();
        byte[] bytes = new byte[numbytes];
        fis.read(bytes);
        fis.close();
        KeyFactory fabricallaves = KeyFactory.getInstance("RSA");
        KeySpec keyspecprivada = new PKCS8EncodedKeySpec(bytes);
        PrivateKey llavedelarchivopriv = fabricallaves.generatePrivate(keyspecprivada);
        return llavedelarchivopriv;
    }
}
