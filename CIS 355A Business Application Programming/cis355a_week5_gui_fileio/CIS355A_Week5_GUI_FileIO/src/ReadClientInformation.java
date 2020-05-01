/***********************************************************************
Program Name: ReadClientInformation.java
Programmer's Name: Student Name
Program Description: This class reads information from the file and display it
***********************************************************************/

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReadClientInformation implements ActionListener {

	//GUI controls
		static JFrame frame ;
		static Container pane;
		
		static JLabel lblFileName;
		static JTextField txtFileName;
		static JButton btnDisplay;
		
		public ReadClientInformation(){
			frame = new JFrame("Client Information");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Set up the content pane.
	        pane = frame.getContentPane();

	        pane.setPreferredSize(new Dimension(500,100));
	        pane.setLayout(new GridLayout(3,1));
	        
	    	lblFileName = new JLabel("File to Read From:");
	    	txtFileName = new JTextField(25);
	    	txtFileName.setText("client.txt");
	    	JPanel pnlDisplay = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    	btnDisplay = new JButton("Dispaly");
	    	pane.add(lblFileName);
	    	pane.add(txtFileName);
	    	pnlDisplay.add(btnDisplay);
	    	btnDisplay.addActionListener(this);
	    	pane.add(pnlDisplay);
	    	//Display the frame
	        frame.pack();
	        frame.setVisible(true);
		}
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		ReadClientInformation r = new ReadClientInformation();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Client> clients = readFromFile(txtFileName.getText());
		System.out.println("\t\t\tClient Activity Report");
		System.out.format("%20s%20s%20s%20s","Client Name","Client ID","Starting Balance","Closing Balance");
		System.out.println();
		for(int i=0;i<clients.size();++i)
		{
			System.out.format("%20s%20s%20.2f%20.2f",clients.get(i).getClientName(), clients.get(i).getClientId(),
					clients.get(i).getStartingBalance(),clients.get(i).getClosingBalance());
			System.out.println();
			
		}
		
	}
	
	
	public ArrayList<Client> readFromFile(String fileName){
		
		ArrayList<Client> clients = new ArrayList<Client>();
		//Opens the file and display the contents
		  FileReader freader;
		try {
			freader = new FileReader(fileName);
				
		  BufferedReader in = new BufferedReader(freader);
		   
		  String clientInfo = "";
		   while((clientInfo = in.readLine()) != null)
		   {
			   String[] clientattr = clientInfo.split("\\|");
			   if(clientattr.length==4){
			   Client c = new Client(clientattr[0],clientattr[1],Double.parseDouble(clientattr[2]),Double.parseDouble(clientattr[3]));
			   clients.add(c);			
			   }
			   
		   }
		    in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clients;
	}
	

}
