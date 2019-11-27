package mustow.etienne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import static spark.Spark.get;

public class App {

    public static final int DEFAULT_PORT = 8080;
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        int port = getPort();
        LOGGER.info("The {} will be used", port);
        Spark.port(port);
        get("/", (req, res) -> "Hello World from Circle CI");
    }

    private static int getPort() {
        String portString = System.getenv("PORT");
        if(portString == null) {
            return DEFAULT_PORT;
        }
        return Integer.parseInt(portString);
    }

}
