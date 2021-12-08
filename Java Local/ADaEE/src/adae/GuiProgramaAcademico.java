package adae;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class GuiProgramaAcademico extends JFrame{
    
    private JPanel panel;
    private JPanel panelImagenes;
    private JLabel decoracion;
    private ImageIcon logo;
    private JLabel adae;
    private JLabel instrucciones;
    private JLabel instrucciones2;
    private JLabel instrucciones3;
    private JLabel instrucciones4;
    private JRadioButton analitica;
    private JRadioButton fisica;
    private JRadioButton quimica;
    private JRadioButton dibujo;
    private JRadioButton entorno;
    private JRadioButton comunicacion;
    private JRadioButton ingles;
    private JRadioButton poo;
    private JRadioButton lpti;
    private JLabel lptiI;
    private JRadioButton apti;
    private JLabel aptiI;
    private ButtonGroup materias;
    private ImageIcon batiziano;
    private JLabel principal;
    private ImageIcon escudo;
    private JLabel ipn;
    private JLabel bienvenida;
    private JLabel fraseChida;
    private JButton regreso;
    private JLabel autor;
    private ImageIcon geometria;
    private JLabel geometriaAnalitica;
    private ImageIcon fisicaI;
    private JLabel fisica1;
    private ImageIcon quimicaI;
    private JLabel quimica1;
    private ImageIcon dibujoTecnico;
    private JLabel dibujoTecnicoI;
    private ImageIcon entornoSocioeconomico;
    private JLabel entornoSocioEconomico;
    private ImageIcon cc;
    private JLabel cCientifica;
    private ImageIcon english;
    private JLabel englishIII;
    private ImageIcon progra;
    private JLabel programacion;
    private ImageIcon lab;
    private JLabel labo;
    private ImageIcon admin;
    private JLabel adminI;
    private JLabel tituloAnalitica;
    private JLabel tituloFisica;
    private JLabel tituloQuimica;
    private JLabel tituloDibujo;
    private JLabel tituloEntorno;
    private JLabel tituloComunicacion;
    private JLabel tituloIngles;
    private JLabel tituloPoo;
    private JLabel tituloLab;
    private JLabel tituloAdmin;
    private ActionListener programas;
    private JButton fundamentos;
    private JButton siguienteFundamento;
    private JButton fundamentoAnterior;
    private JButton competenciasParticulares;
    private JButton programaSintetico;
    private JButton siguienteCuartilla;
    private JButton cuartillaAnterior;
    private ImageIcon fundamentosGeometria;
    private JLabel fundamentosAnalitica;
    private ImageIcon fundamentosGeometria0;
    private JLabel fundamentosAnalitica0;
    private ImageIcon competenciasGeometria;
    private JLabel competenciasAnalitica;
    private ImageIcon programaGeometria;
    private JLabel programaAnalitica;
    private ImageIcon programaGeometria0;
    private JLabel programaAnalitica0;
    private ImageIcon programaGeometria1;
    private JLabel programaAnalitica1;
    private ImageIcon fundamentosFisica;
    private JLabel fundamentacionFisica;
    private ImageIcon fundamentosFisica0;
    private JLabel fundamentacionFisica0;
    private ImageIcon competenciasFisica;
    private JLabel competenciasFisicaI;
    private ImageIcon programaFisica;
    private JLabel programaFisicaI;
    private ImageIcon programaFisica0;
    private JLabel programaFisicaI0;
    private ImageIcon programaFisica1;
    private JLabel programaFisicaI1;
    private ImageIcon fundamentosQuimica;
    private JLabel fundamentacionQuimica;
    private ImageIcon competenciasQuimica;
    private JLabel competenciasQuimicaI;
    private ImageIcon programaQuimica;
    private JLabel programaQuimicaI;
    private ImageIcon programaQuimica0;
    private JLabel programaQuimicaI0;
    private ImageIcon programaQuimica1;
    private JLabel programaQuimicaI1;
    private ImageIcon programaQuimica2;
    private JLabel programaQuimicaI2;
    private ImageIcon fundamentosDibujo;
    private JLabel fundamentacionDibujo;
    private ImageIcon competenciasDibujo;
    private JLabel competenciasDibujoTecnico;
    private ImageIcon programaDibujo;
    private JLabel programaDibujoTecnico;
    private ImageIcon programaDibujo0;
    private JLabel programaDibujoTecnico0;
    private ImageIcon programaDibujo1;
    private JLabel programaDibujoTecnico1;
    private ImageIcon fundamentosEntorno;
    private JLabel fundamentacionEntorno;
    private ImageIcon competenciasEntorno;
    private JLabel competenciasEntornoSocioeconomico;
    private ImageIcon programaEntorno;
    private JLabel programaEntornoSocioeconomico;
    private ImageIcon programaEntorno0;
    private JLabel programaEntornoSocioeconomico0;
    private ImageIcon programaEntorno1;
    private JLabel programaEntornoSocioeconomico1;
    private ImageIcon programaEntorno2;
    private JLabel programaEntornoSocioeconomico2;
    private ImageIcon programaEntorno3;
    private JLabel programaEntornoSocioeconomico3;
    private ImageIcon fundamentosComunicacion;
    private JLabel fundamentacionComunicacion;
    private ImageIcon competenciasComunicacion;
    private JLabel competenciasComunicacionCientifica;
    private ImageIcon programaComunicacion;
    private JLabel programaComunicacionCientifica;
    private ImageIcon programaComunicacion0;
    private JLabel programaComunicacionCientifica0;
    private ImageIcon fundamentosIngles;
    private JLabel fundamentacionIngles;
    private ImageIcon fundamentosIngles0;
    private JLabel fundamentacionIngles0;
    private ImageIcon competenciasIngles;
    private JLabel competenciasInglesIII;
    private ImageIcon programaIngles;
    private JLabel programaInglesIII;
    private ImageIcon programaIngles0;
    private JLabel programaInglesIII0;
    private ImageIcon fundamentosPoo;
    private JLabel fundamentacionPoo;
    private ImageIcon fundamentosPoo0;
    private JLabel fundamentacionPoo0;
    private ImageIcon competenciasPoo;
    private JLabel competenciasPOO;
    private ImageIcon programaPoo;
    private JLabel programaPOO;
    private ImageIcon programaPoo0;
    private JLabel programaPOO0;
    private ImageIcon programaPoo1;
    private JLabel programaPOO1;
    private ImageIcon programaPoo2;
    private JLabel programaPOO2;
    private ImageIcon programaPoo3;
    private JLabel programaPOO3;
    private ImageIcon fundamentosLPTI;
    private JLabel fundamentacionLPTI;
    private ImageIcon fundamentosLPTI0;
    private JLabel fundamentacionLPTI0;
    private ImageIcon fundamentosLPTI1;
    private JLabel fundamentacionLPTI1;
    private ImageIcon competenciasLPTI;
    private JLabel competenciasLPTII;
    private ImageIcon programaLPTI;
    private JLabel programaLPTII;
    private ImageIcon programaLPTI0;
    private JLabel programaLPTII0;
    private ImageIcon programaLPTI1;
    private JLabel programaLPTII1;
    private ImageIcon fundamentosAPTI;
    private JLabel fundamentacionAPTI;
    private ImageIcon fundamentosAPTI0;
    private JLabel fundamentacionAPTI0;
    private ImageIcon competenciasAPTI;
    private JLabel competenciasAPTII;
    private ImageIcon programaAPTI;
    private JLabel programaAPTII;
    private ImageIcon programaAPTI0;
    private JLabel programaAPTII0;
    private ImageIcon programaAPTI1;
    private JLabel programaAPTII1;
    private ImageIcon programaAPTI2;
    private JLabel programaAPTII2;
    private ActionListener verFundamentos;
    private ActionListener verCompetencias;
    private ActionListener verPrograma;
    private ActionListener fundamentoSiguiente;
    private ActionListener anteriorFundamento;
    private ActionListener siguientePrograma;
    private ActionListener programaAnterior;
    Usuario a=new Usuario();
    
    public GuiProgramaAcademico(){
        setTitle("Unidades de Aprendizaje");
        setSize(1100, 630);
        setResizable(false);
        ImageIcon AdAE = new ImageIcon("icono.png");
        Image icono = AdAE.getImage();
        setIconImage(icono);       
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        componentes();
    }
    private void componentes(){
        panelUA();
        panelImagenes();
        decoracion();
        logo();
        instrucciones();
        radioBotones();
        agruparBotones();
        inicio();
        ipn();
        ATS();
        fotosTitulos();
        titulo();
        botones();
        analitica();
        fisica();
        quimica();
        dibujo();
        entorno();
        comunicacion();
        ingles();
        poo();
        lpti();
        apti();
        verMaterias();
    }
    private void panelUA(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 630);
        panel.setBackground(new Color(0, 52, 89));
        getContentPane().add(panel);
    }
    private void panelImagenes(){
        panelImagenes = new JPanel();
        panelImagenes.setLayout(null);
        panelImagenes.setBounds(0, 0, 700, 630);
        panelImagenes.setBackground(Color.white);
        getContentPane().add(panelImagenes);
    }
    private void decoracion(){
        decoracion = new JLabel();
        decoracion.setBounds(370, 0, 30, 630);
        decoracion.setBackground(new Color(0, 169, 231));
        decoracion.setOpaque(true);
        panel.add(decoracion);
    }
    private void logo(){
        logo = new ImageIcon("imagenAdae.jpg");
        adae = new JLabel();
        adae.setBounds(0, 0, 140, 140);
        adae.setIcon(new ImageIcon(logo.getImage().getScaledInstance(adae.getWidth(), adae.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(adae);
    }
    private void instrucciones(){
        instrucciones = new JLabel("Seleccione la unidad de", SwingConstants.CENTER);
        instrucciones.setBounds(140, 25, 210, 20);
        instrucciones.setForeground(Color.white);
        instrucciones.setFont(new Font("arial", Font.PLAIN, 20));
        panel.add(instrucciones);
        instrucciones2 = new JLabel("aprendizaje de la cual", SwingConstants.CENTER);
        instrucciones2.setBounds(132, 45, 210, 22);
        instrucciones2.setForeground(Color.white);
        instrucciones2.setFont(new Font("arial", Font.PLAIN, 20));
        panel.add(instrucciones2);
        instrucciones3 = new JLabel("desee conocer su", SwingConstants.CENTER);
        instrucciones3.setBounds(115, 65, 210, 20);
        instrucciones3.setForeground(Color.white);
        instrucciones3.setFont(new Font("arial", Font.PLAIN, 20));
        panel.add(instrucciones3);
        instrucciones4 = new JLabel("programa académico.", SwingConstants.CENTER);
        instrucciones4.setBounds(132, 85, 210, 22);
        instrucciones4.setForeground(Color.white);
        instrucciones4.setFont(new Font("arial", Font.PLAIN, 20));
        panel.add(instrucciones4);
    }
    private void radioBotones(){
        analitica = new JRadioButton("Geometría Analítica", false);
        analitica.setBounds(10, 150, 220, 20);
        analitica.setForeground(Color.white);
        analitica.setFont(new Font("arial", Font.PLAIN, 18));
        analitica.setBackground(new Color(0, 52, 89));
        panel.add(analitica);
        fisica = new JRadioButton("Física I", false);
        fisica.setBounds(10, 180, 220, 20);
        fisica.setForeground(Color.white);
        fisica.setFont(new Font("arial", Font.PLAIN, 18));
        fisica.setBackground(new Color(0, 52, 89));
        panel.add(fisica);
        quimica = new JRadioButton("Química I", false);
        quimica.setBounds(10, 210, 220, 20);
        quimica.setForeground(Color.white);
        quimica.setFont(new Font("arial", Font.PLAIN, 18));
        quimica.setBackground(new Color(0, 52, 89));
        panel.add(quimica);
        dibujo = new JRadioButton("Dibujo Técnico I", false);
        dibujo.setBounds(10, 240, 220, 20);
        dibujo.setForeground(Color.white);
        dibujo.setFont(new Font("arial", Font.PLAIN, 18));
        dibujo.setBackground(new Color(0, 52, 89));
        panel.add(dibujo);
        entorno = new JRadioButton("Entorno Socioeconómico de México", false);
        entorno.setBounds(10, 270, 360, 20);
        entorno.setForeground(Color.white);
        entorno.setFont(new Font("arial", Font.PLAIN, 18));
        entorno.setBackground(new Color(0, 52, 89));
        panel.add(entorno);
        comunicacion = new JRadioButton("Comunicación Científica", false);
        comunicacion.setBounds(10, 300, 360, 20);
        comunicacion.setForeground(Color.white);
        comunicacion.setFont(new Font("arial", Font.PLAIN, 18));
        comunicacion.setBackground(new Color(0, 52, 89));
        panel.add(comunicacion);
        ingles = new JRadioButton("Inglés III", false);
        ingles.setBounds(10, 330, 360, 20);
        ingles.setForeground(Color.white);
        ingles.setFont(new Font("arial", Font.PLAIN, 18));
        ingles.setBackground(new Color(0, 52, 89));
        panel.add(ingles);
        poo = new JRadioButton("Programación Orientada a Objetos", false);
        poo.setBounds(10, 360, 360, 20);
        poo.setForeground(Color.white);
        poo.setFont(new Font("arial", Font.PLAIN, 18));
        poo.setBackground(new Color(0, 52, 89));
        panel.add(poo);
        lpti = new JRadioButton("Laboratorio de Proyectos de Tecnologías", false);
        lpti.setBounds(10, 390, 360, 20);
        lpti.setForeground(Color.white);
        lpti.setFont(new Font("arial", Font.PLAIN, 18));
        lpti.setBackground(new Color(0, 52, 89));
        panel.add(lpti);
        lptiI = new JLabel("de la Información I");
        lptiI.setBounds(30, 418, 390, 20);
        lptiI.setForeground(Color.white);
        lptiI.setFont(new Font("arial", Font.PLAIN, 18));
        panel.add(lptiI);
        apti = new JRadioButton("Administración de Proyectos de", false);
        apti.setBounds(10, 450, 360, 20);
        apti.setForeground(Color.white);
        apti.setFont(new Font("arial", Font.PLAIN, 18));
        apti.setBackground(new Color(0, 52, 89));
        panel.add(apti);
        aptiI = new JLabel("Tecnologías de la Información I");
        aptiI.setBounds(30, 478, 390, 20);
        aptiI.setForeground(Color.white);
        aptiI.setFont(new Font("arial", Font.PLAIN, 18));
        panel.add(aptiI);
    }
    private void agruparBotones(){
        materias = new ButtonGroup();
        materias.add(analitica);
        materias.add(fisica);
        materias.add(quimica);
        materias.add(dibujo);
        materias.add(entorno);
        materias.add(comunicacion);
        materias.add(ingles);
        materias.add(poo);
        materias.add(lpti);
        materias.add(apti);
    }
    private void ipn(){
        escudo = new ImageIcon("IPN.png");
        ipn = new JLabel();
        ipn.setBounds(0, 500, 98, 100);
        ipn.setIcon(new ImageIcon(escudo.getImage().getScaledInstance(ipn.getWidth(), ipn.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(ipn);
    }
    private void inicio(){
        batiziano = new ImageIcon("batiziano.png");
        principal = new JLabel();
        principal.setBounds(580, 107, 313, 320);
        principal.setIcon(new ImageIcon(batiziano.getImage().getScaledInstance(principal.getWidth(), principal.getHeight(), Image.SCALE_SMOOTH)));
        panelImagenes.add(principal);
        bienvenida = new JLabel("Bienvenido a los programas académicos");
        bienvenida.setBounds(580, 70, 400, 20);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        bienvenida.setForeground(Color.BLACK);
        panelImagenes.add(bienvenida);
    }
    private void ATS(){
        fraseChida = new JLabel("''Si puedes imaginarlo puedes programarlo.''");
        fraseChida.setBounds(570, 460, 400, 20);
        fraseChida.setFont(new Font("arial", Font.BOLD, 18));
        fraseChida.setForeground(Color.BLACK);
        panelImagenes.add(fraseChida);
        autor = new JLabel("-Alejandro Taboada-");
        autor.setBounds(840, 495, 400, 20);
        autor.setFont(new Font("arial", Font.ITALIC, 18));
        autor.setForeground(Color.BLACK);
        panelImagenes.add(autor);
    }
    private void fotosTitulos(){
        geometria = new ImageIcon("geometriaAnalitica.png");
        geometriaAnalitica = new JLabel();
        geometriaAnalitica.setBounds(485, 100, 530, 320);
        geometriaAnalitica.setIcon(new ImageIcon(geometria.getImage().getScaledInstance(geometriaAnalitica.getWidth(), geometriaAnalitica.getHeight(), Image.SCALE_SMOOTH)));
        fisicaI = new ImageIcon("fisicaI.jpg");
        fisica1 = new JLabel();
        fisica1.setBounds(485, 100, 530, 320);
        fisica1.setIcon(new ImageIcon(fisicaI.getImage().getScaledInstance(fisica1.getWidth(), fisica1.getHeight(), Image.SCALE_SMOOTH)));
        quimicaI = new ImageIcon("quimicaI.jpg");
        quimica1 = new JLabel();
        quimica1.setBounds(485, 100, 530, 320);
        quimica1.setIcon(new ImageIcon(quimicaI.getImage().getScaledInstance(quimica1.getWidth(), quimica1.getHeight(), Image.SCALE_SMOOTH)));
        dibujoTecnico = new ImageIcon("dibujoTecnicoI.jpg");
        dibujoTecnicoI = new JLabel();
        dibujoTecnicoI.setBounds(485, 100, 530, 320);
        dibujoTecnicoI.setIcon(new ImageIcon(dibujoTecnico.getImage().getScaledInstance(dibujoTecnicoI.getWidth(), dibujoTecnicoI.getHeight(), Image.SCALE_SMOOTH)));
        entornoSocioeconomico = new ImageIcon("entornoSocioeconomicoDeMexico.jpg");
        entornoSocioEconomico = new JLabel();
        entornoSocioEconomico.setBounds(485, 100, 530, 320);
        entornoSocioEconomico.setIcon(new ImageIcon(entornoSocioeconomico.getImage().getScaledInstance(entornoSocioEconomico.getWidth(), entornoSocioEconomico.getHeight(), Image.SCALE_SMOOTH)));
        cc = new ImageIcon("comunicacionCientifica.jpg");
        cCientifica = new JLabel();
        cCientifica.setBounds(485, 100, 530, 320);
        cCientifica.setIcon(new ImageIcon(cc.getImage().getScaledInstance(cCientifica.getWidth(), cCientifica.getHeight(), Image.SCALE_SMOOTH)));
        english = new ImageIcon("inglesIII.jpg");
        englishIII = new JLabel();
        englishIII.setBounds(485, 100, 530, 320);
        englishIII.setIcon(new ImageIcon(english.getImage().getScaledInstance(englishIII.getWidth(), englishIII.getHeight(), Image.SCALE_SMOOTH)));
        progra = new ImageIcon("programacionOrientadaAObjetos.jpg");
        programacion = new JLabel();
        programacion.setBounds(485, 100, 530, 320);
        programacion.setIcon(new ImageIcon(progra.getImage().getScaledInstance(programacion.getWidth(), programacion.getHeight(), Image.SCALE_SMOOTH)));
        lab = new ImageIcon("laboratorioDeProyectosDeTecnologiasDeLaInformacionI.jpg");
        labo = new JLabel();
        labo.setBounds(485, 100, 530, 320);
        labo.setIcon(new ImageIcon(lab.getImage().getScaledInstance(labo.getWidth(), labo.getHeight(), Image.SCALE_SMOOTH)));
        admin = new ImageIcon("administracionDeProyectosDeTecnologiaDeLaInformacionI.png");
        adminI = new JLabel();
        adminI.setBounds(485, 100, 530, 320);
        adminI.setIcon(new ImageIcon(admin.getImage().getScaledInstance(adminI.getWidth(), adminI.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void titulo(){
        tituloAnalitica = new JLabel("Geometría Analítica");
        tituloAnalitica.setBounds(655, 10, 200, 24);
        tituloAnalitica.setFont(new Font("Arial", Font.BOLD, 22));
        tituloAnalitica.setForeground(Color.BLACK);
        tituloFisica = new JLabel("Física I");
        tituloFisica.setBounds(730, 10, 200, 24);
        tituloFisica.setFont(new Font("Arial", Font.BOLD, 22));
        tituloFisica.setForeground(Color.BLACK);
        tituloQuimica = new JLabel("Química I");
        tituloQuimica.setBounds(700, 10, 200, 24);
        tituloQuimica.setFont(new Font("Arial", Font.BOLD, 22));
        tituloQuimica.setForeground(Color.BLACK);
        tituloDibujo = new JLabel("Dibujo Técnico I");
        tituloDibujo.setBounds(660, 10, 200, 24);
        tituloDibujo.setFont(new Font("Arial", Font.BOLD, 22));
        tituloDibujo.setForeground(Color.BLACK);
        tituloEntorno = new JLabel("Entorno Socioeconomico de México");
        tituloEntorno.setBounds(555, 10, 400, 24);
        tituloEntorno.setFont(new Font("Arial", Font.BOLD, 22));
        tituloEntorno.setForeground(Color.BLACK);
        tituloComunicacion = new JLabel("Comunicación Científica");
        tituloComunicacion.setBounds(623, 10, 400, 24);
        tituloComunicacion.setFont(new Font("Arial", Font.BOLD, 22));
        tituloComunicacion.setForeground(Color.BLACK);
        tituloIngles = new JLabel("Inglés III");
        tituloIngles.setBounds(710, 10, 200, 24);
        tituloIngles.setFont(new Font("Arial", Font.BOLD, 22));
        tituloIngles.setForeground(Color.BLACK);
        tituloPoo = new JLabel("Programación Orientada a Objetos");
        tituloPoo.setBounds(575, 10, 400, 24);
        tituloPoo.setFont(new Font("Arial", Font.BOLD, 22));
        tituloPoo.setForeground(Color.BLACK);
        tituloLab = new JLabel("Laboratorio de Proyectos de Tecnologías de la Información I");
        tituloLab.setBounds(415, 7, 700, 24);
        tituloLab.setFont(new Font("Arial", Font.BOLD, 22));
        tituloLab.setForeground(Color.BLACK);
        tituloAdmin = new JLabel("Administracion de Proyectos de Tecnologías de la Información I");
        tituloAdmin.setBounds(413, 7, 700, 24);
        tituloAdmin.setFont(new Font("Arial", Font.BOLD, 22));
        tituloAdmin.setForeground(Color.BLACK);
    }
    private void botones(){
        fundamentos = new JButton("Fundamentación");
        fundamentos.setForeground(Color.white);
        fundamentos.setFont(new Font("Arial", Font.BOLD, 14));
        fundamentos.setBackground(new Color(0, 52, 89));
        fundamentos.setBounds(445, 550, 180, 20);
        fundamentoAnterior = new JButton("Anterior");
        fundamentoAnterior.setFont(new Font("Arial", Font.BOLD, 14));
        fundamentoAnterior.setForeground(Color.white);
        fundamentoAnterior.setBackground(new Color(0, 169, 231));
        fundamentoAnterior.setBounds(410, 550, 95, 20);
        siguienteFundamento = new JButton("Siguiente");
        siguienteFundamento.setFont(new Font("Arial", Font.BOLD, 14));
        siguienteFundamento.setForeground(Color.white);
        siguienteFundamento.setBackground(new Color(0, 52, 89));
        siguienteFundamento.setBounds(517, 550, 115, 20);
        competenciasParticulares = new JButton("Red de competencias");
        competenciasParticulares.setForeground(Color.white);
        competenciasParticulares.setFont(new Font("Arial", Font.BOLD, 14));
        competenciasParticulares.setBackground(new Color(0, 169, 231));
        competenciasParticulares.setBounds(645, 550, 200, 20);
        programaSintetico = new JButton("Programa Sintético");
        programaSintetico.setForeground(Color.white);
        programaSintetico.setBackground(new Color(0, 52, 89));
        programaSintetico.setFont(new Font("Arial", Font.BOLD, 14));
        programaSintetico.setBounds(865, 550, 200, 20);
        cuartillaAnterior = new JButton("Anterior");
        cuartillaAnterior.setBounds(865, 550, 95, 20);
        cuartillaAnterior.setForeground(Color.white);
        cuartillaAnterior.setBackground(new Color(0, 52, 89));
        cuartillaAnterior.setFont(new Font("Arial", Font.BOLD, 14));
        siguienteCuartilla = new JButton("Siguiente");
        siguienteCuartilla.setForeground(Color.white);
        siguienteCuartilla.setFont(new Font("Arial", Font.BOLD, 14));
        siguienteCuartilla.setBackground(new Color(0, 169, 231));
        siguienteCuartilla.setBounds(972, 550, 115, 20);
        regreso = new JButton("Inicio");
        regreso.setBounds(240, 555, 100, 30);
        regreso.setBackground(new Color(0, 169, 231));
        regreso.setForeground(Color.white);
        regreso.setFont(new Font("Gadugi", Font.BOLD, 18));
        panel.add(regreso);
        inciarOyenteRaton();
    }
    private void analitica(){
        fundamentosGeometria = new ImageIcon("fundamentosAnalitica.png");
        fundamentosAnalitica = new JLabel();
        fundamentosAnalitica.setBounds(410, 32, 680, 492);
        fundamentosAnalitica.setIcon(new ImageIcon(fundamentosGeometria.getImage().getScaledInstance(fundamentosAnalitica.getWidth(), fundamentosAnalitica.getHeight(), Image.SCALE_SMOOTH)));
        fundamentosGeometria0 = new ImageIcon("fundamentosAnalitica2.png");
        fundamentosAnalitica0 = new JLabel();
        fundamentosAnalitica0.setBounds(410, 32, 680, 492);
        fundamentosAnalitica0.setIcon(new ImageIcon(fundamentosGeometria0.getImage().getScaledInstance(fundamentosAnalitica0.getWidth(), fundamentosAnalitica0.getHeight(), Image.SCALE_SMOOTH)));
        competenciasGeometria = new ImageIcon("aprendizajesEsperadosAnalitica.png");
        competenciasAnalitica = new JLabel();
        competenciasAnalitica.setBounds(410, 32, 680, 492);
        competenciasAnalitica.setIcon(new ImageIcon(competenciasGeometria.getImage().getScaledInstance(competenciasAnalitica.getWidth(), competenciasAnalitica.getHeight(), Image.SCALE_SMOOTH)));
        programaGeometria = new ImageIcon("programaSinteticoAnalitica.png");
        programaAnalitica = new JLabel();
        programaAnalitica.setBounds(410, 32, 680, 492);
        programaAnalitica.setIcon(new ImageIcon(programaGeometria.getImage().getScaledInstance(programaAnalitica.getWidth(), programaAnalitica.getHeight(), Image.SCALE_SMOOTH)));
        programaGeometria0 = new ImageIcon("programaSinteticoAnalitica2.png");
        programaAnalitica0 = new JLabel();
        programaAnalitica0.setBounds(410, 32, 680, 492);
        programaAnalitica0.setIcon(new ImageIcon(programaGeometria0.getImage().getScaledInstance(programaAnalitica0.getWidth(), programaAnalitica0.getHeight(), Image.SCALE_SMOOTH)));
        programaGeometria1 = new ImageIcon("programaSinteticoAnalitica3.png");
        programaAnalitica1 = new JLabel();
        programaAnalitica1.setBounds(410, 32, 680, 492);
        programaAnalitica1.setIcon(new ImageIcon(programaGeometria1.getImage().getScaledInstance(programaAnalitica1.getWidth(), programaAnalitica1.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void fisica(){
        fundamentosFisica = new ImageIcon("fundamentosFisicaI.png");
        fundamentacionFisica = new JLabel();
        fundamentacionFisica.setBounds(410, 32, 680, 492);
        fundamentacionFisica.setIcon(new ImageIcon(fundamentosFisica.getImage().getScaledInstance(fundamentacionFisica.getWidth(), fundamentacionFisica.getHeight(), Image.SCALE_SMOOTH)));
        fundamentosFisica0 = new ImageIcon("fundamentosFisicaI2.png");
        fundamentacionFisica0 = new JLabel();
        fundamentacionFisica0.setBounds(410, 32, 680, 492);
        fundamentacionFisica0.setIcon(new ImageIcon(fundamentosFisica0.getImage().getScaledInstance(fundamentacionFisica0.getWidth(), fundamentacionFisica0.getHeight(), Image.SCALE_SMOOTH)));
        competenciasFisica = new ImageIcon("aprendizajesEsperadosFisicaI.png");
        competenciasFisicaI = new JLabel();
        competenciasFisicaI.setBounds(410, 32, 680, 492);
        competenciasFisicaI.setIcon(new ImageIcon(competenciasFisica.getImage().getScaledInstance(competenciasFisicaI.getWidth(), competenciasFisicaI.getHeight(), Image.SCALE_SMOOTH)));
        programaFisica = new ImageIcon("programaSinteticoFisicaI.png");
        programaFisicaI = new JLabel();
        programaFisicaI.setBounds(410, 32, 680, 492);
        programaFisicaI.setIcon(new ImageIcon(programaFisica.getImage().getScaledInstance(programaFisicaI.getWidth(), programaFisicaI.getHeight(), Image.SCALE_SMOOTH)));
        programaFisica0 = new ImageIcon("programaSinteticoFisicaI2.png");
        programaFisicaI0 = new JLabel();
        programaFisicaI0.setBounds(410, 32, 680, 492);
        programaFisicaI0.setIcon(new ImageIcon(programaFisica0.getImage().getScaledInstance(programaFisicaI0.getWidth(), programaFisicaI0.getHeight(), Image.SCALE_SMOOTH)));
        programaFisica1 = new ImageIcon("programaSinteticoFisicaI3.png");
        programaFisicaI1 = new JLabel();
        programaFisicaI1.setBounds(410, 32, 680, 492);
        programaFisicaI1.setIcon(new ImageIcon(programaFisica1.getImage().getScaledInstance(programaFisicaI1.getWidth(), programaFisicaI1.getHeight(), Image.SCALE_SMOOTH)));        
    }
    private void quimica(){
        fundamentosQuimica = new ImageIcon("fundamentosQuimicaI.png");
        fundamentacionQuimica = new JLabel();
        fundamentacionQuimica.setBounds(410, 32, 680, 492);
        fundamentacionQuimica.setIcon(new ImageIcon(fundamentosQuimica.getImage().getScaledInstance(fundamentacionQuimica.getWidth(), fundamentacionQuimica.getHeight(), Image.SCALE_SMOOTH)));
        competenciasQuimica = new ImageIcon("aprendizajesEsperadosQuimicaI.png");
        competenciasQuimicaI = new JLabel();
        competenciasQuimicaI.setBounds(410, 32, 680, 492);
        competenciasQuimicaI.setIcon(new ImageIcon(competenciasQuimica.getImage().getScaledInstance(competenciasQuimicaI.getWidth(), competenciasQuimicaI.getHeight(), Image.SCALE_SMOOTH)));
        programaQuimica = new ImageIcon("programaSinteticoQuimicaI.png");
        programaQuimicaI = new JLabel();
        programaQuimicaI.setBounds(410, 32, 680, 492);
        programaQuimicaI.setIcon(new ImageIcon(programaQuimica.getImage().getScaledInstance(programaQuimicaI.getWidth(), programaQuimicaI.getHeight(), Image.SCALE_SMOOTH)));
        programaQuimica0 = new ImageIcon("programaSinteticoQuimicaI2.png");
        programaQuimicaI0 = new JLabel();
        programaQuimicaI0.setBounds(410, 32, 680, 492);
        programaQuimicaI0.setIcon(new ImageIcon(programaQuimica0.getImage().getScaledInstance(programaQuimicaI0.getWidth(), programaQuimicaI0.getHeight(), Image.SCALE_SMOOTH)));
        programaQuimica1 = new ImageIcon("programaSinteticoQuimicaI3.png");
        programaQuimicaI1 = new JLabel();
        programaQuimicaI1.setBounds(410, 32, 680, 492);
        programaQuimicaI1.setIcon(new ImageIcon(programaQuimica1.getImage().getScaledInstance(programaQuimicaI1.getWidth(), programaQuimicaI1.getHeight(), Image.SCALE_SMOOTH)));
        programaQuimica2 = new ImageIcon("programaSinteticoQuimicaI4.png");
        programaQuimicaI2 = new JLabel();
        programaQuimicaI2.setBounds(410, 32, 680, 492);
        programaQuimicaI2.setIcon(new ImageIcon(programaQuimica2.getImage().getScaledInstance(programaQuimicaI2.getWidth(), programaQuimicaI2.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void dibujo(){
        fundamentosDibujo = new ImageIcon("fundamentosDibujoTecnicoI.png");
        fundamentacionDibujo = new JLabel();
        fundamentacionDibujo.setBounds(410, 32, 680, 492);
        fundamentacionDibujo.setIcon(new ImageIcon(fundamentosDibujo.getImage().getScaledInstance(fundamentacionDibujo.getWidth(), fundamentacionDibujo.getHeight(), Image.SCALE_SMOOTH)));
        competenciasDibujo = new ImageIcon("aprendizajesEsperadosDibujoTecnicoI.png");
        competenciasDibujoTecnico = new JLabel();
        competenciasDibujoTecnico.setBounds(410, 32, 680, 492);
        competenciasDibujoTecnico.setIcon(new ImageIcon(competenciasDibujo.getImage().getScaledInstance(competenciasDibujoTecnico.getWidth(), competenciasDibujoTecnico.getHeight(), Image.SCALE_SMOOTH)));
        programaDibujo = new ImageIcon("programaSinteticoDibujoTecnicoI.png");
        programaDibujoTecnico = new JLabel();
        programaDibujoTecnico.setBounds(410, 32, 680, 492);
        programaDibujoTecnico.setIcon(new ImageIcon(programaDibujo.getImage().getScaledInstance(programaDibujoTecnico.getWidth(), programaDibujoTecnico.getHeight(), Image.SCALE_SMOOTH)));
        programaDibujo0 = new ImageIcon("programaSinteticoDibujoTecnicoI2.png");
        programaDibujoTecnico0 = new JLabel();
        programaDibujoTecnico0.setBounds(410, 32, 680, 492);
        programaDibujoTecnico0.setIcon(new ImageIcon(programaDibujo0.getImage().getScaledInstance(programaDibujoTecnico0.getWidth(), programaDibujoTecnico0.getHeight(), Image.SCALE_SMOOTH)));
        programaDibujo1 = new ImageIcon("programaSinteticoDibujoTecnicoI3.png");
        programaDibujoTecnico1 = new JLabel();
        programaDibujoTecnico1.setBounds(410, 32, 680, 492);
        programaDibujoTecnico1.setIcon(new ImageIcon(programaDibujo1.getImage().getScaledInstance(programaDibujoTecnico1.getWidth(), programaDibujoTecnico1.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void entorno(){
        fundamentosEntorno = new ImageIcon("fundamentosEntornoSocioeconomicoDeMexico.png");
        fundamentacionEntorno = new JLabel();
        fundamentacionEntorno.setBounds(410, 32, 680, 492);
        fundamentacionEntorno.setIcon(new ImageIcon(fundamentosEntorno.getImage().getScaledInstance(fundamentacionEntorno.getWidth(), fundamentacionEntorno.getHeight(), Image.SCALE_SMOOTH)));
        competenciasEntorno = new ImageIcon("aprendizajesEsperadosEntornoSocioeconomicoDeMexico.png");
        competenciasEntornoSocioeconomico = new JLabel();
        competenciasEntornoSocioeconomico.setBounds(410, 32, 680, 492);
        competenciasEntornoSocioeconomico.setIcon(new ImageIcon(competenciasEntorno.getImage().getScaledInstance(competenciasEntornoSocioeconomico.getWidth(), competenciasEntornoSocioeconomico.getHeight(), Image.SCALE_SMOOTH)));
        programaEntorno = new ImageIcon("programaSinteticoEntornoSocioeconomicoDeMexico.png");
        programaEntornoSocioeconomico = new JLabel();
        programaEntornoSocioeconomico.setBounds(410, 32, 680, 492);
        programaEntornoSocioeconomico.setIcon(new ImageIcon(programaEntorno.getImage().getScaledInstance(programaEntornoSocioeconomico.getWidth(), programaEntornoSocioeconomico.getHeight(), Image.SCALE_SMOOTH)));
        programaEntorno0 = new ImageIcon("programaSinteticoEntornoSocioeconomicoDeMexico2.png");
        programaEntornoSocioeconomico0 = new JLabel();
        programaEntornoSocioeconomico0.setBounds(410, 32, 680, 492);
        programaEntornoSocioeconomico0.setIcon(new ImageIcon(programaEntorno0.getImage().getScaledInstance(programaEntornoSocioeconomico0.getWidth(), programaEntornoSocioeconomico0.getHeight(), Image.SCALE_SMOOTH)));
        programaEntorno1 = new ImageIcon("programaSinteticoEntornoSocioeconomicoDeMexico3.png");
        programaEntornoSocioeconomico1 = new JLabel();
        programaEntornoSocioeconomico1.setBounds(410, 32, 680, 492);
        programaEntornoSocioeconomico1.setIcon(new ImageIcon(programaEntorno1.getImage().getScaledInstance(programaEntornoSocioeconomico1.getWidth(), programaEntornoSocioeconomico1.getHeight(), Image.SCALE_SMOOTH)));
        programaEntorno2 = new ImageIcon("programaSinteticoEntornoSocioeconomicoDeMexico4.png");
        programaEntornoSocioeconomico2 = new JLabel();
        programaEntornoSocioeconomico2.setBounds(410, 32, 680, 492);
        programaEntornoSocioeconomico2.setIcon(new ImageIcon(programaEntorno2.getImage().getScaledInstance(programaEntornoSocioeconomico2.getWidth(), programaEntornoSocioeconomico2.getHeight(), Image.SCALE_SMOOTH)));
        programaEntorno3 = new ImageIcon("programaSinteticoEntornoSocioeconomicoDeMexico5.png");
        programaEntornoSocioeconomico3 = new JLabel();
        programaEntornoSocioeconomico3.setBounds(410, 32, 680, 492);
        programaEntornoSocioeconomico3.setIcon(new ImageIcon(programaEntorno3.getImage().getScaledInstance(programaEntornoSocioeconomico3.getWidth(), programaEntornoSocioeconomico3.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void comunicacion(){
        fundamentosComunicacion = new ImageIcon("fundamentosComunicacionCientifica.png");
        fundamentacionComunicacion = new JLabel();
        fundamentacionComunicacion.setBounds(410, 32, 680, 492);
        fundamentacionComunicacion.setIcon(new ImageIcon(fundamentosComunicacion.getImage().getScaledInstance(fundamentacionEntorno.getWidth(), fundamentacionEntorno.getHeight(), Image.SCALE_SMOOTH)));
        competenciasComunicacion = new ImageIcon("aprendizajesEsperadosComunicacionCientifica.png");
        competenciasComunicacionCientifica = new JLabel();
        competenciasComunicacionCientifica.setBounds(410, 32, 680, 492);
        competenciasComunicacionCientifica.setIcon(new ImageIcon(competenciasComunicacion.getImage().getScaledInstance(competenciasComunicacionCientifica.getWidth(), competenciasComunicacionCientifica.getHeight(), Image.SCALE_SMOOTH)));
        programaComunicacion = new ImageIcon("programaSinteticoComunicacionCientifica.png");
        programaComunicacionCientifica = new JLabel();
        programaComunicacionCientifica.setBounds(410, 32, 680, 492);
        programaComunicacionCientifica.setIcon(new ImageIcon(programaComunicacion.getImage().getScaledInstance(programaComunicacionCientifica.getWidth(), programaComunicacionCientifica.getHeight(), Image.SCALE_SMOOTH)));
        programaComunicacion0 = new ImageIcon("programaSinteticoComunicacionCientifica0.png");
        programaComunicacionCientifica0 = new JLabel();
        programaComunicacionCientifica0.setBounds(410, 32, 680, 492);
        programaComunicacionCientifica0.setIcon(new ImageIcon(programaComunicacion0.getImage().getScaledInstance(programaComunicacionCientifica0.getWidth(), programaComunicacionCientifica0.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void ingles(){
        fundamentosIngles = new ImageIcon("fundamentosInglesIII.png");
        fundamentacionIngles = new JLabel();
        fundamentacionIngles.setBounds(410, 32, 680, 492);
        fundamentacionIngles.setIcon(new ImageIcon(fundamentosIngles.getImage().getScaledInstance(fundamentacionIngles.getWidth(), fundamentacionIngles.getHeight(), Image.SCALE_SMOOTH)));
        fundamentosIngles0 = new ImageIcon("fundamentosInglesIII0.png");
        fundamentacionIngles0 = new JLabel();
        fundamentacionIngles0.setBounds(410, 32, 680, 492);
        fundamentacionIngles0.setIcon(new ImageIcon(fundamentosIngles0.getImage().getScaledInstance(fundamentacionIngles0.getWidth(), fundamentacionIngles0.getHeight(), Image.SCALE_SMOOTH)));
        competenciasIngles = new ImageIcon("aprendizajesEsperadosInglesIII.png");
        competenciasInglesIII = new JLabel();
        competenciasInglesIII.setBounds(410, 32, 680, 492);
        competenciasInglesIII.setIcon(new ImageIcon(competenciasIngles.getImage().getScaledInstance(competenciasInglesIII.getWidth(), competenciasInglesIII.getHeight(), Image.SCALE_SMOOTH)));
        programaIngles = new ImageIcon("programaSinteticoInglesIII.png");
        programaInglesIII = new JLabel();
        programaInglesIII.setBounds(410, 32, 680, 492);
        programaInglesIII.setIcon(new ImageIcon(programaIngles.getImage().getScaledInstance(programaInglesIII.getWidth(), programaInglesIII.getHeight(), Image.SCALE_SMOOTH)));
        programaIngles0 = new ImageIcon("programaSinteticoInglesIII0.png");
        programaInglesIII0 = new JLabel();
        programaInglesIII0.setBounds(410, 32, 680, 492);
        programaInglesIII0.setIcon(new ImageIcon(programaIngles0.getImage().getScaledInstance(programaInglesIII0.getWidth(), programaInglesIII0.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void poo(){
        fundamentosPoo = new ImageIcon("fundamentosProgramacionOrientadaAObjetos.png");
        fundamentacionPoo = new JLabel();
        fundamentacionPoo.setBounds(410, 32, 680, 492);
        fundamentacionPoo.setIcon(new ImageIcon(fundamentosPoo.getImage().getScaledInstance(fundamentacionPoo.getWidth(), fundamentacionPoo.getHeight(), Image.SCALE_SMOOTH)));
        fundamentosPoo0 = new ImageIcon("fundamentosProgramacionOrientadaAObjetos0.png");
        fundamentacionPoo0 = new JLabel();
        fundamentacionPoo0.setBounds(410, 32, 680, 492);
        fundamentacionPoo0.setIcon(new ImageIcon(fundamentosPoo0.getImage().getScaledInstance(fundamentacionPoo0.getWidth(), fundamentacionPoo0.getHeight(), Image.SCALE_SMOOTH)));
        competenciasPoo = new ImageIcon("aprendizajesEsperadosProgramacionOrientadaAObjetos.png");
        competenciasPOO = new JLabel();
        competenciasPOO.setBounds(410, 32, 680, 492);
        competenciasPOO.setIcon(new ImageIcon(competenciasPoo.getImage().getScaledInstance(competenciasPOO.getWidth(), competenciasPOO.getHeight(), Image.SCALE_SMOOTH)));
        programaPoo = new ImageIcon("programaSinteticoProgramacionOrientadaAObjetos.png");
        programaPOO = new JLabel();
        programaPOO.setBounds(410, 32, 680, 492);
        programaPOO.setIcon(new ImageIcon(programaPoo.getImage().getScaledInstance(programaPOO.getWidth(), programaPOO.getHeight(), Image.SCALE_SMOOTH)));
        programaPoo0 = new ImageIcon("programaSinteticoProgramacionOrientadaAObjetos0.png");
        programaPOO0 = new JLabel();
        programaPOO0.setBounds(410, 32, 680, 492);
        programaPOO0.setIcon(new ImageIcon(programaPoo0.getImage().getScaledInstance(programaPOO0.getWidth(), programaPOO0.getHeight(), Image.SCALE_SMOOTH)));
        programaPoo1 = new ImageIcon("programaSinteticoProgramacionOrientadaAObjetos1.png");
        programaPOO1 = new JLabel();
        programaPOO1.setBounds(410, 32, 680, 492);
        programaPOO1.setIcon(new ImageIcon(programaPoo1.getImage().getScaledInstance(programaPOO1.getWidth(), programaPOO1.getHeight(), Image.SCALE_SMOOTH)));
        programaPoo2 = new ImageIcon("programaSinteticoProgramacionOrientadaAObjetos2.png");
        programaPOO2 = new JLabel();
        programaPOO2.setBounds(410, 32, 680, 492);
        programaPOO2.setIcon(new ImageIcon(programaPoo2.getImage().getScaledInstance(programaPOO2.getWidth(), programaPOO2.getHeight(), Image.SCALE_SMOOTH)));
        programaPoo3 = new ImageIcon("programaSinteticoProgramacionOrientadaAObjetos3.png");
        programaPOO3 = new JLabel();
        programaPOO3.setBounds(410, 32, 680, 492);
        programaPOO3.setIcon(new ImageIcon(programaPoo3.getImage().getScaledInstance(programaPOO3.getWidth(), programaPOO3.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void lpti(){
        fundamentosLPTI = new ImageIcon("fundamentosLaboratorioDeProyectosDeTecnologiasDeLaInformacionI.png");
        fundamentacionLPTI = new JLabel();
        fundamentacionLPTI.setBounds(410, 32, 680, 492);
        fundamentacionLPTI.setIcon(new ImageIcon(fundamentosLPTI.getImage().getScaledInstance(fundamentacionLPTI.getWidth(), fundamentacionLPTI.getHeight(), Image.SCALE_SMOOTH)));
        fundamentosLPTI0 = new ImageIcon("fundamentosLaboratorioDeProyectosDeTecnologiasDeLaInformacionI0.png");
        fundamentacionLPTI0 = new JLabel();
        fundamentacionLPTI0.setBounds(410, 32, 680, 492);
        fundamentacionLPTI0.setIcon(new ImageIcon(fundamentosLPTI0.getImage().getScaledInstance(fundamentacionLPTI0.getWidth(), fundamentacionLPTI0.getHeight(), Image.SCALE_SMOOTH)));
        fundamentosLPTI1 = new ImageIcon("fundamentosLaboratorioDeProyectosDeTecnologiasDeLaInformacionI1.png");
        fundamentacionLPTI1 = new JLabel();
        fundamentacionLPTI1.setBounds(410, 32, 680, 492);
        fundamentacionLPTI1.setIcon(new ImageIcon(fundamentosLPTI1.getImage().getScaledInstance(fundamentacionLPTI1.getWidth(), fundamentacionLPTI1.getHeight(), Image.SCALE_SMOOTH)));
        competenciasLPTI = new ImageIcon("aprendizajesEsperadosLaboratorioDeProyectosDeTecnologiasDeLaInformacion.png");
        competenciasLPTII = new JLabel();
        competenciasLPTII.setBounds(410, 32, 680, 492);
        competenciasLPTII.setIcon(new ImageIcon(competenciasLPTI.getImage().getScaledInstance(competenciasLPTII.getWidth(), competenciasLPTII.getHeight(), Image.SCALE_SMOOTH)));
        programaLPTI = new ImageIcon("programaSinteticoLaboratorioDeProyectosDeTecnologiasDeLaInformacionI.png");
        programaLPTII = new JLabel();
        programaLPTII.setBounds(410, 32, 680, 492);
        programaLPTII.setIcon(new ImageIcon(programaLPTI.getImage().getScaledInstance(programaLPTII.getWidth(), programaLPTII.getHeight(), Image.SCALE_SMOOTH)));
        programaLPTI0 = new ImageIcon("programaSinteticoLaboratorioDeProyectosDeTecnologiasDeLaInformacionI0.png");
        programaLPTII0 = new JLabel();
        programaLPTII0.setBounds(410, 32, 680, 492);
        programaLPTII0.setIcon(new ImageIcon(programaLPTI0.getImage().getScaledInstance(programaLPTII0.getWidth(), programaLPTII0.getHeight(), Image.SCALE_SMOOTH)));
        programaLPTI1 = new ImageIcon("programaSinteticoLaboratorioDeProyectosDeTecnologiasDeLaInformacionI1.png");
        programaLPTII1 = new JLabel();
        programaLPTII1.setBounds(410, 32, 680, 492);
        programaLPTII1.setIcon(new ImageIcon(programaLPTI1.getImage().getScaledInstance(programaLPTII1.getWidth(), programaLPTII1.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void apti(){
        fundamentosAPTI = new ImageIcon("fundamentosAdministracionDeProyectosDeTecnologiasDeLaInformacionI.png");
        fundamentacionAPTI = new JLabel();
        fundamentacionAPTI.setBounds(410, 32, 680, 492);
        fundamentacionAPTI.setIcon(new ImageIcon(fundamentosAPTI.getImage().getScaledInstance(fundamentacionAPTI.getWidth(), fundamentacionAPTI.getHeight(), Image.SCALE_SMOOTH)));
        fundamentosAPTI0 = new ImageIcon("fundamentosAdministracionDeProyectosDeTecnologiasDeLaInformacionI0.png");
        fundamentacionAPTI0 = new JLabel();
        fundamentacionAPTI0.setBounds(410, 32, 680, 492);
        fundamentacionAPTI0.setIcon(new ImageIcon(fundamentosAPTI0.getImage().getScaledInstance(fundamentacionAPTI0.getWidth(), fundamentacionAPTI0.getHeight(), Image.SCALE_SMOOTH)));
        competenciasAPTI = new ImageIcon("aprendizajesEsperadosAdministracionDeProyectosDeTecnologiasDeLaInformacionI.png");
        competenciasAPTII = new JLabel();
        competenciasAPTII.setBounds(410, 32, 680, 492);
        competenciasAPTII.setIcon(new ImageIcon(competenciasAPTI.getImage().getScaledInstance(competenciasAPTII.getWidth(), competenciasAPTII.getHeight(), Image.SCALE_SMOOTH)));
        programaAPTI = new ImageIcon("programaSinteticoAdministracionDeProyectosDeTecnologiasDeLaInformacionI.png");
        programaAPTII = new JLabel();
        programaAPTII.setBounds(410, 32, 680, 492);
        programaAPTII.setIcon(new ImageIcon(programaAPTI.getImage().getScaledInstance(programaAPTII.getWidth(), programaAPTII.getHeight(), Image.SCALE_SMOOTH)));
        programaAPTI0 = new ImageIcon("programaSinteticoAdministracionDeProyectosDeTecnologiasDeLaInformacionI0.png");
        programaAPTII0 = new JLabel();
        programaAPTII0.setBounds(410, 32, 680, 492);
        programaAPTII0.setIcon(new ImageIcon(programaAPTI0.getImage().getScaledInstance(programaAPTII0.getWidth(), programaAPTII0.getHeight(), Image.SCALE_SMOOTH)));
        programaAPTI1 = new ImageIcon("programaSinteticoAdministracionDeProyectosDeTecnologiasDeLaInformacionI1.png");
        programaAPTII1 = new JLabel();
        programaAPTII1.setBounds(410, 32, 680, 492);
        programaAPTII1.setIcon(new ImageIcon(programaAPTI1.getImage().getScaledInstance(programaAPTII1.getWidth(), programaAPTII1.getHeight(), Image.SCALE_SMOOTH)));
        programaAPTI2 = new ImageIcon("programaSinteticoAdministracionDeProyectosDeTecnologiasDeLaInformacionI2.png");
        programaAPTII2 = new JLabel();
        programaAPTII2.setBounds(410, 32, 680, 492);
        programaAPTII2.setIcon(new ImageIcon(programaAPTI2.getImage().getScaledInstance(programaAPTII2.getWidth(), programaAPTII2.getHeight(), Image.SCALE_SMOOTH)));
    }
    private void verMaterias(){
    programas = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(geometriaAnalitica);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(fisica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fisica1);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(quimica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(quimica1);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(dibujo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(dibujoTecnicoI);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(entorno.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(entornoSocioEconomico);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(comunicacion.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(cCientifica);
                panelImagenes.add(tituloComunicacion);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(ingles.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(englishIII);
                panelImagenes.add(tituloIngles);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(poo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programacion);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(lpti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(labo);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(apti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(adminI);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
        }
    };
    verFundamentos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentosAnalitica);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(fisica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionFisica);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(quimica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionQuimica);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(dibujo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionDibujo);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(entorno.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionEntorno);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(comunicacion.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionComunicacion);
                panelImagenes.add(tituloComunicacion);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(ingles.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionIngles);
                panelImagenes.add(tituloIngles);              
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(poo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionPoo);
                panelImagenes.add(tituloPoo);             
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(lpti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionLPTI);
                panelImagenes.add(tituloLab);              
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(apti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionAPTI);
                panelImagenes.add(tituloAdmin);            
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
        }
    };
    verCompetencias = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasAnalitica);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(fisica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasFisicaI);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(quimica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasQuimicaI);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(dibujo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasDibujoTecnico);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(entorno.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasEntornoSocioeconomico);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(comunicacion.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasComunicacionCientifica);
                panelImagenes.add(tituloComunicacion);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(ingles.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasInglesIII);
                panelImagenes.add(tituloIngles);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(poo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasPOO);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(lpti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasLPTII);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
            if(apti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(competenciasAPTII);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelUA();
            }
        }
    };
    verPrograma = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAnalitica);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(fisica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaFisicaI);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(quimica.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaQuimicaI);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(dibujo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaDibujoTecnico);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(entorno.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(comunicacion.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaComunicacionCientifica);
                panelImagenes.add(tituloComunicacion);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(ingles.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaInglesIII);
                panelImagenes.add(tituloIngles);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(poo.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(lpti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaLPTII);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(apti.isSelected()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAPTII);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
        }
    };
    programaSintetico.addActionListener(verPrograma);
    fundamentoSiguiente = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected() && fundamentosAnalitica.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentosAnalitica0);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(false);
                panelUA();
            }
            if(fisica.isSelected() && fundamentacionFisica.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionFisica0);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(false);
                panelUA();
            }
            if(ingles.isSelected() && fundamentacionIngles.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionIngles0);
                panelImagenes.add(tituloIngles);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(false);
                panelUA();
            }
            if(poo.isSelected() && fundamentacionPoo.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionPoo0);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(false);
                panelUA();
            }
            if(lpti.isSelected() && fundamentacionLPTI.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionLPTI0);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }else if(lpti.isSelected() && fundamentacionLPTI0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionLPTI1);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(false);
                panelUA();
            }
            if(apti.isSelected() && fundamentacionAPTI.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionAPTI0);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(false);
                panelUA();
            }
        }
    };
    siguienteFundamento.addActionListener(fundamentoSiguiente);
    anteriorFundamento = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected() && programaAnalitica0.isVisible()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentosAnalitica);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(fisica.isSelected() && fundamentacionFisica0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionFisica);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(ingles.isSelected() && fundamentacionIngles0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionIngles);
                panelImagenes.add(tituloIngles);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(poo.isSelected() && fundamentacionPoo0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionPoo);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(lpti.isSelected() && fundamentacionLPTI0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionLPTI);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }else if(lpti.isSelected() && fundamentacionLPTI1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionLPTI0);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(true);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
            if(apti.isSelected() && fundamentacionAPTI0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(fundamentacionAPTI);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentoAnterior);
                panelImagenes.add(siguienteFundamento);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(programaSintetico);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                fundamentoAnterior.setEnabled(false);
                siguienteFundamento.setEnabled(true);
                panelUA();
            }
        }
    };
    fundamentoAnterior.addActionListener(anteriorFundamento);
    siguientePrograma = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected() && programaAnalitica.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAnalitica0);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(analitica.isSelected() && programaAnalitica0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAnalitica1);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(fisica.isSelected() && programaFisicaI.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaFisicaI0);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            } else if(fisica.isSelected() && programaFisicaI0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaFisicaI1);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(quimica.isSelected() && programaQuimicaI.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaQuimicaI0);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(quimica.isSelected() && programaQuimicaI0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaQuimicaI1);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(quimica.isSelected() && programaQuimicaI1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaQuimicaI2);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(dibujo.isSelected() && programaDibujoTecnico.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaDibujoTecnico0);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(dibujo.isSelected() && programaDibujoTecnico0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaDibujoTecnico1);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(entorno.isSelected() && programaEntornoSocioeconomico.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico0);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(entorno.isSelected() && programaEntornoSocioeconomico0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico1);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(entorno.isSelected() && programaEntornoSocioeconomico1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico2);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(entorno.isSelected() && programaEntornoSocioeconomico2.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico3);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(comunicacion.isSelected() && programaComunicacionCientifica.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaComunicacionCientifica0);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(ingles.isSelected() && programaInglesIII.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaInglesIII0);
                panelImagenes.add(tituloIngles);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(poo.isSelected() && programaPOO.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO0);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(poo.isSelected() && programaPOO0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO1);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(poo.isSelected() && programaPOO1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO2);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(poo.isSelected() && programaPOO2.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO3);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(lpti.isSelected() && programaLPTII.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaLPTII0);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(lpti.isSelected() && programaLPTII0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaLPTII1);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
            if(apti.isSelected() && programaAPTII.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAPTII0);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(apti.isSelected() && programaAPTII0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAPTII1);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(apti.isSelected() && programaAPTII1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAPTII2);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(false);
                panelUA();
            }
        }
    };
    siguienteCuartilla.addActionListener(siguientePrograma);
    programaAnterior = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(analitica.isSelected() && programaAnalitica0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAnalitica);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            } else if(analitica.isSelected() && programaAnalitica1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAnalitica0);
                panelImagenes.add(tituloAnalitica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(fisica.isSelected() && programaFisicaI0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaFisicaI);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(fisica.isSelected() && programaFisicaI1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaFisicaI0);
                panelImagenes.add(tituloFisica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(quimica.isSelected() && programaQuimicaI0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaQuimicaI);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(quimica.isSelected() && programaQuimicaI1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaQuimicaI0);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(quimica.isSelected() && programaQuimicaI2.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaQuimicaI1);
                panelImagenes.add(tituloQuimica);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(dibujo.isSelected() && programaDibujoTecnico0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaDibujoTecnico);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(dibujo.isSelected() && programaDibujoTecnico1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaDibujoTecnico0);
                panelImagenes.add(tituloDibujo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(entorno.isSelected() && programaEntornoSocioeconomico0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(entorno.isSelected() && programaEntornoSocioeconomico1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico0);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(entorno.isSelected() && programaEntornoSocioeconomico2.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico1);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(entorno.isSelected() && programaEntornoSocioeconomico3.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaEntornoSocioeconomico2);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(comunicacion.isSelected() && programaComunicacionCientifica0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaComunicacionCientifica);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(ingles.isSelected() && programaInglesIII0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaInglesIII);
                panelImagenes.add(tituloEntorno);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(poo.isSelected() && programaPOO0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(poo.isSelected() && programaPOO1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO0);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(poo.isSelected() && programaPOO2.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO1);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(poo.isSelected() && programaPOO3.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaPOO2);
                panelImagenes.add(tituloPoo);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(lpti.isSelected() && programaLPTII0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaLPTII);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(lpti.isSelected() && programaLPTII1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaLPTII0);
                panelImagenes.add(tituloLab);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
            if(apti.isSelected() && programaAPTII0.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAPTII);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(false);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(apti.isSelected() && programaAPTII1.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAPTII0);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }else if(apti.isSelected() && programaAPTII2.isShowing()){
                panelImagenes.removeAll();
                panelImagenes.repaint();
                panelImagenes.revalidate();
                panelImagenes.add(programaAPTII1);
                panelImagenes.add(tituloAdmin);
                panelImagenes.add(fundamentos);
                panelImagenes.add(competenciasParticulares);
                panelImagenes.add(cuartillaAnterior);
                panelImagenes.add(siguienteCuartilla);
                panelImagenes.repaint();
                panelImagenes.revalidate();
                cuartillaAnterior.setEnabled(true);
                siguienteCuartilla.setEnabled(true);
                panelUA();
            }
        }
    };
    cuartillaAnterior.addActionListener(programaAnterior);
    competenciasParticulares.addActionListener(verCompetencias);
    fundamentos.addActionListener(verFundamentos);
    analitica.addActionListener(programas);
    fisica.addActionListener(programas);
    quimica.addActionListener(programas);
    dibujo.addActionListener(programas);
    entorno.addActionListener(programas);
    comunicacion.addActionListener(programas);
    ingles.addActionListener(programas);
    poo.addActionListener(programas);
    lpti.addActionListener(programas);
    apti.addActionListener(programas);
    }
    private void inciarOyenteRaton(){
    
         MouseListener oyentederaton= new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(e.getSource()==regreso){
                     GuiInicio pag1= new GuiInicio();
                     pag1.setVisible(true);
                     pag1.setUs(getA());
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
         regreso.addMouseListener(oyentederaton);
    }
    public Usuario getA() {
        return a;
    }

    public void setA(Usuario a) {
        this.a = a;
    }
}
