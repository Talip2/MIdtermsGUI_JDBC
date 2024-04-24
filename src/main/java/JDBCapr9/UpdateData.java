package JDBCapr9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main1(String[] args) {
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


    public static void updateSpending(int spendingID, int amount, String reason, int currUID) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("UPDATE spending SET amount=?, reason=? WHERE spendingID=? AND userID=?")) {
            c.setAutoCommit(false);
            statement.setInt(1, amount);
            statement.setString(2, reason);
            statement.setInt(3, spendingID);
            statement.setInt(4, currUID);

            System.out.println("Executing SQL: " + statement.toString());

            int rows = statement.executeUpdate();
            System.out.println("Rows updated: " + rows + " user: " + currUID);

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
