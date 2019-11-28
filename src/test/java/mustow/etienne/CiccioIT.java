package mustow.etienne;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.port;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class CiccioIT {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>();
    public static final int TEST_PORT = 8888;

    @BeforeClass
    public static void beforeClass() {
        new Ciccio(TEST_PORT).start();
        port = TEST_PORT;
    }

    @Test
    public void hello_world_is_returned_in_the_home_page() {
        get("/").then()
                .body(is("Hello World"));
    }

    @Test
    public void db_is_correctly_deployed() throws Exception {
        Properties connectionProps = new Properties();
        connectionProps.put("user", postgreSQLContainer.getUsername());
        connectionProps.put("password", postgreSQLContainer.getPassword());
        Connection connection = DriverManager.getConnection(postgreSQLContainer.getJdbcUrl(), connectionProps);
        assertEquals(Integer.valueOf(1), new QueryRunner().query(connection, postgreSQLContainer.getTestQueryString(), new ScalarHandler<Integer>()));
    }
}
