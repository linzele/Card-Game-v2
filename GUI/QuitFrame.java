package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Player;

public class QuitFrame extends JFrame implements ActionListener{

	private QuitPanel quitPanel;
	private boolean submit;
	
	public QuitFrame() {
		setPreferredSize(new Dimension(321,194));
		this.quitPanel = new QuitPanel();
		add(this.quitPanel);
		pack();
		
		setTitle("Exit");
		setLocationRelativeTo(null);
		quitPanel.getConfirmButton().addActionListener(this);
		quitPanel.getCancel().addActionListener(this);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource() == quitPanel.getConfirmButton())
		{
			submit = true;
		}
		
		
		else if (e.getSource() == quitPanel.getCancel())
		{
			submit = true;
			
			dispose();
		}
		
	}
	
	public boolean getSubmit()
	{
		return this.submit;
	}
	
	public void setSubmit(boolean submit)
	{
		this.submit = submit;
	}
	
	public String getPasswordText()
	{
		return quitPanel.getPassword();
	}
	
	public JButton getSubmitButton()
	{
		return quitPanel.getConfirmButton();
	}
	
	public void displayError(String message)
	{
		JOptionPane.showMessageDialog(this, message,"Wrong password!",JOptionPane.ERROR_MESSAGE);
	}
	
	
	
}
