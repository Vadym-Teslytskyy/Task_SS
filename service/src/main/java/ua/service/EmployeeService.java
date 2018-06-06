package ua.service;

import ua.model.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeDto> findEmployeeById(Integer id);

    Optional<List<EmployeeDto>> getAllEmployees();

    boolean deleteEmployee(EmployeeDto employeeDto);

    boolean updateEmployee(EmployeeDto employeeDto);

    boolean createEmployee(EmployeeDto employeeDto);
}
