package Fxx.test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Fxx.test.GameFram.PaintThread;

public class MyFrame extends Frame {
	
	public void launchFram(){
		setSize(Canstant.GAME_WIDTH,Canstant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);{
					System.exit(0);
				}
			}
		});
	}
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
