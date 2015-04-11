/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcheesi;

import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diana
 */
public class Parcheesi {

public static void main(String args[])
    {
        JFrame parcheesiJFrame = new JFrame();
        parcheesiJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel bg = new JPanel(new GridLayout(3,3));
        ParcheesiHomeJPanel home1 = new ParcheesiHomeJPanel();
        bg.add(home1);
        
        JLabel lb = new JLabel("to be made");
        bg.add(lb);
        
        ParcheesiHomeJPanel home2 = new ParcheesiHomeJPanel();
        bg.add(home2);
        
        JLabel lb2 = new JLabel("to be made2");
        bg.add(lb2);
        
       // ParcheesiHomeJPanel home3 = new ParcheesiHomeJPanel();
       // bg.add(home3);
        
        JLabel lb3 = new JLabel("to be made3");
        bg.add(lb3);
        
        JLabel lb4 = new JLabel("to be made4");
        bg.add(lb4);
        
        ParcheesiHomeJPanel home4 = new ParcheesiHomeJPanel();
        bg.add(home4);
        
        JLabel lb5= new JLabel("to be made5");
        bg.add(lb5);
        
        ParcheesiHomeJPanel home5 = new ParcheesiHomeJPanel();
        bg.add(home5);
        
        parcheesiJFrame.add(bg);
        parcheesiJFrame.setSize(1000,1000);                  //set frame size
        parcheesiJFrame.setVisible(true);                  //display frame
    } //end main
} //end class

class ParcheesiHomeJPanel extends JPanel 
{
     public void paintComponent(Graphics g)
    {
         super.paintComponent(g);       //calls superclass's paint method
         g.drawOval(0, 0, 300, 300);
    }
}

