/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcheesiGame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author diana
 */
public class Menu extends JPanel{
    public int numPlayers;
    public int dice1;
    public int dice2;
    public int playerturn;
    public int selectedPiece;
    private static boolean rollAgain;
    private static JLabel diceRollView;
   // private static int xpos;
    private static int ypos;
    Menu(int numPlayers)
    {
        this.numPlayers = numPlayers;
        rollAgain = false;
        ypos = this.getHeight();
        this.setLayout(null);
        JLabel c = new JLabel("PARCHEESI");
        c.setBounds(50, 0, 100, 40);
        //this.setSize(100, 590);
        this.add(c, BorderLayout.NORTH);
        playerturn = 0;
        diceRollView = new JLabel("<html>Let's Play! <br>Player 1 <br>click below to <br>roll dice!</html>");
        diceRollView.setBounds(50, 50, 100, 60);
        this.add(diceRollView);
        addRules(this);
        addRoll(this);
     
    }
    public void addRules(Container c)
    {
        JButton rules = new JButton("Rules");
        rules.setBounds(5,575,135,30);
        rules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String info = "Goal: \n\tGet all of your tokens arround the board,"
						+ " and then to the center of the board.\n\nRules:\n\tIf a token is on a white tile,"
						+ " and another Player's token is moved there, the origonal token must"
						+ " go back to start. \nEach player will roll 2 dice, with a maximum value of 12 to determine"
						+ " how many spaces to move\n\n"
						+ "For Each Player's Turn: \n\t1.First Roll the dice.\n\t2.Then Select Which piece to move.\n "
						+ "WARNING! If you select a peice before the roll, this piece will be moved to that location.";
				JOptionPane.showMessageDialog(null, info, "Help/Instuctions",
						JOptionPane.INFORMATION_MESSAGE);
            }
        });
        c.add(rules);
    }
    public void addRoll(Container c)
    {
        JButton rollButton = new JButton("Roll Dice");
        rollButton.setBounds(5,545,135,30);
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rollDice();
                
            }
        });
        c.add(rollButton);
    }
    public void rollDice()
    {
        Random rand = new Random();
        dice1 = rand.nextInt(6) + 1;
        dice2 = rand.nextInt(6) + 1;
        
        diceRollView.setText("<html>Player " + (playerturn + 1) + "rolled:<br>" + "Dice 1: " + dice1 + "<br>Dice 2: " + dice2);
        if(dice1 == dice2)
            playerturn = playerturn;
        else
        {
            if((playerturn + 1) % 4 == 0)
                playerturn = 0;
            else
                playerturn += 1;
        }
        PlayerTurn();
    }
    public void PlayerTurn()
    {
        String[] options = { "1", "2", "3", "4" };
	String x = (String) JOptionPane.showInputDialog(null,	"Which game piece would you like to move?","Parcheesi",
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	if (x == null) {
            System.exit(0);
	} 
        else {
            selectedPiece = Integer.parseInt(x);
             }                       
        //Graphics g;		
        //setMove(g, selectedPiece, playerturn);
    }
    /*public void paintComponent(Graphics g)
    {
        StringBuilder player = new StringBuilder();
        player.append("Player");
        //String player = "Player"; 
        if(numPlayers != 0)
        {
            int ypos = 50;
            for(int i = 1; i < numPlayers +1; i++)
            {
                player.append(" " + i);
                g.drawChars(player.toString().toCharArray(), 0, player.length(), 10, ypos);
                ypos+=50;
                player.delete(6, 8);
            }
                
        }
      
    }*/
    
}
