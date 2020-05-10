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
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawSator extends Drawable {
	private Image satorImage;
	public DrawSator() {
		try {
			satorImage=ImageIO.read(new File("./Jegmezo/image/tent.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		
		g.drawImage(satorImage, getPositionX()*80, getPositionY()*80, null);
	}
	
	public void setPosition(int px, int py) 
	{
		super.setPosition(px, py);
	}
	public void setPositionX(int px) 
	{
		super.setPositionX(px);
	}
	public void setPositionY(int py) 
	{
		super.setPositionY(py);
	}
	public int getPositionX() 
	{
		return super.getPositionX();
	}
	public int getPositionY() 
	{
		return super.getPositionY();
	}
}
