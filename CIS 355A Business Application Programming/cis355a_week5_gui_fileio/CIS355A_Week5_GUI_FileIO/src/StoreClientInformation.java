/***********************************************************************
Program Name: StoreClientInformation.java
Programmer's Name: Student Name
Program Description: This class stores client information in a file
***********************************************************************/

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class StoreClientInformation implements ActionListener{

	//GUI controls
	static JFrame frame ;
	static Container pane;
	
	static JLabel lblClientName;
	static JLabel lblClientId;
	static JLabel lblStartingBal;
	static JLabel lblClosingBal;
	
	static JTextField txtClientName;
	static JTextField txtClientId;
	static JTextField txtStartingBal;
	static JTextField txtClosingBal;
	
	static JButton btnSave;
	
	public StoreClientInformation()
    {
 		frame = new JFrame("Client Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        pane = frame.getContentPane();

        pane.setPreferredSize(new Dimension(500,100));
        pane.setLayout(new GridLayout(2,1));
        
    	 
        //Panel for input controls
    	JPanel pnlInput = new JPanel(new GridLayout(2,4));
        //Create the input fields
        lblClientName = new JLabel("Client Name:");
    	txtClientName = new JTextField(25);
    	lblClientId = new JLabel("Client ID:");
    	txtClientId = new JTextField(25);
    	lblStartingBal = new JLabel("Starting Balance:");
    	txtStartingBal = new JTextField(25);
    	lblClosingBal = new JLabel("Closing Balance:");
    	txtClosingBal = new JTextField(25);
    	btnSave = new JButton("Save");
    	btnSave.addActionListener(this);
    	
    	pnlInput.add(lblClientName);
    	pnlInput.add(txtClientName);
    	pnlInput.add(lblClientId);
    	pnlInput.add(txtClientId);
    	pnlInput.add(lblStartingBal);
    	pnlInput.add(txtStartingBal);
    	pnlInput.add(lblClosingBal);
    	pnlInput.add(txtClosingBal);
    	
    	
    	pane.add(pnlInput);
    	JPanel pnlSave = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	pnlSave.add(btnSave);
    	pane.add(pnlSave);
    	
    	//Display the frame
        frame.pack();
        frame.setVisible(true);
    }
	
	public static boolean saveToFile(String clientInfo){
		String file_name = "client.txt";
		  File file = new File(file_name);
		 
		try {
			if(!file.exists()){
    			file.createNewFile();
    		}
		  FileWriter fstream = new FileWriter(file_name,true);
		  BufferedWriter out = new BufferedWriter(fstream);
		  
		  out.write(clientInfo);
		  out.newLine();
		  out.close();
		  return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
			@SuppressWarnings("unused")
			StoreClientInformation c = new StoreClientInformation();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String clientName = txtClientName.getText();
		String clientId = txtClientId.getText();
		DecimalFormat df = new DecimalFormat("#.00");
		double startBal = Double.parseDouble(txtStartingBal.getText());
		double closeBal = Double.parseDouble(txtClosingBal.getText());
		String contents = clientName + "|" + clientId + "|" + df.format(startBal) +"|" + df.format(closeBal) + "\n";
		boolean isSaved = saveToFile(contents);
		if(isSaved){
		JOptionPane.showMessageDialog(null,"Client Information Saved Successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Client Information could not be Saved.");
		}
	}

}
