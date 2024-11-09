import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Humanos extends Seres
{
    //Atributos
    protected boolean llegada;
    //Constructor: 
    public Humanos(int x, int y)
    {
        super(x,y,"Imagenes/Humano.png");
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();   
        this.llegada=false;
        this.visible=0;
    }
    public void mover()
    {
        if(this.y<301)
        {
            this.y++;
        }
        if(this.y>150)
        {
            this.visible=1;
        }
        if(this.y==300)
        {
            this.llegada=true;
        }
        if(this.llegada==true)
        {
            this.y+=dy;
            if(this.y<300) 
            {
                y=301;
            }     
            if(this.y>550)
            {
                y=549;
            } 
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