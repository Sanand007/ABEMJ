/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package final_year_project;

import javax.swing.JFrame;

/**
 *
 * @author SMIT
 */
public class Final_year_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
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
