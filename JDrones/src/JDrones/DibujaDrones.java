package JDrones;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.ArrayList;
public class DibujaDrones extends JPanel{
    private int aux;
    private int divisiones;
    private int x;
    private int y;
    private NumDron n;
    private BufferedImage ima;
    private ArrayList<Ellipse2D> circulos;
    
    
    Graphics2D g2;
    DibujaDrones(BufferedImage ima){
        setBackground(Color.GREEN);
        this.ima=ima;
        this.x=x;
        this.y=y;
        this.n=n;
        circulos= new ArrayList<Ellipse2D>();
    }
    public void paintComponent(Graphics g){
        int conta=0;
        super.paintComponent(g);
        g2 = (Graphics2D)g;
        g2.drawImage(ima, -400, -120, this);
        g2.setColor(Color.black);
        
        dibujaDivision(divisiones);
        
        //System.out.println(aux + " " +conta);
        for(Ellipse2D c:circulos){
            if(aux == conta){
                 
                c.setFrame(x, y, 20, 20);
               
            }
            
             g2.fill((Ellipse2D)c);
            conta++;
        }
         //System.out.println(aux + " " +conta);
        

    }
    public void CreaCirculo(){
        circulos.add(new Ellipse2D.Double());
    }
    
    public void limpiarCirculo(){
        circulos.clear();
    }
    public void ActuaslizaXY(int x, int y, int nombre){
            this.x = x;
            this.y = y;
            this.aux = nombre;
           
        
    }
    public void setDivisiones(int div){
        this.divisiones = div;
    }
    
    public void dibujaDivision(int i){
        if(i == 2){
            g2.fill(new Rectangle2D.Double(355, 0, 2, 460));
        }
        
        if(i == 4){
            g2.fill(new Rectangle2D.Double(355, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(0, 230, 750, 2));
        }
        
        if( i == 6){
            g2.fill(new Rectangle2D.Double(240, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(480, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(0, 230, 750, 2));
        }
        
        if(i == 8){
            g2.fill(new Rectangle2D.Double(180, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(360, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(540, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(0, 230, 750, 2));
        }
        
        if(i == 10){
             g2.fill(new Rectangle2D.Double(150, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(300, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(450, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(600, 0, 2, 460));
            g2.fill(new Rectangle2D.Double(0, 230, 750, 2));
        }
    }
}
