package ua.resource;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Controller
public class ClientTestResource {

    @GET
    public String getTestMessage() {
        return "Hello from Dropwizard test!";
    }
}
