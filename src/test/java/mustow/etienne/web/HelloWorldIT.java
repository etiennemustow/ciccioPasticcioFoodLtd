package mustow.etienne.web;

import io.restassured.RestAssured;
import mustow.etienne.Ciccio;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class HelloWorldIT {

    public static final int TEST_PORT = 8888;

    @BeforeClass
    public static void beforeClass() {
        new Ciccio(TEST_PORT).start();
        RestAssured.port = TEST_PORT;
    }

    @Test
    public void hello_world_is_returned_in_the_home_page() {
        RestAssured.get("/").then()
                .body(is("Hello World"));
    }
}
