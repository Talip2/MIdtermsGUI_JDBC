package JDBCapr9;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
    static int id;
    public static boolean scan(String user, String pass) {
        try (Connection c = MySQLConnection.getConnection();
             Statement statement = c.createStatement()){
            c.setAutoCommit(false);

            String query = "SELECT * FROM users";
            ResultSet res = statement.executeQuery(query);
            while (res.next()){
                id = res.getInt("userID");
                String name = res.getString("name");
                String password = res.getString("password");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Password: " + password);

                if(user.equals(name) && pass.equals(password)){
                    return true;
                }
            }

            c.setAutoCommit(true);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public static int getUserID(){
        System.out.println("ID b4 return: " + id);
        return id;
    }


}
