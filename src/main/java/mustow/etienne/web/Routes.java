package mustow.etienne.web;

import spark.Request;
import spark.Response;

import java.util.UUID;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {

    private Routes() {
        declareRoutes();
    }

    public static void generate() {
        new Routes();
    }

    private void declareRoutes() {
        get("/", (req, res) -> "Hello World");
        post("/user", this::createUser);
    }

    private String createUser(Request request, Response response) {
        String name = request.queryParams("name");
        if(name == null) {
            response.status(400);
            return "name parameter is required";
        }
        response.status(201);
        return UUID.randomUUID().toString();
    }
}
