
package adae;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiCrearUsuario extends JFrame{
    //Atributos
    private JPanel panel1, panel2, panel3;
    private JTextField Nom;
    private JPasswordField contra, recontra;
    private JButton boton1, boton2;
    private String InNom, InContra;
    CrearUsuario obj2= new CrearUsuario();
    GuiIniciarSesion obj3= new GuiIniciarSesion();
    int j=1;
    
    public GuiCrearUsuario() {
    this.setSize(780, 490);
    this.setTitle("Crear Cuenta");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(null);
    ImageIcon logo= new ImageIcon("icono.png");
    Image Logo= logo.getImage();
    this.setIconImage(Logo);
    iniciarcomponentes();
    }
    
    private void iniciarcomponentes(){
        //Paneles
    panel1= new JPanel();
    panel1.setLayout(null);
    panel1.setBackground(new Color(0, 52, 89));
    panel1.setBounds(0, 0, 270, 490);
    this.getContentPane().add(panel1);
    
    panel2= new JPanel();
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 169, 231));
    panel2.setBounds(270, 0, 20, 490);
    this.getContentPane().add(panel2);
    
    panel3= new JPanel();
    panel3.setLayout(null);
    panel3.setBackground(Color.white);
    panel3.setBounds(290, 0, 490, 490);
    this.getContentPane().add(panel3);
    // Etiquetas
    ImageIcon img1= new ImageIcon("icono.png");
    JLabel log= new JLabel();
    log.setBounds(65, 20, 150, 150);
    log.setIcon(new ImageIcon(img1.getImage().getScaledInstance(log.getWidth(), 
            log.getHeight(), Image.SCALE_SMOOTH)));
    panel1.add(log);
    
    
    JLabel texto= new JLabel("Registrarse",  SwingConstants.CENTER);
    texto.setBounds(15, 200, 245, 50);
    texto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 36));
    texto.setForeground(Color.white);
    panel1.add(texto);
    
    JLabel texto1= new JLabel("Nombre de Usuario:", SwingConstants.LEFT);
    texto1.setBounds(90, 40, 220, 50);
    texto1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
    texto1.setForeground(Color.black);
    panel3.add(texto1);
    
    JLabel texto2= new JLabel("Contraseña:",  SwingConstants.LEFT);
    texto2.setBounds(90, 110, 245, 50);
    texto2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
    texto2.setForeground(Color.black);
    panel3.add(texto2);
    
    JLabel text3= new JLabel("Confirmar Contraseña:",  SwingConstants.LEFT);
    text3.setBounds(90, 180, 200, 50);
    text3.setForeground(Color.black);
    text3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
    panel3.add(text3);
    //Cajas de Texto
    Nom=new JTextField();
    Nom.setBounds(90, 90, 300, 20);
    panel3.add(Nom);
    
    contra=new JPasswordField();
    contra.setBounds(90, 160, 300, 20);
    panel3.add(contra);
    
    recontra=new JPasswordField();
    recontra.setBounds(90, 230, 300, 20);
    panel3.add(recontra);
    // Botones
    boton1= new JButton("Registrarse");
    boton1.setBounds(170, 290, 150, 40);
    boton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton1.setBackground(new Color(0, 52, 89));
    boton1.setForeground(Color.white);
    boton1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
    boton1.setEnabled(false);
    panel3.add(boton1);
    
    boton2= new JButton("¿Ya tienes una cuenta? Inicia sesión.");
    boton2.setBounds(240, 420, 225, 40);
    boton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton2.setBackground(Color.white);
    boton2.setForeground(new Color(0,126,167));
    boton2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
    panel3.add(boton2);
    
    boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    iniciarOyenteRaton();
    iniciarOyenteTeclado();
    }
    
    private void iniciarOyenteRaton(){
         MouseListener oyentederaton= new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(e.getSource()==boton1){
                     
                     if(j==0){
                         RecibirDatos();
                         boton1.setEnabled(false);
                         j=1;
                     }
                 }
                 if(e.getSource()==boton2){
                     obj3.setVisible(true);
                     dispose();
                 }
                 
             }

             @Override
             public void mousePressed(MouseEvent e) {
                 
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
             }

             @Override
             public void mouseExited(MouseEvent e) {
             }
         };
         boton1.addMouseListener(oyentederaton);
         boton2.addMouseListener(oyentederaton);
    }
    
    private void RecibirDatos(){
        if(new String(contra.getPassword()).equals(new String(recontra.getPassword()))){
            InNom= Nom.getText();
            InContra= contra.getText();
            String confirmation= obj2.crearUsuario(InNom, InContra);
            if(confirmation.equals("Si")){
                Nom.setText("");
                contra.setText("");
                recontra.setText("");
                JOptionPane.showMessageDialog(null,"El Usuario " + InNom +" ha sido Registrado Satisfactoriamente"
                , "Usuario Registrado",  JOptionPane.INFORMATION_MESSAGE);
            }
            if(confirmation.equals("No")){
                JOptionPane.showMessageDialog(null,"El Usuario " + InNom + " ya Existe"
                , "No se puede realizar el Registro",  JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
        JOptionPane.showMessageDialog(null,"Las Contraseñas No Coinciden"
                , "No Coinciden",  JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void iniciarOyenteTeclado(){
    
     KeyListener oyentedeteclado= new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
             
             
             
             if(Nom.getText().isEmpty()||new String(contra.getPassword()).isEmpty() || 
                     new String(recontra.getPassword()).isEmpty()){
                 j=1;
             }
             else{
                 j=0;
                 boton1.setEnabled(true);
             }
             
         }
     };
     
        Nom.addKeyListener(oyentedeteclado);
        contra.addKeyListener(oyentedeteclado);
        recontra.addKeyListener(oyentedeteclado);
    }
}
