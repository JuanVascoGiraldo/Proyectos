
package administrarmascotas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pagina1 extends JFrame {
    // hecho por vasco giraldo juan esteban
    // hecho por vasco giraldo juan esteban
    //variables
    private JPanel panel, panel2, panel3;
    private JTextField nombre;
    private JTextField id;
    private JTextField edad;
    private ButtonGroup genero;
    private JRadioButton genero1;
    private JRadioButton genero2;
    private ButtonGroup rescatado;
    private JRadioButton rescatado1;
    private JRadioButton rescatado2;
    private ButtonGroup discapacidad;
    private JRadioButton discapacidad1;
    private JRadioButton discapacidad2;
    private JButton salir= new JButton();
    private JButton guardar= new JButton();
    private JButton siguiente= new JButton();
    public  JButton actualizar= new JButton();
    private JButton anterior= new JButton();
    private JButton eliminar= new JButton();
    private JButton buscar= new JButton();
    private JButton modificar= new JButton();
    public static String Gatonombre = "";
    public static String Gatoedad="";
    public static String Gatogenero= "";
    public static String Gatorescatado= "";
    public static String Gatodiscapacidad= "";
    public static String Gatoid="";
    private int i=0, j=0, a=0 , b=0, h=0;
    int ide=0;
    ArrayList<Gato> lista= new ArrayList<Gato>();  
    ArrayList <Gato> datospermanentes= new ArrayList<Gato>();
    String matriz[][];
    boolean seguir= true, yaregistrado=false, uwu=true, nooo=true, sip=true;
    //metodo Constructor
    public Pagina1(){
        this.setSize(700,500);
        this.setTitle("Agregar Datos");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon logo= new ImageIcon("icono.png");
        Image Logo= logo.getImage();
        this.setIconImage(Logo);
        iniciarcomponentes();
        }
    //iniciar componentes
    private void iniciarcomponentes(){
        Paneles();
        Etiquetas();
        CajasdeTexto();
        RadioBotones();
        Botones();
        Raton();
        Teclado();
        mostrar();
        leer();
        generarid();
    }
    // Paneles
    private void Paneles(){
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(5, 137, 158));
        panel.setBounds(0, 0, 700, 420);
        panel.setVisible(true);
        this.getContentPane().add(panel);
        
        panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(5, 137, 158));
        panel2.setBounds(0, 420, 700, 80);
        panel2.setVisible(true);
        this.getContentPane().add(panel2);
        
        panel3= new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(new Color(5, 137, 158));
        panel3.setBounds(0, 0, 700, 420);
        panel3.setVisible(false);
        this.getContentPane().add(panel3);
        
        
    }
    //Etiquetas
    private void Etiquetas(){
    ImageIcon Gato= new ImageIcon("pagina1.png");
    JLabel imagen= new JLabel();
    imagen.setBounds(20, 10, 200, 400);
    imagen.setIcon(new ImageIcon(Gato.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
    panel.add(imagen);
    
    JLabel inicio= new JLabel("Ingresar Datos",  SwingConstants.CENTER);
    inicio.setBounds(230, 10, 470, 40);
    inicio.setFont(new Font("Arial", Font.BOLD, 30));
    inicio.setForeground(Color.black);
    panel.add(inicio);
    
    JLabel Lnombre= new JLabel("Nombre:",  SwingConstants.CENTER);
    Lnombre.setBounds(230, 60, 120, 40);
    Lnombre.setFont(new Font("Arial", Font.ITALIC , 25));
    Lnombre.setForeground(Color.black);
    panel.add(Lnombre);
    
    JLabel Lid= new JLabel("id:",  SwingConstants.CENTER);
    Lid.setBounds(230, 120, 70, 40);
    Lid.setFont(new Font("Arial", Font.ITALIC , 25));
    Lid.setForeground(Color.black);
    panel.add(Lid);
        
    JLabel Ledad= new JLabel("Edad:",  SwingConstants.CENTER);
    Ledad.setBounds(230, 180, 90, 40);
    Ledad.setFont(new Font("Arial", Font.ITALIC , 25));
    Ledad.setForeground(Color.black);
    panel.add(Ledad);
    
    JLabel genero= new JLabel("Genero:",  SwingConstants.CENTER);
    genero.setBounds(230, 240, 120, 40);
    genero.setFont(new Font("Arial", Font.ITALIC , 25));
    genero.setForeground(Color.black);
    panel.add(genero);
    
    JLabel rescatado= new JLabel("Rescatado:",  SwingConstants.CENTER);
    rescatado.setBounds(230, 300, 150, 40);
    rescatado.setFont(new Font("Arial", Font.ITALIC , 25));
    rescatado.setForeground(Color.black);
    panel.add(rescatado);
    
    JLabel discapacidad= new JLabel("Discapacidad:",  SwingConstants.CENTER);
    discapacidad.setBounds(230, 360, 180, 40);
    discapacidad.setFont(new Font("Arial", Font.ITALIC , 25));
    discapacidad.setForeground(Color.black);
    panel.add(discapacidad);
    
    JLabel Pagina2= new JLabel("Datos registrados",  SwingConstants.CENTER);
    Pagina2.setBounds(0, 5, 700, 40);
    Pagina2.setFont(new Font("Arial", Font.BOLD , 30));
    Pagina2.setForeground(Color.black);
    panel3.add(Pagina2);
    
    ImageIcon imagen2= new ImageIcon("pag2.png");
    JLabel pag2=new JLabel();
    pag2.setBounds(70, 260, 300, 150);
    pag2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(pag2.getWidth(), pag2.getHeight(), Image.SCALE_SMOOTH)));
    panel3.add(pag2);
    
    ImageIcon imagen3= new ImageIcon("gato2.png");
    JLabel pag22= new JLabel();
    pag22.setBounds(430, 260, 150, 150);
    pag22.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(pag22.getWidth(), pag22.getHeight(), Image.SCALE_SMOOTH)));
    panel3.add(pag22);
    
    }
    //Cajas de Texto
    private void CajasdeTexto(){
        nombre= new JTextField();
        nombre.setBounds(350, 70, 300, 20);
        panel.add(nombre);
        
        id= new JTextField();
        id.setBounds(350, 130, 300, 20);
        panel.add(id);
        id.setEditable(false);
        
        edad= new JTextField();
        edad.setBounds(350, 190, 300, 20);
        panel.add(edad);
    }
    //RadioBotones
    private void RadioBotones(){
        genero1= new JRadioButton("Macho", true);
        genero1.setBounds(390, 245, 100, 30);
        genero1.setBackground(new Color(5, 137, 158));
        genero1.setForeground(Color.white);
        genero1.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(genero1);
        
        genero2= new JRadioButton("Hembra", false);
        genero2.setBounds(520, 245, 100, 30);
        genero2.setBackground(new Color(5, 137, 158));
        genero2.setForeground(Color.white);
        genero2.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(genero2);
        
        genero= new ButtonGroup();
        genero.add(genero1);
        genero.add(genero2);
        
        rescatado1=new JRadioButton("Si", true);
        rescatado1.setBounds(420, 305, 100, 30);
        rescatado1.setBackground(new Color(5, 137, 158));
        rescatado1.setForeground(Color.white);
        rescatado1.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(rescatado1);
        
        rescatado2=new JRadioButton("No", false);
        rescatado2.setBounds(550, 305, 100, 30);
        rescatado2.setBackground(new Color(5, 137, 158));
        rescatado2.setForeground(Color.white);
        rescatado2.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(rescatado2);
        
        rescatado= new ButtonGroup();
        rescatado.add(rescatado1);
        rescatado.add(rescatado2);
        
        discapacidad1=new JRadioButton("Si", true);
        discapacidad1.setBounds(420, 365, 100, 30);
        discapacidad1.setBackground(new Color(5, 137, 158));
        discapacidad1.setForeground(Color.white);
        discapacidad1.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(discapacidad1);
        
        discapacidad2=new JRadioButton("No", false);
        discapacidad2.setBounds(550, 365, 100, 30);
        discapacidad2.setBackground(new Color(5, 137, 158));
        discapacidad2.setForeground(Color.white);
        discapacidad2.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(discapacidad2);
        
        discapacidad= new ButtonGroup();
        discapacidad.add(discapacidad1);
        discapacidad.add(discapacidad2);
    }
    //Botones
    private void Botones(){
        ImageIcon Salir= new ImageIcon("salir.png");
        salir.setBounds(50, 0, 90, 40);
        salir.setIcon(new ImageIcon(Salir.getImage().getScaledInstance(salir.getWidth(), salir.getHeight(), Image.SCALE_SMOOTH)));
        salir.setBackground(new Color(5, 137, 158));
        salir.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel2.add(salir);
        
        ImageIcon Guardar= new ImageIcon("guardar.png");
        guardar.setBounds(360, 0, 110, 40);
        guardar.setIcon(new ImageIcon(Guardar.getImage().getScaledInstance(guardar.getWidth(), guardar.getHeight(), Image.SCALE_SMOOTH)));
        guardar.setBackground(new Color(5, 137, 158));
        guardar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        guardar.setEnabled(false);
        panel2.add(guardar);
        
        ImageIcon Siguiente= new ImageIcon("siguiente.png");
        siguiente.setBounds(520, 0, 130, 40);
        siguiente.setIcon(new ImageIcon(Siguiente.getImage().getScaledInstance(siguiente.getWidth(), siguiente.getHeight(), Image.SCALE_SMOOTH)));
        siguiente.setBackground(new Color(5, 137, 158));
        siguiente.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        siguiente.setEnabled(true);
        panel2.add(siguiente);
        
        ImageIcon Actualizar= new ImageIcon("actualizar.png");
        actualizar.setBounds(570, 45, 110, 40);
        actualizar.setIcon(new ImageIcon(Actualizar.getImage().getScaledInstance(actualizar.getWidth(), actualizar.getHeight(), Image.SCALE_SMOOTH)));
        actualizar.setBackground(new Color(5, 137, 158));
        actualizar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel3.add(actualizar);
        
        ImageIcon Anterior= new ImageIcon("anterior.png");
        anterior.setBounds(195, 0, 120, 40);
        anterior.setIcon(new ImageIcon(Anterior.getImage().getScaledInstance(anterior.getWidth(), anterior.getHeight(), Image.SCALE_SMOOTH)));
        anterior.setBackground(new Color(5, 137, 158));
        anterior.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        anterior.setEnabled(false);
        panel2.add(anterior);
        
        ImageIcon borrando= new ImageIcon("eliminar.png"); 
        eliminar.setBounds(570, 105, 110, 40);
        eliminar.setIcon(new ImageIcon(borrando.getImage().getScaledInstance(eliminar.getWidth(), eliminar.getHeight(), Image.SCALE_SMOOTH)));
        eliminar.setBackground(new Color(5, 137, 158));
        eliminar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel3.add(eliminar);
        
        ImageIcon buscando= new ImageIcon("buscar.png");
        buscar.setBounds(570, 165, 110, 40);
        buscar.setIcon(new ImageIcon(buscando.getImage().getScaledInstance(buscar.getWidth(), buscar.getHeight(), Image.SCALE_SMOOTH)));
        buscar.setBackground(new Color(5, 137, 158));
        buscar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel3.add(buscar);
        
        ImageIcon modificando= new ImageIcon("modificar.png");
        modificar.setBounds(570, 225, 110, 40);
        modificar.setIcon(new ImageIcon(modificando.getImage().getScaledInstance(modificar.getWidth(), modificar.getHeight(), Image.SCALE_SMOOTH)));
        modificar.setBackground(new Color(5, 137, 158));
        modificar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel3.add(modificar);
    }
    //Metodos Para Poder obtener Los Datos
    //Metodo if para obtener datos
    private void Arreglo(){
        
        Gatonombre= nombre.getText();
        Gatoedad= edad.getText();
        Gatoid= id.getText();
        if(genero1.isSelected()){
            Gatogenero= "Macho";}
        else{
            Gatogenero= "Hembra";
        }
        
        if(rescatado1.isSelected()){
            Gatorescatado="Si";
        }
        else{
            Gatorescatado="No";
        }
        
        if(discapacidad1.isSelected()){
            Gatodiscapacidad= "Si";
        }
        else{
        Gatodiscapacidad= "No";
        }
    }
    //oyente de teclado
    private void Teclado(){
        KeyListener oyentedeteclado= new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               
               if(e.getSource()== id){
                    char cha=e.getKeyChar();
                    if(cha < '0' || cha > '9')e.consume();
               }
               if(e.getSource()==edad){
                    char cha=e.getKeyChar();
                    if(cha < '1' || cha > '9')e.consume();
               }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(nombre.getText().isEmpty()||edad.getText().isEmpty() /*|| id.getText().isEmpty()*/){/*id.getText().isEmpty()*/
                    guardar.setEnabled(false);
                }
                else{
                        guardar.setEnabled(true);
                        j=1;
                }  
            }
        };
        nombre.addKeyListener(oyentedeteclado);
        edad.addKeyListener(oyentedeteclado);
        id.addKeyListener(oyentedeteclado);
    }
    //oyente de raton
    private void Raton(){
        MouseListener oyentederaton= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()== salir){
                System.exit(0);
                }
                if(e.getSource()==guardar){
                    if(j==1){
                        recibirdatos();
                        yaregistrado=false;
                    }
                    }
                if(e.getSource()==siguiente){
                        h=1;
                        panel3.setVisible(true);
                        panel.setVisible(false);
                        anterior.setEnabled(true);
                        siguiente.setEnabled(false);
                        guardar.setEnabled(false);
                        a=0;
                        b=1;
                    }
                    
                if(e.getSource()==actualizar){
                    mostrar();
                    guardar();
                    }
                if(e.getSource()==anterior){
                        if(b==1){
                        panel3.setVisible(false);
                        panel.setVisible(true);
                        anterior.setEnabled(false);
                        siguiente.setEnabled(true);
                        guardar.setEnabled(false);
                        a=1;
                        b=0;
                        }
                    }
                if(e.getSource()==eliminar){
                        retirarelemento();
                        seguir=true;
                
                }
                if(e.getSource()==buscar){
                    burcardatos();
                    uwu=true;
                }
                if(e.getSource()==modificar){
                    modificardatos();
                    nooo=true;
                }       
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                if(e.getSource()==salir){
                    ImageIcon Salir= new ImageIcon("salir2.png");
                    salir.setBounds(50, 0, 90, 40);
                    salir.setIcon(new ImageIcon(Salir.getImage().getScaledInstance(salir.getWidth(), salir.getHeight(), Image.SCALE_SMOOTH)));   
                }
                if(e.getSource()==guardar){
                    if(j==1){
                        ImageIcon Guardar= new ImageIcon("guardar2.png");
                        guardar.setBounds(360, 0, 110, 40);
                        guardar.setIcon(new ImageIcon(Guardar.getImage().getScaledInstance(guardar.getWidth(), guardar.getHeight(), Image.SCALE_SMOOTH)));
                    }
                    }
                if(e.getSource()==siguiente){
                        ImageIcon Siguiente= new ImageIcon("siguiente2.png");
                        siguiente.setBounds(520, 0, 130, 40);
                        siguiente.setIcon(new ImageIcon(Siguiente.getImage().getScaledInstance(siguiente.getWidth(), siguiente.getHeight(), Image.SCALE_SMOOTH))); 
                    }
                if(e.getSource()==actualizar){
                        ImageIcon Actualizar= new ImageIcon("actualizar2.png");
                        actualizar.setBounds(570, 45, 110, 40);
                        actualizar.setIcon(new ImageIcon(Actualizar.getImage().getScaledInstance(actualizar.getWidth(), actualizar.getHeight(), Image.SCALE_SMOOTH)));
                    }
                if(e.getSource()==anterior){
                    if(b==1){
                        ImageIcon Anterior= new ImageIcon("anterior2.png");
                        anterior.setBounds(195, 0, 120, 40);
                        anterior.setIcon(new ImageIcon(Anterior.getImage().getScaledInstance(anterior.getWidth(), anterior.getHeight(), Image.SCALE_SMOOTH)));
                        }
                    }
                if(e.getSource()==eliminar){
                        ImageIcon borrando= new ImageIcon("eliminar2.png");
                        eliminar.setBounds(570, 105, 110, 40);
                        eliminar.setIcon(new ImageIcon(borrando.getImage().getScaledInstance(eliminar.getWidth(), eliminar.getHeight(), Image.SCALE_SMOOTH)));
                }
                if(e.getSource()==buscar){
                    ImageIcon buscando= new ImageIcon("buscar2.png");
                    buscar.setBounds(570, 165, 110, 40);
                    buscar.setIcon(new ImageIcon(buscando.getImage().getScaledInstance(buscar.getWidth(), buscar.getHeight(), Image.SCALE_SMOOTH)));
                }
                if(e.getSource()==modificar){
                    ImageIcon modificando= new ImageIcon("modificar2.png");
                    modificar.setBounds(570, 225, 110, 40);
                    modificar.setIcon(new ImageIcon(modificando.getImage().getScaledInstance(modificar.getWidth(), modificar.getHeight(), Image.SCALE_SMOOTH)));
                }  
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 if(e.getSource()==salir){
                        ImageIcon Salir= new ImageIcon("salir.png");
                        salir.setBounds(50, 0, 90, 40);
                        salir.setIcon(new ImageIcon(Salir.getImage().getScaledInstance(salir.getWidth(), salir.getHeight(), Image.SCALE_SMOOTH)));
                    }
                if(e.getSource()==guardar){
                        ImageIcon Guardar= new ImageIcon("guardar.png");
                        guardar.setBounds(360, 0, 110, 40);
                        guardar.setIcon(new ImageIcon(Guardar.getImage().getScaledInstance(guardar.getWidth(), guardar.getHeight(), Image.SCALE_SMOOTH)));
                    }
                if(e.getSource()==siguiente){
                    
                        ImageIcon Siguiente= new ImageIcon("siguiente.png");
                        siguiente.setBounds(520, 0, 130, 40);
                        siguiente.setIcon(new ImageIcon(Siguiente.getImage().getScaledInstance(siguiente.getWidth(), siguiente.getHeight(), Image.SCALE_SMOOTH)));
                    }
                if(e.getSource()==actualizar){
                        ImageIcon Actualizar= new ImageIcon("actualizar.png");
                        actualizar.setBounds(570, 45, 110, 40);
                        actualizar.setIcon(new ImageIcon(Actualizar.getImage().getScaledInstance(actualizar.getWidth(), actualizar.getHeight(), Image.SCALE_SMOOTH)));
                        }
                if(e.getSource()==anterior){
                    
                        ImageIcon Anterior= new ImageIcon("anterior.png");
                        anterior.setBounds(195, 0, 120, 40);
                        anterior.setIcon(new ImageIcon(Anterior.getImage().getScaledInstance(anterior.getWidth(), anterior.getHeight(), Image.SCALE_SMOOTH)));
                    }
                if(e.getSource()==eliminar){
                        ImageIcon borrando= new ImageIcon("eliminar.png"); 
                        eliminar.setBounds(570, 105, 110, 40);
                        eliminar.setIcon(new ImageIcon(borrando.getImage().getScaledInstance(eliminar.getWidth(), eliminar.getHeight(), Image.SCALE_SMOOTH)));
                }
                if(e.getSource()==buscar){
                    ImageIcon buscando= new ImageIcon("buscar.png");
                    buscar.setBounds(570, 165, 110, 40);
                    buscar.setIcon(new ImageIcon(buscando.getImage().getScaledInstance(buscar.getWidth(), buscar.getHeight(), Image.SCALE_SMOOTH)));
                }
                if(e.getSource()==modificar){
                    ImageIcon modificando= new ImageIcon("modificar.png");
                    modificar.setBounds(570, 225, 110, 40);
                    modificar.setIcon(new ImageIcon(modificando.getImage().getScaledInstance(modificar.getWidth(), modificar.getHeight(), Image.SCALE_SMOOTH)));
                }  
                
            }
        };
        salir.addMouseListener(oyentederaton);
        guardar.addMouseListener(oyentederaton);
        siguiente.addMouseListener(oyentederaton);
        actualizar.addMouseListener(oyentederaton);
        anterior.addMouseListener(oyentederaton);
        eliminar.addMouseListener(oyentederaton);
        buscar.addMouseListener(oyentederaton);
        modificar.addMouseListener(oyentederaton);
    }
    //tabla
    private void mostrar(){
        
        String matriz[][]= new String[datospermanentes.size()][6];
    
        for (int k = 0; k < datospermanentes.size(); k++) {
            matriz[k][0]=datospermanentes.get(k).getId();
            matriz[k][1]=datospermanentes.get(k).getNombre();
            matriz[k][2]=datospermanentes.get(k).getEdad();
            matriz[k][3]=datospermanentes.get(k).getGenero();
            matriz[k][4]=datospermanentes.get(k).getRescatado();
            matriz[k][5]=datospermanentes.get(k).getDiscapacidad(); }
            
            JScrollPane scroll = new JScrollPane();
            String[] columnNames = {"Id", "Nombre", "Edad","Genero","Rescatado","Discapacidad"};
            final JTable table= new JTable (matriz, columnNames);
            scroll.setViewportView(table);
            scroll.setBounds(10, 55, 550, 200);
            panel3.add(scroll);
        
    }
    //metodos de algunas variables
    public ArrayList<Gato> getLista() {
        return lista;
      }

    public void setLista(ArrayList<Gato> lista) {
        this.lista = lista;
    }
    
    public ArrayList<Gato> getDatospermanentes() {
        return datospermanentes;
    }

    private void setDatospermanentes(ArrayList<Gato> datosa) {
       for(int y=0; y<datosa.size(); y++){
           datospermanentes.add(datosa.get(y));
       }
        
    }
    //guardar datos
    private void guardar(){
        
        try{
            ArrayList <Gato> holis= (ArrayList <Gato>)datospermanentes.clone();
            ObjectOutputStream salida = new ObjectOutputStream (new FileOutputStream("Hola.pokee"));
            salida.writeObject (holis);
            salida.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
     }
    //leer datos
    private void leer(){
        try{
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Hola.pokee"));
            ArrayList <Gato> datosguardados = (ArrayList <Gato>) entrada.readObject();
            setDatospermanentes(datosguardados);
            entrada.close();      
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "no se encontro el archivo");
          }
        
    }
    //retirar elementos
    private void retirarelemento(){
        try{
        h= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Id de la mascota a Retirar"));
        for(int gatitos=0; gatitos<datospermanentes.size(); gatitos++){

            if(h==Integer.parseInt(datospermanentes.get(gatitos).getId())){
                datospermanentes.remove(gatitos);
                seguir=false;
                JOptionPane.showMessageDialog(null,"el Id "+ h+" ha sido removido Exitosamente"
                        , "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                mostrar();
                guardar();
                break; 
            }
            }
        if(seguir==true){
            JOptionPane.showMessageDialog(null,"el Id "+ h+" No se ha encontrado"
                        , "No registrado", JOptionPane.OK_OPTION);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Se ha introducido un valor no Permitido"
            , "Error",  JOptionPane.ERROR_MESSAGE);
        }
    }
    // recibir datos
    private void recibirdatos(){
        Arreglo();
        Gato datos= new Gato(Gatonombre,Gatoedad, Gatogenero,Gatodiscapacidad, Gatorescatado , Gatoid );
        for(int jua=0; jua<datospermanentes.size(); jua++){
            if(datos.getId().equals(datospermanentes.get(jua).getId())){
                yaregistrado=true;
                j=0;
                guardar.setEnabled(false);
                JOptionPane.showMessageDialog(null,"Se ha introducido un Id ya registrado"
                , "Valor ya introducido",  JOptionPane.WARNING_MESSAGE);
                break;
            }
            }
        if(yaregistrado==false){
        i++;
        j=0;
        datospermanentes.add(datos);
        nombre.setText("");
        edad.setText("");
        id.setText("");
        genero.clearSelection();
        rescatado.clearSelection();
        discapacidad.clearSelection();
        if(i==1){
        a=1;
        }
        guardar.setEnabled(false);
        generarid();
        }
    }
    // buscar datos
    private void burcardatos(){
        try{
            int ju= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Id de la mascota a buscar"));
            for(int mic=0; mic<datospermanentes.size(); mic++){
                if(ju==Integer.parseInt(datospermanentes.get(mic).getId())){
                    uwu=false;
                    JOptionPane.showMessageDialog(null,"Nombre:\t"+ datospermanentes.get(mic).getNombre()+"\n"
                            + "Edad:\t"+ datospermanentes.get(mic).getEdad()+"\n"
                            + "Genero:\t"+ datospermanentes.get(mic).getGenero()+"\n"
                            + "Discapacidad:\t"+ datospermanentes.get(mic).getDiscapacidad()+"\n"
                            + "Rescatado:\t"+ datospermanentes.get(mic).getRescatado()+"\n"
                            , "Mascota encontrada", JOptionPane.INFORMATION_MESSAGE);
                    break; 
                }
                }
            if(uwu==true){
                JOptionPane.showMessageDialog(null,"el Id "+ ju+" No se ha encontrado"
                            , "No registrado", JOptionPane.OK_OPTION);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Se ha introducido un valor no Permitido"
            , "Error",  JOptionPane.ERROR_MESSAGE);
        }
    }
    // modificar Datos
    private void modificardatos(){
        try{
            int mira= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el Id de la mascota a modificar"));
            String[] mimiendo= {"Nombre", "Edad", "Genero","Discapacidad", "Rescatado"};
            String[] ashu={"Si", "No"};
            String[] generosbebe={"Macho", "Hembra"};
            for(int jul=0; jul<datospermanentes.size();jul++){
                
                if(mira==Integer.parseInt(datospermanentes.get(jul).getId())){
                    nooo=false;
                    Object holi=JOptionPane.showInputDialog(null,"Selecciona el parametro a modificar",
                            "Elegir",JOptionPane.QUESTION_MESSAGE,null,mimiendo, mimiendo[0]);
                    if(holi.toString().equals("Nombre")){
                        String newnombre=JOptionPane.showInputDialog(null, "Establezca el Nuevo nombre");
                        datospermanentes.get(jul).setNombre(newnombre);
                        JOptionPane.showMessageDialog(null,"el Nombre del Id "+ mira+" ha sido cambiado Exitosamente"
                        , "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                        mostrar();
                        guardar();
                        break; 
                    }
                    if(holi.toString().equals("Edad")){
                        int newedad=Integer.parseInt(JOptionPane.showInputDialog(null, "Establezca la nueva edad"));
                        datospermanentes.get(jul).setEdad(String.valueOf(newedad));
                        JOptionPane.showMessageDialog(null,"La edad del Id "+ mira+" ha sido cambiado Exitosamente"
                        , "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                        mostrar();
                        guardar();
                        break; 
                    }
                    if(holi.toString().equals("Genero")){
                        Object pok=JOptionPane.showInputDialog(null,"Selecciona el nuevo genero"
                                , "Elegir",JOptionPane.QUESTION_MESSAGE,null,generosbebe, generosbebe[0]);
                        datospermanentes.get(jul).setGenero(pok.toString());
                        JOptionPane.showMessageDialog(null,"El Genero del Id "+ mira+" ha sido cambiado Exitosamente"
                        , "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                        mostrar();
                        guardar();
                        break; 
                    }
                    if(holi.toString().equals("Discapacidad")){
                        Object poker=JOptionPane.showInputDialog(null,"Selecciona el nuevo Valor de Discapacidad"
                                , "Elegir",JOptionPane.QUESTION_MESSAGE,null,ashu, ashu[0]);
                        datospermanentes.get(jul).setDiscapacidad(poker.toString());
                        JOptionPane.showMessageDialog(null,"El Valor de Discapacidad del Id "+ mira+" ha sido cambiado Exitosamente"
                        , "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                        mostrar();
                        guardar();
                        break; 
                        
                    }
                    if(holi.toString().equals("Rescatado")){
                        Object pokemita=JOptionPane.showInputDialog(null,"Selecciona el nuevo Valor de Rescatado"
                                , "Elegir",JOptionPane.QUESTION_MESSAGE,null,ashu, ashu[0]);
                        datospermanentes.get(jul).setRescatado(pokemita.toString());
                        JOptionPane.showMessageDialog(null,"El Valor de Rescatado del Id "+ mira+" ha sido cambiado Exitosamente"
                        , "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                        mostrar();
                        guardar();
                        break; 
                    }
                }
            }
            
            if(nooo==true){
                JOptionPane.showMessageDialog(null,"el Id "+ mira+" No se ha encontrado"
                            , "No registrado", JOptionPane.OK_OPTION);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Se ha introducido un valor no Permitido"
            , "Error",  JOptionPane.ERROR_MESSAGE);
        }
        
    }
    // generador de id al azar
    private void generarid(){
    sip=true;
    int ash=0;
    do{
        ide=0;
        ide=(int)(Math.random()*10000);
        if(datospermanentes.size()==0){
            sip=false;
            id.setText(String.valueOf(ide)); 
        }
        if(datospermanentes.size()>0){
        for(int him=0; him<datospermanentes.size(); him++){
            
            if(ide!= Integer.parseInt(datospermanentes.get(him).getId())){
                sip=false;
                id.setText(String.valueOf(ide));
                System.out.println("Hola");
                break;
            }
        }
                }
        
    }
    while(sip==true);
    }
    
}
