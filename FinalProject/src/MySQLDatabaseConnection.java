import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDatabaseConnection {
    public static Void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/smart_village_test";
        String username = "root";
        String password = "";
        try {
            // Replace with your actual JDBC driver, database URL, username, and password
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement=(Statement) connection.createStatement();

            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery("SELECT * FROM barang");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + resultSet.getInt(3));
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
