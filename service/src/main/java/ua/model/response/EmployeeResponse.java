package ua.model.response;

import ua.model.dto.EmployeeDto;

import java.util.List;

public class EmployeeResponse {

    private List<EmployeeDto> employeeDtos;

    private String message;

    public String getMessage() {
        return "We found " + employeeDtos.size() + " employees.";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<EmployeeDto> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(List<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }
}
