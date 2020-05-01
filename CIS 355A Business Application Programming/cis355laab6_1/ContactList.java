import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ContactList {

    /**
     * Create a database connection
     */
    public static Connection getConnection() {
        // JDBC driver name and database URL
        
        String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
        String DB_CONN_STRING = "jdbc:mysql://Devry.edupe.net:4300/CIS355A_iLab6";

        // Database credentials 
        Properties info = new Properties();
        info.put("user", "3370"); // change user id
        info.put("password", "9kkHdVWx9TlBjG74"); // change password
      

        Connection result = null;
        try {
            Class.forName(DRIVER_CLASS_NAME).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error loading driver: " + DRIVER_CLASS_NAME);
        }

        try {
            result = DriverManager.getConnection(DB_CONN_STRING, info);
        } catch (SQLException ex) {
            System.out.println("Driver loaded, but cannot connect to db: " + DB_CONN_STRING);
        }
        return result;
    }

    public void addContact() {

        String name = JOptionPane.showInputDialog("Please input your full name");
        String phone = JOptionPane.showInputDialog("Please input your phone number");
        Connection conn = getConnection();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String sql = "INSERT INTO Contact "
                    + "VALUES ('" + name + "', '" + phone + " ')";

            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Contact Added");
            stmt.close();
        } catch (Exception se) {
            se.printStackTrace();
        }

    }

    public void viewContact() {

        Connection conn = getConnection();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String select;
            select = "SELECT * from Contact";
            ResultSet rs = stmt.executeQuery(select);
            System.out.println("Contact List:");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.println(rs.getString(2));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ContactList conact = new ContactList();
        conact.addContact();
        conact.viewContact();

    }
}

