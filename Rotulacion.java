import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
public class Rotulacion
{
    //Atributos
    protected int x;
    protected int y;
    protected int visible;
    protected Image Img;
    protected ImageIcon Icono;
    //Constructor
    public Rotulacion(int x, int y, String tipo)
    {
        this.x=x;
        this.y=y;
        if(tipo=="Bienvenida1")
        {
            this.Icono=new ImageIcon("Imagenes/Rotulacion/Bienvenida1.png");
        }
        else if(tipo=="Bienvenida2")
        {
            this.Icono=new ImageIcon("Imagenes/Rotulacion/Bienvenida1.png");
        }
        else if(tipo=="Nivel1")
        {
            this.Icono=new ImageIcon("Imagenes/Rotulacion/Nivel1.gif");
        }
        else if(tipo=="Nivel2")
        {
            this.Icono=new ImageIcon("Imagenes/Rotulacion/Nivel2.gif");
        }
        else if(tipo=="GameOver")
        {
            this.Icono=new ImageIcon("Imagenes/Rotulacion/GameOver.png");
        }
        else if(tipo=="Ganador")
        {
            this.Icono=new ImageIcon("Imagenes/Rotulacion/Ganador.png");
        }
        else if(tipo=="Conquista")
        {
            if(Puntajes.getConquistas()==0)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Conquista0.png");
            else if(Puntajes.getConquistas()==1)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Conquista1.png");
            else if(Puntajes.getConquistas()==2)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Conquista2.png");
            else if(Puntajes.getConquistas()==3)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Conquista3.png");
            else if(Puntajes.getConquistas()==4)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Conquista4.png");
            else if(Puntajes.getConquistas()==5)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Conquista5.png");
            else if(Puntajes.getConquistas()==6)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Conquista6.png");
        }
        else if(tipo=="Vidas")
        {
            if(Puntajes.getVidas()==0)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Vidas0.png");
            else if(Puntajes.getVidas()==1)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Vidas1.png");
            else if(Puntajes.getVidas()==2)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Vidas2.png");
            else if(Puntajes.getVidas()==3)
                this.Icono=new ImageIcon("Imagenes/Rotulacion/Vidas3.png");
        }
        this.Img=Icono.getImage();
        this.visible=0;
    }
    //Metodos
    public void dibujar(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(this.visible==1)
        {
            g2.drawImage(this.Img,this.x,this.y,null);
        }
    }
    public void setVisible(int v)
    {
        this.visible=v;
    }
    public int getVisible()
    {
        return this.visible;
    }
}
