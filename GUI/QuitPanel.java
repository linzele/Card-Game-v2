package GUI;

import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class QuitPanel extends JPanel {

	private JLabel label;
	private JTextField password;
	private JButton confirm;
	private JButton cancel;
	
	public QuitPanel() {
		super();
		setLayout(null);
		setPreferredSize(new Dimension(321,194));
		
		label = new JLabel("Password");
		label.setBounds(50,57,69,20);
		
		add(label);
		
		password = new JPasswordField(20);
		password.setBounds(176,57,90,27);
		add(password);
		
		
		// CONFIRM BUTTON
		confirm = new JButton("confim");
		confirm.setBounds(45,103,90,27);
		add(confirm);
		
		// CANCEL BUTTON
		cancel = new JButton("cancel");
		cancel.setBounds(176,103,90,27);
		add(cancel);
	}
	
	public String getPassword()
	{
		return this.password.getText();
	}
	

	
	public JButton getConfirmButton()
	{
		return confirm;
	}
	
	public JButton getCancel()
	{
		return cancel;
	}
	
	
	
	
	
}
