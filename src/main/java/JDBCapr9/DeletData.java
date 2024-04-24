package JDBCapr9;

import java.sql.*;

public class DeletData {
    public static void main1(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("DELETE FROM users WHERE id=? RETURNING *")){


            int id = 1;
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            ResultSet res = statement.getResultSet();
            if(res.next()){
                System.out.println("Name: " + res.getString("name"));
                System.out.println("Email: " + res.getString("email"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteSpending(int spendingID) {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement("DELETE FROM spending WHERE spendingID=? RETURNING *")){

            statement.setInt(1, spendingID);
            int rows = statement.executeUpdate();
            System.out.println("Deleted: " + rows);
            ResultSet res = statement.getResultSet();
            if(res.next()){
                System.out.println("Amount: " + res.getString("amount"));
                System.out.println("Reason: " + res.getString("reason"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
