package presentacion;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.SwingConstants.CENTER;

public class PantallaInicio extends JPanel {
    public static final String fondoI = "src/presentacion/imagenes/fondo1.png";
    public static final String fondoI2 = "src/presentacion/imagenes/fondo3.png";
    public static final String fondoI3 = "src/presentacion/imagenes/fondo4.png";
    protected JButton n,jugadores,maquina,continuar,empezar,atras;
    private BufferedImage fondo;
    private JComboBox<Object> Color1, Color2;
    private JLabel jugador1, jugador2,titulo1,titulo2,titulo3;
    private JTextField nombre1, nombre2,tim,porc;
    private JButton[][] boton;
    private JRadioButton radio1,radio2,radio3,radio4;
    private ButtonGroup bg;
    public PantallaInicio(String imagen){
        super(null);
        prepareElemtosIn();
        setFondo(imagen);

    }
    private void setFondo(String root) {
        try {
            fondo = ImageIO.read(new File(root));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void prepareElemtosIn(){
        removeAll();
        setFondo(PantallaInicio.fondoI);
        n = new JButton("JUGAR");
        n.setBounds(374,283,150,50);
        n.setIcon(new ImageIcon("src/presentacion/imagenes/jugar.png"));
        add(n);
        repaint();
    }
    public void prepararElementosModo(){
        removeAll();
        setFondo(PantallaInicio.fondoI);
        continuar = new JButton("CONTINUAR");
        continuar.setBounds(600,400,170,50);
        continuar.setIcon(new ImageIcon("src/presentacion/imagenes/Continuar.png"));
        add(continuar);
        atras = new JButton("atras");
        atras.setBounds(5,10,80,20);
        add(atras);
        titulo1 = new JLabel("DIFICULTAL DEL JUEGO");
        titulo1.setBounds(245,220,150,30);
        add(titulo1);
        bg=new ButtonGroup();
        radio1=new JRadioButton("Normal");
        radio1.setBounds(235,270,100,30);
        add(radio1);
        bg.add(radio1);
        radio2=new JRadioButton("Quicktime");
        radio2.setBounds(235,320,100,30);
        add(radio2);
        bg.add(radio2);
        tim = new JTextField("tiempo de turno");
        tim.setBounds(340,320,100,30);
        add(tim);
        titulo2 = new JLabel("CASILLAS ESPECIALES");
        titulo2.setBounds(500,220,150,30);
        add(titulo2);
        radio3=new JRadioButton("Si");
        radio3.setBounds(500,270,50,30);
        add(radio3);
        bg.add(radio3);
        porc = new JTextField("porcentaje de casillas");
        porc.setBounds(580,270,150,30);
        add(porc);
        radio4=new JRadioButton("No");
        radio4.setBounds(500,320,50,30);
        add(radio4);
        repaint();
    }
    public void prepararElementosJugadores(){
        removeAll();
        setFondo(PantallaInicio.fondoI2);
        atras = new JButton("atras");
        atras.setBounds(5,10,80,20);
        add(atras);
        jugadores = new JButton("Jugador VS Jugador");
        jugadores.setBounds(374,150,170,70);
        jugadores.setIcon(new ImageIcon("src/presentacion/imagenes/Jugador.png"));
        add(jugadores);
        maquina = new JButton("Jugador VS Maquina");
        maquina.setBounds(374,250,170,70);
        maquina.setIcon(new ImageIcon("src/presentacion/imagenes/maquina.png"));
        add(maquina);
        repaint();
    }

    public void areasDates() {
        removeAll();
        setFondo(PantallaInicio.fondoI2);
        JPanel seccionDatos = new JPanel(new GridLayout(2, 3, 5, 5));
        empezar = new JButton("EMPEZAR JUEGO");
        empezar.setBounds(400,350,140,50);
        empezar.setIcon(new ImageIcon("src/presentacion/imagenes/empezar.png"));
        atras = new JButton("atras");
        atras.setBounds(5,10,80,20);
        add(atras);
        jugador1 = new JLabel("Jugador1", CENTER);
        jugador2 = new JLabel("Jugador2", CENTER);
        nombre1 = new JTextField();
        nombre2 = new JTextField();
        Color1 = new JComboBox<>();
        Color1.addItem("");
        Color1.addItem("Rojo");
        Color1.addItem("Negro");
        Color2 = new JComboBox<>();
        Color2.addItem("");
        Color2.addItem("Rojo");
        Color2.addItem("Negro");
        int verticalPadding = (int) (getSize().height * 0.03);
        int horizontalPadding = (int) (getSize().width * 0.05);
        seccionDatos.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding),
                new TitledBorder("INFORMACIÓN")));
        seccionDatos.add(jugador1);
        seccionDatos.add(nombre1);
        seccionDatos.add(Color1);
        seccionDatos.add(jugador2);
        seccionDatos.add(nombre2);
        seccionDatos.add(Color2);
        seccionDatos.setBounds(10,50,850,250);
        seccionDatos.setVisible(true);
        add(seccionDatos);
        add(empezar);
        repaint();
    }

    public void tablero() {
        removeAll();
        setFondo(PantallaInicio.fondoI3);
        Image imagen = new ImageIcon(getClass().getResource("imagenes/EspacionNegro.png")).getImage();
        Image newimag = imagen.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imagenx = new ImageIcon(newimag);
        JPanel jugada = new JPanel(new GridLayout(3, 1, 5, 50));
        JLabel c = new JLabel("Información del juego actual");
        JLabel inf1 = new JLabel("Jugador 1");
        JLabel inf2 = new JLabel("Jugador 2");
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.add(jugada, BorderLayout.CENTER);
        jugada.add(c, BorderLayout.CENTER);
        jugada.add(inf1, BorderLayout.CENTER);
        jugada.add(inf2, BorderLayout.CENTER);
        JPanel juego = new JPanel(new GridLayout(10, 10));
        boton = new JButton[10][10];
        juego.setBounds(5,5,700,470);
        panelIzquierdo.setBounds(700,5,200,470);
        juego.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[0].length; j++) {
                boton[i][j] = new JButton();
                boton[i][j].setBackground(Color.WHITE);
                boton[i][j].setBorderPainted(false);
                boton[i][j].setContentAreaFilled(false);
                boton[i][j].setOpaque(false);
                juego.add(boton[i][j]);
                if (((j % 2 == 0) && (i % 2 != 0)) || ((j % 2 != 0) && (i % 2 == 0))) {
                    boton[i][j].setIcon(imagenx);
                }
            }
        }

        add(juego, BorderLayout.CENTER);
        add(panelIzquierdo);
        repaint();
    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this);
    }



}
