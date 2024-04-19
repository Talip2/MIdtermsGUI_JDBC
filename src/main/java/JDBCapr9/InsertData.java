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


    public static void insert(String name, String email){
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("INSERT INTO users (name, email) VALUES (?,?)")){
                statement.setString(1, name);
                statement.setString(2, email);
                int rows = statement.executeUpdate();
            System.out.println("Inserted rows: " + rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
