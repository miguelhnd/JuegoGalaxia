import javax.swing.*;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;
public class Principal extends JFrame
{
    //Atributos
    private EscenarioNivel1 ENivel1;
    private EscenarioNivel2 ENivel2;
    private EscenarioMarte EMarte;
    private EscenarioVenus EVenus;
    private EscenarioMercurio EMercurio;
    private EscenarioTierra ETierra; 
    private EscenarioJupiter EJupiter; 
    private EscenarioSol ESol;
    private static ImageIcon ImagenEntrada;
    public Principal()
    {
        ENivel1 = new EscenarioNivel1(this,"");
        add(ENivel1);
        setResizable(false);
        setSize(1000,700);
        setVisible(true);
    }
    public Principal(JFrame marco, int nivel, String planeta, int habi, boolean conquistado)
    {
        marco.dispose();
        if(nivel==1)
        {
            if(planeta=="EscenarioMarte")
            {
                EMarte = new EscenarioMarte(this,habi,conquistado);
                add(EMarte);
            }
            else if(planeta=="EscenarioVenus")
            {
                EVenus = new EscenarioVenus(this,habi,conquistado);
                add(EVenus);
            }
            else if(planeta=="EscenarioMercurio")
            {
                EMercurio = new EscenarioMercurio(this,habi,conquistado);
                add(EMercurio);
            }
        }
        else if(nivel==2)
        {
            if(planeta=="EscenarioTierra")
            {
                ETierra = new EscenarioTierra(this,habi,conquistado);
                add(ETierra);
            }
            else if(planeta=="EscenarioJupiter")
            {
                EJupiter = new EscenarioJupiter(this,habi,conquistado);
                add(EJupiter);
            }
            else if(planeta=="EscenarioSol")
            {
                ESol = new EscenarioSol(this,habi,conquistado);
                add(ESol);
            }
        }
        setResizable(false);
        setSize(1000,700);
        setVisible(true);
    }
    public Principal(JFrame marco, int nivel, String PlanetaConquistado)
    {
        marco.dispose();
        if(nivel==1)
        {
            ENivel1 = new EscenarioNivel1(this,PlanetaConquistado);
            add(ENivel1);
        }
        else if(nivel==2)
        {
            ENivel2 = new EscenarioNivel2(this,PlanetaConquistado);
            add(ENivel2);
        }
        setResizable(false);
        setSize(1000,700);
        setVisible(true);
    }
    public static void main(String args[])
    {
        //Estilos de JOPtionPane
        UIManager Formato=new UIManager();
        Formato.put("OptionPane.background", Color.black);
        Formato.put("Panel.background", Color.black);
        Formato.put("OptionPane.messageForeground", Color.white);        
        Font TamanoFuente = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        UIManager.put("OptionPane.messageFont", TamanoFuente);
        UIManager.put("OptionPane.buttonFont", TamanoFuente);
        //Inicio del Juego
        ImagenEntrada= new ImageIcon("Imagenes/Intro01.gif");  
        JOptionPane.showMessageDialog(null,"","     Batalla Espacial: Primera Parte     -     Programación Orientada a Objetos",1,ImagenEntrada);    
        new Principal();
    }
}