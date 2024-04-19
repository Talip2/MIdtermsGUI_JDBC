package JDBCapr9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("UPDATE users SET name=? WHERE id=?")){
            String name = "Vince";
            int id = 1;

            statement.setString(1, name);
            statement.setInt(2,id);
            int rows = statement.executeUpdate();
            System.out.println("Rows inserted: " + rows);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
