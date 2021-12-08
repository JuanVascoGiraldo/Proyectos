
package adae;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GuiInicio extends JFrame{

    private JPanel panel1;
    private JButton boton1,boton2,boton3;

    public GuiInicio(){
        this.setSize(780, 490);
        this.setTitle("Inicio de Sesión");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon logo= new ImageIcon("icono.png");
        Image Logo= logo.getImage();
        this.setIconImage(Logo);
        iniciarcomponentes();    }
    
    private void iniciarcomponentes(){
        panel1= new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(0, 52, 89));
        this.getContentPane().add(panel1);
        
        JLabel text1= new JLabel ("Bienvenido");
        text1.setBounds(215, 40, 350, 60);
        text1.setFont(new Font("MV Boli", Font.BOLD, 60));
        text1.setForeground(Color.white);
        panel1.add(text1);
        
        ImageIcon img1= new ImageIcon("temario.png");
        JLabel Temario= new JLabel();
        Temario.setBounds(80, 150, 150, 150);
        Temario.setIcon(new ImageIcon(img1.getImage().getScaledInstance(Temario.getWidth(), Temario.getHeight(), Image.SCALE_SMOOTH)));
        panel1.add(Temario);
        
        ImageIcon img2= new ImageIcon("unidad.png");
        JLabel unidad= new JLabel();
        unidad.setBounds(300, 150, 150, 150);
        unidad.setIcon(new ImageIcon(img2.getImage().getScaledInstance(unidad.getWidth(), unidad.getHeight(), Image.SCALE_SMOOTH)));
        panel1.add(unidad);
        
        ImageIcon img3= new ImageIcon("actividades.png");
        JLabel act= new JLabel();
        act.setBounds(520, 150, 150, 150);
        act.setIcon(new ImageIcon(img3.getImage().getScaledInstance(act.getWidth(), act.getHeight(), Image.SCALE_SMOOTH)));
        panel1.add(act);
        
        boton1= new JButton("Programa Academico");
        boton1.setBounds(80, 350, 150, 40);
        boton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(6,76,139));
        boton1.setFont(new Font("Gadugi", Font.BOLD, 14));
        panel1.add(boton1);
        
        boton2=new JButton("Unidades de Aprendizaje");
        boton2.setBounds(290, 350, 170, 40);
        boton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        boton2.setForeground(Color.white);
        boton2.setBackground(new Color(6,76,139));
        boton2.setFont(new Font("Gadugi", Font.BOLD, 14));
        panel1.add(boton2);
        
        boton3=new JButton("Actividades");
        boton3.setBounds(520, 350, 150, 40);
        boton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        boton3.setForeground(Color.white);
        boton3.setBackground(new Color(6,76,139));
        boton3.setFont(new Font("Gadugi", Font.BOLD, 14));
        panel1.add(boton3);
        
        boton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        iniciarOyenteRaton();
    }
    private void iniciarOyenteRaton(){
        
         MouseListener oyentederaton= new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(e.getSource()==boton1){
                     GuiProgramaAcademico pag3= new GuiProgramaAcademico();
                     pag3.setVisible(true);
                     dispose();
                 }
                 if(e.getSource()==boton2){
                    GuiUnidad pag2= new GuiUnidad();
                    pag2.setVisible(true);
                    dispose();
                 }
                 
                 if(e.getSource()==boton3){
                    GuiActividad pag1=new GuiActividad();
                    pag1.setVisible(true);
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
         boton3.addMouseListener(oyentederaton);
    }
    
}
