/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcheesiGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author diana
 */
public class GameBoard extends JPanel
{
    private static int xcoord;      //jframe size
    private static int ycoord;      //jframe size
    private static int width;
    private static int height;
    private static int x;// starting
    private static int y;
    private static int w;
    private int h;
    public static ArrayList<Point> cellnumbers, playersloc;
    private int[] xpoints;
    private int[] ypoints;
    private BufferedImage image, smaller, piece;
    public Player[][] players;
    public GamePiece[][] pieces;
    public BufferedImage[][] gPieces;
    public static int die;
    private Point p;
    
    public GameBoard() 
    {
        try {
                image = ImageIO.read(this.getClass().getResource("home.jpg"));
                //smaller = Scalr.resize(image,150);
                
        }catch (IOException ex){
        }
    }
    
    public void startgame() throws IOException
    {
        String red = "red";
        String green = "green";
        String blue = "blue";
        String yellow = "yellow";
        
       piece = ImageIO.read(this.getClass().getResource("Untitled.jpg"));
       
       players = new Player[4][4];
       gPieces = new BufferedImage[4][4];
       pieces = new GamePiece[4][4];
       Point point = new Point(0,0);
       playersloc = new ArrayList<Point>();
       playersloc.add(point);
       
       for(int i = 0; i < 1; ++i)
       {
        for(int j = 0; j < 4; ++j)
        {
           
        gPieces[i][j] = piece;
        players[i][j] = new Player(red, j, gPieces[i][j],playersloc);

        }
       }
    }
    public void updowncells(Graphics g)
    {
        w = ((xcoord - width) - width)/3;
        h = height/ 7 ;
        for (int k = 0; k < 7; k++)     
        {
            g.drawRect(x, y, w, h);
            cellnumbers.add(new Point(x, y));
            y += h;
	}
    }
    
    public void rightleftcells(Graphics g)
    {
        for (int k = 0; k < 7; k++)     
        {
            g.drawRect(x, y, w, h);
            cellnumbers.add(new Point(x, y));
            x -= w;
	}   
    }
    public void leftrightcells(Graphics g)
    {
        for (int k = 0; k < 7; k++) 
        {
            g.drawRect(x, y, w, h);
            cellnumbers.add(new Point(x, y));
            x += w;
	}
    }
    public void downupcells(Graphics g)
    {
        for (int k = 0; k < 7; k++)     
        {
            g.drawRect(x, y, w, h);
            cellnumbers.add(new Point(x, y));
            y -= h;
	}
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);       //calls superclass's paint method
        
        xpoints = new int[5];
        ypoints = new int[5];
        xcoord = getWidth();
        ycoord = getHeight();
        width = (xcoord/3);
        height = (ycoord/3);
      
	x = width;// starting
	y = 0;
        
        cellnumbers = new ArrayList<Point>(); //saves cell location
  
        g2d.setColor(Color.BLACK);
        
        //wraps around like a swirl
        //cell 0-6
        updowncells(g2d);
        
        //cell 7 polygon
        xpoints[0] = x;             ypoints[0] = y;
        xpoints[1] = x + w;         ypoints[1] = y ;
        xpoints[2] = x  + w;        ypoints[2] = y + h;
        xpoints[3] = x + h;         ypoints[3] = y + h;
        xpoints[4] = x + h;         ypoints[4] = y +h;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        h = (ycoord - (2*height))/3;
        w = height/7;
        
        //cell 8 polygon
        xpoints[0] = x;             ypoints[0] = y + 1;
        xpoints[1] = x + w;     ypoints[1] = y + w;
        xpoints[2] = x  + w;    ypoints[2] = y + h;
        xpoints[3] = x;             ypoints[3] = y + h;
        xpoints[4] = x;             ypoints[4] = y + 1;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
       
        //h = (ycoord - (2*height))/3;
        w = width/7;
        x -= w;
        
        //cell 9-15
        rightleftcells(g2d);
       
        y += h;
        x += w;
        g2d.drawRect(x, y, w, h); //cell 16
        cellnumbers.add(new Point(x,y));
       
