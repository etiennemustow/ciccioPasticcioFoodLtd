package mustow.etienne.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    private DBConnector() { }

    public static Connection getConnection() {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        try {
            return DriverManager.getConnection(dbUrl, props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
