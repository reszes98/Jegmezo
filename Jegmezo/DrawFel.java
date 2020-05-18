package Jegmezo;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Henrik
 * A Fel ir�ny kirajzol�s�t val�sitja meg
 */
public class DrawFel extends Drawable{

	/**
	 * Bet�lti a fel ir�ny k�p�t
	 */
	public DrawFel() 
	{
		try {
			img=ImageIO.read(new File("./Jegmezo/image/arrup.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a fel ir�nyt
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80+25, getPositionY()*80, null);
	}
	
}
