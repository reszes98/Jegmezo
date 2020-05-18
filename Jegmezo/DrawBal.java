package Jegmezo;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Henrik
 * A Bal ir�ny kirajzol�s�t val�sitja meg
 */
public class DrawBal extends Drawable{

	/**
	 * Bet�lti a balra ir�ny k�p�t
	 */
	public DrawBal() 
	{
		try {
			img=ImageIO.read(new File("./Jegmezo/image/arrleft.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a balra ir�nyt
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80, getPositionY()*80+25, null);
	}
	
}
