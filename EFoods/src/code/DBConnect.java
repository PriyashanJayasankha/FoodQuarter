package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection connection() throws ClassNotFoundException{
        Connection connect = null;
      
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/efoodsdb", "root", "");
        }
        catch(SQLException e){
            System.out.println("hhdsugcud");
            System.out.println(e);
        }
        return connect;
    }
}
