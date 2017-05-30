package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import fxx.util.Constant;

public class Bullet extends GameObjects{
	protected double degree;
	
	public Bullet(){
		initial();
	}
	
	public void draw(Graphics g){
		Color c= g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		g.setColor(c);
		move();
	}
	public void initial(){
		this.x=Constant.GAME_WIDTH/2;
		this.y=Constant.GAME_HEIGHT/2;
		width=10;
		height=10;
		speed=3;
		degree = Math.random()*Math.PI*2;
	}
	
	
	public void move(){
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(x<=width||x>=Constant.GAME_WIDTH-width){
			degree=Math.PI-degree;
		}
		if(y<=height||y>=Constant.GAME_HEIGHT-height){
			degree = -degree;
		}
	}
	
}
