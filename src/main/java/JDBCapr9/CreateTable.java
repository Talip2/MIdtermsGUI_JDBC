package JDBCapr9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void create() {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()){

            c.setAutoCommit(false);
            String query = "CREATE TABLE IF NOT EXISTS users (" +
                            "userID INT AUTO_INCREMENT PRIMARY KEY," +
                            "name VARCHAR(50) NOT NULL," +
                            "password VARCHAR(50) NOT NULL)";
                String query1 = "CREATE TABLE IF NOT EXISTS spending (" +
                        "spendingID INT AUTO_INCREMENT PRIMARY KEY," +
                        "amount INT NOT NULL," +
                        "reason VARCHAR(50) NOT NULL," +
                        "userID INT, FOREIGN KEY (userID) REFERENCES users(userID))";


            statement.execute(query);
            statement.execute(query1);
            System.out.println("Table created succesfully");

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
