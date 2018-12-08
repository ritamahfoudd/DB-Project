import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {


    private static Connection conn;

    public static Connection connect(String username, String password) {

        String url = "jdbc:mysql://localhost:3306/SCHOOL?useSSL=false";
        conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Access Denied");
            return null;
        }

        System.out.println("Access Granted");
        return conn;
    }

    public static Connection getConn() {
        return conn;
    }
}
