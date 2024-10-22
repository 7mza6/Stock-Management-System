/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.management.system.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static stock.management.system.application.form.other.FormDashboard.getConnection;

public class Warehouses {
    private int id;
    private String name;
    private String location;
    private Connection connection;
 
    
    public Warehouses()  {
        try {
            this.connection = getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Warehouses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    public void addWarehouse(int id,String name, String location) {
        String sql = "INSERT INTO warehouses (name, location, companyId) VALUES (?, ?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setInt(3, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { 
                    System.out.println("Warehouse created successfully");
                
            } else {
                System.out.println("Failed to create warehouse.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to create warehouse!");
            e.printStackTrace();
        }
    }

    public void updateWarehouse(int id,String name, String location,int companyId) {
        String sql = "UPDATE warehouses SET name=?, location=? , companyId=? WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setInt(3, companyId);
            statement.setInt(4, id);

            statement.executeUpdate();
           
        } catch (SQLException e) {
            System.err.println("Failed to update warehouse information!");
            e.printStackTrace();
        }
    }

    public void deleteWarehouse(int id) {
        String sql = "DELETE FROM warehouses WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Failed to delete warehouse!");
            e.printStackTrace();
        }
    }

    public static List<Vector> getAllWarehouses() throws SQLException {
    Connection connection = getConnection();
String sql = "SELECT i.id, i.name, i.location, c.Name AS companyName " +
             "FROM Warehouses i " +
             "LEFT JOIN companys c ON i.companyId = c.ID";
    List<Vector> warehouses = new ArrayList<>();
     try (PreparedStatement statement = connection.prepareStatement(sql)) {
        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()) {
            Vector<Object> item = new Vector<>();
            for (int k = 1; k <= columnCount; k++) {
                item.add(resultSet.getObject(k)); 
            }
            warehouses.add(item);
        }
    } catch (SQLException e) {
        System.err.println("Failed to retrieve items!");
        e.printStackTrace();
        throw e; 
    }

    return warehouses;
}
public static Vector<Object> getWarehouseById(int warehouseId) throws SQLException {
    Vector<Object> warehouseData = new Vector<>();

    String sql = "SELECT w.*, c.Name AS companyName, c.ID AS companyId " +
                 "FROM Warehouses w " +
                 "LEFT JOIN Companys c ON w.companyId = c.ID " +
                 "WHERE w.id = ?";

    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, warehouseId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                warehouseData.add(rs.getInt("id"));
                warehouseData.add(rs.getString("name"));
                warehouseData.add(rs.getString("location"));
                warehouseData.add(rs.getInt("companyId"));
                warehouseData.add(rs.getString("companyName"));
            }
        }
    }
    return warehouseData;
}


 
}