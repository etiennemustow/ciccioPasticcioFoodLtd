package mustow.etienne;

import mustow.etienne.web.RoutesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

public class Ciccio {

    private static final int DEFAULT_PORT = 8080;
    private static final Logger LOGGER = LoggerFactory.getLogger(Ciccio.class);

    private int port;

    public Ciccio(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        String portString = System.getenv("PORT");
        int port;
        if(portString == null) {
            port = DEFAULT_PORT;
        } else {
            port = Integer.parseInt(portString);
        }
        Ciccio ciccio = new Ciccio(port);
        ciccio.start();
    }

    public void start() {
        startServer();
        deployRoutes();
    }

    private void startServer() {
        LOGGER.info("The {} will be used", port);
        Spark.port(port);
    }

    private void deployRoutes() {
        RoutesConfig.setup();
    }

}