        y +=h;
        //cell 17-23
        leftrightcells(g2d);
        
        //cell 24
        xpoints[0] = x;                  ypoints[0] = y;
        xpoints[1] = x + (height/7);     ypoints[1] = y;
        xpoints[2] = x + (height/7);     ypoints[2] = y + h - (height/7);
        xpoints[3] = x;                  ypoints[3] = y + h;
        xpoints[4] = x;                  ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        //cell 25
        xpoints[0] = x + (height/7);                        ypoints[0] = y + h - (height/7);
        xpoints[1] = x + (((xcoord - width) - width)/3);    ypoints[1] = y + h - (height/7);
        xpoints[2] = x + (((xcoord - width) - width)/3);    ypoints[2] = y + h;
        xpoints[3] = x;                                     ypoints[3] = y + h;
        xpoints[4] = x + (height/7);         ypoints[4] = y + h - (height/7);
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        y += h;
        w = ((xcoord - width) - width)/3;
        h = height/ 7 ;
        //cell 26-32
        updowncells(g2d);
       
        //cell 33
        y -= h;
        x += w;
        g2d.drawRect(x, y, w, h); 
        cellnumbers.add(new Point(x,y));
       
        x += w;
        //cells 34-40
        downupcells(g2d);
       
        //cell 41
        xpoints[0] = x;                     ypoints[0] = y;
        xpoints[1] = x + w - (width/7);     ypoints[1] = y;
        xpoints[2] = x + w;                 ypoints[2] = y + h;
        xpoints[3] = x;                     ypoints[3] = y + h;
        xpoints[4] = x;                     ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
      
        //y = y + h - w;
        h = (ycoord - (2*height))/3;
        w = width/7;
       
        //cell 42
        xpoints[0] = x + ((xcoord - (2*width))/3) - w;          ypoints[0] = y + (height/7) -h ;
        xpoints[1] = x + ((xcoord - (2*width))/3) ;             ypoints[1] = y + (height/7) -h ;
        xpoints[2] = x + (((xcoord - width) - width)/3);        ypoints[2] = y + (height/7) ;
        xpoints[3] = x + ((xcoord - (2*width))/3) - w;     ypoints[3] = y;
        xpoints[4] = x + ((xcoord - (2*width))/3) - w;     ypoints[4] =  y + (height/7) -h;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
       
        w = width/7;
        //43-49
        x = x + ((xcoord - (2*width))/3);
        y = y + (height/7) - h;
  
        leftrightcells(g2d);
        //cell 50
        y -= h;
        x -= w;
        g2d.drawRect(x, y, w, h); 
        cellnumbers.add(new Point(x,y));
        
        //cell 51-57
        y -= h;
        rightleftcells(g2d);
        
        //cell 58
        xpoints[0] = x ;             ypoints[0] = y + (height/7);
        xpoints[1] = x + w;          ypoints[1] = y;
        xpoints[2] = x + w;          ypoints[2] = y + h;
        xpoints[3] = x ;             ypoints[3] = y  + h;
        xpoints[4] = x ;             ypoints[4] = y + (height/7);
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        w = ((xcoord - width) - width)/3;
        h = height/7;
        //cell 59
        xpoints[0] = x + (width/7) - w ;           ypoints[0] = y;
        xpoints[1] = x + (width/7);                ypoints[1] = y;
        xpoints[2] = x;                            ypoints[2] = y + (height/7);
        xpoints[3] = x + (width/7) - w;            ypoints[3] = y  + (height/7);
        xpoints[4] = x  + (width/7) -w;            ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
       
        //cell 60-66
        x = x + (width/7) - w;
        y -=h;
        downupcells(g2d);
       
        //cell 67
        y += h;
        x -= w;
        g2d.drawRect(x, y, w, h); 
        cellnumbers.add(new Point(x,y));
      
