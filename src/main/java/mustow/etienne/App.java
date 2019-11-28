package mustow.etienne;

import mustow.etienne.web.Routes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

public class App {

    private static final int DEFAULT_PORT = 8080;
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        startServer();
        deployRoutes();
    }

    private static void startServer() {
        int port = getPort();
        LOGGER.info("The {} will be used", port);
        Spark.port(port);
    }

    private static int getPort() {
        String portString = System.getenv("PORT");
        if(portString == null) {
            return DEFAULT_PORT;
        }
        return Integer.parseInt(portString);
    }

    private static void deployRoutes() {
        Routes.generate();
    }

}
