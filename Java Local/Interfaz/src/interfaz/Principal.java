
package interfaz;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "La boleta y la contraseña ya estan predefinidas");
        JOptionPane.showMessageDialog(null, "Boleta: 12345 contraseña:12345");
        interfaz i1= new interfaz();
        i1.setVisible(true);
    }
}
