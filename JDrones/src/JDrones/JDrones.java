package JDrones;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class JDrones extends javax.swing.JFrame {
    private DibujaDrones panel;
    private Lock MUTEX = new ReentrantLock();
    private Semaphore semaforos = new Semaphore (1);;
    private MiX x;
    private MiY y;
    private int x1=0;
    private int y1=0;
    private NumDron n;
    private BufferedImage ima;
    private double[] datosX;
    private double[] datosY;
    private ArrayList<Dron> drones;
    private int sincroniza = 0;
    public JDrones() {
        this.setResizable(false);
        initComponents();
        try{                                        // PASARLO a MENU
            ima = ImageIO.read(new File("mapaCU.png"));
        }catch(IOException e){e.printStackTrace();}
        datosX = new double[10];
        datosY = new double[10];
        drones =new ArrayList<Dron>();
        panel= new DibujaDrones(ima);

        //d2 = new Dron(x,null,panel,datosX);
        panel.setBounds(0, 0, 1345, 599);
        add(panel);
        reiniciarDrones();
        
    }
    
     public void apagarDrones(){
         
        
        for(Dron d: drones){
                    d.muerto();
        }
        drones.clear();
    }
    
    public void reiniciarDrones(){
        MUTEX = new ReentrantLock();
        x1 = 0;
        y1 = 0;
        panel.limpiarCirculo();
        for(int i=0; i<=9;i++){
                    x1 = 0;
                    x = new MiX(0);
                    y = new MiY(0);
                    
                        
                        
                  
                drones.add(new Dron(x,y,panel,i));
            }
        int i=0;
        for(Dron d: drones){
            i++;
            d.setMutex(MUTEX);
            d.setSemaforo(semaforos);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mutex = new javax.swing.JRadioButtonMenuItem();
        semaforo = new javax.swing.JRadioButtonMenuItem();
        vCondicion = new javax.swing.JRadioButtonMenuItem();
        Monitores = new javax.swing.JRadioButtonMenuItem();
        Barreras = new javax.swing.JRadioButtonMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Concurrente");

        jMenu1.setText("File");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Drones");

        jMenuItem2.setText("Un dron");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("Dos drones");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Cuatro drones");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Seis drones");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Ocho drones");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Diez drones");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Sincronización");

        mutex.setSelected(true);
        mutex.setText("Mutex");
        mutex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mutexActionPerformed(evt);
            }
        });
        jMenu5.add(mutex);

        semaforo.setText("Semáforo");
        semaforo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semaforoActionPerformed(evt);
            }
        });
        jMenu5.add(semaforo);

        vCondicion.setText("Variable Condición");
        vCondicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCondicionActionPerformed(evt);
            }
        });
        jMenu5.add(vCondicion);

        Monitores.setText("Monitores");
        Monitores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonitoresActionPerformed(evt);
            }
        });
        jMenu5.add(Monitores);

        Barreras.setText("Barreras");
        Barreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarrerasActionPerformed(evt);
            }
        });
        jMenu5.add(Barreras);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       CyclicBarrier Barrier = new CyclicBarrier (1);
        panel.setDivisiones(0);
        apagarDrones();
       reiniciarDrones();
       int i = 0;
       for(Dron d: drones){
           if(!d.isAlive())
            try{
                if(i==0){
                    d.barrera(Barrier);
                    d.sincro(sincroniza);
                    d.aumentoX1(350);
                        
                    
                    panel.CreaCirculo();
                    d.start();
                }
                    
            }catch(IllegalThreadStateException ex){ex.printStackTrace();} 
           i++;
        }
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CyclicBarrier Barrier = new CyclicBarrier (2);
        panel.setDivisiones(2);
        apagarDrones();
       reiniciarDrones();
       int i = 0;
       for(Dron d: drones){
           if(!d.isAlive())
            try{
                if(i>=0 && i<=1){
                    d.barrera(Barrier);
                    d.sincro(sincroniza);
                    if(i == 1){
                        d.setX(355);
                        d.aumentoX(350);
                        d.aumentoX1(350);
                        System.out.print("entre");
                    }
                    panel.CreaCirculo();
                    d.start();
                }
                    
            }catch(IllegalThreadStateException ex){ex.printStackTrace();} 
           i++;
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       CyclicBarrier Barrier = new CyclicBarrier (10);
        panel.setDivisiones(10);
        apagarDrones();
       reiniciarDrones();
       int i = 0;
       for(Dron d: drones){
           if(!d.isAlive())
            try{
                if(i>=0 && i<=9){
                    d.barrera(Barrier);
                    d.sincro(sincroniza);
                    if(i == 0){
                        d.aumentoY(-230);
                        d.aumentoX1(-200);
                    }
                    if(i == 1){
                        d.setX(150);
                        d.aumentoX(150);
                        d.aumentoX1(-50);
                        d.aumentoY(-230);
                        
                    }
                    
                    if(i == 2){
                        d.setX(300);
                        d.aumentoX(300);
                        d.aumentoX1(100);
                        d.aumentoY(-230);
                        
                    }
                    if(i == 6){
                        d.setX(450);
                        d.aumentoX(450);
                        d.aumentoX1(250);
                        d.aumentoY(-230);
                        
                    }
                    
                    if(i == 8){
                        d.setX(600);
                        d.aumentoX(600);
                        d.aumentoX1(400);
                        d.aumentoY(-230);
                        
                    }
                    if(i == 3){
                        d.setY(230);
                        d.aumentoY1(230);
                       d.aumentoX1(-200);
                        
                        
                        
                    }
                    
                     if(i == 4){
                        d.setY(230);
                        
                        d.aumentoY1(230);
                        
                        d.setX(150);
                        d.aumentoX(150);
                        d.aumentoX1(-50);
                        
                        
                    }
                     
                     if(i == 5){
                        d.setY(230);
                        
                        d.aumentoY1(230);
                        
                         d.setX(300);
                        d.aumentoX(300);
                        d.aumentoX1(100);
                        
                        
                    }
                     
                     if(i == 7){
                        d.setY(230);
                        
                        d.aumentoY1(230);
                        
                        
                        d.setX(450);
                       d.aumentoX(450);
                        d.aumentoX1(250);
                        
                        
                        
                    }
                    
                    if(i == 9){
                        d.setY(230);
                        
                        d.aumentoY1(230);
                        
                        
                        
                       d.setX(600);
                        d.aumentoX(600);
                        d.aumentoX1(400);
                        
                        
                    }
                     
                    panel.CreaCirculo();
                    d.start();
                    
                }
                    
            }catch(IllegalThreadStateException ex){ex.printStackTrace();} 
           i++;
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       panel.setDivisiones(4);
       CyclicBarrier Barrier = new CyclicBarrier (4);
        apagarDrones();
       reiniciarDrones();
       int i = 0;
       for(Dron d: drones){
           if(!d.isAlive())
            try{
                if(i>=0 && i<=3){
                    d.barrera(Barrier);
                    d.sincro(sincroniza);
                    if(i == 0){
                        d.aumentoY(-230);
                        
                    }
                    if(i == 1){
                        d.setX(350);
                        d.aumentoX(350);
                        d.aumentoX1(350);
                        d.aumentoY(-230);
                        
                    }
                    
                    if(i == 2){
                        d.setY(230);
                        d.aumentoY1(230);
                        
                    }
                    if(i == 3){
                        d.setX(350);
                        d.aumentoX(350);
                        d.aumentoX1(350);
                        d.setY(230);
                        d.aumentoY1(230);
                        System.out.print("entre");
                    }
                    panel.CreaCirculo();
                    d.start();
                }
                    
            }catch(IllegalThreadStateException ex){ex.printStackTrace();} 
           i++;
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       panel.setDivisiones(6);
       CyclicBarrier Barrier = new CyclicBarrier (6);
        apagarDrones();
       reiniciarDrones();
       int i = 0;
       for(Dron d: drones){
           if(!d.isAlive())
            try{
                if(i>=0 && i<=5){
                    d.barrera(Barrier);
                    d.sincro(sincroniza);
                    if(i == 0){
                        d.aumentoY(-230);
                        d.aumentoX1(-110);
                    }
                    if(i == 1){
                        d.setX(240);
                        d.aumentoX(240);
                        d.aumentoX1(130);
                        d.aumentoY(-230);
                        
                    }
                    
                    if(i == 2){
                        d.setX(480);
                        d.aumentoX(480);
                        d.aumentoX1(370);
                        d.aumentoY(-230);
                        
                    }
                    if(i == 3){
                        d.setY(230);
                        d.aumentoY1(230);
                        d.aumentoX1(-110);
                        
                        
                    }
                    
                     if(i == 4){
                        d.setY(230);
                        d.setX(240);
                        d.aumentoY1(230);
                        d.aumentoX(240);
                        d.aumentoX1(130);
                        
                        
                    }
                     
                     if(i == 5){
                        d.setY(230);
                        d.setX(480);
                        d.aumentoX(480);
                       d.aumentoX1(370);
                        d.aumentoY1(230);
                        
                        
                    }
                    panel.CreaCirculo();
                    d.start();
                }
                    
            }catch(IllegalThreadStateException ex){ex.printStackTrace();} 
           i++;
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        CyclicBarrier Barrier = new CyclicBarrier (8);
        panel.setDivisiones(8);
        apagarDrones();
       reiniciarDrones();
       int i = 0;
       
       for(Dron d: drones){
           if(!d.isAlive())
            try{
                if(i>=0 && i<=7){
                    d.barrera(Barrier);
                    d.sincro(sincroniza);
                    if(i == 0){
                        
                        d.aumentoY(-230);
                        d.aumentoX1(-170);
                    }
                    if(i == 1){
                        d.setX(180);
                        d.aumentoX(180);
                        d.aumentoX1(10);
                        d.aumentoY(-230);
                        
                    }
                    
                    if(i == 2){
                        d.setX(360);
                        d.aumentoX(360);
                        d.aumentoX1(190);
                        d.aumentoY(-230);
                        
                    }
                    
                    if(i == 6){
                        d.setX(540);
                        d.aumentoX(540);
                        d.aumentoX1(370);
                        d.aumentoY(-230);
                        
                    }
                    if(i == 3){
                        d.setY(230);
                        d.aumentoY1(230);
                        d.aumentoX1(-170);
                        
                        
                        
                    }
                    
                     if(i == 4){
                        d.setY(230);
                        d.setX(180);
                        d.aumentoY1(230);
                        
                        
                        d.aumentoX(180);
                        d.aumentoX1(10);
                        
                        
                    }
                     
                     if(i == 5){
                        d.setY(230);
                        
                        d.aumentoY1(230);
                        
                        d.setX(360);
                        d.aumentoX(360);
                        d.aumentoX1(190);
                        
                        
                    }
                     
                     if(i == 7){
                        d.setY(230);
                        
                        d.aumentoY1(230);
                        
                        
                        
                        d.setX(540);
                        d.aumentoX(540);
                        d.aumentoX1(370);
                        
                        
                    }
                    panel.CreaCirculo();
                    d.start();
                }
                    
            }catch(IllegalThreadStateException ex){ex.printStackTrace();} 
           i++;
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void mutexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutexActionPerformed
        apagarDrones();
        
        sincroniza = 0;
        Barreras.setSelected(false);
        semaforo.setSelected(false);
        vCondicion.setSelected(false);
        Monitores.setSelected(false);
        panel.limpiarCirculo();
        panel.setDivisiones(0);
        panel.repaint();
         JOptionPane.showMessageDialog(rootPane, "Por favor, selecciona el número de drones");
    }//GEN-LAST:event_mutexActionPerformed

    private void semaforoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaforoActionPerformed
        apagarDrones();
        
        sincroniza = 1;
        Barreras.setSelected(false);
        mutex.setSelected(false);
        Monitores.setSelected(false);
        vCondicion.setSelected(false);
        panel.limpiarCirculo();
        panel.setDivisiones(0);
        panel.repaint();
        JOptionPane.showMessageDialog(rootPane, "Por favor, selecciona el número de drones");
    }//GEN-LAST:event_semaforoActionPerformed

    private void vCondicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCondicionActionPerformed
        apagarDrones();
        
        sincroniza = 2;
        mutex.setSelected(false);
        Barreras.setSelected(false);
        semaforo.setSelected(false);
        Monitores.setSelected(false);
        panel.limpiarCirculo();
        panel.setDivisiones(0);
        panel.repaint();
        JOptionPane.showMessageDialog(rootPane, "Por favor, selecciona el número de drones");
    }//GEN-LAST:event_vCondicionActionPerformed

    private void MonitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonitoresActionPerformed
        apagarDrones();
        
        sincroniza = 3;
        mutex.setSelected(false);
        semaforo.setSelected(false);
        vCondicion.setSelected(false);
        panel.limpiarCirculo();
        panel.setDivisiones(0);
        panel.repaint();
        JOptionPane.showMessageDialog(rootPane, "Por favor, selecciona el número de drones");
    }//GEN-LAST:event_MonitoresActionPerformed

    
    private void crearBarrera(int numBarrera){
        System.out.println("Aca ando");
        CyclicBarrier Barrier = new CyclicBarrier (numBarrera);
        for(Dron d: drones){
                    d.barrera(Barrier);
        }
        
    }
    private void BarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarrerasActionPerformed
        sincroniza = 4;
        mutex.setSelected(false);
        semaforo.setSelected(false);
        vCondicion.setSelected(false);
        Monitores.setSelected(false);
        panel.limpiarCirculo();
        panel.setDivisiones(0);
        panel.repaint();
        JOptionPane.showMessageDialog(rootPane, "Por favor, selecciona el número de drones");
    }//GEN-LAST:event_BarrerasActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDrones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem Barreras;
    private javax.swing.JRadioButtonMenuItem Monitores;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JRadioButtonMenuItem mutex;
    private javax.swing.JRadioButtonMenuItem semaforo;
    private javax.swing.JRadioButtonMenuItem vCondicion;
    // End of variables declaration//GEN-END:variables
}
