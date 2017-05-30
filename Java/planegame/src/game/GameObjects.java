package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import fxx.util.GameUtil;

public class GameObjects {
	protected Image I;
	protected double x,y;
	protected double speed;
	protected int width,height;
	public GameObjects(){}
	
	
	public GameObjects(String imgPath, double x, double y, double speed, int width, int height) {
		I = GameUtil.getImage(imgPath);
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}


	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,width,height);
	}
	
	public void draw(Graphics g){
		g.drawImage(I,(int) x,(int) y, null);
	}
}
