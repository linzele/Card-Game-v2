package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ShuffleFrame extends JFrame{

	
	private ShufflePanel shufflePanel;
	
	public ShuffleFrame() 
	{
		
		setPreferredSize(new Dimension(1024, 768));
		this.shufflePanel = new ShufflePanel();
		add(this.shufflePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Shuffling");	
		pause();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void pause() 
	{
	 try
	 {
	     Thread.sleep(2000);
	 }
	 catch(Exception e){}
	 }
	


}
