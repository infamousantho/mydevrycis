import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JavaPizza extends JFrame implements ActionListener, ChangeListener {

    JTextField nameTextField, phoneTextField, totalTextField; // Text fields
    JCheckBox pepperoniCheckBox, sausageCheckBox, mushroomCheckBox, onionCheckBox; // Check boxes
    JButton summaryButton = new JButton("Order Summary"); // Summary Button
    ButtonGroup btngroup = new ButtonGroup();
    private final int SMALL_PRICE = 8;
    private final int MEDIUM_PRICE = 10;
    private final int LARGE_PRICE = 12;
    String pizzaSize = "";
    String pizzaToppings = "";
    int totalPrice;

    JavaPizza() {
        super("Java Pizza");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        setSize(300, 200);
        //pack();
        setVisible(true);
    }

    public void addComponentsToPane(Container contentPane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add customer tab to the frame
        JPanel customerPanel = customerTab();
        tabbedPane.addTab("Customer", customerPanel);

        // Add size tab to the frame
        JPanel sizePanel = sizeTab();
        tabbedPane.addTab("Size", sizePanel);

        // Add topping tab to the frame
        JPanel toppingPanel = toppingTab();
        tabbedPane.addTab("Toppings", toppingPanel);

        // Add total tab to the frame
        JPanel totalPanel = totalTab();
        tabbedPane.addTab("Total", totalPanel);

        tabbedPane.addChangeListener(this);

        add(tabbedPane);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Variable for number of toppings selected
        int noOfTopings = 0;
        int price = 0; // Price of the pizza
        pizzaToppings = ""; // clear toppings

        JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
        int index = sourceTabbedPane.getSelectedIndex();

        // calculate if total tab is selected
        if (sourceTabbedPane.getTitleAt(index).equalsIgnoreCase("Total")) {

            // Get the size of the pizza
            ButtonModel b = btngroup.getSelection();
            if (b != null) {
                pizzaSize = b.getActionCommand();
            }

            // If size is not selected dsplay a message to select size
            if (pizzaSize.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Select size of your Pizza");
            } else {
                // calculate price of pizza
                if (pizzaSize.equalsIgnoreCase("Small")) {
                    price = SMALL_PRICE;
                } else if (pizzaSize.equalsIgnoreCase("Medium")) {
                    price = MEDIUM_PRICE;
                } else {
                    price = LARGE_PRICE;
                }

                // add toppings to the pizza
                if (pepperoniCheckBox.isSelected()) {
                    pizzaToppings += pepperoniCheckBox.getText();
                    noOfTopings += 2;
                }

                if (sausageCheckBox.isSelected()) {
                    pizzaToppings += sausageCheckBox.getText();
                    noOfTopings += 2;
                }

                if (mushroomCheckBox.isSelected()) {
                    pizzaToppings += mushroomCheckBox.getText();
                    noOfTopings += 2;
                }
                if (onionCheckBox.isSelected()) {
                    pizzaToppings += onionCheckBox.getText();
                    noOfTopings += 2;
                }
            }
        }
        // Calculate total price
        totalPrice = price + noOfTopings;
        totalTextField.setText(String.valueOf(totalPrice));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Create a new frame and display summary of the order
        JFrame frame = new JFrame("Order Summary");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(250, 200);
        JTextArea summaryTextArea = new JTextArea();
        String result = "Customer name: " + nameTextField.getText() + "\nPhone Number: " + phoneTextField.getText() + "\nSize: " + pizzaSize + "\nToppings: " + pizzaToppings + "\nTotal: " + totalPrice;
        summaryTextArea.setText(result);
        frame.getContentPane().add(summaryTextArea);
        frame.setVisible(true);
    }

    public JPanel customerTab() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Welcome to Java Pizza"));
        panel.add(new JLabel("Name: "));
        nameTextField = new JTextField(15);
        panel.add(nameTextField);
        panel.add(new JLabel("Phone Number: "));
        phoneTextField = new JTextField(15);
        panel.add(phoneTextField);
        panel.add(new JLabel(" "));
        panel.add(new JLabel(" "));

        return panel;
    }

    public JPanel sizeTab() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("What size pizza?", JLabel.CENTER));
        JRadioButton smallOption = new JRadioButton("Small");
        smallOption.setActionCommand("Small");
        JRadioButton mediumOption = new JRadioButton("Medium");
        mediumOption.setActionCommand("Medium");
        JRadioButton largeOption = new JRadioButton("Large");
        largeOption.setActionCommand("Large");

        btngroup.add(smallOption);
        btngroup.add(mediumOption);
        btngroup.add(largeOption);

        panel.add(smallOption);
        panel.add(mediumOption);
        panel.add(largeOption);

        return panel;
    }

    public JPanel toppingTab() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("What topping would you like?", JLabel.CENTER));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        pepperoniCheckBox = new JCheckBox("Pepperoni");
        sausageCheckBox = new JCheckBox("Sausage");
        mushroomCheckBox = new JCheckBox("Mushroom");
        onionCheckBox = new JCheckBox("Onion");

        panel.add(pepperoniCheckBox);
        panel.add(sausageCheckBox);
        panel.add(mushroomCheckBox);
        panel.add(onionCheckBox);

        return panel;
    }

    public JPanel totalTab() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Total Due"));
        totalTextField = new JTextField(15);
        panel.add(totalTextField);
        panel.add(summaryButton);
        summaryButton.addActionListener(this);

        return panel;
    }

    public static void main(String[] args) {
        JavaPizza pizza = new JavaPizza();
    }
}
