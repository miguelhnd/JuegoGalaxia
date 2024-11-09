import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class NaveAmiga extends Naves
{
    //Atributos
    //Constructor: 
    public NaveAmiga(int x, int y)
    {
        super(x,y,"Imagenes/NaveAmiga.png");
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();
    }
    public void mover()
    {
        if(this.movimiento==true)
        {
            this.x+=dx;
            if(this.x<0) 
            {
                x=1;
            }     
            if(this.x>800)
            {
                x=799;
            }
            this.y+=dy;
            if(this.y<0) 
            {
                y=1;
            }     
            if(this.y>600)
            {
                y=599;
            }
        }
    } 
    public void keyPressed(KeyEvent ev)
    {
        int tecla=ev.getKeyCode();
        if(tecla==KeyEvent.VK_LEFT)
        {
            this.dx=-5;
        }
        if(tecla==KeyEvent.VK_RIGHT)
        {
            this.dx+=5;
        }
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
         if ((tecla==KeyEvent.VK_LEFT)||(tecla==KeyEvent.VK_RIGHT))
         {
             this.dx=0;
         }
         if ((tecla==KeyEvent.VK_UP)||(tecla==KeyEvent.VK_DOWN))
         {
             this.dy=0;
         }
    }
}