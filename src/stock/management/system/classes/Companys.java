
package stock.management.system.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import static stock.management.system.application.form.other.FormDashboard.getConnection;



public class Companys {

private Connection connection;
    public Companys() throws SQLException {
        connection= getConnection();
    }
    
    public void addCompany(String name, String address, String contactPerson, String phoneNumber, String email) {
        String sql = "INSERT INTO companys (name, address, contactPerson, phoneNumber, email) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, contactPerson);
            statement.setString(4, phoneNumber);
            statement.setString(5, email);

           int rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to create company!");
            e.printStackTrace();
        }
    }

    // Update company information in the database
    public void updateCompany(int companyId,String name, String address, String contactPerson, String phoneNumber, String email) {
      String sql = "UPDATE companys SET name=?, address=?, contactPerson=?, phoneNumber=?, email=? WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, address );
            statement.setString(3, contactPerson );
            statement.setString(4, phoneNumber);
            statement.setString(5, email);
            statement.setInt(6, companyId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to update company information!");
            e.printStackTrace();
        }
    }

    // Delete company from the database
    public void deleteCompany(int companyId) {
       String sql = "DELETE FROM companys WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, companyId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Company deleted successfully!");
            } else {
                System.out.println("No company found with ID: " + companyId);
            }
        } catch (SQLException e) {
            System.err.println("Failed to delete company!");
            e.printStackTrace();
        }
    }




    public static List<Vector> getAllCompanies(Connection connection) {
        String sql = "SELECT * FROM companys";
        List<Vector> companies = new ArrayList<>();
        int c;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            java.sql.ResultSetMetaData Rss = resultSet.getMetaData();
            c = Rss.getColumnCount();
                while(resultSet.next()){
                   Vector company = new Vector();
                   for(int k=1; k <= c; k++){

                    company.add (resultSet.getString("id") ) ;
                    company.add (resultSet.getString ("name") ) ;
                    company.add (resultSet.getString ("address"));
                    company.add (resultSet.getString ("contactPerson") );
                    company.add (resultSet.getString ("phoneNumber") );
                    company.add (resultSet.getString ("email") );
                    
                   }
                   companies.add(company);
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve companies!");
            e.printStackTrace();
        }
        return companies;
    }
    public static Vector<Object> getCompanyById(int companyId) throws SQLException {
    Vector<Object> companyData = new Vector<>();

    String sql = "SELECT * FROM Companys WHERE Id = ?";

    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, companyId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                companyData.add(rs.getInt("Id"));
                companyData.add(rs.getString("Name"));
                companyData.add(rs.getString("Address"));
                companyData.add(rs.getString("ContactPerson"));
                companyData.add(rs.getString("PhoneNumber"));
                companyData.add(rs.getString("Email"));
            }
        }
    }
    return companyData;
}


}

