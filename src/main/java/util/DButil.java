package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ps1X on 27.06.2017.
 */
public class DButil {
    private static final String NAME = "postgres";
    private static final String PASS = "**********";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
        return connection;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, NAME, PASS);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
