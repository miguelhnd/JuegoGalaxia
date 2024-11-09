import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class EscenarioMercurio extends JPanel implements ActionListener, KeyListener
{
    // Atributos 
    private Rotulacion RNivel1;
    private Rotulacion RVidas;
    private Rotulacion RConquistas;
    private Rotulacion RPerdedor;
    private NaveAmiga NaveA;
    private NaveEnemiga3 NaveE3;
    private Humanos Humano;
    private Balas BalaHumano[];
    private Aliens Enemigos[];
    private Balas BalaEnemigo[];
    private ImageIcon Icono;
    private Image FondoPantalla;
    private Timer t;
    private Random r;
    private int x;
    private int y;
    private int PosX;
    private int PosY;
    private int PosYHumano;
    private int PlanetaHabitado;
    private boolean comprobar;
    private int VidasEnemigas;
    private JFrame marco;
    // Constructores
    public EscenarioMercurio(JFrame marco, int habi, boolean conquistado)
    {
        this.marco=marco;
        this.y=0;
        this.x=0;
        Icono=new ImageIcon("Imagenes/FondoMercurio.jpg");
        FondoPantalla=Icono.getImage();
        this.r=new Random();
        this.PlanetaHabitado=habi;
        this.comprobar=true;
        this.VidasEnemigas=20;
        
        this.PosYHumano=r.nextInt(100)-300;
        Humano=new Humanos(20,PosYHumano);
        NaveA=new NaveAmiga(20,150);
        BalaHumano=new Balas[300];
        for(int i=0; i<BalaHumano.length; i++)
        {
            BalaHumano[i]=new Balas(r.nextInt(2000)-4000,PosYHumano+30,0,"BalaAmiga");
        }
        if(PlanetaHabitado==1)
        {
            NaveE3=new NaveEnemiga3(700,r.nextInt(500)-1000);
            Enemigos=new Aliens[20];
            BalaEnemigo=new Balas[20];
            for(int i=0; i<Enemigos.length; i++)
            {
                this.PosX=r.nextInt(150)+700;
                this.PosY=r.nextInt(500)-2000;
                Enemigos[i]=new Aliens(PosX,PosY);
                BalaEnemigo[i]=new Balas(PosX,PosY,Enemigos[i].getPosicion(),"BalaEnemiga");
            }
        }
        
        RNivel1=new Rotulacion(840,5,"Nivel1");
        RNivel1.setVisible(1);
        RVidas=new Rotulacion(10,5,"Vidas");
        RVidas.setVisible(1);
        RConquistas=new Rotulacion(170,5,"Conquista");
        RConquistas.setVisible(1);
        RPerdedor=new Rotulacion(220,250,"GameOver");
        RPerdedor.setVisible(0);
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
        Humano.dibujar(g);
        NaveA.dibujar(g);
        for(int i=0; i<BalaHumano.length; i++)
        {
            BalaHumano[i].dibujar(g);
        }
        if(PlanetaHabitado==1)
        {
            NaveE3.dibujar(g);
            for(int i=0; i<Enemigos.length; i++)
            {
                Enemigos[i].dibujar(g);
                BalaEnemigo[i].dibujar(g);
            }
        }
        RNivel1.dibujar(g);
        RVidas.dibujar(g);
        RConquistas.dibujar(g);
        RPerdedor.dibujar(g);
        repaint();
    }
    public void actionPerformed(ActionEvent e)
    {
        this.x-=1;
        if(this.x<=-2200)
        {
            this.x=0;
        }
        Humano.mover();
        NaveA.mover();
        for(int j=0; j<BalaHumano.length; j++)
        {
            BalaHumano[j].mover();
        }
        if(comprobar==true)
        { 
            if(PlanetaHabitado==1)
            {
                NaveE3.mover();
                for(int i=0; i<Enemigos.length; i++)
                {
                    Enemigos[i].mover();
                    BalaEnemigo[i].mover();
                    if(BalaEnemigo[i].detectar(Humano.getRectangle()))
                    {
                        if((Puntajes.getVidas()==3)||(Puntajes.getVidas()==2)||(Puntajes.getVidas()==1))
                        {
                            BalaEnemigo[i].setX(-100);
                            Puntajes.setVidas(1);
                            JOptionPane.showMessageDialog(null,"Perdiste una vida.");
                        }
                        if(Puntajes.getVidas()==0)
                        {
                            RPerdedor.setVisible(1);
                            Puntajes.setVidasInicio(3);
                            Puntajes.setConquistasInicio(0);
                            Puntajes.setPuntajeInicio(0);
                            JOptionPane.showMessageDialog(null,"Has perdido la partida,\nNo tienes mas vidas disponibles.");
                            new Principal();
                            marco.dispose();   
                            comprobar=false;
                        }         
                    }
                    for(int j=0; j<BalaHumano.length; j++)
                    {
                       if(BalaHumano[j].detectar(Enemigos[i].getRectangle()))
                       {
                           if(this.VidasEnemigas>0)
                           {
                               Enemigos[i].setX(6000);
                               this.VidasEnemigas=this.VidasEnemigas-1;
                           }
                           if(this.VidasEnemigas==0)
                           {
                               JOptionPane.showMessageDialog(null,"Planeta Mercurio conquistado. Has ganado 10 puntos.");
                               Puntajes.setConquistas(1);
                               Puntajes.setPuntaje(10);
                               new Principal(this.marco,1,"PlanetaMercurio"); 
                               comprobar=false;
                           }
                       }
                       if(BalaHumano[j].detectar(BalaEnemigo[i].getRectangle()))
                       {
                           BalaHumano[j].setX(7000);
                           BalaEnemigo[i].setX(8000);
                       }
                    }  
                }
            }
            else if(PlanetaHabitado==0)
            {
                JOptionPane.showMessageDialog(null,"Planeta Mercurio deshabitado. Has ganado 10 puntos.");
                Puntajes.setConquistas(1);
                Puntajes.setPuntaje(10);
                new Principal(this.marco,1,"PlanetaMercurio"); 
                comprobar=false;
            }
        }
    }
    public void keyPressed(KeyEvent ev)
    {      
        Humano.keyPressed(ev);
        for(int i=0; i<BalaHumano.length; i++)
        {
            BalaHumano[i].keyPressed(ev);
        }
    }
    public void keyReleased(KeyEvent ev)
    {   
        Humano.keyReleased(ev);
        for(int i=0; i<BalaHumano.length; i++)
        {
            BalaHumano[i].keyReleased(ev);
        }
    }
    public void keyTyped(KeyEvent ev)
    {
    }
}
