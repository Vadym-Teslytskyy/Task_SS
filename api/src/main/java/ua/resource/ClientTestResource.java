package ua.resource;

import io.dropwizard.jersey.params.IntParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kafka.producer.Sender;
import ua.model.dto.EmployeeDto;
import ua.model.response.EmployeeResponse;
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

//    @GET
//    public EmployeeDto getAllEmployees() {
//        return service.findEmployeeById(1).get();
//    }

    @GET
    public EmployeeResponse getTestMessage() {
        sender.send("***********************Spring Kafka Producer and Consumer Example!****************************");
        EmployeeResponse employeeResponse = new EmployeeResponse();
        if (service.getAllEmployees().isPresent()) {
            employeeResponse.setEmployeeDtos(service.getAllEmployees().get());
            return employeeResponse;
        } else {
            return new EmployeeResponse();
        }
    }

    @GET
    @Path("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathParam("id") IntParam id) {
//        if (service.findEmployeeById(id.get()).isPresent()){
//            return service.findEmployeeById(id.get()).get();
//        }
        return service.findEmployeeById(id.get()).get();
    }

    @DELETE
    @Path("/employee/{id}/delete")
    public Response deleteEmployee(@PathParam("id") IntParam id) {
        Optional<EmployeeDto> employeeForDelete = service.findEmployeeById(id.get());
        if (employeeForDelete.isPresent()) {
            boolean isDeleted = service.deleteEmployee(employeeForDelete.get());
            if (isDeleted == true) {
                return Response.status(Response.Status.OK).entity("Employee deleted successfuly").build();
            } else {
                return Response.status(Response.Status.OK).entity("Error during deleting").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Employee does not exist").build();
        }
    }


}
