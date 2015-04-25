/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcheesiGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author nigel
 */
public class Player extends JPanel{
   public String color; //olor for pieces
    public int pid;
    public BufferedImage images;
    ArrayList<Point> cellnum = GameBoard.cellnumbers;
    ArrayList<Point>  playercell; 
    Point p;
    
    public Player(String color,int pid, BufferedImage images, ArrayList<Point> playercell)
    {
        //super();        
        this.images = images;
        this.color = color;
        this.pid = pid;
        
        if(color == "red")
        {
            this.playercell = playercell;
        }
    }
    
    //Check for final cell before safety space
    public Boolean checkForHome()
    {
     //based off color you check for home
        
        return true;
    }
    
    //check for home win
    public Boolean checkForWin()
    {
        //check if index is at final point
        return true; 
    }
 /*   public void setMove(Graphics g, int index, Player p)
    {  
        int x = cellnum.get(4).x;
        int y = cellnum.get(4).y;
        
        if(p.GetX() == 0 && p.GetY() == 0 )
        {
            g.drawImage(images, x, y, null);
        }
        
//        g.drawImage(images, pid, pid, null);
        //playercell.add(point);
        
    }*/
     public void setX(int x)
    {
        p.x = x;
        
        
    }
    
    public int GetX()
    {
        return p.x;
    }
    
    public void setY(int y)
    {
        p.y = y;
    }
    
    public int GetY()
    {
        return p.y;
    }
    public Point saveLocation(int x, int y)
    {
        Point p1 = new Point(x,y);
        return p1;
    }
      
    
    public void ShowStats()
    {
        //edit panel to show how far away from how 
        
    }
    
    public void Options(int result, Point location)
    {
        //edit board
    }
    public String getColor()
    {
        return color; 
    }
}