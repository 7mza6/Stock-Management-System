/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stock.management.system.classes;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static stock.management.system.application.form.other.FormDashboard.getConnection;


/**
 *
 * @author Eng.Sanad
 */
public class Account {
    String name;
    String password;
    String email;
    private Connection connection;
    
    public Account(String name, String password, String email) throws SQLException{
        this.connection = getConnection();
        this.name=name;
        this.password=password;
        this.email=email;
    }
    public Account(String name, String password) throws SQLException{
        this.connection = getConnection();
        this.name=name;
        this.password=password;
        this.email=email;
    }
    public Account() throws SQLException{
        this.connection = getConnection();
        
    }
    public void addAccount(){
         String sql = "INSERT INTO Accounts (username, email, password) VALUES (?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { 
                    System.out.println("Acount added successfully");
                
            } else {
                System.out.println("Failed to add Acount");
            }
        } catch (SQLException e) {
            System.err.println("Failed to add Acount");
            e.printStackTrace();
        }
        
        
    }
    public boolean checkExistance(String name) {
    String sql = "SELECT * FROM Accounts WHERE username = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, name);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String username1 = resultSet.getString("username");
                if (username1.equals(name)) {
                    return true;
                }
            }
        }
    } catch (SQLException e) {
        System.err.println("Failed to check existence");
        e.printStackTrace();
    }
    return false;
}
    public boolean checkPass(String name, String pass) {
    String sql = "SELECT password FROM Accounts WHERE username = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) { 
            String passwordFromDatabase = rs.getString("password");
            if (passwordFromDatabase.equals(pass)) {
                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    public void deleteAcount(int id){
        String sql= "delete from Accounts where account_id= ?";
        try(PreparedStatement statement= connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
                }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
