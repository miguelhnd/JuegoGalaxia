import javax.swing.*;
import java.awt.*;
public class Puntajes
{
    //Atributos
    public static int vidas=3;
    public static int conquistas=0;
    public static int puntaje=0;
    //Constructor: 
    public Puntajes()
    {
        //this.vidas=3;
        //this.conquistas=0;
        //this.puntaje=0;
    }
    //Metodos 
    //Vidas
    public static void setVidasInicio(int vid)
    {
        vidas=vid;
    }
    public static void setVidas(int vid)
    {
        vidas=vidas-vid;
    }
    public static int getVidas()
    {
        return vidas;
    }
    //Conquistas
    public static void setConquistasInicio(int con)
    {
        conquistas=con;
    }
    public static void setConquistas(int con)
    {
        conquistas=conquistas+con;
    }
    public static int getConquistas()
    {
        return conquistas;
    }
    //Puntaje
    public static void setPuntajeInicio(int pun)
    {
        puntaje=pun;
    }
    public static void setPuntaje(int pun)
    {
        puntaje=puntaje+pun;
    }
    public static int getPuntaje()
    {
        return puntaje;
    }
}