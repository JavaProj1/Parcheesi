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
    private static int hsize;
    private static int wsize;
    private static int x;// starting
    private static int y;
    private static int w;
    private int h;
    private static ArrayList<Point> cellnumbers;
    private int[] xpoints;
    private int[] ypoints;
    private BufferedImage image,smaller;
    
    public GameBoard() 
    {
        try {
                image = ImageIO.read(this.getClass().getResource("home.jpg"));
                //smaller = Scalr.resize(image,150);
                
        }catch (IOException ex){
        }
       // this(true);
    }
    
    public GameBoard(boolean isDoubleBuffered)
    {
        super(null, isDoubleBuffered);
    }
    
    public GameBoard(LayoutManager layout, boolean isDoubleBuffered)
    {
        super(layout, true);
    }
    
    public GameBoard(LayoutManager layout)
    {
        this(layout,true);
    }
    
    public void updowncells(Graphics g)
    {
        w = wsize;
        h = hsize;
        for (int k = 0; k < 7; k++)     
        {
            g.drawRect(x, y, w, h);
            cellnumbers.add(new Point(x, y));
            y += hsize;
	}
    }
    
    public void rightleftcells(Graphics g)
    {
        for (int k = 0; k < 7; k++)     
        {
		g.drawRect(x, y, w, h);
		cellnumbers.add(new Point(x, y));
		x -= hsize;
	}   
    }
    public void leftrightcells(Graphics g)
    {
        for (int k = 0; k < 7; k++) 
        {
            g.drawRect(x, y, w, h);
            cellnumbers.add(new Point(x, y));
            x += hsize;
	}
    }
    public void downupcells(Graphics g)
    {
        for (int k = 0; k < 7; k++)     
        {
            g.drawRect(x, y, w, h);
            cellnumbers.add(new Point(x, y));
            y -= hsize;
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
        int width = xcoord/3;
        int height = ycoord/3;
        
        int difLength = (xcoord - width) - width;
        int ydifLength = (ycoord - height ) - height;
        x = 230;// starting
	y = 0;
        
        wsize = difLength / 3;
        hsize = ydifLength / 7;
        
	x = width;// starting
	y = 0;
        w = wsize;
        h = hsize;
        
        cellnumbers = new ArrayList<Point>(); //saves cell location
  
        g2d.setColor(Color.BLACK);
        
        //wraps around like a swirl
        //cell 0-6
        updowncells(g2d);
        
        //cell 7 polygon
        xpoints[0] = x;         ypoints[0] = y;
        xpoints[1] = x + wsize;     ypoints[1] = y ;
        xpoints[2] = x  + wsize;       ypoints[2] = y + hsize;
        xpoints[3] = x + hsize;                 ypoints[3] = y + hsize;
        xpoints[4] = x + hsize;         ypoints[4] = y +hsize;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        //cell 8 polygon
        xpoints[0] = x;             ypoints[0] = y + 1;
        xpoints[1] = x + hsize;     ypoints[1] = y + hsize;
        xpoints[2] = x  + hsize;    ypoints[2] = y + wsize;
        xpoints[3] = x;             ypoints[3] = y + wsize;
        xpoints[4] = x;             ypoints[4] = y + hsize;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        h = wsize;
        w = hsize;
        x -= hsize;
        
        
        //cell 9-15
        rightleftcells(g2d);
       
        y += h;
        x += hsize;
        g2d.drawRect(x, y, w, h); //cell 16
        cellnumbers.add(new Point(x,y));
       
        y +=h;
        //cell 17-23
        leftrightcells(g2d);
        //cell 24
        xpoints[0] = x;             ypoints[0] = y;
        xpoints[1] = x + hsize;     ypoints[1] = y;
        xpoints[2] = x + hsize;     ypoints[2] = y + wsize - hsize;
        xpoints[3] = x;             ypoints[3] = y + wsize;
        xpoints[4] = x;             ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        //y += hsize;
        //cell 25
        xpoints[0] = x + hsize;         ypoints[0] = y + wsize - hsize;
        xpoints[1] = x + wsize;     ypoints[1] = y + wsize - hsize;
        xpoints[2] = x + wsize;    ypoints[2] = y + wsize;
        xpoints[3] = x;                 ypoints[3] = y + wsize;
        xpoints[4] = x + hsize;         ypoints[4] = y + wsize - hsize;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        y = y + wsize;
        //cell 26-32
       updowncells(g2d);
       
       y -= hsize;
       x += wsize;
       g2d.drawRect(x, y, w, h); //cell 33
       cellnumbers.add(new Point(x,y));
       
       x += wsize;
       //cells 34-40
       downupcells(g2d);
       
       //cell 41
        xpoints[0] = x;                     ypoints[0] = y;
        xpoints[1] = x + wsize - hsize;     ypoints[1] = y;
        xpoints[2] = x + wsize;             ypoints[2] = y + hsize;
        xpoints[3] = x;                     ypoints[3] = y + hsize;
        xpoints[4] = x;                     ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
       
       y += hsize;
       y -= wsize;
       
       //cell 42
        xpoints[0] = x + wsize - hsize;     ypoints[0] = y;
        xpoints[1] = x + wsize;             ypoints[1] = y;
        xpoints[2] = x + wsize;             ypoints[2] = y + wsize;
        xpoints[3] = x + wsize - hsize;     ypoints[3] = y  + wsize - hsize;
        xpoints[4] = x + wsize - hsize;     ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
       
        //43-49
        x += wsize;
        h = wsize;
        w = hsize;
        leftrightcells(g2d);
        //cell 50
        y -=wsize;
        x -= hsize;
        g2d.drawRect(x, y, w, h); 
        cellnumbers.add(new Point(x,y));
        
        //cell 51-58
        y -= wsize;
        rightleftcells(g2d);
        
        //cell 59
        xpoints[0] = x + hsize;      ypoints[0] = y;
        xpoints[1] = x + hsize;      ypoints[1] = y + wsize;
        xpoints[2] = x;              ypoints[2] = y + wsize;
        xpoints[3] = x ;             ypoints[3] = y  + hsize;
        xpoints[4] = x + hsize;      ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        //cell 60
        xpoints[0] = x + hsize - wsize;    ypoints[0] = y;
        xpoints[1] = x + hsize;            ypoints[1] = y;
        xpoints[2] = x;                    ypoints[2] = y + hsize;
        xpoints[3] = x + hsize - wsize;    ypoints[3] = y  + hsize;
        xpoints[4] = x + hsize - wsize;    ypoints[4] = y;
        g2d.drawPolygon(xpoints, ypoints, 5);
        cellnumbers.add(new Point(x,y));
        
        //cell 61-68
        x = x + hsize - wsize;
        y -=hsize;
        h = hsize;
        w = wsize;
        downupcells(g2d);
        
        //cell 69
        y += hsize;
        x -= wsize;
        g2d.drawRect(x, y, w, h); 
        cellnumbers.add(new Point(x,y));
       
        Stroke stroke = new BasicStroke(2.0f);
        //cell 70-77 red home
        //float line[]={10.0f};
        //BasicStroke lines = new BasicStroke(1.0f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f,line,0.0f);
        g2d.setColor(Color.RED);
        y += hsize;
        for (int k = 0; k < 7; k++)     //top center
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.red);
            
            cellnumbers.add(new Point(x, y));
            y += hsize;
	}
      
        x = x - wsize - (6*hsize);
        y = y - hsize + wsize;
        h = wsize;
        w = hsize;
        
        g2d.setPaint(Color.GREEN);
        for (int k = 0; k < 7; k++)     //left center
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.green);
            
            cellnumbers.add(new Point(x, y));
            x += hsize;
        }
        
        x = x - hsize + wsize;
        y = y + (2*wsize) + (5* hsize);
        w =wsize;
        h = hsize;
        
        g2d.setPaint(Color.BLUE);
        for (int k = 0; k < 7; k++)     //bottom center
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.blue);
            
            cellnumbers.add(new Point(x, y));
            y -= hsize;
        }
        
        //right center
        y = y + (2*hsize) - (2 *wsize);
        x = x + (2*wsize) + (5 * hsize);
        w = hsize;
        h = wsize;
        g2d.setPaint(Color.YELLOW);
        for (int k = 0; k < 7; k++)     
        {
            g2d.fillRect(x, y, w, h);
            g2d.setStroke(stroke);
            g2d.setColor(Color.black);
            g2d.drawRect(x, y, w, h);
            g2d.setPaint(Color.YELLOW);
            
            cellnumbers.add(new Point(x, y));
            x -= hsize;
        }
        
        y = y - wsize + hsize;
        x = x + hsize - (3 * wsize)+ hsize;
        
      //  g2d.drawImage(image, x+42,y, null);
        
        g2d.setColor(Color.red);
        g2d.fillOval(0, 0, width, height);
        
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(xcoord - width, 0, width, height); 
         
        g2d.setColor(Color.GREEN);
        g2d.fillOval(0, ycoord-height, width, height);
         
        g2d.setColor(Color.BLUE);
        g2d.fillOval(xcoord-width, ycoord - height, width, height);
        
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
