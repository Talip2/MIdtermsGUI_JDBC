package JDBCapr9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
//        try (Connection c = MySQLConnection.getConnection();
//             PreparedStatement statement = c.prepareStatement("INSERT INTO users (name, email) VALUES (?,?)")){
//
//
//            String name = "Deo Talip";
//            String email = "deo@gmail.com";
//
//            statement.setString(1, name);
//            statement.setString(2,email);
//
//            int rows = statement.executeUpdate();
//
//            System.out.println("Rows inserted: " + rows);
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }


    public static void insertUser(String name, String password){
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("INSERT INTO users (name, password) VALUES (?,?)")){
            c.setAutoCommit(false);

                statement.setString(1, name);
                statement.setString(2, password);
                int rows = statement.executeUpdate();
            System.out.println("Inserted rows: " + rows);

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void insertSpending(int amount, String reason, int userID){
        System.out.println("current user id: " + userID);
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("INSERT INTO spending (amount, reason, userID) VALUES (?,?,?)")){
            c.setAutoCommit(false);

            statement.setInt(1, amount);
            statement.setString(2, reason);
            statement.setInt(3, userID);
            int rows = statement.executeUpdate();
            System.out.println("Inserted rows: " + rows);

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
