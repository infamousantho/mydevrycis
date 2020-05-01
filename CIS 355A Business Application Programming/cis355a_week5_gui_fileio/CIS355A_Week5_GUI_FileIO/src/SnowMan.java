/***********************************************************************
Program Name: SnowMan.java
Programmer's Name: Student Name
Program Description: This class displays a snow man
***********************************************************************/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class SnowMan extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame("Snow Man"); //frame object for the display
	
	public SnowMan(){
		frame.add(this);
  	  	frame.setSize(500, 500);
  	  	frame.setResizable(false);
		frame.setVisible(true);
	}
	/**
	 * paintComponent method 
	 * @param  g Graphics object
	 */
	public void paintComponent(Graphics g)
    {
          super.paintComponent(g);// Base class method clears background
       
          //fill a rectangle as per the size of the frame with black color
          g.setColor(Color.CYAN);
          g.fillRect(0, 0, getWidth(), getHeight());          
          g.setColor(Color.white);
          g.fillOval(100,50, 100, 100);
          g.fillOval(50,145, 200, 200);
          g.setColor(Color.black);
          g.translate(125, 10);
          g.fillPolygon(new Polygon(
                  new int[]{25, 50, 0},
                  new int[]{0, 50, 50},
                  3));
          g.translate(0, 70);
          g.setColor(Color.BLUE);
          g.fillRect(0, 0, 10, 10); 
          g.translate(40, 0);
          g.setColor(Color.BLUE);
          g.fillRect(0, 0, 10, 10); 
          g.translate(-20, 20);
          g.setColor(Color.GREEN);
          g.fillOval(0,0, 10, 10);
          g.setColor(Color.red);
          g.translate(-20, -20);
          g.drawArc(0, 0, 50,50, 240, 70);
          g.translate(20, 100);
          g.setColor(Color.black);
          g.fillOval(0,0, 15, 15);
          g.translate(0, 30);
          g.setColor(Color.red);
          g.fillOval(0,0, 15, 15);
          g.translate(0, 30);
          g.setColor(Color.GREEN);
          g.fillOval(0,0, 15, 15);
          g.translate(100, -100);
          int fontSize = 20;

          g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
           
          g.setColor(Color.red);
          
          g.drawString("This is my SnowMan", 10, 20);
        
         
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnowMan s = new SnowMan();
	}

}
