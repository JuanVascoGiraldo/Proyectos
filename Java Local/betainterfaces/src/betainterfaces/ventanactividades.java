
package betainterfaces;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import java.awt.Color;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class ventanactividades extends JFrame{
    //Variables globales
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    
    JDateChooser uwu;
    public ventanactividades(){
    
    this.setSize(900, 500);
    this.setTitle("Actividades");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    ImageIcon logo= new ImageIcon("icono.png");
    Image Logo= logo.getImage();
    this.setIconImage(Logo);
    iniciarcomponentes();
    }
    public void iniciarcomponentes(){
    Paneles();
    }
    private void Paneles(){
    panel1= new JPanel();
    panel1.setLayout(null);
    panel1.setBackground(new Color(0, 52, 89));
    panel1.setBounds(0, 0, 200, 500);
    this.getContentPane().add(panel1);
    
    panel2= new JPanel();
    panel2.setLayout(null);
    panel2.setBackground(Color.WHITE);
    panel2.setBounds(230, 0, 670, 500);
    this.getContentPane().add(panel2);
    
    panel3= new JPanel();
    panel3.setLayout(null);
    panel3.setBackground(new Color(0, 169, 231));
    panel3.setBounds(200, 0, 490, 490);
    this.getContentPane().add(panel3);
    
    }
    
    
}
