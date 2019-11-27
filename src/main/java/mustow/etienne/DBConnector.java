package mustow.etienne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }

    public String healthcheck() {
        try {
            return getConnection().getSchema();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
