package Jegmezo;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawLe extends Drawable{

	/**
	 * Betölti a le irány képét
	 */
	public DrawLe() 
	{
		try {
			img=ImageIO.read(new File("./Jegmezo/image/arrdown.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a le irány képét
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80+25, getPositionY()*80+40, null);
	}
	
	
}
