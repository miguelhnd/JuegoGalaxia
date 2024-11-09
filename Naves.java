import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Naves
{
    //Atributos
    protected int x;
    protected int y;
    protected Image img;
    protected ImageIcon icono;
    protected int ancho;
    protected int alto;
    protected int visible;
    protected int dx;
    protected int dy;
    protected int xmax;
    protected int xmin;
    protected int ymax;
    protected int ymin;
    protected boolean movimiento;
    protected Rectangle rect;
    Random r;
    //Constructor: 
    public Naves(int x, int y, String ima)
    {
        this.x=x;
        this.y=y;
        this.icono=new ImageIcon(ima);
        this.alto=icono.getIconHeight();
        this.ancho=icono.getIconWidth();
        this.img=icono.getImage();
        this.visible=1;    
        this.xmax=x;
        this.xmin=x;
        this.ymax=y;
        this.ymin=y;
        this.dx=0;
        this.dy=0;
        this.movimiento=true;
    }
    //Metodos 
    public void dibujar(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(this.visible==1)
        {
            g2.drawImage(this.img,this.x,this.y,null);
        }
        //g2.setColor(Color.black);
        //g2.drawRect(this.x, this.y, this.ancho, this.alto);
    }
    public boolean detectar(Rectangle r)
    {
        this.rect=new Rectangle(this.x,this.y,this.ancho,this.alto);
        return rect.intersects(r);
    }
    public Rectangle getRectangle()
    {
        return this.rect=new Rectangle(this.x, this.y, this.ancho, this.alto);
    }
    public void setVisible(int v)
    {
        this.visible=v;
    }
    public int getVisible()
    {
        return this.visible;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public boolean getMovimiento()
    {
        return this.movimiento;
    }
    public void setX(int num)
    {
        this.x=num;
    }
    public void setY(int num)
    {
        this.y=num;
    }
    public void setMovimiento(boolean mov)
    {
        this.movimiento=mov;
    }
}