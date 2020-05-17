package Jegmezo;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawJobb extends Drawable{

	/**
	 * Bet�lti a jobb ir�ny k�p�t
	 */
	public DrawJobb() 
	{
		try {
			img=ImageIO.read(new File("./Jegmezo/image/arright.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a jobb ir�ny k�p�t
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img,getPositionX()*80+40, getPositionY()*80+25, null);
	}
	
}
