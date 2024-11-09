import javax.swing.*;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class EscenarioNivel1 extends JPanel implements ActionListener, KeyListener
{
    // Atributos 
    private NaveAmiga NaveA;
    public PlanetaMarte PlanetaM;
    private PlanetaVenus PlanetaV;
    private PlanetaMercurio PlanetaMer;
    private Meteorito Met[];
    private Rotulacion RNivel1;
    private Rotulacion RBienvenida;
    private Rotulacion RPerdedor;
    private Rotulacion RVidas;
    private Rotulacion RConquistas;
    private ImageIcon Icono;
    private Image FondoPantalla;
    private Timer t;
    private Random r;
    private int PosX;
    private int PosY;
    private int x;
    private int y;
    private boolean comprobar;
    private JFrame marco;
    // Constructores
    public EscenarioNivel1(JFrame marco, String PlanetaConquistado)
    {
        this.marco=marco;
        this.y=0;
        this.x=0;
        Icono=new ImageIcon("Imagenes/Fondo1.jpg");
        FondoPantalla=Icono.getImage();
        this.r=new Random();
        this.PosX=this.r.nextInt(4000)+250;
        this.PosY=this.r.nextInt(500)+5;
        this.comprobar=true;
        
        NaveA=new NaveAmiga(5,270);
        PlanetaM=new PlanetaMarte(PosX,PosY,this.r.nextInt(2));
        PlanetaV=new PlanetaVenus(r.nextInt(4000)+250,r.nextInt(500)+5,this.r.nextInt(2));
        PlanetaMer=new PlanetaMercurio(r.nextInt(4000)+250,r.nextInt(500)+5,this.r.nextInt(2));
        Met=new Meteorito[10];
        for(int i=0; i<Met.length; i++)
        {
            Met[i]=new Meteorito(r.nextInt(4000)+250,r.nextInt(500)+5);
        }

        RNivel1=new Rotulacion(840,5,"Nivel1");
        RNivel1.setVisible(1);
        RBienvenida=new Rotulacion(220,250,"Bienvenida1");
        RBienvenida.setVisible(1);
        RPerdedor=new Rotulacion(220,250,"GameOver");
        RPerdedor.setVisible(0);
        RVidas=new Rotulacion(10,5,"Vidas");
        RVidas.setVisible(1);
        RConquistas=new Rotulacion(170,5,"Conquista");
        RConquistas.setVisible(1);
        
        if(PlanetaConquistado=="PlanetaMarte")
            PlanetaM.setConquistado(true);
        if(PlanetaConquistado=="PlanetaVenus")
            PlanetaV.setConquistado(true);
        if(PlanetaConquistado=="PlanetaMercurio")
            PlanetaMer.setConquistado(true);   
        //Activar el Timer.
        t=new Timer(5,null);
        t.addActionListener(this);
        t.start();
        //Add KeyListener.        
        addKeyListener(this);
        setFocusable(true);  
        setSize(897,720);
        setVisible(true);
        //Estilos de JOPtionPane
        UIManager Formato=new UIManager();
        Formato.put("OptionPane.background", Color.black);
        Formato.put("Panel.background", Color.black);
        Formato.put("OptionPane.messageForeground", Color.white);        
        Font TamanoFuente = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        UIManager.put("OptionPane.messageFont", TamanoFuente);
        UIManager.put("OptionPane.buttonFont", TamanoFuente);
    }
    // Metodos 
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2=(Graphics2D) g;
        g2.drawImage(this.FondoPantalla,this.x,this.y,this);
        NaveA.dibujar(g);
        PlanetaM.dibujar(g);
        PlanetaV.dibujar(g);
        PlanetaMer.dibujar(g);
        for(int i=0; i<Met.length; i++)
        {
            Met[i].dibujar(g);
        }
        RNivel1.dibujar(g);
        RBienvenida.dibujar(g);
        RPerdedor.dibujar(g);
        RVidas.dibujar(g);
        RConquistas.dibujar(g);
        repaint();
    }
    public void actionPerformed(ActionEvent e)
    {
        this.x-=1;
        if(this.x<=-2200)
        {
            this.x=0;
        }
        NaveA.mover();
        if((NaveA.getX()>20)||(NaveA.getY()>280)||(NaveA.getY()<270))
        {
            RBienvenida.setVisible(0);
        }
        if(RBienvenida.getVisible()==0)
        {
            PlanetaM.mover();
            PlanetaV.mover();
            PlanetaMer.mover();
            for(int i=0; i<Met.length; i++)
            {
                Met[i].mover();
            }
        }
        if(comprobar==true)
        { 
            for(int i=0; i<Met.length; i++)
            {
                if((NaveA.detectar(PlanetaM.getRectangle()))&&(PlanetaM.getConquistado()==false))
                {
                    PlanetaM.setMovimiento(false);
                    PlanetaM.setX(-1000);
                    PlanetaM.setY(-1000);
                    NaveA.setMovimiento(false);
                    NaveA.setX(-2000);
                    NaveA.setY(-2000);
                    new Principal(this.marco,1,"EscenarioMarte",PlanetaM.getHabitado(),PlanetaM.getConquistado()); 
                }  
                if((NaveA.detectar(PlanetaV.getRectangle()))&&(PlanetaV.getConquistado()==false))
                {
                    PlanetaV.setMovimiento(false);
                    PlanetaV.setX(-1000);
                    PlanetaV.setY(-1000);
                    NaveA.setMovimiento(false);
                    NaveA.setX(-2000);
                    NaveA.setY(-2000);
                    new Principal(this.marco,1,"EscenarioVenus",PlanetaV.getHabitado(),PlanetaV.getConquistado()); 
                }  
                if((NaveA.detectar(PlanetaMer.getRectangle()))&&(PlanetaMer.getConquistado()==false))
                {
                    PlanetaMer.setMovimiento(false);
                    PlanetaMer.setX(-1000);
                    PlanetaMer.setY(-1000);
                    NaveA.setMovimiento(false);
                    NaveA.setX(-2000);
                    NaveA.setY(-2000);
                    new Principal(this.marco,1,"EscenarioMercurio",PlanetaMer.getHabitado(),PlanetaMer.getConquistado()); 
                }  
                if(NaveA.detectar(Met[i].getRectangle()))
                {
                    if((Puntajes.getVidas()==3)||(Puntajes.getVidas()==2)||(Puntajes.getVidas()==1))
                    {
                        Met[i].setX(1500); 
                        Met[i].setY(270);
                        Puntajes.setVidas(1);
                        JOptionPane.showMessageDialog(null,"Fuiste alcanzado por un meteorito.");
                    }
                    if(Puntajes.getVidas()==0)
                    {
                        NaveA.setMovimiento(false);
                        NaveA.setVisible(0);
                        NaveA.setX(-1000); 
                        NaveA.setY(-1000);
                        PlanetaM.setMovimiento(false);
                        PlanetaV.setMovimiento(false);
                        PlanetaMer.setMovimiento(false);
                        RPerdedor.setVisible(1);
                        Puntajes.setVidasInicio(3);
                        Puntajes.setConquistasInicio(0);
                        Puntajes.setPuntajeInicio(0);
                        JOptionPane.showMessageDialog(null,"Fuiste alcanzado por un meteorito,\nNo tienes mas vidas disponibles.");
                        new Principal();
                        marco.dispose();   
                    }                        
                }   
                if((PlanetaM.getConquistado()==true)&&(PlanetaV.getConquistado()==true)&&(PlanetaMer.getConquistado()==true))
                {
                    JOptionPane.showMessageDialog(null,"Felicidades has completado el NIVEL 1.");
                    new Principal(this.marco,2,""); 
                    comprobar=false;
                }
            }
        }
    }
    public void keyPressed(KeyEvent ev)
    {      
        NaveA.keyPressed(ev);
    }
    public void keyReleased(KeyEvent ev)
    {   
        NaveA.keyReleased(ev);
    }
    public void keyTyped(KeyEvent ev)
    {
    }
}