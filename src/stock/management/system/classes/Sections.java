/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class Sections {
    Connection connection;
    public Sections() {
        try {
            this.connection = getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Sections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public void addSection(String name, String description, int warehouseId) {
        String sql = "INSERT INTO sections (name, description, warehouseId) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, warehouseId);

            statement.executeUpdate();
           
        } catch (SQLException e) {
            System.err.println("Failed to create section!");
            e.printStackTrace();
        }
    }

    public void updateSection(int id,String name, String description, int warehouseId) {
        String sql = "UPDATE sections SET name=?, description=?, warehouseId=? WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, warehouseId);
            statement.setInt(4, id);
            statement.executeUpdate();
          
        } catch (SQLException e) {
            System.err.println("Failed to update section information!");
            e.printStackTrace();
        }
    }

    public void deleteSection(int id) {
        String sql = "DELETE FROM sections WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to delete section!");
            e.printStackTrace();
        }
    }

    public static List<Vector> getAllSections(Connection connection) {
        String sql = "SELECT i.id, i.name, i.description, c.Name AS warehouseName " +
                 "FROM Sections i " +
                 "LEFT JOIN Warehouses c ON i.warehouseId = c.ID";
        List<Vector> sectionsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Vector section = new Vector();
                section.add(resultSet.getString("id"));
                section.add(resultSet.getString("name"));
                section.add(resultSet.getString("description"));
                section.add(resultSet.getString("warehouseName"));
                sectionsList.add(section);
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve sections!");
            e.printStackTrace();
        }
        return sectionsList;
    }
    
    public static Vector<Object> getSectionById(int sectionId) throws SQLException {
        Vector<Object> sectionData = new Vector<>();

        String sql = "SELECT s.*, w.Name AS warehouseName, w.ID AS warehouseId " +
                     "FROM Sections s " +
                     "LEFT JOIN Warehouses w ON s.warehouseId = w.ID " +
                     "WHERE s.id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setInt(1, sectionId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    sectionData.add(rs.getInt("id"));
                    sectionData.add(rs.getString("name"));
                    sectionData.add(rs.getString("description"));
                    sectionData.add(rs.getInt("warehouseId"));
                    sectionData.add(rs.getString("warehouseName"));
                }
            }
        }
        return sectionData;
    }
    
    public static Vector<Vector<Object>> getSectionsByWarehouseId(int warehouseId) throws SQLException {
        Vector<Vector<Object>> sectionsData = new Vector<>();
        String sql = "SELECT ID, Name FROM Sections WHERE WarehouseID = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, warehouseId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> sectionData = new Vector<>();
                    sectionData.add(rs.getInt("ID"));
                    sectionData.add(rs.getString("Name"));
                    sectionsData.add(sectionData);
                }
            }
        }
        return sectionsData;
    }
   
}