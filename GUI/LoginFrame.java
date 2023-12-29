package GUI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginFrame extends JFrame{

	private LoginPanel loginPanel;
	
	public LoginFrame()
	{
		setPreferredSize(new Dimension(321,174));
		this.loginPanel = new LoginPanel();
		add(this.loginPanel);
		pack();
		setVisible(true);
		setTitle("Game Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public LoginPanel getLoginPanel()
	{
		return this.loginPanel;
	}
	
	

	public JButton getSubmitButton()
	{
		return loginPanel.getDefaultButton();
	}
	
	
}
