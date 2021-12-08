
package pkg04_aes;

public class Main {

    public static void main(String[] args) {
        try{
        String mensaje = "Habia una vez un patito que decia miau miau y queria jugar halo infinite, y tambien reprobar a los alumnos de batiz wiiiiiii :3";
        String mensajecifrado = Cifrar.encrypt(mensaje);
        String mensajedescifrado = Cifrar.decrypt(mensajecifrado);
        
        System.out.println("El mensaje en texto plano es: "+ mensaje);
        System.out.println("EL mensaje cifrado con AES 128 es: "+ mensajecifrado);
        System.out.println("EL mensaje descifrado con AES 128 es: "+ mensajedescifrado);
        }catch(Exception e){
            System.out.println("Valio");
        }
    }
    
}
