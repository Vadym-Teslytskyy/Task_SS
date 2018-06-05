package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class ClientTestResource {

    @GET
    public String getTestMessage(){
        return "Hello from Dropwizard test!";
    }
}