        Stroke stroke = new BasicStroke(2.0f);
        //cell 68-74 red safety
        g2d.setColor(Color.RED);
        y += h;
        for (int k = 0; k < 7; k++)     //top center
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.red);
            
            cellnumbers.add(new Point(x, y));
            y += h;
	}
        p = cellnumbers.get(4);
        g2d.fillRect((int)p.getX(), (int)p.getY(), w, h);
        //g2d.setStroke(stroke);
        
        y -= h;
        x = x - w - (6*(width/7));
        h = (ycoord - (2*height))/3;
        w = width/7;
        y += h;
        
        //cell  75-81 green safety
        g2d.setPaint(Color.GREEN);
        for (int k = 0; k < 6; k++)     //left center
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.green);
            
            cellnumbers.add(new Point(x, y));
            x += w;
        }
        p = cellnumbers.get(21);
        g2d.fillRect((int)p.getX(), (int)p.getY(), w, h);
        //g2d.setStroke(stroke);
        
        g2d.fillRect(x, y, (height/7), h);
        g2d.setStroke(stroke);
        g2d.setColor(Color.black);
        g2d.drawRect(x, y, (height/7), h);
        g2d.setPaint(Color.green);
            
        cellnumbers.add(new Point(x, y));
        
        y += 2*h;
        w = ((xcoord - width) - width)/3;
        x = x + w;
        h = height/ 7 ;
        y += (5*h);
        //cell  82-88 blue safety
        g2d.setPaint(Color.BLUE);
        for (int k = 0; k < 7; k++)     //bottom center
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.blue);
            
            cellnumbers.add(new Point(x, y));
            y -= h;
        }
        p = cellnumbers.get(38);
        g2d.fillRect((int)p.getX(), (int)p.getY(), w, h);
        //g2d.setStroke(stroke);
        
        //right center
        h = (ycoord - (2*height))/3;
        y = 7*(height/7) + h;
        x += 2*w;
        w = width/7;
        x += 5*w;
        //cell  89-95 yellow safety
        g2d.setPaint(Color.YELLOW);
        for (int k = 0; k < 7; k++)     
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.YELLOW);
            
            cellnumbers.add(new Point(x, y));
            x -= w;
        }
        p = cellnumbers.get(55);
        g2d.fillRect((int)p.getX(), (int)p.getY(), w, h);
        //g2d.setStroke(stroke);
        
        g2d.setColor(Color.red);
        g2d.fillOval(0, 0, width, height);
        cellnumbers.add(new Point(0, 0));       //red circle cell 96
        
        g2d.setColor(Color.GREEN);
        g2d.fillOval(0, ycoord-height, width, height);
        cellnumbers.add(new Point(0, ycoord-height));  // green cirle cell 97
         
        g2d.setColor(Color.BLUE);
        g2d.fillOval(xcoord-width, ycoord - height, width, height);
        cellnumbers.add(new Point(xcoord - width, ycoord-height));  // blue cirle cell 98
        
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(xcoord - width, 0, width, height); 
        cellnumbers.add(new Point(xcoord - width, 0));  // yellow cirle cell 99
        
        x = (7*width/7) + (height/7);
        y = 8 * (height/7);
        w = (xcoord - (2*width)) - (width/7)- (height/7);
        h =(ycoord - (2*height)) - (2*(height/7)) ;
        g2d.drawImage(image, x,y,w,h, null);
        cellnumbers.add(new Point(x, y));  // HOME cell 100
        
        try {
            startgame();
        } catch (IOException ex) {
            //Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int space = 0;      
        for(int i = 0; i < 1; ++i)
        {
          for(int j = 0; j < 4; ++j)
          {
             
             g2d.drawImage(gPieces[i][j], (width/2 + space), (height/2 + space),null);
             space = space + 10; 

          }
          
        }
        
        // g2d.drawImage(gPieces[0], width/2, test, null);
        //  g2d.drawImage(gPieces[0], ((xcoord-width) + width/2), height/2, null);
        //  g2d.drawImage(gPieces[0], ((xcoord-width) + width/2), ((ycoord-height) + height/2), null);
        
    }
}
