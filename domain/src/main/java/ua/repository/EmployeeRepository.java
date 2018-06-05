package ua.repository;

import ua.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    Employee findEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean createEmployee(Employee employee);
}
