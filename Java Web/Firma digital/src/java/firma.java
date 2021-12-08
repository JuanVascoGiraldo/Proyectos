
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;


public class firma {
     public static void firmardocumento(String archi,  PrivateKey priva){
        try {
            byte[] data = archi.getBytes("UTF8");
            Signature firma = Signature.getInstance("MD5WithRSA");
            firma.initSign(priva);
            firma.update(data);
            byte[] firmadocumento = firma.sign();
            FileOutputStream fos = new FileOutputStream("Firma.txt");
            fos.write(firmadocumento);
            fos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean Verificarfirma(String archi, PublicKey publi){
        try{
            byte[] data = archi.getBytes("UTF8");
            FileInputStream fis = new FileInputStream("Firma.txt");
            int numbytes = fis.available();
            byte[] docfirma = new byte[numbytes];
            fis.read(docfirma);
            fis.close();
            Signature firma = Signature.getInstance("MD5WithRSA");
            firma.initVerify(publi);
            firma.update(data);
            return firma.verify(docfirma);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
