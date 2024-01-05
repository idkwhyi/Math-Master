import java.sql.*;

public class CoinManager {
    private Connection connection;

    public CoinManager() {
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

    public int getPlayerID(String username) {
        int player_id = 0;
        String query = "SELECT ID FROM player " +
                "WHERE username = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    player_id = resultSet.getInt("ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player_id;
    }

    public int getCoin(int playerId) {
        int coin = 0;
        String query = "SELECT jumlah_koin FROM coin " +
                "WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, playerId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    coin = resultSet.getInt("jumlah_koin");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coin;
    }

    public void updateCoin(int playerId, int coins) {
        int coinBefore = getCoin(playerId);

        // System.out.println("coin before: " + coinBefore);
        int coinAfter = coinBefore + coins;
        System.out.println("coinmanager coin before" + coinBefore);
        System.out.println("coinmanager coin after: " + coinAfter);
        String query;
    
        if (coinBefore == 0) {
            query = "INSERT INTO coin (ID, jumlah_koin) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, playerId);
                statement.setInt(2, coinAfter);
        
                int rowsAffected = statement.executeUpdate();
        
                if (rowsAffected > 0) {
                    System.out.println("Coin updated/added successfully.");
                } else {
                    System.out.println("Failed to update/add coins.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            query = "UPDATE coin SET jumlah_koin = ? WHERE ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, coinAfter);
                statement.setInt(2, playerId);
        
                int rowsAffected = statement.executeUpdate();
        
                if (rowsAffected > 0) {
                    System.out.println("Coin updated/added successfully.");
                } else {
                    System.out.println("Failed to update/add coins.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
}
