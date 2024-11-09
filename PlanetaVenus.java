import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class PlanetaVenus extends Planetas
{
    //Atributos
    //Constructor: 
    public PlanetaVenus(int x, int y, int habi)
    {
        super(x,y,"Imagenes/PlanetaVenus.png",habi);
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();
        this.dx=1;
        this.dy=2;
    }
    public void mover()
    {
         if(this.movimiento==true)
         {
            x+=dx;
            if(this.x>790)
            {
                this.dx=-1;
            }
            if(this.x<1)
            {
                this.dx=1;
            }
            y+=dy;
            if(this.y>500)
            {
                this.dy=-1;
            }
            if(this.y<1)
            {
                this.dy=1;
            } 
         }
         if(this.conquistado==true)
         {
             this.icono=new ImageIcon("Imagenes/PlanetaVenusConquista.png");
             this.img=icono.getImage();
             this.alto=icono.getIconHeight();
             this.ancho=icono.getIconWidth();
         }
    }
}