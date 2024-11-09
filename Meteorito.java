import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Meteorito extends Planetas
{
    //Atributos
    //Constructor: 
    public Meteorito(int x, int y)
    {
        super(x,y,"Imagenes/Meteorito.png",0);
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();
        this.dx=1;    
        this.dy=1; 
    }
    public void mover()
    {
         if(this.movimiento==true)
         {
            x+=dx;
            if(this.x>850)
            {
                this.dx=-1;
            }
            if(this.x<1)
            {
                this.dx=1;
            }
            y+=dy;
            if(this.y>630)
            {
                this.dy=-1;
            }
            if(this.y<1)
            {
                this.dy=1;
            } 
         }
    }
}