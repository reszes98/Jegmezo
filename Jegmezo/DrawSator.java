package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : DrawSator.java
//  @ Date : 2020. 05. 05.
//  @ Author : 
//
//

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Henrik
 * A S�tor kirajzol�s�t val�sitja meg
 */
public class DrawSator extends Drawable {

	/**
	 * Bet�lti a s�tor k�p�t
	 */
	public DrawSator() {
		try {
			img=ImageIO.read(new File("./Jegmezo/image/tent.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a s�tort
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80+40, getPositionY()*80+40, null);
	}
	

}
