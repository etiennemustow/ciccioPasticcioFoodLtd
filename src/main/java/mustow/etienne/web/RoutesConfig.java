package mustow.etienne.web;

import static spark.Spark.get;

public class RoutesConfig {

    private RoutesConfig() {
        declareRoutes();
    }

    public static void setup() {
        new RoutesConfig();
    }

    private void declareRoutes() {
        get("/", (req, res) -> "Hello World");
    }

}
