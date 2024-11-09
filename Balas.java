import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Balas extends Seres
{
    //Atributos
    private String TipoBala;
    private int MovIzq;
    private int MovDer;
    private int Disparar;
    private boolean llegada;
    //Constructor: 
    public Balas(int x, int y, int pos, String tipo)
    {
        super(x,y,"Imagenes/balavacia.png");
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();
        this.posicion=pos;
        this.TipoBala=tipo;
        this.MovIzq=-2;    
        this.MovDer=2;
        this.Disparar=0;
    }
    public void mover()
    {
        if(this.TipoBala=="BalaEnemiga")
        {
            this.y++;
            if(this.y>posicion)
            {
                this.y=posicion;
                this.x+=MovIzq;  
                this.icono=new ImageIcon("Imagenes/BalaEnemigo.png");
                this.img=icono.getImage();
            }
        }
        else if(this.TipoBala=="BalaAmiga")
        {
            if(this.y<330)
            {
                this.y++;
            }
            if(this.y>325)
            {
                this.llegada=true;
                this.icono=new ImageIcon("Imagenes/BalaAmiga.png");
                this.img=icono.getImage();
            }
            if((this.llegada==true)&&(this.x<60))
            {
                this.visible=0;
                this.y+=dy;
                if(this.y<325) 
                {
                    y=326;
                }     
                if(this.y>580)  
                {
                    y=579;
                } 
            }
            if((this.x>60)&&(this.x<80))
            {
                this.visible=1;
            }
            x++;
        }  
    }
    public void keyPressed(KeyEvent ev)
    {
        int tecla=ev.getKeyCode();
        if(tecla==KeyEvent.VK_UP)
        {
            this.dy=-5;
        }
        if(tecla==KeyEvent.VK_DOWN)
        {
            this.dy+=5;
        }
    } 
    public void keyReleased(KeyEvent ev)
    {
         int tecla=ev.getKeyCode();
         if ((tecla==KeyEvent.VK_UP)||(tecla==KeyEvent.VK_DOWN))
         {
             this.dy=0;
         }
    }
}
