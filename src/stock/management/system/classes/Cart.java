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

public class Cart {
    
    private static Connection connection;
    
    public Cart() throws SQLException{
        connection= getConnection();
    }
    
    public void addToCart(int id,String name,double price, int quantity ,double totalP,int Customerid ){
        String sql = "INSERT INTO cart (name ,price , quantity, totalP,itemId,CustomerID) VALUES (?, ?, ?, ?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, quantity);
            statement.setDouble(4,totalP );
            statement.setInt(5, id);
            statement.setInt(6, Customerid);

            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void updateCart(int id, int newQuantity,double totalP) {
        String sql = "UPDATE cart SET quantity = ?, totalP = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newQuantity);
            statement.setDouble(2, totalP);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
     public void addQuantity(int id, int newQuantity) {
        String sql = "UPDATE cart SET quantity = (quantity + ?), totalP = (price * (quantity + ?)) WHERE itemId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newQuantity);
            statement.setInt(2, newQuantity);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
        public void updateQuantity(int id, int newQuantity) {
        String sql = "UPDATE cart SET quantity = ?, totalP = (price * ?) WHERE itemId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newQuantity);
            statement.setInt(2, newQuantity);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
     
    
    
    public void updatePrice(int id, double price) {
        String sql = "UPDATE cart SET price = ?, totalP =(?* quantity) WHERE itemId = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, price);
            statement.setDouble(2, price);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void deleteFromCart(int id) {
        String sql = "DELETE FROM cart WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAll() {
        String sql = "DELETE FROM cart";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static List<Vector> getAll() throws SQLException {
        connection= getConnection();
        List<Vector> cartList = new ArrayList<>();
        String sql = "SELECT * FROM cart";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
         int c = Rss.getColumnCount();
            while (resultSet.next()) {
                Vector cart = new Vector();
                cart.add(resultSet.getString("name"));
                cart.add(resultSet.getDouble("price"));
                cart.add(resultSet.getInt("quantity"));
                cart.add(resultSet.getInt("totalP"));
                cart.add(resultSet.getInt("CustomerID"));
                cartList.add(cart);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartList;
    }
     
     
     public static int inCart(int id) throws SQLException {
        connection= getConnection();
        String sql = "SELECT * FROM cart WHERE itemId = ? ";
        int c = 0;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
         statement.setInt(1, id);
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
         
            while (resultSet.next()) {
                c++;
                }

            
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
     
      
         public static int getRowId(int rowNum) throws SQLException {
         int id =0 ;
        connection= getConnection();
        String sql = "SELECT * FROM cart ORDER BY (SELECT NULL) OFFSET ? ROWS FETCH NEXT 1 ROWS ONLY";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rowNum  );
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
            while (resultSet.next()) {
             id = resultSet.getInt("id");
                }

            }
        
         catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
                return id;
    }
         
    public static int getItemsId(int rowNum) throws SQLException {
        int id =0 ;
        connection= getConnection();
        String sql = "SELECT * FROM cart ORDER BY (SELECT NULL) OFFSET ? ROWS FETCH NEXT 1 ROWS ONLY";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rowNum  );
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
            while (resultSet.next()) {
             id = resultSet.getInt("itemId");
                }
            }
         catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
                return id;
    }
    
    public static int getQuantity(int id) throws SQLException {
        connection= getConnection();

        int quantity = 0;
        String sql = "SELECT * FROM cart WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);
         ResultSet resultSet = statement.executeQuery();
         java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
            while (resultSet.next()) {
                quantity = resultSet.getInt("quantity");
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quantity;
    }
    

       
}
