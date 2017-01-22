/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package final_year_project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author SMIT
 */

abstract class keyclass implements KeyListener
{
    
}


public class mainpanel extends javax.swing.JPanel{

    /**
     * Creates new form mainpanel
     */
    String filename="outputfile.txt";
    int[] data = new int[20];
    int data1[]=new int[20];
    final int PAD = 20;
    int count=0,countdied=0;
    public int deathrate;
    String str=" ";
  public  int lvl0,lvl1,lvl2,lvl3,born=12,died=0,x,graphcounter=0,iniborn=12,finborn,randonangervalue=0,findied=0,inidied=0;
   int xcord=950,ycord=550;
   int blue[]=new int[1000];
   int red[]=new int[1000];
   int green[]=new int[1000];
   int greenfood_timer[]=new int[1000];
   int redfood_timer[]=new int[1000];
   int greenfoodx[]=new int[1000];
   int greenfoody[]=new int[1000];
   int redfoodx[]=new int[1000];
   int redfoody[]=new int[1000];
   int orgx[]=new int[1000];
   int orgy[]=new int[1000];
   int mistake[]=new int[1000];
   int foodenergy[]=new int[1000];
   int foodcount[]=new int[1000];
   int dx,dy,countred=0,countgreen=0,countorg=0,randomx,randomy,clock=0,clocktime=0,min,indic=0,total,a,b,v,breakcount=0;
   int memory_counter=0;
   int homeindic=0,steps=0;
   String display;
   private static final int TIMER_DELAY = 10;
   Graphics g;
   Random rand=new Random();
   //mutation muta;
  // graph_panel panel1=new graph_panel();
    public mainpanel() {
        super();
        initComponents();
        setBackground(Color.GRAY.brighter());
       for(int i=0;i<1000;i++) {
       mistake[i]=0;
       foodenergy[i]=1500;
       greenfood_timer[i]=0;
       redfood_timer[i]=0; }
       try {
       PrintWriter writer = new PrintWriter("outputfile.txt");
                writer.print("");
                writer.close();
       }
       catch(IOException e){
    		e.printStackTrace();
    	}
       for(int i=0;i<5;i++)
       {
           redfood_timer[i]=500;
           randomx=40+(int)(Math.random()*xcord);
           randomy=40+(int)(Math.random()*ycord);
           redfoodx[countred]=randomx;
           redfoody[countred]=randomy;
           countred++;
       }
       for(int i=0;i<10;i++)
       {
           greenfood_timer[i]=500;
           randomx=40+(int)(Math.random()*xcord);
           randomy=40+(int)(Math.random()*ycord);
           greenfoodx[countgreen]=randomx;
           greenfoody[countgreen]=randomy;
           countgreen+=1;
       }
       for(int i=0;i<12;i++)
       {
           blue[i]=rand.nextInt(64);
           green[i]=rand.nextInt(64);
           red[i]=rand.nextInt(64);
           randomx=40+(int)(Math.random()*xcord);
           randomy=40+(int)(Math.random()*ycord);
           orgx[countorg]=randomx;
           orgy[countorg]=randomy;
           countorg+=1;
       }
        javax.swing.Timer timer;
       timer = new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               mainpanel.this.repaint();
           }
       });
       timer.start ();


    }
    
   public void updated_value(int x,int y)
    {
        if(count<10) {
            finborn=x;
        data[count]=(finborn-iniborn)*10;
        iniborn=finborn;
        count+=1;
        }
        else {
            for(int j=0;j<9;j++)
                data[j]=data[j+1];
            finborn=x;
            data[9]=(finborn-iniborn)*10;
            iniborn=finborn;
        }
        if(countdied<10)
        {
            findied=y;
            data1[countdied]=(findied-inidied)*10;
            inidied=findied;
            countdied+=1;
        }
        else {
            for(int j=0;j<9;j++)
                data1[j]=data1[j+1];
            findied=y;
            data1[9]=(findied-inidied)*10;
            inidied=findied;
        }
    }

    /**
     *
     * @param i
     */
    public void kill(int i)
   {
       if(foodenergy[i]<=0)
       {
           orgx[i]=orgx[countorg-1];
           orgy[i]=orgy[countorg-1];
           countorg-=1;
           died+=1;
       }
   }
   @Override
   public void update(Graphics g)
   {
       super.paintComponent(g);
        steps+=1;
        if(steps%100==0)
        {
           // randonangervalue=
            updated_value(born,died);
        }
        if(steps%1000==0)
        {
            try{
                
                String p=String.valueOf(countorg);
                p="POPULATION   : "+p;
                String s=String.valueOf(steps);
                s="STEPS   : "+s;
                String b=String.valueOf(born);
                b="BORN   : "+b;
                String d=String.valueOf(died);
                d="DIED   : "+d;
                String t=String.valueOf(steps/100);
    		String data = "STATISTICS AFTER  " +t+ " SECONDS";
    		File file =new File("outputfile.txt");
 
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
 
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
                bufferWritter.newLine();
                bufferWritter.write(p);
                bufferWritter.newLine();
                bufferWritter.write(b);
                bufferWritter.newLine();
                bufferWritter.write(d);
                bufferWritter.newLine();
                bufferWritter.newLine();
    	        bufferWritter.close();
 
	        System.out.println("Done");
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
        }
       g.setColor(Color.WHITE);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
      //  System.out.println(h+" "+w);
        //set the size here
        g2.draw(new Line2D.Double(1060, 200, 1060, 500));
        g2.draw(new Line2D.Double(1060, 350, 1360, 350));
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
            g2.drawString(letter, 1050, sy);
            sy += sh;
        }
        s = "x axis";
        sy = h - PAD + (PAD - sh)/2 + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = (w - sw)/2;
        g2.drawString(s, 1200, 470);
        double xInc = (double)(1000-PAD)/(data.length-1);
        double scale = (double)(260 - 2*PAD)/getMax();
        g2.setPaint(Color.green.darker());
        graphcounter=0;
        for(int i = 0; i <count-1; i++) {
           // double x1 = 1070 + i*xInc;
            //double y1 = 450 - scale*data[i]-180;
            //double x2 = 1070 + (i+1)*xInc;
            //double y2 = 450  - scale*data[i+1]-180;
            //g2.draw(new Line2D.Double(x1, y1, x2, y2));
            g2.draw(new Line2D.Double(1060+graphcounter,350-data[i],1060+30+graphcounter,350-data[i+1]));
            graphcounter+=30;
        }
        g2.setPaint(Color.RED.darker());
        graphcounter=0;
        for(int i=0;i<countdied-1;i++)
        {
            g2.draw(new Line2D.Double(1060+graphcounter,350-data1[i],1060+30+graphcounter,350-data1[i+1]));
            graphcounter+=30;
        }
        graphcounter=0;
        g2.setPaint(Color.red);
        for(int i = 0; i < count; i++) {
            double x = 1070 + i*xInc;
            double y = 450  - scale*data[i]-180;
            g2.fill(new Ellipse2D.Double(1060+graphcounter-2, 350-data[i]-2, 4, 4));
            g2.fill(new Ellipse2D.Double(1060+graphcounter-2, 350-data1[i]-2, 4, 4));
            graphcounter+=30;
        }
       //graph_panel graph=new graph_panel(10);
       //graph.value(born);
       lvl0=0;lvl1=0;lvl2=0;lvl3=0;
       for(int i=0;i<countorg;i++)
       {
           if(foodcount[i]==0)
               lvl0+=1;
           else if(foodcount[i]==1)
               lvl1+=1;
           else if(foodcount[i]==2)
               lvl2+=1;
           else if(foodcount[i]==3)
               lvl3+=1;
       }
       g.setColor(Color.WHITE);
       g.drawLine(1040, 0, 1040, 800);
       display=String.valueOf(countorg);
       g.drawString("Population : ", 1070, 30);
       g.drawString(display, 1160, 30);
       g.drawString("Steps         : ", 1070, 50);
       display=String.valueOf(steps);
       g.drawString(display, 1160, 50);
       g.drawString("Level Zero : ", 1070, 70);
       display=String.valueOf(lvl0);
       g.drawString(display, 1160, 70);
       g.drawString("Level One : ", 1070, 90);
       display=String.valueOf(lvl1);
       g.drawString(display, 1160, 90);
       g.drawString("Level Two : ", 1070, 110);
       display=String.valueOf(lvl2);
       g.drawString(display, 1160, 110);
       g.drawString("Level Three : ", 1070, 130);
       display=String.valueOf(lvl3);
       g.drawString(display, 1160, 130);
       g.drawString("BORN : ", 1070, 150);
       display=String.valueOf(born);
       g.drawString(display, 1160, 150);
       g.drawString("DIED : ", 1070, 170);
       display=String.valueOf(died);
       g.drawString(display, 1160, 170);
       clock+=1;
       clocktime=clock/100;
       display=String.valueOf(clocktime);
       g.setColor(Color.WHITE);
       g.drawString(display, 10, 20);
       for(int i=0;i<countgreen;i++)
       {
           greenfood_timer[i]-=1;
           if(greenfood_timer[i]!=0)
           {
               g.setColor ( Color.GREEN );
               g.fillOval ( greenfoodx[i], greenfoody[i], 20, 20);
               g.setColor ( Color.BLACK );
               display=String.valueOf(greenfood_timer[i]/100);
               g.drawString(display, greenfoodx[i]+5, greenfoody[i]+15);
           }
           else
           {
               randomx=40+(int)(Math.random()*xcord);
               randomy=40+(int)(Math.random()*ycord);
               greenfoodx[i]=randomx;
               greenfoody[i]=randomy;
               greenfood_timer[i]=500;
               g.setColor ( Color.GREEN );
               g.fillOval ( greenfoodx[i], greenfoody[i], 20, 20);
               g.setColor ( Color.BLACK );
               display=String.valueOf(greenfood_timer[i]/100);
               g.drawString(display, greenfoodx[i]+5, greenfoody[i]+15);
           }
       }
        for(int i=0;i<countred;i++)
       {
           redfood_timer[i]-=1;
           if(redfood_timer[i]!=0)
           {
               g.setColor ( Color.RED );
               g.fillOval ( redfoodx[i], redfoody[i], 20, 20);
               g.setColor ( Color.BLACK );
               display=String.valueOf(redfood_timer[i]/100);
               g.drawString(display, redfoodx[i]+5, redfoody[i]+15);
           }
           else
           {
               randomx=40+(int)(Math.random()*xcord);
               randomy=40+(int)(Math.random()*ycord);
               redfoodx[i]=randomx;
               redfoody[i]=randomy;
               redfood_timer[i]=500;
               g.setColor ( Color.RED );
               g.fillOval ( redfoodx[i], redfoody[i], 20, 20);
               g.setColor ( Color.BLACK );
               display=String.valueOf(redfood_timer[i]/100);
               g.drawString(display, redfoodx[i]+5, redfoody[i]+15);
           }
       }
        for(int i=0;i<countorg;i++)
       {
           homeindic=0;
           if(foodenergy[i]>1800) {
               foodenergy[i]-=1;
               kill(i);
               homeindic=1;
            }
           if(homeindic==0) {
           min=10000000;
           indic=0;
           for(int j=0;j<countgreen;j++)
           {
               dx=Math.abs ( orgx[i]-greenfoodx[j]);
               dy=Math.abs ( orgy[i]-greenfoody[j]);
               total=dx+dy;
               if(total<min)
               {
                   min=total;
                   a=greenfoodx[j];
                   b=greenfoody[j];
                   v=j;
               }
           }
            if(mistake[i]==0) {
           for(int j=0;j<countred;j++)
           {
               dx=Math.abs(orgx[i]-redfoodx[j]);
               dy=Math.abs ( orgy[i]-redfoody[j]);
               total=dx+dy;
               if(total<min)
               {
                   min=total;
                   a=redfoodx[j];
                   b=redfoody[j];
                   v=j;
                   indic=1;
               }
           }           }
             if(a<orgx[i] && b<orgy[i])
           {
               orgx[i]-=1;
               orgy[i]-=1;
               foodenergy[i]-=1;
           }
           else if(a==orgx[i] && b<orgy[i])
           {
               orgy[i]-=1;
               foodenergy[i]-=1;
           }
           else if(a>orgx[i] && b<orgy[i])
           {
               orgx[i]+=1;
               orgy[i]-=1;
               foodenergy[i]-=1;
           }
           else if(a<orgx[i] && b==orgy[i])
           {
               orgx[i]-=1;
               foodenergy[i]-=1;
           }
           else if(a>orgx[i] && b==orgy[i])
           {
               orgx[i]+=1;
               foodenergy[i]-=1;
           }
           else if(a<orgx[i] && b>orgy[i])
           {
               orgx[i]-=1;
               orgy[i]+=1;
               foodenergy[i]-=1;
           }
              else if(a==orgx[i] && b>orgy[i])
           {
               orgy[i]+=1;
               foodenergy[i]-=1;
           }
           else if(a>orgx[i] && b>orgy[i])
           {
               orgx[i]+=1;
               orgy[i]+=1;
               foodenergy[i]-=1;
           }
           else if(a==orgx[i] && b==orgy[i] && indic==0)
           {
               g.setColor ( Color.GREEN );
               if(foodcount[i]<4)
               {
                    foodcount[i]+=1;
               }
               foodenergy[i]+=800;
               greenfoodx[v]=40+(int)(Math.random()*xcord);
               greenfoody[v]=40+(int)(Math.random()*ycord);
               greenfood_timer[v]=500;
               g.setColor ( Color.GREEN );
               g.fillOval ( greenfoodx[v], greenfoody[v], 20, 20);
               g.setColor ( Color.BLACK );
               display=String.valueOf(greenfood_timer[v]/100);
               g.drawString(display, greenfoodx[v]+5, greenfoody[v]+15);
               kill(i);
               i=-1;
               continue;
           }
             else if(a==orgx[i] && b==orgy[i] && indic==1)
           {
               g.setColor ( Color.RED );
               foodenergy[i]-=200;
               redfoodx[v]=40+(int)(Math.random()*xcord);
               redfoody[v]=40+(int)(Math.random()*ycord);
               redfood_timer[v]=500;
               g.setColor ( Color.RED );
               g.fillOval ( redfoodx[v], redfoody[v], 20, 20);
               g.setColor ( Color.BLACK );
               display=String.valueOf(redfood_timer[v]/100);
               g.drawString(display, redfoodx[v]+5, redfoody[v]+15);
               mistake[i]=1;
               kill(i);
               i=-1;
               continue;
           }
             kill(i);
         //  g.setColor ( Color.YELLOW );
           for(int j=0;j<countorg;j++)
           {
               for(int k=0;k<countorg;k++)
               {
                   if(Math.abs (orgx[j]-orgx[k])<=10 && Math.abs (orgy[j]-orgy[k])<=10 && j!=k)
                   {
                       if(foodcount[j]>=foodcount[k])
                       {
                           orgx[k]=40+(int)(Math.random()*xcord);
                           orgy[k]=40+(int)(Math.random()*ycord);
                           g.fillRect ( orgx[k], orgy[k], 20, 20);
                       }
                       else
                       {
                           orgx[j]=40+(int)(Math.random()*xcord);
                           orgy[j]=40+(int)(Math.random()*ycord);
                           g.fillRect ( orgx[j], orgy[j], 20, 20);
                       }
                   }
               }
           }
       } }
        // g.setColor ( Color.YELLOW );
       breakcount=0;
       int mutate=0,mutate2=0;
       for(int i=0;i<countorg;i++)
       {
           if(foodcount[i]==4)
           {
               g.setColor(new Color(red[i]*4,green[i]*4,blue[i]*4));
               g.fillRect ( orgx[i], orgy[i], (20+(foodcount[i]*3)), (20+(foodcount[i]*3)));
               mutate+=1;
               if(mutate==1)
               {
                   mutate2=i;
               }
               else if(mutate==2)
               {
                   foodcount[i]=0;
                   foodenergy[i]-=400;
                   foodcount[mutate2]=0;
                   foodenergy[mutate2]-=400;
                   if(foodenergy[i]<=0 || foodenergy[mutate2]<=0) {
                        kill(i); kill(mutate2); continue;}
                  // muta.domutation(i);
                   
                   int x=blue[i];
        int y=green[i];
        int z=red[i];
        int bluearri[]=new int[6];
        int j1=0;
        while(x>0)
        {
            if(x%2==0)
                bluearri[j1]=0;
            else
                bluearri[j1]=1;
                       x=x/2;
                       j1+=1;
                   }
                   int greenarri[]=new int[6];
                   j1=0;
                   while(y>0)
                   {
                       if(y%2==0)
                           greenarri[j1]=0;
                       else
                           greenarri[j1]=1;
                       y=y/2;
                       j1+=1;
                   }
                   int redarri[]=new int[6];
                   j1=0;
                   while(z>0)
                   {
                       if(z%2==0)
                           redarri[j1]=0;
                       else
                           redarri[j1]=1;
                       z=z/2;
                       j1+=1;
                   }
                   x=blue[mutate2];
                   y=green[mutate2];
                   z=red[mutate2];
                   int bluearrm[]=new int[6];
                   j1=0;
                   while(x>0)
                   {
                       if(x%2==0)
                           bluearrm[j1]=0;
                       else
                           bluearrm[j1]=1;
                       x=x/2;
                       j1+=1;
                   }
                   int greenarrm[]=new int[6];
                   j1=0;
                   while(y>0)
                   {
                       if(y%2==0)
                           greenarrm[j1]=0;
                       else
                           greenarrm[j1]=1;
                       y=y/2;
                       j1+=1;
                   }
                   int redarrm[]=new int[6];
                   j1=0;
                   while(z>0)
                   {
                       if(z%2==0)
                           redarrm[j1]=0;
                       else
                           redarrm[j1]=1;
                       z=z/2;
                       j1+=1;
                   }
                   blue[countorg]=0;
                   if(bluearri[5]==1)
                       blue[countorg]+=32;
                   if(bluearri[4]==1)
                       blue[countorg]+=16;
                   if(bluearri[3]==1)
                       blue[countorg]+=8;
                   if(bluearri[2]==1)
                       blue[countorg]+=4;
                   if(bluearrm[1]==1)
                       blue[countorg]+=2;
                   if(bluearrm[0]==1)
                       blue[countorg]+=1;
                   blue[countorg+1]=0;
                   if(bluearrm[5]==1)
                       blue[countorg+1]+=32;
                   if(bluearrm[4]==1)
                       blue[countorg+1]+=16;
                   if(bluearrm[3]==1)
                       blue[countorg+1]+=8;
                   if(bluearrm[2]==1)
                       blue[countorg+1]+=4;
                   if(bluearri[1]==1)
                       blue[countorg+1]+=2;
                   if(bluearri[0]==1)
                       blue[countorg+1]+=1;
                   
                   green[countorg]=0;
                   if(greenarri[5]==1)
                       green[countorg]+=32;
                   if(greenarri[4]==1)
                       green[countorg]+=16;
                   if(greenarri[3]==1)
                       green[countorg]+=8;
                   if(greenarri[2]==1)
                       green[countorg]+=4;
                   if(greenarrm[1]==1)
                       green[countorg]+=2;
                   if(greenarrm[0]==1)
                       green[countorg]+=1;
                   green[countorg+1]=0;
                   if(greenarrm[5]==1)
                       green[countorg+1]+=32;
                   if(greenarrm[4]==1)
                       green[countorg+1]+=16;
                   if(greenarrm[3]==1)
                       green[countorg+1]+=8;
                   if(greenarrm[2]==1)
                       green[countorg+1]+=4;
                   if(greenarri[1]==1)
                       green[countorg+1]+=2;
                   if(greenarri[0]==1)
                       green[countorg+1]+=1;
                   
                   red[countorg]=0;
                   if(redarri[5]==1)
                       red[countorg]+=32;
                   if(redarri[4]==1)
                       red[countorg]+=16;
                   if(redarri[3]==1)
                       red[countorg]+=8;
                   if(redarri[2]==1)
                       red[countorg]+=4;
                   if(redarrm[1]==1)
                       red[countorg]+=2;
                   if(redarrm[0]==1)
                       red[countorg]+=1;
                   red[countorg+1]=0;
                   if(redarrm[5]==1)
                       red[countorg+1]+=32;
                   if(redarrm[4]==1)
                       red[countorg+1]+=16;
                   if(redarrm[3]==1)
                       red[countorg+1]+=8;
                   if(redarrm[2]==1)
                       red[countorg+1]+=4;
                   if(redarri[1]==1)
                       red[countorg+1]+=2;
                   if(redarri[0]==1)
                       red[countorg+1]+=1;
                   
                   
                   
                   
                   orgx[countorg]=40+(int)(Math.random()*xcord);
                   orgy[countorg]=40+(int)(Math.random()*ycord);
                   g.setColor(new Color(red[countorg]*4,green[countorg]*4,blue[countorg]*4));
                   g.fillRect ( orgx[countorg], orgy[countorg], 20, 20);
                   
                   orgx[countorg+1]=40+(int)(Math.random()*xcord);
                   orgy[countorg+1]=40+(int)(Math.random()*ycord);
                   g.setColor(new Color(red[countorg+1]*4,green[countorg+1]*4,blue[countorg+1]*4));
                   g.fillRect ( orgx[countorg+1], orgy[countorg+1], 20, 20);
                   
                   foodenergy[countorg]=500;
                   foodenergy[countorg+1]=500;
                   foodcount[countorg]=0;
                   foodcount[countorg+1]=0;
                   
                   countorg+=2;
                   born+=2;
               }
           }
           else
           {
               g.setColor(new Color(red[i]*4,green[i]*4,blue[i]*4));
               g.fillRect ( orgx[i], orgy[i], (20+(foodcount[i]*3)), (20+(foodcount[i]*3)));
           }
       }
   }
   
   private int getMax() {
        int max = -Integer.MAX_VALUE;
        for(int i = 0; i < count; i++) {
            if(data[i] > max)
                max = data[i];
        }
        return max;
    }
   
   @Override
   public void paint(Graphics g)
   {
       update(g);
   }
   @Override
   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       for(int i=0;i<countgreen;i++)
       {
           g.setColor ( Color.GREEN );
           g.fillOval ( greenfoodx[i], greenfoody[i], 20, 20);
           g.setColor ( Color.BLACK );
           display=String.valueOf(greenfood_timer[i]/100);
           g.drawString(display, greenfoodx[i]+5, greenfoody[i]+15);
       }
       for(int i=0;i<countred;i++)
       {
           g.setColor(Color.red);
           g.fillOval(redfoodx[i], redfoody[i], 20, 20);
           g.setColor(Color.BLACK);
           display=String.valueOf(redfood_timer[i]/100);
           g.drawString(display, redfoodx[i]+5, redfoody[i]+15);
       }
       //g.setColor(Color.YELLOW);
       for(int i=0;i<countorg;i++)
       {
           g.fillRect ( orgx[i], orgy[i], 20, 20);
       }
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
            
    public static void main(String[] args){
        // TODO code application logic here
       mainpanel panel = new mainpanel();
       JFrame application = new JFrame();
       application.setTitle("My Project");
       application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       application.add(panel);
       application.setSize(1380, 720);
       application.setVisible(true);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

