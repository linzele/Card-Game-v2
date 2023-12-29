package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import AdminMod.Utility;

public class LoginPanel extends JPanel implements ActionListener {

	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JTextField passwordText;
	private JButton button;
	private JLabel activity;
	private boolean submit;

	public LoginPanel() {
		super();
		setLayout(null);
		setPreferredSize(new Dimension(321, 174));

		// LABEL
		userLabel = new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);
		add(userLabel);

		// TEXTFIELD
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		add(userText);

		// PASSWORD
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		add(passwordLabel);

		// PASSWORD FIELD
		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 50, 165, 25);
		add(passwordText);

		// BUTTON
		button = new JButton("Login");
		button.setBounds(140, 90, 80, 25);
		button.addActionListener(this);

		add(button);

		// ANY MESSAGE
		activity = new JLabel("");
		activity.setBounds(10, 110, 300, 25);
		activity.setForeground(Color.red);
		add(activity);
	}

	public String getUserText() {
		return this.userText.getText();
	}

	public JButton getDefaultButton() {
		return this.button;
	}

	public void displayError(String message) {
		JOptionPane.showMessageDialog(this, message, "Invalid account", JOptionPane.ERROR_MESSAGE);
	}

	public String getPassword() {
		return this.passwordText.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {
			submit = true;
		}

	}

	public boolean getSubmit() {
		return this.submit;
	}

	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

}
