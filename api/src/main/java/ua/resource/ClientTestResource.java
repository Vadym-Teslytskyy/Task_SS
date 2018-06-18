package ua.resource;

import io.dropwizard.jersey.params.IntParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kafka.producer.Sender;
import ua.model.dto.EmployeeDto;
import ua.model.response.ErrorDto;
import ua.service.EmployeeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Service
public class ClientTestResource {

    @Autowired
    private EmployeeService service;

    @Autowired
    private Sender sender;

    @POST
    @Path("/employee/create")
    public Response createEmployee(EmployeeDto employeeDto) {
        boolean isCreated = service.createEmployee(employeeDto);
        if (isCreated) {
            return Response.status(Response.Status.OK)
                    .entity("Employee created successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorDto("Error during creation")).build();
        }
    }

    @GET
    public Response getAllEmployees() {
        sender.send("***********************Spring Kafka Producer and Consumer Example!****************************");
        if (service.getAllEmployees().isPresent()) {
            return Response.status(Response.Status.OK)
                    .entity(service.getAllEmployees().get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorDto("No employee found")).build();
        }
    }

    @GET
    @Path("/employee/{id}")
    public Response getEmployeeById(@PathParam("id") IntParam id) {
        if (service.findEmployeeById(id.get()).isPresent()) {
            return Response.status(Response.Status.OK)
                    .entity(service.findEmployeeById(id.get()).get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorDto("Employee with this id does not exist")).build();
        }
    }

    @DELETE
    @Path("/employee/{id}/delete")
    public Response deleteEmployee(@PathParam("id") IntParam id) {
        Optional<EmployeeDto> employeeForDelete = service.findEmployeeById(id.get());
        if (employeeForDelete.isPresent()) {
            boolean isDeleted = service.deleteEmployee(employeeForDelete.get());
            if (isDeleted) {
                return Response.status(Response.Status.OK)
                        .entity("Employee deleted successfully").build();
            } else {
                return Response.status(Response.Status.OK)
                        .entity(new ErrorDto("Error during deleting")).build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorDto("Employee does not exist")).build();
        }
    }

    @PUT
    @Path("/employee/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(EmployeeDto employeeDto) {
        boolean isUpdated = service.updateEmployee(employeeDto);
        if (isUpdated) {
            return Response.status(Response.Status.OK).entity("Employee updated successfully").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorDto("Error during update")).build();
        }

    }

}
