/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcheesi;

import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author diana
 */
public class ParcheesiJFrame extends JFrame
{
    public ParcheesiJFrame() 
    {
        super("Parcheesi");
        
        JPanel bgJPanel = new JPanel();
    //    ParcheesiJPanel cell1 = new ParcheesiJPanel();
    //    bgJPanel.add(cell1);
    }
}

/*class ParcheesiJPanel extends JPanel 
{
     public void paintComponent(Graphics g)
    {
         super.paintComponent(g);       //calls superclass's paint method
         g.drawOval(0, 0, 300, 300);
    }
}*/
