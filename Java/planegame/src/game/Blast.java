package game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import fxx.util.GameUtil;

public class Blast {
	ArrayList<Image> boom = new ArrayList<Image>();
	double x,y;
	public Blast(){
		for(int i=1;i<=16;i++)
		{
			boom.add(GameUtil.getImage("blastimages/e"+i+".gif"));
		}
	}
	public void draw(Graphics g,double x,double y){
		for(Image I:boom){
			g.drawImage(I,(int) x,(int) y, null);
		}
	}
}
