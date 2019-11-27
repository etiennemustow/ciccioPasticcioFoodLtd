package mustow.etienne;

import spark.Request;

import java.sql.*;
import java.util.Properties;

import static java.lang.String.format;

public class DBConnector {

    public String tables() throws SQLException {
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet queryRes = statement.executeQuery("SELECT pg_tables.tablename FROM pg_catalog.pg_tables");) {
            return tableNamesToString(queryRes);
        }
    }

    private String tableNamesToString(ResultSet queryRes) throws SQLException {
        StringBuilder res = new StringBuilder();
        while(queryRes.next()) {
            res.append(queryRes.getString("tablename"));
            res.append(System.lineSeparator());
        }
        return res.toString();
    }

    public String createTable(Request req) throws SQLException {
        String tableName = req.queryParams("table");
        if(tableName == null) {
            return "'table' parameter required, please use ?table=TABLE_NAME";
        }
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()) {
            return Boolean.toString(statement.execute(format("CREATE TABLE %s (id bigserial primary key, name varchar(20) NOT NULL)", tableName)));
        }
    }

    private static Connection getConnection() throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","postgres");
        return DriverManager.getConnection(dbUrl, props);
    }
}
