/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.management.system.classes;

/**
 *
 * @author a-z
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import static stock.management.system.application.form.other.FormDashboard.getConnection;
public class Items {
  
    private static Connection connection;
    public Items() throws SQLException {
        this.connection = getConnection();
    }
        public void addItem(String name, int quantity, double weight, String category, double price, String barcode, String code, String status, String description, int sectionId, int warehouseId, int companyId) {
        String query = "INSERT INTO items (name, quantity, weight, category, price, barcode, code, status, description, sectionId, warehouseId, companyId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setDouble(3, weight);
            statement.setString(4, category);
            statement.setDouble(5, price);
            statement.setString(6, barcode);
            statement.setString(7, code);
            statement.setString(8, status);
            statement.setString(9, description);
            statement.setInt(10, sectionId);
            statement.setInt(11, warehouseId);
            statement.setInt(12, companyId);
            
            statement.executeUpdate();

            
            
        }
        
        catch (SQLException e) {
            System.err.println("Failed to create item!");
            e.printStackTrace();
        }
    

    }
    public void updateItem(int id, String name, int quantity, double weight, String category, double price, String barcode, String code, String status, String description, int sectionId, int warehouseId, int companyId) {
    String sql = "UPDATE Items SET name=?, quantity=?, weight=?, category=?, price=?, barcode=?, code=?, status=?, description=?, sectionId=?, warehouseId=?, companyId=? WHERE id=?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, name);
        statement.setInt(2, quantity);
        statement.setDouble(3, weight);
        statement.setString(4, category);
        statement.setDouble(5, price);
        statement.setString(6, barcode);
        statement.setString(7, code);
        statement.setString(8, status);
        statement.setString(9, description);
        statement.setInt(10, sectionId);
        statement.setInt(11, warehouseId);
        statement.setInt(12, companyId);
        statement.setInt(13, id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("No item found with ID: " + id);
        }
    } catch (SQLException e) {
        System.err.println("Failed to update item!");
        e.printStackTrace();
    }
}
    
    
    public void takenItem(int id,int quantity) {
    String sql = "UPDATE Items SET quantity=(quantity - ?) WHERE id=?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, quantity);
        statement.setInt(2, id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("No item found with ID: " + id);
        }
    } catch (SQLException e) {
        System.err.println("Failed to update item!");
        e.printStackTrace();
    }
}

    
    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Warehouse deleted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Failed to delete warehouse!");
            e.printStackTrace();
        }
    }
  
    public static List<Vector> getAllItems() throws SQLException {
    Connection connection = getConnection();
    List<Vector> items = new ArrayList<>();
    
    String sql = "SELECT i.id, i.name, i.quantity, i.weight, i.category, i.price, i.barcode, i.code, i.status, i.description, " +
                 "s.Name AS name, w.Name AS name, c.Name AS name " +
                 "FROM items i " +
                 "LEFT JOIN Sections s ON i.sectionId = s.ID " +
                 "LEFT JOIN Warehouses w ON i.warehouseId = w.ID " +
                 "LEFT JOIN companys c ON i.companyId = c.ID";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Vector<Object> item = new Vector<>();
            for (int k = 1; k <= columnCount; k++) {
                item.add(resultSet.getObject(k)); 
            }
            items.add(item);
        }
    } catch (SQLException e) {
        System.err.println("Failed to retrieve items!");
        e.printStackTrace();
        throw e; // It's usually better to throw the exception to be handled by the caller
    }

    return items;
}


    public static int getQuantity(int id) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT * FROM items WHERE id = ?";
        int Quantity = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            java.sql.ResultSetMetaData Rss = resultSet.getMetaData();

            while (resultSet.next()) {
                    Quantity= resultSet.getInt("quantity");

                }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve items!");
            e.printStackTrace();
        }
        return Quantity;
        }
    
public static Vector<Object> getItemById(int itemId) throws SQLException {
    Vector<Object> itemData = new Vector<>();
    
    String sql = "SELECT i.*, s.Name AS sectionName, s.ID AS sectionId, w.Name AS warehouseName, w.ID AS warehouseId, c.Name AS companyName, c.ID AS companyId " +
                 "FROM Items i " +
                 "LEFT JOIN Sections s ON i.sectionId = s.ID " +
                 "LEFT JOIN Warehouses w ON i.warehouseId = w.ID " +
                 "LEFT JOIN Companys c ON i.companyId = c.ID " +
                 "WHERE i.id = ?"; 
    
    try (Connection conn = getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, itemId);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                itemData.add(rs.getInt("id")); 
                itemData.add(rs.getString("name")); 
                itemData.add(rs.getInt("quantity")); 
                itemData.add(rs.getBigDecimal("weight")); 
                itemData.add(rs.getString("category")); 
                itemData.add(rs.getBigDecimal("price")); 
                itemData.add(rs.getString("barcode")); 
                itemData.add(rs.getString("code")); 
                itemData.add(rs.getString("status")); 
                itemData.add(rs.getString("description"));
                itemData.add(rs.getInt("sectionId"));
                itemData.add(rs.getString("sectionName"));
                itemData.add(rs.getInt("warehouseId"));
                itemData.add(rs.getString("warehouseName")); 
                itemData.add(rs.getInt("companyId")); 
                itemData.add(rs.getString("companyName")); 
            }
        }
    }
    return itemData; 
}

    }

