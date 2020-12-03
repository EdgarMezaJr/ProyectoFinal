package JDrones;
import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.locks.*;
import java.util.concurrent.*;
public class Dron extends Thread{
    private MiX x;
    private MiY y;
    private DibujaDrones panel;
    private int aumento=0;
    private int aumento2=0;
    private int aumento3=0;
    private int aumento4=0;
    private int a=1;
    private int b=1;
    private int nombre;
    private int sincroniza;
    private Lock mutex;
    private Semaphore semaforo;
    private boolean muerto;
    private Condition condition;
    private Lock VCondition;
    CyclicBarrier bar;
   
    
    
    Dron(MiX x, MiY y, DibujaDrones panel, int nombre){
        this.x=x;
        this.y=y;
        this.aumento = 0;
        this.aumento2 = 0;
        this.nombre = nombre;
        this.panel=panel;
       
        this.muerto = false;
        semaforo = new Semaphore (1);
        VCondition = new ReentrantLock();
        condition = VCondition.newCondition();
    }
    public void setSemaforo(Semaphore semaforo){
        this.semaforo = semaforo;
    }
    
    public void setMutex(Lock mutex){
        this.mutex = mutex;
    }
    
    public void barrera(CyclicBarrier bar){
        this.bar = bar;
    }
    
    public void setX(int a){
         this.x.setX(a);
    }
    public void setY(int a){
        this.y.setY(a);
    
    }
    
    public void aumentoX(int aumento){
         this.aumento = aumento;
    }
    public void aumentoY(int aumento2){
        this.aumento2 = aumento2;
    
    }
    
     public void aumentoX1(int aumento){
         this.aumento3 = aumento;
    }
    public void aumentoY1(int aumento2){
        this.aumento4 = aumento2;
    
    }
    
    public void muerto(){
        this.muerto = true;
    }
    public void sincro(int sincroniza){
        this.sincroniza = sincroniza;
    }
    
    public void mutex(){
        try{
                
                    mutex.lock();
                    
                        y.setY(y.getY()+b);// = y+b;
                        x.setX(x.getX()+a);//;=x+a;
                        panel.ActuaslizaXY(x.getX(),y.getY(), nombre);
                        panel.repaint();
                        
                        if (y.getY()==430+aumento2)
                            b=-b;
                        if (y.getY()==0+aumento4)
                            b=-b;
                        if (x.getX()>=350+aumento3)
                            a=-a;
                        if (x.getX()==0+aumento)
                            a=-a;
                  mutex.unlock();
                    
                sleep(3);
    
            }catch(Exception e){e.printStackTrace();}
    }
    
    

    
    /* Metodo: Algoritmo que permite ejecutar nuestro Dron con semaforos
    Recibe: Nada
    Regresa: Nada
    */
    public void semaforos(){
    
    try{
                
                    semaforo.acquire();
                        y.setY(y.getY()+b);// = y+b;
                        x.setX(x.getX()+a);//;=x+a;
                        panel.ActuaslizaXY(x.getX(),y.getY(), nombre);
                        panel.repaint();
                        
                        
                        if (y.getY()==430+aumento2)
                            b=-b;
                        if (y.getY()==0+aumento4)
                            b=-b;
                        if (x.getX()>=350+aumento3)
                            a=-a;
                        if (x.getX()==0+aumento)
                            a=-a;
                    semaforo.release();
                    this.sleep(3);
                        
                        
                
                
            }catch(Exception e){e.printStackTrace();}
    }
    
    public void vCondicion(){
        //Aquire
        mutex.lock();
        try{
                condition.signal();
        }catch(Exception e){}
        finally{
            mutex.unlock();
        }
        
        y.setY(y.getY()+b);// = y+b;
        x.setX(x.getX()+a);//;=x+a;
        panel.ActuaslizaXY(x.getX(),y.getY(), nombre);
        panel.repaint();
        try{
            this.sleep(3);
        }catch(Exception e){}
        if (y.getY()==430+aumento2)
            b=-b;
        if (y.getY()==0+aumento4)
            b=-b;
        if (x.getX()>=350+aumento3)
            a=-a;
        if (x.getX()==0+aumento)
            a=-a;
        //Relese    
        try{
                mutex.lock();
                condition.await();
        }catch(Exception e){}
        finally{
            mutex.unlock();
        }    
                
    }
    
    public void barreras(){
        
        try
        { 
           bar.await();
        }  
        catch (InterruptedException | BrokenBarrierException e)  
        { 
            e.printStackTrace(); 
        } 
        y.setY(y.getY()+b);// = y+b;
        x.setX(x.getX()+a);//;=x+a;
        panel.ActuaslizaXY(x.getX(),y.getY(), nombre);
        panel.repaint();
        try{
            this.sleep(3);
        }catch(Exception e){}
        if (y.getY()==430+aumento2)
            b=-b;
        if (y.getY()==0+aumento4)
            b=-b;
        if (x.getX()>=350+aumento3)
            a=-a;
        if (x.getX()==0+aumento)
            a=-a;
        
        if(bar.isBroken()){
            bar.reset();
        }
        
    }
    
    public void monitores(){
        y.setY(y.getY()+b);// = y+b;
        x.setX(x.getX()+a);//;=x+a;
        synchronized(panel){
                panel.ActuaslizaXY(x.getX(),y.getY(), nombre);
                panel.repaint();
        }
        
        try{
            this.sleep(3);
        }catch(Exception e){}
        if (y.getY()==430+aumento2)
            b=-b;
        if (y.getY()==0+aumento4)
            b=-b;
        if (x.getX()>=350+aumento3)
            a=-a;
        if (x.getX()==0+aumento)
            a=-a;
    }
    
    
    
    public  void run(){
        while(!muerto){
            
            switch(sincroniza){
                    case 0: //Sin algoritmo
                        mutex();
                        break;
                    case 1:
                        semaforos();
                        break;
                    case 2:
                        vCondicion();
                        break;
                    case 3:
                        monitores();
                        break;
                    case 4:
                        barreras();
                        break; 
            }
            
        }
    }
}
