package componts;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBC {
    static Connection conn = null;
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/bankloansystem";
            String userName = "root";
            String password = "SAI@winay9912";
            conn = DriverManager.getConnection(url, userName, password);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
