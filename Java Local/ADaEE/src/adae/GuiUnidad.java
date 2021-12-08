
package adae;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiUnidad extends JFrame{
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JButton boton1, boton2, boton3, boton4, boton6, boton7;
    JTextField caja2, caja5,caja6, caja7, caja8, caja9, caja10, caja11;
    private AAyU obj1= new AAyU();
    JLabel text6;
    private ArrayList<Actividad> array1= new ArrayList<Actividad>();
    private ArrayList<Unidad> array2= new ArrayList<Unidad>();
    private ArrayList<Unidad> array3= new ArrayList<Unidad>();
    JComboBox combo, combo2, combo3, combo4;
    Usuario a=new Usuario();
    public GuiUnidad()
    {
        this.setSize(780, 490);
        this.setTitle("Unidades de Aprendizaje");
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
    
    JLabel text1= new JLabel("Unidades de Aprendizaje", SwingConstants.CENTER);
    text1.setBounds(10, 20, 460, 60);
    text1.setFont(new Font("MV Boli", Font.BOLD, 32));
    text1.setForeground(Color.black);
    panel3.add(text1);
    
    JLabel text2= new JLabel("Consultar Unidad de Aprendizaje", SwingConstants.CENTER);
    text2.setBounds(10, 10, 460, 30);
    text2.setFont(new Font("MV Boli", Font.BOLD, 26));
    text2.setForeground(Color.black);
    panel4.add(text2);
    
    JLabel text3= new JLabel("Nombre de Unidad de Aprendizaje", SwingConstants.CENTER);
    text3.setBounds(10, 40, 460, 60);
    text3.setFont(new Font("MV Boli", Font.BOLD, 24));
    text3.setForeground(Color.black);
    panel4.add(text3);
    
    JLabel text4= new JLabel("Tabla de Actividades", SwingConstants.CENTER);
    text4.setBounds(10, 150, 460, 60);
    text4.setFont(new Font("MV Boli", Font.BOLD, 24));
    text4.setForeground(Color.black);
    panel4.add(text4);
    
    JLabel text5= new JLabel("Promedio Unidad:", SwingConstants.CENTER);
    text5.setBounds(70, 400, 215, 60);
    text5.setFont(new Font("MV Boli", Font.BOLD, 24));
    text5.setForeground(Color.black);
    panel4.add(text5);
    
    text6= new JLabel("", SwingConstants.CENTER);
    text6.setBounds(290, 400, 100, 60);
    text6.setFont(new Font("MV Boli", Font.BOLD, 24));
    text6.setForeground(Color.black);
    panel4.add(text6);
    
    JLabel text7= new JLabel("Agregar Unidad de Aprendizaje", SwingConstants.CENTER);
    text7.setBounds(5, 10, 470, 60);
    text7.setFont(new Font("MV Boli", Font.BOLD, 29));
    text7.setForeground(Color.black);
    panel5.add(text7);
    
    JLabel text8= new JLabel("Nombre de Unidad de Aprendizaje", SwingConstants.CENTER);
    text8.setBounds(10, 80, 460, 60);
    text8.setFont(new Font("MV Boli", Font.BOLD, 24));
    text8.setForeground(Color.black);
    panel5.add(text8);
    
    JLabel text81= new JLabel("Porcentaje Primer Parcial", SwingConstants.CENTER);
    text81.setBounds(60, 200, 270, 30);
    text81.setFont(new Font("MV Boli", Font.BOLD, 18));
    text81.setForeground(Color.black);
    panel5.add(text81);
    
    JLabel text82= new JLabel("Porcentaje Segundo Parcial", SwingConstants.CENTER);
    text82.setBounds(60, 250, 270, 30);
    text82.setFont(new Font("MV Boli", Font.BOLD, 18));
    text82.setForeground(Color.black);
    panel5.add(text82);
    
    JLabel text83= new JLabel("Porcentaje Tercer Parcial", SwingConstants.CENTER);
    text83.setBounds(60, 300, 270, 30);
    text83.setFont(new Font("MV Boli", Font.BOLD, 18));
    text83.setForeground(Color.black);
    panel5.add(text83);
    
    JLabel text9= new JLabel("Modificar Unidad de Aprendizaje", SwingConstants.CENTER);
    text9.setBounds(5, 10, 470, 60);
    text9.setFont(new Font("MV Boli", Font.BOLD, 27));
    text9.setForeground(Color.black);
    panel6.add(text9);
    
    JLabel text10= new JLabel("Nombre de Unidad de Aprendizaje", SwingConstants.CENTER);
    text10.setBounds(10, 70, 460, 60);
    text10.setFont(new Font("MV Boli", Font.BOLD, 24));
    text10.setForeground(Color.black);
    panel6.add(text10);
    
    JLabel text11= new JLabel("Elige el Cambio", SwingConstants.CENTER);
    text11.setBounds(10, 170, 460, 60);
    text11.setFont(new Font("MV Boli", Font.BOLD, 24));
    text11.setForeground(Color.black);
    panel6.add(text11);
    
    JLabel text12= new JLabel("% 1er Parcial", SwingConstants.CENTER);
    text12.setBounds(230, 270, 100, 30);
    text12.setFont(new Font("MV Boli", Font.BOLD, 12));
    text12.setForeground(Color.gray);
    panel6.add(text12);
    
    JLabel text13= new JLabel("% 2do Parcial", SwingConstants.CENTER);
    text13.setBounds(230, 320, 100, 30);
    text13.setFont(new Font("MV Boli", Font.BOLD, 12));
    text13.setForeground(Color.gray);
    panel6.add(text13);
    
    JLabel text14= new JLabel("% 3er Parcial", SwingConstants.CENTER);
    text14.setBounds(230, 370, 100, 30);
    text14.setFont(new Font("MV Boli", Font.BOLD, 12));
    text14.setForeground(Color.gray);
    panel6.add(text14);
    
    
    ImageIcon img2= new ImageIcon("icono2.png");
    JLabel log2= new JLabel();
    log2.setBounds(100, 120, 290, 273);
    log2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(log2.getWidth(), log2.getHeight(), Image.SCALE_SMOOTH)));
    panel3.add(log2);
    
    boton1= new JButton("Consultar Unidad de aprendizaje");
    boton1.setBounds(15, 200, 240, 40);
    boton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton1.setForeground(Color.white);
    boton1.setBackground(new Color(6,76,139));
    boton1.setFont(new Font("Gadugi", Font.BOLD, 14));
    panel1.add(boton1);
    
    boton2= new JButton("Agregar Unidad de aprendizaje");
    boton2.setBounds(15, 260, 240, 40);
    boton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton2.setForeground(Color.white);
    boton2.setBackground(new Color(6,76,139));
    boton2.setFont(new Font("Gadugi", Font.BOLD, 14));
    panel1.add(boton2);
    
    boton3= new JButton("Modificar Unidad de aprendizaje");
    boton3.setBounds(15, 320, 240, 40);
    boton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton3.setBackground(new Color(6,76,139));
    boton3.setFont(new Font("Gadugi", Font.BOLD, 14));
    boton3.setForeground(Color.white );
    panel1.add(boton3);
    
    boton4= new JButton("Inicio");
    boton4.setBounds(85, 380, 100, 40);
    boton4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton4.setForeground(Color.white);
    boton4.setBackground(new Color(6,76,139));
    boton4.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel1.add(boton4);
    
    boton6= new JButton("Agregar");
    boton6.setBounds(200, 350, 90, 40);
    boton6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton6.setForeground(Color.white);
    boton6.setBackground(new Color(6,76,139));
    boton6.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel5.add(boton6);
    boton6.setEnabled(false);
    
    boton7= new JButton("Cambiar");
    boton7.setBounds(200, 410, 90, 40);
    boton7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    boton7.setForeground(Color.white);
    boton7.setBackground(new Color(6,76,139));
    boton7.setFont(new Font("Gadugi", Font.BOLD, 18));
    panel6.add(boton7);
    boton7.setEnabled(false);
    
    boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton7.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    
    caja2= new JTextField();
    caja2.setBounds(100, 150, 290, 30);
    caja2.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel5.add(caja2);
    
    caja5= new JTextField();
    caja5.setBounds(350, 200, 50, 30);
    caja5.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel5.add(caja5);
    
    caja6= new JTextField();
    caja6.setBounds(350, 250, 50, 30);
    caja6.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel5.add(caja6);
    
    caja7= new JTextField();
    caja7.setBounds(350, 300, 50, 30);
    caja7.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel5.add(caja7);
    
    caja8= new JTextField();
    caja8.setBounds(60, 320, 140, 30);
    caja8.setFont(new Font("MV Boli", Font.BOLD, 18));
    caja8.setEditable(false);
    panel6.add(caja8);
    
    caja9= new JTextField();
    caja9.setBounds(350, 270, 50, 30);
    caja9.setFont(new Font("MV Boli", Font.BOLD, 18));
    caja9.setEditable(false);
    panel6.add(caja9);
    
    caja10= new JTextField();
    caja10.setBounds(350, 320, 50, 30);
    caja10.setFont(new Font("MV Boli", Font.BOLD, 18));
    caja10.setEditable(false);
    panel6.add(caja10);
    
    caja11= new JTextField();
    caja11.setBounds(350, 370, 50, 30);
    caja11.setFont(new Font("MV Boli", Font.BOLD, 18));
    caja11.setEditable(false);
    panel6.add(caja11);
    
    combo= new JComboBox();
    combo.setBounds(40, 90, 170, 30);
    combo.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel4.add(combo);
    
    combo2= new JComboBox();
    combo2.setBounds(140, 140, 210, 30);
    combo2.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel6.add(combo2);
    
    combo3= new JComboBox();
    combo3.addItem("Elige el Parametro");
    combo3.addItem("Nombre");
    combo3.addItem("Porcentajes");
    combo3.setBounds(140, 220, 210, 30);
    combo3.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel6.add(combo3);
    
    combo4= new JComboBox();
    combo4.addItem("Escoge Parcial");
    combo4.addItem("Primer Parcial");
    combo4.addItem("Segundo Parcial");
    combo4.addItem("Tercer Parcial");
    combo4.addItem("Todos");
    combo4.setBounds(250, 90, 150, 30);
    combo4.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel4.add(combo4);
    
    array2= obj1.getArray2(getA());
    iniciarOyenteRaton();
    MostrarTabla();
    iniciarOyenteTeclado();
    iniciarOyenteItem();
    obj1.setAh(getA());
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
                    act();
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
                    act2();
                 }
                 if(e.getSource()==boton4){
                       GuiInicio pag1= new GuiInicio();
                       pag1.setVisible(true);
                       pag1.setUs(getA());
                       dispose();
                 }
                 if(e.getSource()==boton6){
                     if(boton6.isEnabled()==true){
                         int j=0;
                         j= Integer.valueOf(caja5.getText())+ Integer.valueOf(caja6.getText())
                                 + Integer.valueOf(caja7.getText());
                         if(j==100){
                        boton6.setEnabled(false);
                        AgregarUnidad();}
                         else{
                         JOptionPane.showMessageDialog(null,"La suma de los porcentajes debe ser 100"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
                         }
                     }
                 }
                 if(e.getSource()==boton7){
                     if(boton7.isEnabled()==true && array2.size()!=0){
                        String parametro= (String)combo3.getSelectedItem();
                        
                        if(parametro.equals("Nombre")){
                            if(!caja8.getText().equals("")){
                                ModificarUnidad();
                            }
                            else{
                               JOptionPane.showMessageDialog(null,"Rellena el Campo"
                            , "Error",  JOptionPane.ERROR_MESSAGE); 
                            }
                        }
                        if(parametro.equals("Porcentajes")){
                            if(!caja9.getText().equals("") && !caja10.getText().equals("") && !caja11.getText().equals("") ){
                                int P= Integer.valueOf(caja9.getText())+Integer.valueOf(caja10.getText())+
                                        Integer.valueOf(caja11.getText());
                                if(P==100){
                                    ModificarUnidad();
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Rellena el Campo"
                                    , "Error",  JOptionPane.ERROR_MESSAGE); 
                                }
                            }
                            else{
                               JOptionPane.showMessageDialog(null,"Rellena Los Campos"
                            , "Error",  JOptionPane.ERROR_MESSAGE); 
                            }
                        }
                     }
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
         boton3.addMouseListener(oyentederaton);
         boton4.addMouseListener(oyentederaton);
         boton6.addMouseListener(oyentederaton);
         boton7.addMouseListener(oyentederaton);
    }
    
      private void iniciarOyenteTeclado(){
    
         KeyListener oyentedeteclado= new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
            if(e.getSource()== caja5){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
            if(e.getSource()== caja6){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
            if(e.getSource()== caja7){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
            if(e.getSource()== caja9){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
            if(e.getSource()== caja10){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
            if(e.getSource()== caja11){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
         }

         @Override
         public void keyPressed(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
             
            if(caja2.getText().isEmpty()||caja5.getText().isEmpty()||
                    caja6.getText().isEmpty()||caja7.getText().isEmpty()
                      ){
                 boton6.setEnabled(false);
             }
             else{ 
                 boton6.setEnabled(true);
             }
            
         }
     };
        caja2.addKeyListener(oyentedeteclado);
        caja5.addKeyListener(oyentedeteclado);
        caja6.addKeyListener(oyentedeteclado);
        caja7.addKeyListener(oyentedeteclado);
        caja9.addKeyListener(oyentedeteclado);
        caja10.addKeyListener(oyentedeteclado);
        caja11.addKeyListener(oyentedeteclado);
      }
    
    private void iniciarOyenteItem(){
    
        ItemListener oyenteitem= new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource()==combo3){
                    Cambios();
                }
                if(e.getSource()==combo4){
                    ConsultarUnidad();
                }  
            }
        };
        combo3.addItemListener(oyenteitem);
        combo4.addItemListener(oyenteitem);
        
    }  
      
    private void AgregarUnidad(){
        obj1.setAh(getA());
        String conf="";
        String nomb= caja2.getText();
        int PPP=Integer.valueOf(caja5.getText());
        int PSP=Integer.valueOf(caja6.getText());
        int PTP=Integer.valueOf(caja7.getText());
        conf= obj1.AgregarUnidad(nomb, PPP, PSP,PTP);
        if(conf.equals("Si")){
            JOptionPane.showMessageDialog(null,"La Unidad se ha guardado"
                        , "Registrada",  JOptionPane.INFORMATION_MESSAGE);
            caja2.setText("");
            caja5.setText("");
            caja6.setText("");
            caja7.setText("");
        }
        if(conf.equals("No")){
            JOptionPane.showMessageDialog(null,"El nombre coincide con otra ya registrada"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void ModificarUnidad(){
        obj1.setAh(getA());
        String conf="";
        String nomUni= (String)combo2.getSelectedItem();
        String Tipo= (String)combo3.getSelectedItem();
        
        if(Tipo.equals("Nombre")){
            String newnom= caja8.getText();
            conf=obj1.ModificarUnidad(nomUni, newnom,0,0,0, Tipo);
        }
        if(Tipo.equals("Porcentajes")){
            int PPP= Integer.valueOf(caja9.getText());
            int PSP= Integer.valueOf(caja10.getText());
            int PTP= Integer.valueOf(caja11.getText());
            conf=obj1.ModificarUnidad(nomUni, "",PPP,PSP,PTP, Tipo);
        }
        
        if(conf.equals("Si")){
            JOptionPane.showMessageDialog(null,"El Cambio se ha guardado"
                        , "Registrada",  JOptionPane.INFORMATION_MESSAGE);
            act2();
            caja8.setText("");
            caja9.setText("");
            caja10.setText("");
            caja11.setText("");
            caja8.setEditable(false);
            caja9.setEditable(false);
            caja10.setEditable(false);
            caja11.setEditable(false);
            
        }
        if(conf.equals("No")){
            JOptionPane.showMessageDialog(null,"Revisa y intentalo de nuevo"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    private void ConsultarUnidad(){
        obj1.setAh(getA());
        String nomb=(String)combo.getSelectedItem();
        array1= obj1.ConsultarUnidad(nomb);
        MostrarTabla();
    }
    
    private void MostrarTabla(){
        ArrayList<Actividad> array4= new ArrayList<Actividad>();
        double calificacion=0, Caf1=0, Caf2=0, Caf3=0;
        int porcentaje=0, p1=0, p2=0, p3=0, jjj=0;
        String nomb=(String)combo.getSelectedItem();
        array2= obj1.getArray2(getA());
        int par=0;
        
        if(((String)combo4.getSelectedItem()).equals("Primer Parcial")){
            par=1;
        }
        if(((String)combo4.getSelectedItem()).equals("Segundo Parcial")){
            par=2;
        }
        if(((String)combo4.getSelectedItem()).equals("Tercer Parcial")){
            par=3;
        }
        if(((String)combo4.getSelectedItem()).equals("Escoge Parcial")){
            porcentaje=100;
            par=0;
        }
        if(((String)combo4.getSelectedItem()).equals("Todos")){
            par=4;
        }
        
        obj1.setAh(getA());
        
        for(int jj=0; jj<array1.size(); jj++){
            if(par==1){
                if(array1.get(jj).getParcial()==1){
                    array4.add(array1.get(jj));
                }
            }
            if(par==2){
                if(array1.get(jj).getParcial()==2){
                    array4.add(array1.get(jj));
                }
            }
            if(par==3){
                if(array1.get(jj).getParcial()==3){
                    array4.add(array1.get(jj));
                }
            }
            if(par==4){
                    array4.add(array1.get(jj));  
            }
        }
        
        
        String matriz[][]= new String[array4.size()][5];
    
        for (int k = 0; k < array4.size(); k++) {
            
            if(par==1){
               
            if(array4.get(k).getParcial()==1){
                matriz[k][0]=array4.get(k).getNombre();
                matriz[k][1]=array4.get(k).getFecha();
                matriz[k][2]=String.valueOf(array4.get(k).getCalificacion());
                matriz[k][3]=String.valueOf(array4.get(k).getPorcentaje());
                matriz[k][4]=String.valueOf(array4.get(k).getParcial());

                calificacion= calificacion + array4.get(k).getCalificacion();
                porcentaje= porcentaje+array4.get(k).getPorcentaje();
            }
            }
            if(par==2){
                
            if(array4.get(k).getParcial()==2){
                matriz[k][0]=array4.get(k).getNombre();
                matriz[k][1]=array4.get(k).getFecha();
                matriz[k][2]=String.valueOf(array4.get(k).getCalificacion());
                matriz[k][3]=String.valueOf(array4.get(k).getPorcentaje());
                matriz[k][4]=String.valueOf(array4.get(k).getParcial());

                calificacion= calificacion + array4.get(k).getCalificacion();
                porcentaje= porcentaje+array4.get(k).getPorcentaje();
            }
            }
            if(par==3){
                
            if(array4.get(k).getParcial()==3){
                matriz[k][0]=array4.get(k).getNombre();
                matriz[k][1]=array4.get(k).getFecha();
                matriz[k][2]=String.valueOf(array4.get(k).getCalificacion());
                matriz[k][3]=String.valueOf(array4.get(k).getPorcentaje());
                matriz[k][4]=String.valueOf(array4.get(k).getParcial());

                calificacion= calificacion + array4.get(k).getCalificacion();
                porcentaje= porcentaje+array4.get(k).getPorcentaje();
            }
            }
            if(par==4){
                
            if(array4.get(k).getParcial()==1){
                matriz[k][0]=array4.get(k).getNombre();
                matriz[k][1]=array4.get(k).getFecha();
                matriz[k][2]=String.valueOf(array4.get(k).getCalificacion());
                matriz[k][3]=String.valueOf(array4.get(k).getPorcentaje());
                matriz[k][4]=String.valueOf(array4.get(k).getParcial());

                Caf1= Caf1 + array4.get(k).getCalificacion();
            }
            
            if(array4.get(k).getParcial()==2){
                matriz[k][0]=array4.get(k).getNombre();
                matriz[k][1]=array4.get(k).getFecha();
                matriz[k][2]=String.valueOf(array4.get(k).getCalificacion());
                matriz[k][3]=String.valueOf(array4.get(k).getPorcentaje());
                matriz[k][4]=String.valueOf(array4.get(k).getParcial());

                Caf2= Caf2 + array4.get(k).getCalificacion();
            }
            
            if(array4.get(k).getParcial()==3){
                matriz[k][0]=array4.get(k).getNombre();
                matriz[k][1]=array4.get(k).getFecha();
                matriz[k][2]=String.valueOf(array4.get(k).getCalificacion());
                matriz[k][3]=String.valueOf(array4.get(k).getPorcentaje());
                matriz[k][4]=String.valueOf(array4.get(k).getParcial());

                Caf3= Caf3 + array4.get(k).getCalificacion();
            }
            for(int pok=0; pok<array2.size(); pok++){
            
                if(nomb.equals(array2.get(pok).getNombUni())){
                    p1=array2.get(pok).getPPP();
                    p2=array2.get(pok).getPSP();
                    p3=array2.get(pok).getPTP();
                }
            }
            
            calificacion= (Caf1*p1/100)+(Caf2*p2/100)+(Caf3*p3/100);
            porcentaje= 100;
            
            }
            
        }
            
            JScrollPane scroll = new JScrollPane();
            String[] columnNames = {"Nombre", "Fecha", "Calificacion","Porcentaje", "Parcial"};
            final JTable table= new JTable (matriz, columnNames);
            scroll.setViewportView(table);
            scroll.setBounds(20, 200, 450, 200);
            panel4.add(scroll);
            
            text6.setText(String.valueOf(calificacion));
            if(par!=0&& jjj!=1){
            if(calificacion<6.0  && array1.size()!=0){
            JOptionPane.showMessageDialog(null,"La Unidad de aprendizaje esta en peligro de Reprobacion"
                        , "Advertencia",  JOptionPane.INFORMATION_MESSAGE);
            jjj=1;
            }
            }
            if(porcentaje>100){
                JOptionPane.showMessageDialog(null,"El valor del porcentaje es mayor al 100% \n "
                                                 + "por lo que el valor de la calificacion \n"
                                                 + "puede no ser acertado"
                        , "Advertencia",  JOptionPane.INFORMATION_MESSAGE);
            }
    }
    
    private void act(){
            obj1.setAh(getA());
            combo.removeAllItems();
            array2= obj1.getArray2(getA());
            for(int i=0; i<array2.size(); i++){
            combo.addItem(array2.get(i).getNombUni());
        }
        if(array2.size()!=0){
            combo4.setEnabled(true);
        }
    }
    
    private void act2(){
            obj1.setAh(getA());
            combo2.removeAllItems();
            array2= obj1.getArray2(getA());
            for(int i=0; i<array2.size(); i++){
            combo2.addItem(array2.get(i).getNombUni());
        }  
    }
    
    public Usuario getA() {
        return a;
    }

    public void setA(Usuario a) {
        this.a = a;
    }
    
    private void Cambios(){
        String parametro= (String) combo3.getSelectedItem();
        
        if(parametro.equals("Elige el Parametro")){
            caja8.setText("");
            caja9.setText("");
            caja10.setText("");
            caja11.setText("");
            
            caja8.setEditable(false);
            caja9.setEditable(false);
            caja10.setEditable(false);
            caja11.setEditable(false);
            
            boton7.setEnabled(false);
        }
        
        if(parametro.equals("Nombre")){
            boton7.setEnabled(true);
            caja9.setText("");
            caja10.setText("");
            caja11.setText("");
            
            caja8.setEditable(true);
            caja9.setEditable(false);
            caja10.setEditable(false);
            caja11.setEditable(false);
        }
        
        if(parametro.equals("Porcentajes")){
            boton7.setEnabled(true);
            caja8.setText("");
            
            caja8.setEditable(false);
            caja9.setEditable(true);
            caja10.setEditable(true);
            caja11.setEditable(true);
        }
        
    
    }
}
