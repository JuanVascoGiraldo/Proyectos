
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;


public class GuiActividad extends JFrame{
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
    private JTextField caja1, caja3, caja4, caja5, caja6, caja7;
    private JComboBox combo, combo2, combo3;
    private MaskFormatter mascara, mascara2;
    private JFormattedTextField Fechas, cambios;
    private AAyU obj1= new AAyU();
    private ArrayList<Unidad> array1= new ArrayList<Unidad>();
    public GuiActividad()
    {
        this.setSize(780, 490);
        this.setTitle("Actividad");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        ImageIcon logo= new ImageIcon("icono.png");
        Image Logo= logo.getImage();
        this.setIconImage(Logo);
        iniciarcomponentes();
        }

    public void setArray1(ArrayList<Unidad> array1) {
        this.array1 = array1;
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
    
    panel4= new JPanel();
    panel4.setLayout(null);
    panel4.setBackground(Color.white);
    panel4.setBounds(290, 0, 490, 490);
    this.getContentPane().add(panel4);
    panel4.setVisible(false);
    
    panel5= new JPanel();
    panel5.setLayout(null);
    panel5.setBackground(Color.white);
    panel5.setBounds(290, 0, 490, 490);
    this.getContentPane().add(panel5);
    panel5.setVisible(false);
    
    panel6= new JPanel();
    panel6.setLayout(null);
    panel6.setBackground(Color.white);
    panel6.setBounds(290, 0, 490, 490);
    this.getContentPane().add(panel6);
    panel6.setVisible(false);
    
    // Etiquetas
    ImageIcon img1= new ImageIcon("icono.png");
    JLabel log= new JLabel();
    log.setBounds(27, 10, 216, 184);
    log.setIcon(new ImageIcon(img1.getImage().getScaledInstance(log.getWidth(), log.getHeight(), Image.SCALE_SMOOTH)));
    panel1.add(log);
    
    JLabel text1= new JLabel("Actividades", SwingConstants.CENTER);
    text1.setBounds(10, 20, 460, 60);
    text1.setFont(new Font("MV Boli", Font.BOLD, 60));
    text1.setForeground(Color.black);
    panel3.add(text1);
    
    JLabel text2= new JLabel("Agregar Actividades", SwingConstants.CENTER);
    text2.setBounds(10, 10, 460, 60);
    text2.setFont(new Font("MV Boli", Font.BOLD, 32));
    text2.setForeground(Color.black);
    panel4.add(text2);
    
    JLabel text3= new JLabel("Nombre de Actividad", SwingConstants.CENTER);
    text3.setBounds(10, 70, 460, 60);
    text3.setFont(new Font("MV Boli", Font.BOLD, 24));
    text3.setForeground(Color.black);
    panel4.add(text3);
    
    JLabel text4= new JLabel("Fecha Ej: 28/12/2020", SwingConstants.CENTER);
    text4.setBounds(10, 150, 460, 60);
    text4.setFont(new Font("MV Boli", Font.BOLD, 24));
    text4.setForeground(Color.black);
    panel4.add(text4);
    
    JLabel text5= new JLabel("Unidad", SwingConstants.CENTER);
    text5.setBounds(10, 230, 460, 60);
    text5.setFont(new Font("MV Boli", Font.BOLD, 24));
    text5.setForeground(Color.black);
    panel4.add(text5);
    
    JLabel text6= new JLabel("Porcentaje (1-100)", SwingConstants.CENTER);
    text6.setBounds(10, 310, 460, 60);
    text6.setFont(new Font("MV Boli", Font.BOLD, 24));
    text6.setForeground(Color.black);
    panel4.add(text6);
    
    JLabel text7= new JLabel("Calificar Actividades", SwingConstants.CENTER);
    text7.setBounds(10, 10, 460, 60);
    text7.setFont(new Font("MV Boli", Font.BOLD, 32));
    text7.setForeground(Color.black);
    panel5.add(text7);
    
    JLabel text8= new JLabel("Nombre de Actividad", SwingConstants.CENTER);
    text8.setBounds(10, 110, 460, 60);
    text8.setFont(new Font("MV Boli", Font.BOLD, 24));
    text8.setForeground(Color.black);
    panel5.add(text8);
    
    JLabel text9= new JLabel("Calificacion 1-100", SwingConstants.CENTER);
    text9.setBounds(10, 200, 460, 60);
    text9.setFont(new Font("MV Boli", Font.BOLD, 24));
    text9.setForeground(Color.black);
    panel5.add(text9);
    
    JLabel text10= new JLabel("Moficicar Actividades", SwingConstants.CENTER);
    text10.setBounds(10, 10, 460, 60);
    text10.setFont(new Font("MV Boli", Font.BOLD, 32));
    text10.setForeground(Color.black);
    panel6.add(text10);
    
    JLabel text11= new JLabel("Nombre Actividad", SwingConstants.CENTER);
    text11.setBounds(10, 80, 460, 60);
    text11.setFont(new Font("MV Boli", Font.BOLD, 24));
    text11.setForeground(Color.black);
    panel6.add(text11);
    
    JLabel text12= new JLabel("Elige un Parametro", SwingConstants.CENTER);
    text12.setBounds(10, 170, 460, 60);
    text12.setFont(new Font("MV Boli", Font.BOLD, 24));
    text12.setForeground(Color.black);
    panel6.add(text12);
    
    JLabel text13= new JLabel("Introduce el cambio", SwingConstants.CENTER);
    text13.setBounds(10, 300, 460, 60);
    text13.setFont(new Font("MV Boli", Font.BOLD, 24));
    text13.setForeground(Color.black);
    panel6.add(text13);
    
    ImageIcon img2= new ImageIcon("icono2.png");
    JLabel log2= new JLabel();
    log2.setBounds(100, 120, 290, 273);
    log2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(log2.getWidth(), log2.getHeight(), Image.SCALE_SMOOTH)));
    panel3.add(log2);
    
    //botones
    
    boton1= new JButton("Agregar Actividad");
    boton1.setBounds(35, 200, 200, 40);
    boton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton1.setForeground(Color.white);
    boton1.setBackground(new Color(6,76,139));
    boton1.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel1.add(boton1);
    
    boton2= new JButton("Agregar Calificacion");
    boton2.setBounds(35, 260, 200, 40);
    boton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton2.setForeground(Color.white);
    boton2.setBackground(new Color(6,76,139));
    boton2.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel1.add(boton2);
    
    boton3= new JButton("Modificar Actividad");
    boton3.setBounds(35, 320, 200, 40);
    boton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton3.setForeground(Color.white);
    boton3.setBackground(new Color(6,76,139));
    boton3.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel1.add(boton3);
    
    boton4= new JButton("Inicio");
    boton4.setBounds(85, 380, 100, 40);
    boton4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton4.setForeground(Color.white);
    boton4.setBackground(new Color(6,76,139));
    boton4.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel1.add(boton4);
    
    boton5= new JButton("Agregar");
    boton5.setBounds(200, 410, 90, 40);
    boton5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton5.setForeground(Color.white);
    boton5.setBackground(new Color(6,76,139));
    boton5.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel4.add(boton5);
    boton5.setEnabled(false);
    
    boton6= new JButton("Agregar");
    boton6.setBounds(200, 300, 90, 40);
    boton6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton6.setForeground(Color.white);
    boton6.setBackground(new Color(6,76,139));
    boton6.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel5.add(boton6);
    boton6.setEnabled(false);
    
    boton7= new JButton("Elegir Parametro");
    boton7.setBounds(150, 270, 190, 30);
    boton7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton7.setForeground(Color.white);
    boton7.setBackground(new Color(6,76,139));
    boton7.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel6.add(boton7);
    
    boton8= new JButton("Guardar");
    boton8.setBounds(200, 390, 90, 40);
    boton8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton8.setForeground(Color.white);
    boton8.setBackground(new Color(6,76,139));
    boton8.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel6.add(boton8);
    boton8.setEnabled(false);
    
    boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton7.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton8.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    //Cajas de Texto
    caja1= new JTextField();
    caja1.setBounds(100, 120, 290, 30);
    caja1.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel4.add(caja1);
    
   
    
    caja3= new JTextField();
    caja3.setBounds(200, 360, 90, 30);
    caja3.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel4.add(caja3);
    
    caja4= new JTextField();
    caja4.setBounds(100, 170, 290, 30);
    caja4.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel5.add(caja4);
    
    caja5= new JTextField();
    caja5.setBounds(200, 260, 90, 30);
    caja5.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel5.add(caja5);
    
    caja6= new JTextField();
    caja6.setBounds(40, 350, 200, 30);
    caja6.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel6.add(caja6);
    caja6.setEditable(false);
    
    caja7= new JTextField();
    caja7.setBounds(150, 140, 190, 30);
    caja7.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel6.add(caja7);
    
    try{
    mascara= new MaskFormatter("##/##/####");
    mascara2= new MaskFormatter("##/##/####");
    
    }
    catch(Exception e){
    
    }
    
    Fechas= new JFormattedTextField(mascara);
    Fechas.setBounds(180, 200, 130, 30);
    Fechas.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel4.add(Fechas);
    
    cambios= new JFormattedTextField(mascara2);
    cambios.setBounds(250, 350, 180, 30);
    cambios.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel6.add(cambios);
    cambios.setEditable(false);
    
    combo = new JComboBox();
    combo.addItem("Nombre");
    combo.addItem("Unidad de Aprendizaje");
    combo.addItem("Fecha");
    combo.addItem("Porcentaje");
    combo.addItem("Eliminar");
    combo.setBounds(140, 230, 210, 30);
    combo.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel6.add(combo);
    
    setArray1(obj1.getArray2());
    
    combo2= new JComboBox();
    for(int i=0; i<array1.size(); i++){
        combo2.addItem(array1.get(i).getNombUni());
    }
    combo2.setBounds(140, 280, 210, 30);
    combo2.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel4.add(combo2);
    
    combo3= new JComboBox();
    for(int i=0; i<array1.size(); i++){
        combo3.addItem(array1.get(i).getNombUni());
    }
    combo3.setBounds(40, 350, 200, 30);
    combo3.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel6.add(combo3);
    combo3.setVisible(false);
    
    iniciarOyenteRaton();
    iniciarOyenteTeclado();
    }
    
    private void iniciarOyenteRaton(){
        
         MouseListener oyentederaton= new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(e.getSource()==boton1){
                    panel3.setVisible(false);
                    panel4.setVisible(true);
                    panel5.setVisible(false);
                    panel6.setVisible(false);
                 }
                 if(e.getSource()==boton2){
                    panel3.setVisible(false);
                    panel4.setVisible(false);
                    panel5.setVisible(true);
                    panel6.setVisible(false);
                 }
                 
                 if(e.getSource()==boton3){
                    panel3.setVisible(false);
                    panel4.setVisible(false);
                    panel5.setVisible(false);
                    panel6.setVisible(true);
                 }
                 if(e.getSource()==boton4){
                       GuiInicio pag1= new GuiInicio();
                       pag1.setVisible(true);
                       dispose();
                 }
                 if(e.getSource()==boton5){
                       if(boton5.isEnabled()==true && array1.size()!=0){
                        if(Fechas.getText().equals("  /  /    ")){
                            Fechas.setText("00/00/0000");
                            }
                        AgregarActividad();
                        boton5.setEnabled(false);
                       }
                 }
                 if(e.getSource()==boton6){
                     if(boton6.isEnabled()==true){
                         CalificarActividad();
                         boton6.setEnabled(false);
                         
                     }
                 
                 }
                 if(e.getSource()==boton7){
                     if(!caja7.getText().equals("")){
                     caja6.setText("");
                     Introducircambio();
                     boton8.setEnabled(true);}
                     else{
                     JOptionPane.showMessageDialog(null,"Ingresa El nombre de la actividad"
                        , "Campo vacio",  JOptionPane.ERROR_MESSAGE);
                     }
                 }
                 if(e.getSource()==boton8){
                     if(boton8.isEnabled()== true){
                     if(!caja7.getText().equals("")){
                         String parametro= (String)combo.getSelectedItem();
                         if(parametro.equals("Nombre")|| parametro.equals("Porcentaje")){
                             
                             if(caja6.getText().equals("")){
                             JOptionPane.showMessageDialog(null,"Rellena los campos"
                                , "Campo vacio",  JOptionPane.ERROR_MESSAGE);
                             }
                             else{
                                 ModificarActividad();
                                 caja6.setEditable(false);
                                 cambios.setEditable(false);
                             }
                         }
                          if(parametro.equals("Fecha")){
                              if(cambios.getText().equals("  /  /    ")){
                                  JOptionPane.showMessageDialog(null,"Rellena los campos"
                                , "Campo vacio",  JOptionPane.ERROR_MESSAGE);
                              }
                              else{
                                   ModificarActividad();
                                   caja6.setEditable(false);
                                   cambios.setEditable(false);
                             }
                           
                          }
                          if(parametro.equals("Eliminar")){
                                ModificarActividad();
                                }
                          if(parametro.equals("Unidad de Aprendizaje")&& array1.size()!=0){
                                ModificarActividad();
                                }
                     }
                     else{
                     JOptionPane.showMessageDialog(null,"Rellena los campos"
                        , "Campo vacio",  JOptionPane.ERROR_MESSAGE);
                     }
                 }}
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
         boton3.addMouseListener(oyentederaton);
         boton4.addMouseListener(oyentederaton);
         boton5.addMouseListener(oyentederaton);
         boton6.addMouseListener(oyentederaton);
         boton7.addMouseListener(oyentederaton);
         boton8.addMouseListener(oyentederaton);
    }
    
     private void iniciarOyenteTeclado(){
    
         KeyListener oyentedeteclado= new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
            if(e.getSource()== caja3){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
            if(e.getSource()== caja5){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
            if(e.getSource()== caja6){
                    String parametro= (String)combo.getSelectedItem();
                    if(parametro.equals("Porcentaje")){
                        char cha=e.getKeyChar();
                        if(cha < '0' || cha > '9')e.consume();
                    
                    }
               }
         }

         @Override
         public void keyPressed(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
             
             if(caja1.getText().isEmpty()|| caja3.getText().isEmpty()
                      ){
                 boton5.setEnabled(false);
             }
             else{
                 
                 boton5.setEnabled(true);
             }
             
             if(caja4.getText().isEmpty()|| caja5.getText().isEmpty()){
                 boton6.setEnabled(false);
             }
             else{
                 
                 boton6.setEnabled(true);
             }
             
         }
     };
        caja1.addKeyListener(oyentedeteclado);
        caja3.addKeyListener(oyentedeteclado);
        caja4.addKeyListener(oyentedeteclado);
        caja5.addKeyListener(oyentedeteclado);
        caja6.addKeyListener(oyentedeteclado);
    }
    
    private void AgregarActividad(){
        String conf="";
        String Nomact= caja1.getText();
        String NomUni= (String)combo2.getSelectedItem();
        String Fecha= Fechas.getText();
        int porcentaje= Integer.valueOf(caja3.getText());
        if(porcentaje<= 100){
        conf= obj1.AgregarAct(Nomact, NomUni, Fecha, porcentaje);
        if(conf.equals("Si")){
            JOptionPane.showMessageDialog(null,"La actividad se ha guardado"
                        , "Registrada",  JOptionPane.INFORMATION_MESSAGE);
            
            caja1.setText("");
            caja3.setText("");
            Fechas.setText("");
        }
        if(conf.equals("No")){
            JOptionPane.showMessageDialog(null,"La Actividad no ha podido ser guardada Revisa los Datos"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }}
        else{
            JOptionPane.showMessageDialog(null,"El valor del porcentaje es mayor al 100%"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void ModificarActividad(){
        String conf= "";
        String nom= caja7.getText();
        String Cambio="";
        String parametro= (String)combo.getSelectedItem();
        if(parametro.equals("Nombre")|| parametro.equals("Porcentaje")){   
        Cambio= caja6.getText();
        }
        if(parametro.equals("Fecha")){
            Cambio=cambios.getText();
        }
        if(parametro.equals("Eliminar")){
            Cambio= "Na";
        }
        if(parametro.equals("Unidad de Aprendizaje")){
            Cambio=(String)combo3.getSelectedItem();
        }
        
        conf= obj1.ModificarAct(nom, parametro, Cambio);
        
        if(conf.equals("Si")){
            JOptionPane.showMessageDialog(null,"El cambio se ha guardado"
                        , "Registrada",  JOptionPane.INFORMATION_MESSAGE);
            
            caja7.setText("");
            caja6.setText("");
            caja6.setVisible(true);
            cambios.setText("");
            combo.setEnabled(true);
            combo3.setVisible(false);
            boton8.setEnabled(false);
        }
        if(conf.equals("No")){
            JOptionPane.showMessageDialog(null,"El Cambio no se ha podido realizar, Revisa los Datos"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    private void CalificarActividad(){
        
        String conf="";
        String Nomact= caja4.getText();
        int cali= Integer.valueOf(caja5.getText());
        if(cali<=100){
        conf= obj1.CalificarAct(Nomact,cali);
        if(conf.equals("Si")){
            JOptionPane.showMessageDialog(null,"La Calificacion se ha guardado"
                        , "Registrada",  JOptionPane.INFORMATION_MESSAGE);
            caja4.setText("");
            caja5.setText("");
        }
        if(conf.equals("No")){
            JOptionPane.showMessageDialog(null,"LNo se encontro La actividad"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
        }
        else{
            JOptionPane.showMessageDialog(null,"El valor de la calificacion es mayor a 100"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void Introducircambio(){
        String parametro= (String)combo.getSelectedItem();
        combo.setEnabled(false);
        
        if(parametro.equals("Nombre")|| parametro.equals("Porcentaje")){
            caja6.setEditable(true);
            cambios.setEditable(false);
            cambios.setText("");
        
        }
        if(parametro.equals("Fecha")){
            
            cambios.setEditable(true);
            caja6.setEditable(false);
            caja6.setText("");
        }
        if(parametro.equals("Eliminar")){
            boton8.setEnabled(true);
        }
        
        if(parametro.equals("Unidad de Aprendizaje")){
            caja6.setVisible(false);
            combo3.setVisible(true);
        }
        
    }
}
