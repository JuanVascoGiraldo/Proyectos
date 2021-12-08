
package interfaz;

import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class interfaz extends JFrame{
    //variables
    JPanel panel;
    PlaceHolder Holder;
    JButton boton1;
    JButton boton2;
    JRadioButton rboton1;
    JRadioButton rboton2;
    ButtonGroup opciones;
    JTextField CajaBoleta;
    JPasswordField Contraseña;
    ActionListener oyentedeaccion;
    MouseListener oyentederaton;
    public static String texto;
    //int id= 12345;
    //int password= 12345;
    //variables
    public interfaz(){
    this.setSize(400, 550); //tamaño de ventana
    this.setTitle("Iniciar Sesión");
    //this.setLocation(450, 150); localizacion de la ventana
    //this.setBounds(450, 150, 500, 500); localizacion y tamaño de la ventana
    this.setLocationRelativeTo(null); //establecemos la ventana al centro sin importar la pantalla
    //this.getContentPane().setBackground(Color.BLUE);//color a la ventana
    this.setMinimumSize(new Dimension(400, 550));//tamaño mimino
    this.setMaximumSize(new Dimension(400,550));
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImageIcon logo= new ImageIcon("AdAE2.png");
    Image Logo= logo.getImage();
    this.setIconImage(Logo);        
    this.setResizable(false); 
    iniciarComponentes();// llamar metodo
    }
    
    private void iniciarComponentes(){
        ColocarPaneles();
        ColocarEtiquetas();
        ColocarBotones();
        ColocarRadioBotones();
        CajasdeTexto();
        //Oyentedeaccion();
        oyentederaton();
        oyentedeteclado();
        confirmar();
    }
    
    private void ColocarPaneles(){
    panel=new JPanel(); // creacion de un panel
    //panel.setBackground(Color.getHSBColor(188, 95, 44)); //colocar color al panel
    panel.setBackground(new Color (9, 46 , 52));
    panel.setLayout(null);//desactivamos el diseño por defecto del panel
    this.getContentPane().add(panel); //para que el panel se coloque encima de la ventana
    }
    
    private void ColocarEtiquetas(){
        JLabel etiqueta= new JLabel("AdAE", SwingConstants.CENTER);//creamos una eqtiqueta de texto
   //etiqueta.setText("Hola mundo");//establecemos texto de la etiqueta por defecto siempre aparece en el centro
   //etiqueta.setHorizontalAlignment(SwingConstants.CENTER);// centrar
   etiqueta.setBounds(0, 10, 400, 50);//para colocar la etiqueta en otra parte
   etiqueta.setOpaque(false);//es necesario para pintar el dfondo de la etiqueta
   etiqueta.setFont(new Font("Arial", Font.PLAIN, 40));
    //etiqueta.setFont(new Font("Please write me a song", Font.ITALIC, 12))
   etiqueta.setForeground(Color.white);//establecemos el color de la letra
  // etiqueta.setBackground(Color.black);//color de fondo de la etiqueta por defecto no te deja cambiar el fondo
   panel.add(etiqueta); //agregamos la etiqueta al panel
   
   JLabel Boleta= new JLabel("Boleta:",SwingConstants.CENTER);
   Boleta.setBounds(0,320, 100, 50);
   Boleta.setFont(new Font("Arial", Font.ITALIC, 20));
   Boleta.setForeground(Color.white);
   panel.add(Boleta);
   
   JLabel Contraseña= new JLabel("Contraseña:",SwingConstants.CENTER);
   Contraseña.setBounds(0, 360, 140, 50);
   Contraseña.setFont(new Font("Arial", Font.ITALIC, 20));
   Contraseña.setForeground(Color.white);
   panel.add(Contraseña);
   
   JLabel Actividad= new JLabel("Proceso a realizar",SwingConstants.CENTER);
   Actividad.setBounds(0, 400, 400, 50);
   Actividad.setFont(new Font("Arial", Font.ITALIC, 20));
   Actividad.setForeground(Color.white);
   panel.add(Actividad);
   //etiqueta tipo imagen
   ImageIcon Foto= new ImageIcon("Logo.png");
   //ImageIcon Foto= new ImageIcon("gato.png");
   //JLabel imagen= new JLabel(new ImageIcon("Escudo.png"));
   JLabel imagen= new JLabel();
   imagen.setBounds(20, 70, 340, 260); //solo se hace mas pequeña la eqtiqueta pero no la imagen
   //imagen.setBounds(50, 70, 340, 260);
   imagen.setIcon(new ImageIcon(Foto.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
   panel.add(imagen);
   
   
    }
    
    private void ColocarBotones(){
        ImageIcon Salir= new ImageIcon("salir.png");
        boton1= new JButton();
        boton1.setOpaque(false);
        boton1.setBounds(305, 10, 60, 32);
        boton1.setBackground(new Color (9, 46 , 52));
        boton1.setIcon(new ImageIcon(Salir.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.setEnabled(true);//este metodo hace que se pueda hacer la interacción con el usuario
        boton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel.add(boton1);
        ImageIcon Ingresar= new ImageIcon("ingresar.png");
        boton2= new JButton();
        boton2.setBounds(148, 470, 90, 38);
        boton2.setBackground(new Color (9, 46 , 52));
        boton2.setIcon(new ImageIcon(Ingresar.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        boton2.setEnabled(false);
        panel.add(boton2);  
        }
    
    private void ColocarRadioBotones(){
        rboton1= new JRadioButton("Agregar actividad", false);
        rboton1.setBounds(30, 440, 150, 30);
        rboton1.setBackground(new Color (9, 46 , 52));
        rboton1.setForeground(Color.white);
        panel.add(rboton1);
        rboton2= new JRadioButton("Consultar Temas", false);
        rboton2.setBounds(220, 440, 150, 30);
        rboton2.setBackground(new Color (9, 46 , 52));
        rboton2.setForeground(Color.white);
        panel.add(rboton2);
        
        opciones= new ButtonGroup();
        opciones.add(rboton1);
        opciones.add(rboton2);
    }
    
    private void CajasdeTexto(){
    /*JTextField CajaContraseña= new JTextField();
    CajaContraseña.setBounds(140, 375, 180, 20);
    Holder= new PlaceHolder(CajaContraseña , "Introduce Contraseña");
    panel.add(CajaContraseña);*/
    CajaBoleta= new JTextField();
    CajaBoleta.setBounds(140, 335, 180, 20);
    //Holder= new PlaceHolder(CajaBoleta , "Introduce Boleta");
    panel.add(CajaBoleta);
    //caja tipo contraseña
    Contraseña= new JPasswordField();
    Contraseña.setBounds(140, 375, 180, 20);
    //Holder= new PlaceHolder(Contraseña , "Introduce Contraseña");
    panel.add(Contraseña);
    }
  
    private void Oyentedeaccion(){
          oyentedeaccion= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==boton1){
                System.exit(0);}
                if(e.getSource()== boton2){
                   if(CajaBoleta.getText().equals("12345")) {
                       if(Contraseña.getText().equals("12345")){
                       JOptionPane.showMessageDialog(null, "La Boleta o Contraseña es corecta");
                       }
                       else{JOptionPane.showMessageDialog(null, "La Boleta o Contraseña no se ha encontrado"); }   
                   }
                   else {JOptionPane.showMessageDialog(null, "La Boleta o Contraseña no se ha encontrado");}
                }   
            }
        };
        boton1.addActionListener(oyentedeaccion);
        boton2.addActionListener(oyentedeaccion);
    }
    
    public String texto(){
    return texto;
    }
    
    private void oyentederaton(){
    oyentederaton= new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
            if(e.getSource()==boton1){
                System.exit(0);}
                if(e.getSource()== boton2){
                   if(CajaBoleta.getText().equals("12345")) {
                       if(Contraseña.getText().equals("12345")){
                           texto=CajaBoleta.getText();
                       Entrar i2= new Entrar();
                       i2.setVisible(true);
                        dispose();
                       }
                       else{JOptionPane.showMessageDialog(null, "La Boleta o Contraseña no se ha encontrado"); }   
                   }
                   else {JOptionPane.showMessageDialog(null, "La Boleta o Contraseña no se ha encontrado");}
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
            if(e.getSource()==boton1){
                ImageIcon Salir2= new ImageIcon("salir2.png");
                boton1.setBounds(305, 10, 60, 32);
                boton1.setBackground(new Color (9, 46 , 52));
                boton1.setIcon(new ImageIcon(Salir2.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
            }
            if(e.getSource()==boton2){
                ImageIcon Ingresar2= new ImageIcon("ingresar2.png");
                boton2.setBounds(148, 470, 90, 38);
                boton2.setBackground(new Color (9, 46 , 52));
                boton2.setIcon(new ImageIcon(Ingresar2.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
            }
            }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==boton1){
                ImageIcon Salir= new ImageIcon("salir.png");
                boton1.setBounds(305, 10, 60, 32);
                boton1.setBackground(new Color (9, 46 , 52));
                boton1.setIcon(new ImageIcon(Salir.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
            }
            if(e.getSource()==boton2){
                ImageIcon Ingresar= new ImageIcon("ingresar.png");
                boton2.setBounds(148, 470, 90, 38);
                boton2.setBackground(new Color (9, 46 , 52));
                boton2.setIcon(new ImageIcon(Ingresar.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
            }
            }
    };
        boton1.addMouseListener(oyentederaton);
        boton2.addMouseListener(oyentederaton);
    }
    
    private void confirmar(){

    if(CajaBoleta.getText().isEmpty() || Contraseña.getText().isEmpty()){
     boton2.setEnabled(false);
    }
    else{
     boton2.setEnabled(true);
    }
    }
    
    private void oyentedeteclado(){
        KeyListener Oyentedeteclado= new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                confirmar();
                
            }
        };
        
        CajaBoleta.addKeyListener(Oyentedeteclado);
        Contraseña.addKeyListener(Oyentedeteclado);
    }
    
    
}
