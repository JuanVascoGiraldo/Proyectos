
package administrarmascotas;
 // hecho por vasco giraldo juan esteban
// hecho por vasco giraldo juan esteban


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Principal extends JFrame {
    //variables
    JPanel panel;
    JButton ingresar;
    MouseListener oyentederaton;
    //metodo constructor
    public Principal(){
    this.setSize(400, 520);
    this.setTitle("Bienvenida");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    ImageIcon logo= new ImageIcon("icono.png");
    Image Logo= logo.getImage();
    this.setIconImage(Logo);
    iniciarcomponentes();
    }
    //inicarcomponentes
    private void iniciarcomponentes(){
    Paneles();
    Etiquetas();
    Botones();
    OyentedeRaton();
    }
    //paneles
    private void Paneles(){
    panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(new Color(5, 137, 158));
    this.getContentPane().add(panel);
    }
    //Etiquetas
    private void Etiquetas(){
        
    JLabel Saludo= new JLabel("Bienvenido Administrador", SwingConstants.CENTER);
    Saludo.setBounds(0, 5, 400, 50);
    Saludo.setFont(new Font ("Arial", Font.BOLD, 25));
    Saludo.setForeground(Color.black);
    panel.add(Saludo);
    
    ImageIcon Logo= new ImageIcon("Logo.png");
    JLabel Imagen= new JLabel();
    Imagen.setBounds(60, 60, 270, 350);
    Imagen.setIcon(new ImageIcon(Logo.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_SMOOTH)));
    panel.add(Imagen);
    }
    // Botones
    private void Botones(){
    ImageIcon icono= new ImageIcon("ingresar.png");
    ingresar = new JButton();
    ingresar.setBounds(140, 420, 120, 50);
    ingresar.setIcon(new ImageIcon(icono.getImage().getScaledInstance(ingresar.getWidth(), ingresar.getHeight(), Image.SCALE_SMOOTH)));
    ingresar.setBackground(new Color(5, 137, 158));
    ingresar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    panel.add(ingresar);
    }
    //oyente de raton
    private void OyentedeRaton(){
        oyentederaton = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
                    Pagina1 pag1= new Pagina1();
                    pag1.setVisible(true);
                    dispose();
               
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon icono2= new ImageIcon("ingresar2.png");
                ingresar.setBounds(140, 420, 120, 50);
                ingresar.setIcon(new ImageIcon(icono2.getImage().getScaledInstance(ingresar.getWidth(), ingresar.getHeight(), Image.SCALE_SMOOTH)));
                ingresar.setBackground(new Color(5, 137, 158));
                ingresar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon icono= new ImageIcon("ingresar.png");
                ingresar.setBounds(140, 420, 120, 50);
                ingresar.setIcon(new ImageIcon(icono.getImage().getScaledInstance(ingresar.getWidth(), ingresar.getHeight(), Image.SCALE_SMOOTH)));
                ingresar.setBackground(new Color(5, 137, 158));
                ingresar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            }
        };
        ingresar.addMouseListener(oyentederaton);
    }
}
