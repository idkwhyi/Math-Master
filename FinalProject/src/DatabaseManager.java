import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        // Initialize the database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/MathMaster";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean registerUser(String username, String password, String email) {
        try {
            // Check if the username already exists
            if (usernameExists(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return false;
            }

            // If the username is unique, proceed with registration
            String query = "INSERT INTO player (username, password, email) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                int affectedRows = preparedStatement.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean usernameExists(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM player WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        }
    }

    public boolean loginUser(String username, String password, String email) {
        try {
            String query = "SELECT * FROM player WHERE username = ? AND password = ? AND email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next(); // Returns true if a matching user is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean resetPassword(String username, String newPassword, String email) {
        try {
            String query = "UPDATE player SET password = ? WHERE username = ? AND email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newPassword);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, email);

                int rowsUpdated = preparedStatement.executeUpdate();

                return rowsUpdated > 0;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}