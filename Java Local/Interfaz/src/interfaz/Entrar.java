
package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Entrar extends JFrame{
    JPanel panel1; 
    String palabras;
    public Entrar(){
    this.setSize(600, 550); //tamaño de ventana
    this.setTitle("Añadir");
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    iniciarcomponentes();
    }
   
    public void iniciarcomponentes(){
    interfaz xd= new interfaz();
    palabras= xd.texto();
    panel1= new JPanel();
    panel1.setLayout(null);//desactivamos el diseño por defecto del panel
    this.getContentPane().add(panel1); //para que el panel se coloque encima de la ventana
    //ImageIcon Gato= new ImageIcon("inicio.gif");
    JLabel imagen= new JLabel();
    imagen.setBounds(0, 0, 200, 300);
    imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/inicio.gif")));
    panel1.add(imagen);
    JLabel text= new JLabel();
    text.setText(palabras);
    text.setBounds(0, 300, 400, 25);
    text.setFont(new Font("Arial", Font.ITALIC, 20));
    text.setForeground(Color.red);
    panel1.add(text);
    }
    
    
    
}
