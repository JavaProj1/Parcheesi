/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcheesiGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author diana
 */
public class Parcheesi {
    public static int numPlayers;
    public static void main(String args[])
    {
        JFrame parcheesiJFrame = new JFrame();
        parcheesiJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parcheesiJFrame.setSize(600,600);                  //set frame size
        JPanel gameLayout = new JPanel();//new BorderLayout(0,10));
        gameLayout.setLayout(new GridBagLayout());
        gameLayout.setSize(parcheesiJFrame.getWidth(), parcheesiJFrame.getHeight());
        gameLayout.setBorder(BorderFactory.createLineBorder(Color.black));
        //gameLayout.set
        //gameLayout.setBackground(Color.BLACK);
        
        choosePlayers();
        //Player p = new Player("red",1);
        
        GameBoard bg = new GameBoard();
        bg.setBorder(BorderFactory.createLineBorder(Color.black));
        Menu menu = new Menu(numPlayers);
        menu.setBorder(BorderFactory.createLineBorder(Color.black));
        //menu.setSize(290, parcheesiJFrame.getHeight()-30);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = gameLayout.getHeight()+1;
        gbc.ipadx = parcheesiJFrame.getWidth();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0; 
        gbc.weighty  = 0;       
        gameLayout.add(bg, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = parcheesiJFrame.getWidth()/2;
        gbc.ipady = parcheesiJFrame.getHeight() + 9;
        gbc.gridx = 200;
        gbc.gridy = 0;
        gbc.weightx = 0; 
        gbc.weighty  = 0;
        gameLayout.add(menu, gbc);       
        
        parcheesiJFrame.add(gameLayout);
        parcheesiJFrame.setSize(650,650);                  //set frame size
       // parcheesiJFrame.setResizable(false);
        parcheesiJFrame.setVisible(true);                  //display frame
    } //end main

    public static void choosePlayers() 
    {
        while (numPlayers > 4 || numPlayers < 1) 
        {
            String[] options = { "1", "2", "3", "4" };
            String x = (String) JOptionPane.showInputDialog(null,"Number of Players? (1-4)", "Parcheesi",
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (x == null) 
            {
		System.exit(0);
	    } 
            else 
            {
                numPlayers = Integer.parseInt(x);
            }
        }

	}
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

