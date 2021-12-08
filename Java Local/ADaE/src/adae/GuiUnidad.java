
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
    private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7;
    JTextField caja2, caja4;
    private AAyU obj1= new AAyU();
    JLabel text6;
    private ArrayList<Actividad> array1= new ArrayList<Actividad>();
    private ArrayList<Unidad> array2= new ArrayList<Unidad>();
    private ArrayList<Unidad> array3= new ArrayList<Unidad>();
    JComboBox combo, combo2;
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
    text8.setBounds(10, 140, 460, 60);
    text8.setFont(new Font("MV Boli", Font.BOLD, 24));
    text8.setForeground(Color.black);
    panel5.add(text8);
    
    JLabel text9= new JLabel("Modificar Unidad de Aprendizaje", SwingConstants.CENTER);
    text9.setBounds(5, 10, 470, 60);
    text9.setFont(new Font("MV Boli", Font.BOLD, 27));
    text9.setForeground(Color.black);
    panel6.add(text9);
    
    JLabel text10= new JLabel("Nombre de Unidad de Aprendizaje", SwingConstants.CENTER);
    text10.setBounds(10, 110, 460, 60);
    text10.setFont(new Font("MV Boli", Font.BOLD, 24));
    text10.setForeground(Color.black);
    panel6.add(text10);
    
    JLabel text11= new JLabel("Nuevo de Unidad de Aprendizaje", SwingConstants.CENTER);
    text11.setBounds(10, 200, 460, 60);
    text11.setFont(new Font("MV Boli", Font.BOLD, 24));
    text11.setForeground(Color.black);
    panel6.add(text11);
    
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
    
    boton5= new JButton("Buscar");
    boton5.setBounds(200, 130, 90, 30);
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
    
    boton7= new JButton("Cambiar");
    boton7.setBounds(200, 320, 90, 40);
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
    boton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
    boton7.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    
    caja2= new JTextField();
    caja2.setBounds(100, 230, 290, 30);
    caja2.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel5.add(caja2);
    
    caja4= new JTextField();
    caja4.setBounds(100, 270, 290, 30);
    caja4.setFont(new Font("MV Boli", Font.BOLD, 18));
    panel6.add(caja4);
    
    combo= new JComboBox();
    combo.setBounds(140, 90, 210, 30);
    combo.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel4.add(combo);
    
    combo2= new JComboBox();
    combo2.setBounds(140, 170, 210, 30);
    combo2.setFont(new Font("MV Boli", Font.BOLD, 14));
    panel6.add(combo2);
    
    array2= obj1.getArray2();
    iniciarOyenteRaton();
    MostrarTabla();
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
                       dispose();
                 }
                 if(e.getSource()==boton5){
                     if(boton5.isEnabled()==true){
                        ConsultarUnidad();
                     }
                 }
                 if(e.getSource()==boton6){
                     if(boton6.isEnabled()==true){
                        boton6.setEnabled(false);
                        AgregarUnidad();
                     }
                 }
                 if(e.getSource()==boton7){
                     if(boton7.isEnabled()==true && array2.size()!=0){
                        boton7.setEnabled(false);
                        ModificarUnidad();
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
         boton5.addMouseListener(oyentederaton);
         boton6.addMouseListener(oyentederaton);
         boton7.addMouseListener(oyentederaton);
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
             
            if(caja2.getText().isEmpty()
                      ){
                 boton6.setEnabled(false);
             }
             else{ 
                 boton6.setEnabled(true);
             }
            
            if(caja4.getText().isEmpty()){
                 boton7.setEnabled(false);
             }
             else{ 
                 boton7.setEnabled(true);
             }
         }
     };
        caja2.addKeyListener(oyentedeteclado);
        caja4.addKeyListener(oyentedeteclado);
      }
    
    private void AgregarUnidad(){
        String conf="";
        String nomb= caja2.getText();
        conf= obj1.AgregarUnidad(nomb);
        
        if(conf.equals("Si")){
            JOptionPane.showMessageDialog(null,"La Unidad se ha guardado"
                        , "Registrada",  JOptionPane.INFORMATION_MESSAGE);
            caja2.setText("");
        }
        if(conf.equals("No")){
            JOptionPane.showMessageDialog(null,"El nombre coincide con otra ya registrada"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void ModificarUnidad(){
        String conf="";
        String nomUni= (String)combo2.getSelectedItem();
        String newnom= caja4.getText();
        conf=obj1.ModificarUnidad(nomUni, newnom);
        
        if(conf.equals("Si")){
            JOptionPane.showMessageDialog(null,"La Unidad se ha guardado"
                        , "Registrada",  JOptionPane.INFORMATION_MESSAGE);
            caja4.setText("");
        }
        if(conf.equals("No")){
            JOptionPane.showMessageDialog(null,"Revisa y intentalo de nuevo"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    private void ConsultarUnidad(){
        String nomb=(String)combo.getSelectedItem();
        array1= obj1.ConsultarUnidad(nomb);
        MostrarTabla();
    }
    
    private void MostrarTabla(){
        
        double calificacion=0;
        int porcentaje=0;
        String matriz[][]= new String[array1.size()][4];
    
        for (int k = 0; k < array1.size(); k++) {
            matriz[k][0]=array1.get(k).getNombre();
            matriz[k][1]=array1.get(k).getFecha();
            matriz[k][2]=String.valueOf(array1.get(k).getCalificacion());
            matriz[k][3]=String.valueOf(array1.get(k).getPorcentaje()); 
            
            calificacion= calificacion + array1.get(k).getCalificacion();
            porcentaje= porcentaje+array1.get(k).getPorcentaje();
        }
            
            JScrollPane scroll = new JScrollPane();
            String[] columnNames = {"Nombre", "Fecha", "Calificacion","Porcentaje"};
            final JTable table= new JTable (matriz, columnNames);
            scroll.setViewportView(table);
            scroll.setBounds(20, 200, 450, 200);
            panel4.add(scroll);
            
            text6.setText(String.valueOf(calificacion));
            
            if(calificacion<6.0&& array1.size()!=0){
            JOptionPane.showMessageDialog(null,"La Unidad de aprendizaje esta en peligro de Reprobacion"
                        , "Advertencia",  JOptionPane.ERROR_MESSAGE);
            }
            if(porcentaje>100){
                JOptionPane.showMessageDialog(null,"El valor del porcentaje es mayor al 100% \n "
                                                 + "por lo que el valor de la calificacion \n"
                                                 + "puede no ser acertado"
                        , "Advertencia",  JOptionPane.ERROR_MESSAGE);
            }
    }
    
    private void act(){
            combo.removeAllItems();
            array2= obj1.getArray2();
            for(int i=0; i<array2.size(); i++){
            combo.addItem(array2.get(i).getNombUni());
        }
        if(array2.size()!=0){
            boton5.setEnabled(true);
        }
    }
    
    private void act2(){
            combo2.removeAllItems();
            array2= obj1.getArray2();
            for(int i=0; i<array2.size(); i++){
            combo2.addItem(array2.get(i).getNombUni());
        }  
    }
}
