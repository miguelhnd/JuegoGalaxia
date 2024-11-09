import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class NaveEnemiga3 extends Naves
{
    //Atributos
    //Constructor: 
    public NaveEnemiga3(int x, int y)
    {
        super(x,y,"Imagenes/NaveEnemiga3.png");
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();
        this.visible=0; 
    }
    public void mover()
    {
        if(this.movimiento==true)
        {
            this.y++;
            if(this.y>0) 
            {
                this.visible=1;
            }
            if(this.y>150) 
            {
                y=150;
            }
        }
    }
}