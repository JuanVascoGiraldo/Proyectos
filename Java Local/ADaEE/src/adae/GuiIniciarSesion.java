
package adae;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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

public class GuiIniciarSesion extends JFrame{
    
    JPanel panel1, panel2, panel3;
    JTextField Nom;
    JPasswordField contra;
    JButton boton1, boton2, boton3;
    private String InNom, InContra;
    int j=1;
    ArrayList<Usuario> usuarios2= new ArrayList<Usuario>();
    GuardaryLeerArchivoUsuario obj1= new GuardaryLeerArchivoUsuario();
    
    public GuiIniciarSesion(){
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
    log.setIcon(new ImageIcon(img1.getImage().getScaledInstance(log.getWidth(), log.getHeight(), Image.SCALE_SMOOTH)));
    panel1.add(log);
    log.setToolTipText("Agenda De Actividades Estudiantiles");
    
    JLabel texto= new JLabel("Iniciar Sesión",  SwingConstants.CENTER);
    texto.setBounds(15, 200, 245, 50);
    texto.setFont(new Font("Segoe UI Semibold", Font.BOLD, 36));
    texto.setForeground(Color.white);
    panel1.add(texto);
    
    JLabel texto1= new JLabel("Nombre de Usuario:", SwingConstants.LEFT);
    texto1.setBounds(90, 80, 220, 50);
    texto1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
    texto1.setForeground(Color.black);
    panel3.add(texto1);
    
    JLabel texto2= new JLabel("Contraseña:",  SwingConstants.LEFT);
    texto2.setBounds(90, 150, 245, 50);
    texto2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
    texto2.setForeground(Color.black);
    panel3.add(texto2);
    
    
    Nom=new JTextField();
    Nom.setBounds(90, 130, 300, 20);
    panel3.add(Nom);
    
    contra=new JPasswordField();
    contra.setBounds(90, 210, 300, 20);
    panel3.add(contra);
    
    boton1= new JButton("Iniciar Sesión");
    boton1.setBounds(170, 310, 150, 40);
    boton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton1.setBackground(new Color(0, 52, 89));
    boton1.setForeground(Color.white);
    boton1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
    boton1.setEnabled(false);
    panel3.add(boton1);
    
    boton2= new JButton("¿No tienes una cuenta? Regístrate.");
    boton2.setBounds(240, 420, 225, 40);
    boton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton2.setBackground(Color.white);
    boton2.setForeground(new Color(0,126,167));
    boton2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
    panel3.add(boton2);
    
    boton3= new JButton("Mostrar Contraseña");
    boton3.setBounds(260, 232, 130, 20);
    boton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton3.setBackground(Color.white);
    boton3.setForeground(new Color(0,126,167));
    boton3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
    panel3.add(boton3);
    
    boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    iniciarOyenteRaton();
    iniciarOyenteTeclado();
    
    }

    private void setUsuarios2(ArrayList<Usuario> usuarios) {
        usuarios2 = usuarios;
    }
    
    private void iniciarOyenteRaton(){
        
         MouseListener oyentederaton= new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(e.getSource()==boton1){
                     if(j==0){
                         ComprobarDatos();
                         boton1.setEnabled(false);
                         j=1;
                     }
                 }
                 if(e.getSource()==boton2){
                     GuiCrearUsuario pag1= new GuiCrearUsuario();
                     pag1.setVisible(rootPaneCheckingEnabled);
                     dispose();
                 }
                 
                 if(e.getSource()==boton3){
                         contra.setEchoChar('\u2022');
                 }
             }

             @Override
             public void mousePressed(MouseEvent e) {
                 if(e.getSource()==boton3){
                    contra.setEchoChar((char) 0);
                 }
             }

             @Override
             public void mouseReleased(MouseEvent e) {
                 if(e.getSource()==boton3){
                         contra.setEchoChar('\u2022');
                 }
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
         boton3.addMouseListener(oyentederaton);
    }
    
    private void ComprobarDatos(){
        obj1.leer();
        setUsuarios2(obj1.getUsuarios());
        InNom= Nom.getText();
        InContra= new String(contra.getPassword());
        int C= 1;
        for(int i=0; i<usuarios2.size(); i++){
        
            if(InNom.equals(usuarios2.get(i).getNombre()) && InContra.equals(usuarios2.get(i).getContraseña())){
                Nom.setText("");
                contra.setText("");
                C=0;
                GuiInicio pag2= new GuiInicio();
                pag2.setVisible(true);
                pag2.setUs(usuarios2.get(i));
                dispose();
                break;
            }
        }
        if(C==1){
             JOptionPane.showMessageDialog(null,"El Usuario o Contraseña No existe"
                , "Error",  JOptionPane.ERROR_MESSAGE);
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
             
             if(Nom.getText().isEmpty()||new String(contra.getPassword()).isEmpty()){
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
        
    }
    
    
}
