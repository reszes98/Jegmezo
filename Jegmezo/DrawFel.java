package Jegmezo;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Henrik
 * A Fel irány kirajzolását valósitja meg
 */
public class DrawFel extends Drawable{

	/**
	 * Betölti a fel irány képét
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
	 * Kirajzolja a fel irányt
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80+25, getPositionY()*80, null);
	}
	
}
