import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/***********************************************************************
Program Name: CarCare.java
Programmer's Name: 
Program Description: CarCare class with Menus, MenuItems, Menubar, and so forth
Using appropriate event handlers
***********************************************************************/

public class CarCare extends JFrame implements ActionListener {

    public String oilChange = "", carWash = "";
    public int oilChangeCost, carWashCost;

    CarCare() {

        setTitle("Quick Fast Car Care");
        setSize(450, 250);

        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();

        // Add the menubar to the frame
        setJMenuBar(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu oilChangeMenu = new JMenu("Oil Change");
        JMenu carWashMenu = new JMenu("Car Wash");
        JMenu fileMenu = new JMenu("Total/Clear/Exit");
        menuBar.add(oilChangeMenu);
        menuBar.add(carWashMenu);
        menuBar.add(fileMenu);

        // Create and add simple menu item to one of the drop down menu
        JMenuItem bronzeAction = new JMenuItem("Bronze");
        bronzeAction.addActionListener(this);

        JMenuItem silverAction = new JMenuItem("Silver");
        silverAction.addActionListener(this);

        JMenuItem goldAction = new JMenuItem("Gold");
        goldAction.addActionListener(this);

        JMenuItem basicAction = new JMenuItem("Basic");
        basicAction.addActionListener(this);

        JMenuItem betterAction = new JMenuItem("Better");
        betterAction.addActionListener(this);

        JMenuItem bestAction = new JMenuItem("Best");
        bestAction.addActionListener(this);

        JMenuItem totalAction = new JMenuItem("Total");
        totalAction.addActionListener(this);

        JMenuItem clearAction = new JMenuItem("Clear");
        clearAction.addActionListener(this);

        JMenuItem exitAction = new JMenuItem("Exit");
        exitAction.addActionListener(this);

        oilChangeMenu.add(bronzeAction);
        oilChangeMenu.add(silverAction);
        oilChangeMenu.add(goldAction);
        carWashMenu.add(basicAction);
        carWashMenu.add(betterAction);
        carWashMenu.add(bestAction);
        fileMenu.add(totalAction);
        fileMenu.addSeparator();
        fileMenu.add(clearAction);
        fileMenu.add(exitAction);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase("Bronze")) {
            oilChange = "Bronze";
            oilChangeCost = 20;
        } else if (e.getActionCommand().equalsIgnoreCase("Silver")) {
            oilChange = "Silver";
            oilChangeCost = 25;
        } else if (e.getActionCommand().equalsIgnoreCase("Gold")) {
            oilChange = "Gold";
            oilChangeCost = 30;
        } else if (e.getActionCommand().equalsIgnoreCase("Basic")) {
            carWash = "Basic";
            carWashCost = 5;
        } else if (e.getActionCommand().equalsIgnoreCase("Better")) {
            carWash = "Better";
            carWashCost = 10;
        } else if (e.getActionCommand().equalsIgnoreCase("Best")) {
            carWash = "Best";
            carWashCost = 15;
        } else if (e.getActionCommand().equalsIgnoreCase("Total")) {
            int total = carWashCost + oilChangeCost;
            String msg = "Oil Change: " + oilChange + "\nCar Wash: " + carWash;
            JOptionPane.showMessageDialog(rootPane, msg
                    + "\nTotal Cost: $" + total);
        } else if (e.getActionCommand().equalsIgnoreCase("Clear")) {
            carWashCost = 0;
            oilChangeCost = 0;
            oilChange = "";
            carWash = "";
        } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {
            System.exit(0);
        }

    }

}
