/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcheesiGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
        
        GameBoard bg = new GameBoard();
        
       /* bg.setLayout(new GridLayout(3,3));
        bg.setBackground(Color.WHITE);
        
        ParcheesiHomeJPanel home1 = new ParcheesiHomeJPanel();
        home1.setColor(Color.BLUE);
        bg.add(home1);
        
        JLabel lb = new JLabel("to be made");
        bg.add(lb);
        
        ParcheesiHomeJPanel home2 = new ParcheesiHomeJPanel();
        home2.setColor(Color.YELLOW);
        bg.add(home2);
        
        JLabel lb2 = new JLabel("to be made2");
        bg.add(lb2);
        
        JLabel lb3 = new JLabel("to be made3");
        bg.add(lb3);
        
        JLabel lb4 = new JLabel("to be made4");
        bg.add(lb4);
        
        ParcheesiHomeJPanel home4 = new ParcheesiHomeJPanel();
        home4.setColor(Color.red);
        bg.add(home4);
        
        JLabel lb5= new JLabel("to be made5");
        bg.add(lb5);
        
        ParcheesiHomeJPanel home5 = new ParcheesiHomeJPanel();
        home5.setColor(Color.green);
        bg.add(home5);
        */
        parcheesiJFrame.add(bg);
        parcheesiJFrame.setSize(700,765);                  //set frame size
       // parcheesiJFrame.setResizable(false);
        parcheesiJFrame.setVisible(true);                  //display frame
    } //end main
} //end class

class ParcheesiHomeJPanel extends JPanel 
{
    private Color color;
    
    
    public void setColor(Color col)
    {
        color = col;
    }
     public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
         super.paintComponent(g);       //calls superclass's paint method
         g.setColor(color);
         g.fillOval(0, 0, 300, 300);
    }
}

