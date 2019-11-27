package mustow.etienne;

import spark.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class DBConnector {

    public String tables() throws SQLException {
        return executeQuery("SELECT * FROM pg_catalog.pg_tables");
    }

    public String createTable(Request req) throws SQLException {
        String tableName = req.queryParams("table");
        if(tableName == null) {
            return "'table' parameter required, please use ?table=TABLE_NAME";
        }
        return executeQuery(format("CREATE TABLE %s (id bigserial primary key, name varchar(20) NOT NULL)", tableName));
    }

    private String executeQuery(String query) throws SQLException {
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()) {
            return Boolean.toString(statement.execute(query));
        }
    }

    private static Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }
}
