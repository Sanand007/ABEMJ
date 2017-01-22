/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package final_year_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
/**
 *
 * @author SMIT
 */
public class graph_panel extends javax.swing.JPanel {

    /**
     * Creates new form graph_panel
     */
    int[] data ={
        21,30,40,2,12,51,15,16
    };
    
    final int PAD = 20;
    int count=0;
    public int deathrate;
    String str=" ";
    private static final int TIMER_DELAY = 10;
    public Graphics g;
   // mainpanel panel1 = new mainpanel(10);
    public graph_panel()
    {
         super();
        this.deathrate = 0;
        initComponents();
        setBackground(Color.WHITE);
        javax.swing.Timer timer1;
       timer1 = new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               graph_panel.this.repaint();
           }
       });
       timer1.start ();
    }
    public graph_panel(int x) {}
   
    
    /**
     *
     * @param x
     */
    
    public void value(int x)
    {
        if(count<20) {
        data[count]=x;
        count+=1;
        }
        else {
            for(int j=0;j<19;j++)
                data[j]=data[j+1];
            data[19]=x;
        }
        //System.out.println(x);
    }
    
    @Override
    public void update(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
       // System.out.println(h+" "+w);
        //set the size here
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
         Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        float sh = lm.getAscent() + lm.getDescent();
         String s = "data";
        float sy = PAD + ((h - 2*PAD) - s.length()*sh)/2 + lm.getAscent();
        for(int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            float sw = (float)font.getStringBounds(letter, frc).getWidth();
            float sx = (PAD - sw)/2;
            g2.drawString(letter, sx, sy);
            sy += sh;
        }
         s = "x axis";
        sy = h - PAD + (PAD - sh)/2 + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = (w - sw)/2;
        g2.drawString(s, sx, sy);
        double xInc = (double)(w - 2*PAD)/(data.length-1);
        double scale = (double)(h - 2*PAD)/getMax();
        g2.setPaint(Color.green.darker());
        for(int i = 0; i < data.length-1; i++) {
            double x1 = PAD + i*xInc;
            double y1 = h - PAD - scale*data[i];
            double x2 = PAD + (i+1)*xInc;
            double y2 = h - PAD - scale*data[i+1];
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }
        g2.setPaint(Color.red);
        for(int i = 0; i < data.length; i++) {
            double x = PAD + i*xInc;
            double y = h - PAD - scale*data[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
       // str=String.valueOf(born);
      //  g.drawString(str, 100, 100);
        
    }
    @Override
    public void paint(Graphics g)
    {
        update(g);
    }
    
    private int getMax() {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++) {
            if(data[i] > max)
                max = data[i];
        }
        return max;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[])
    {
       graph_panel panel = new graph_panel();
       JFrame application = new JFrame();
       application.setTitle("My Project");
       application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       application.add(panel);
       application.setSize(1380, 720);
       application.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
