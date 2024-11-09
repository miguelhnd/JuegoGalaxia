import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class EscenarioNivel2 extends JPanel implements ActionListener, KeyListener
{
    // Atributos 
    private NaveAmiga NaveA;
    private PlanetaTierra PlanetaT;
    private PlanetaJupiter PlanetaJ;
    private Sol PlanetaSol;
    private Meteorito Met[];
    private Rotulacion RNivel2;
    private Rotulacion RBienvenida;
    private Rotulacion RPerdedor;
    private Rotulacion RVidas;
    private Rotulacion RConquistas;
    private Rotulacion RGanador;
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
    public EscenarioNivel2(JFrame marco, String PlanetaConquistado)
    {
        this.marco=marco;
        this.y=0;
        this.x=0;
        Icono=new ImageIcon("Imagenes/Fondo2.jpg");
        FondoPantalla=Icono.getImage();
        this.r=new Random();
        this.PosX=this.r.nextInt(4000)+250;
        this.PosY=this.r.nextInt(500)+5;
        this.comprobar=true;
        
        NaveA=new NaveAmiga(5,270);
        PlanetaT=new PlanetaTierra(PosX,PosY,this.r.nextInt(2));
        PlanetaJ=new PlanetaJupiter(r.nextInt(4000)+250,r.nextInt(500)+5,this.r.nextInt(2));
        PlanetaSol=new Sol(r.nextInt(4000)+250,r.nextInt(500)+5,this.r.nextInt(2));
        Met=new Meteorito[10];
        for(int i=0; i<Met.length; i++)
        {
            Met[i]=new Meteorito(r.nextInt(4000)+250,r.nextInt(500)+5);
        }
        
        RNivel2=new Rotulacion(840,5,"Nivel2");
        RNivel2.setVisible(1);
        RBienvenida=new Rotulacion(220,250,"Bienvenida2");
        RBienvenida.setVisible(1);
        RPerdedor=new Rotulacion(220,250,"GameOver");
        RPerdedor.setVisible(0);
        RVidas=new Rotulacion(10,5,"Vidas");
        RVidas.setVisible(1);
        RConquistas=new Rotulacion(170,5,"Conquista");
        RConquistas.setVisible(1);
        RGanador=new Rotulacion(220,250,"Ganador");
        RGanador.setVisible(0);
        
        if(PlanetaConquistado=="PlanetaTierra")
            PlanetaT.setConquistado(true);
        if(PlanetaConquistado=="PlanetaJupiter")
            PlanetaJ.setConquistado(true);
        if(PlanetaConquistado=="PlanetaSol")
            PlanetaSol.setConquistado(true); 
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
        PlanetaT.dibujar(g);
        PlanetaJ.dibujar(g);
        PlanetaSol.dibujar(g);
        for(int i=0; i<Met.length; i++)
        {
            Met[i].dibujar(g);
        }
        RNivel2.dibujar(g);
        RBienvenida.dibujar(g);
        RPerdedor.dibujar(g);
        RVidas.dibujar(g);
        RConquistas.dibujar(g);
        RGanador.dibujar(g);
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
            PlanetaT.mover();
            PlanetaJ.mover();
            PlanetaSol.mover();
            for(int i=0; i<Met.length; i++)
            {
                Met[i].mover();
            }
        }
        if(comprobar==true)
        { 
            for(int i=0; i<Met.length; i++)
            {
                if((NaveA.detectar(PlanetaT.getRectangle()))&&(PlanetaT.getConquistado()==false))
                {
                    PlanetaT.setMovimiento(false);
                    PlanetaT.setX(-1000);
                    PlanetaT.setY(-1000);
                    NaveA.setMovimiento(false);
                    NaveA.setX(-2000);
                    NaveA.setY(-2000);
                    new Principal(this.marco,2,"EscenarioTierra",PlanetaT.getHabitado(),PlanetaT.getConquistado()); 
                }  
                if((NaveA.detectar(PlanetaJ.getRectangle()))&&(PlanetaJ.getConquistado()==false))
                {
                    PlanetaJ.setMovimiento(false);
                    PlanetaJ.setX(-1000);
                    PlanetaJ.setY(-1000);
                    NaveA.setMovimiento(false);
                    NaveA.setX(-2000);
                    NaveA.setY(-2000);
                    new Principal(this.marco,2,"EscenarioJupiter",PlanetaJ.getHabitado(),PlanetaJ.getConquistado()); 
                }  
                if((NaveA.detectar(PlanetaSol.getRectangle()))&&(PlanetaSol.getConquistado()==false))
                {
                    PlanetaSol.setMovimiento(false);
                    PlanetaSol.setX(-1000);
                    PlanetaSol.setY(-1000);
                    NaveA.setMovimiento(false);
                    NaveA.setX(-2000);
                    NaveA.setY(-2000);
                    new Principal(this.marco,2,"EscenarioSol",PlanetaSol.getHabitado(),PlanetaSol.getConquistado()); 
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
                        PlanetaT.setMovimiento(false);
                        PlanetaJ.setMovimiento(false);
                        PlanetaSol.setMovimiento(false);
                        RPerdedor.setVisible(1);
                        Puntajes.setVidasInicio(3);
                        Puntajes.setConquistasInicio(0);
                        Puntajes.setPuntajeInicio(0);
                        JOptionPane.showMessageDialog(null,"Fuiste alcanzado por un meteorito,\nNo tienes mas vidas disponibles.");
                        new Principal();
                        marco.dispose();   
                    }                        
                }  
                if((PlanetaT.getConquistado()==true)&&(PlanetaJ.getConquistado()==true)&&(PlanetaSol.getConquistado()==true))
                {
                    JOptionPane.showMessageDialog(null,"Felicidades has completado el NIVEL 2.\n Vidas restantes "+Puntajes.getVidas()+"\n Planetas Conquistados "+Puntajes.getConquistas()+
                    "\n Total de puntos "+Puntajes.getPuntaje());
                    new Principal();
                    marco.dispose(); 
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