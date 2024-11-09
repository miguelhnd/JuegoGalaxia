import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Aliens extends Seres
{
    //Atributos
    //Constructor: 
    public Aliens(int x, int y)
    {
        super(x,y,"Imagenes/Enemigos.png");
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();
        this.visible=0;
        this.dx=1;    
    }
    public void mover()
    {
        this.y++;
        if((this.y>180)&&(disparar==false)) 
        {
            this.visible=1;
        }
        if(this.y>posicion) 
        {
            y=posicion;
            disparar=true;
        }     
        if((this.y==posicion)&&(this.x>699))
        {
            x+=dx;
            if(this.x>940)
            {
                this.dx=-1;
            }                   
            if(this.x<701)
            {
                this.dx=1;
            } 
        } 
    }
}