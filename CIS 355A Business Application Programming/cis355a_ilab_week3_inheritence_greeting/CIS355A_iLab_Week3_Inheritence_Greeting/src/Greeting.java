/***********************************************************************
Program Name: Greeting.java
Programmer's Name: Student Name
Program Description: This Applet inputs user name and displays it on the results label.
***********************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Greeting extends JApplet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		super.init();
		try {
			java.awt.EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					initComponents();
					invalidate();
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public JLabel inputLabel;
	public JLabel outputLabel;
	public JTextField inputText;
	public JButton GreetButton;

	public void initComponents() {
		setSize(500, 500);
		setBackground(Color.yellow);
		setLayout(new BorderLayout());

		inputLabel = new JLabel("Please enter your name:");
		inputText = new JTextField(20);
		GreetButton = new JButton("GREET");
		GreetButton.addActionListener(this);
		Panel topPanel= new Panel();
		topPanel.add(inputLabel);
		topPanel.add(inputText);
		topPanel.add(GreetButton);
		getContentPane().add(topPanel, BorderLayout.PAGE_START);

		outputLabel = new JLabel("Result goes Here");
		outputLabel.setFont(new Font("Serif", Font.BOLD, 32));
		outputLabel.setForeground(Color.BLUE);
		Panel midPanel = new Panel();
		midPanel.add(outputLabel);

		getContentPane().add(midPanel,BorderLayout.CENTER);
		getContentPane().setVisible(true);	    
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String text = inputText.getText();
		outputLabel.setText("Hello "+ text);

	}

}
