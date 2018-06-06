package ua.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.model.response.EmployeeResponse;
import ua.service.EmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Service
public class ClientTestResource {

    @Autowired
    private EmployeeService service;

//    @GET
//    public EmployeeDto getAllEmployees() {
//        return service.findEmployeeById(1).get();
//    }

    @GET
    public EmployeeResponse getTestMessage() {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        if (service.getAllEmployees().isPresent()) {
            employeeResponse.setEmployeeDtos(service.getAllEmployees().get());
            return employeeResponse;
        } else {
            return new EmployeeResponse();
        }
    }
}
