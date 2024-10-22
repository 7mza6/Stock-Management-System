package stock.management.system.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static stock.management.system.application.form.other.FormDashboard.getConnection;


public class Customers {
    private Connection connection;

    public Customers() throws SQLException {
        this.connection = getConnection();
    }

    public void addCustomer(String name, String email, String phoneNumber, String address) {
        String sql = "INSERT INTO customers (Name, Email, PhoneNumber, Address) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);
            statement.setString(4, address);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer added successfully!");
            } else {
                System.out.println("Failed to add customer.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to add customer!");
            e.printStackTrace();
        }
    }

    public void updateCustomer(int customerId, String name, String email, String phoneNumber, String address) {
        String sql = "UPDATE customers SET Name=?, Email=?, PhoneNumber=?, Address=? WHERE CustomerID=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);
            statement.setString(4, address);
            statement.setInt(5, customerId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer information updated successfully!");
            } else {
                System.out.println("No customer found with ID: " + customerId);
            }
        } catch (SQLException e) {
            System.err.println("Failed to update customer information!");
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM customers WHERE CustomerID=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customerId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Customer deleted successfully!");
            } else {
                System.out.println("No customer found with ID: " + customerId);
            }
        } catch (SQLException e) {
            System.err.println("Failed to delete customer!");
            e.printStackTrace();
        }
    }

    public static List<Vector> getAllCustomers() throws SQLException {
        String sql = "SELECT * FROM customers";
        List<Vector> customers = new ArrayList<>();
        Connection connection = getConnection();
        int c;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
            c = Rss.getColumnCount();
            while (resultSet.next()) {
                Vector customer = new Vector();
                for (int k = 1; k <= c; k++) {
                    customer.add(resultSet.getString(k));
                }
                customers.add(customer);
                
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve customers!");
            e.printStackTrace();
        }
        return customers;
    }
    
    public static List<String> getAllCustomersName() throws SQLException {
    List<String> customerNames = new ArrayList<>();
    Connection connection = getConnection();

    String sql = "SELECT Name FROM customers";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            customerNames.add(name);
        }
    } catch (SQLException e) {
        System.err.println("Failed to retrieve customer names!");
        e.printStackTrace();
    }

    return customerNames;
}
     public static int getRowId(int rowNum) throws SQLException {
         int id =0 ;
        Connection connection = getConnection();
        String sql = "SELECT *FROM Customers ORDER BY (SELECT NULL) OFFSET ? ROWS FETCH NEXT 1 ROWS ONLY";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rowNum  );
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
            while (resultSet.next()) {
             id = resultSet.getInt("CustomerID");
                }
            }
        
         catch (SQLException ex) {
            Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }
                return id;
    }
     
     public static void SelectedCustomer(int id) throws SQLException {
        String sql = "UPDATE cart SET CustomerID = ?";
        Connection connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
