package stock.management.system.classes;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static stock.management.system.application.form.other.FormDashboard.getConnection;


public class sales {



    public void sell(DefaultTableModel tableModel, int customerId) throws SQLException {
        String insertSaleSQL = "INSERT INTO Sales (CustomerID, SaleDate, TotalAmount) VALUES (?, CURRENT_TIMESTAMP, ?)";
        String insertSaleDetailSQL = "INSERT INTO SalesDetails (SaleID, ItemID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            // Calculate total amount for sale
            double totalAmount = 0.0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                totalAmount += (Double) tableModel.getValueAt(i, 3);
            }

            // Insert sale and get generated sale ID
            int saleId;
            try (PreparedStatement pstmtSale = conn.prepareStatement(insertSaleSQL, Statement.RETURN_GENERATED_KEYS)) {
                pstmtSale.setInt(1, customerId);
                pstmtSale.setDouble(2, totalAmount);
                pstmtSale.executeUpdate();
                ResultSet generatedKeys = pstmtSale.getGeneratedKeys();
                if (generatedKeys.next()) {
                    saleId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating sale failed, no ID obtained.");
                }
            }

            try (PreparedStatement pstmtSaleDetail = conn.prepareStatement(insertSaleDetailSQL)) {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    pstmtSaleDetail.setInt(1, saleId);
                    pstmtSaleDetail.setInt(2, (Integer) tableModel.getValueAt(i, 0)); 
                    pstmtSaleDetail.setInt(3, (Integer) tableModel.getValueAt(i, 2)); 
                    pstmtSaleDetail.setDouble(4, (Double) tableModel.getValueAt(i, 1)); 
                    pstmtSaleDetail.addBatch();
                }
                pstmtSaleDetail.executeBatch();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

public static List<Vector> getAll() throws SQLException {
        Connection connection = java.sql.DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TO7G8BH:1433;Database=Stock Management System;integratedSecurity=true;trustServerCertificate=true");

        List<Vector> cartList = new ArrayList<>();
        String sql = "SELECT * FROM cart";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
         int c = Rss.getColumnCount();
            while (resultSet.next()) {
                Vector cart = new Vector();
                for(int k=1; k <= c; k++){
                cart.add(resultSet.getString("SaleID"));
                cart.add(resultSet.getDouble("CustomerID"));
                cart.add(resultSet.getInt("SaleDate"));
                cart.add(resultSet.getInt("TotalAmount"));
                }
                cartList.add(cart);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartList;
    }

   public static List<Vector> getAllSales() throws SQLException {
    Connection connection = getConnection();
    List<Vector> stockItems = new ArrayList<>();
    
        String sql = "SELECT * FROM sales";

    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            Vector<Object> item = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                item.add(rs.getObject(i));
            }
            stockItems.add(item); 
        }
    } catch (SQLException e) {
        System.err.println("Failed to retrieve stock items!");
        e.printStackTrace();
    }
    return stockItems;
}
      public static int getRowId(int rowNum) throws SQLException {
         int id =0 ;
        Connection connection = getConnection();
        String sql = "SELECT * FROM Sales ORDER BY (SELECT NULL) OFFSET ? ROWS FETCH NEXT 1 ROWS ONLY";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, (rowNum )  );
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
            while (resultSet.next()) {
             id = resultSet.getInt("SaleID");
                }
            }
        
         catch (SQLException ex) {
            Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }
                return id;
    }
   public static List<Vector> getAllSalesD(int id) throws SQLException {
    Connection connection = getConnection();
    List<Vector> stockItems = new ArrayList<>();
    
        String sql = "SELECT * FROM SalesDetails WHERE SaleID = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)){
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            Vector<Object> item = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                item.add(rs.getObject(i)); 
            }
            stockItems.add(item); 
        }
    } catch (SQLException e) {
        System.err.println("Failed to retrieve stock items!");
        e.printStackTrace();
    }
    return stockItems;
}
} 