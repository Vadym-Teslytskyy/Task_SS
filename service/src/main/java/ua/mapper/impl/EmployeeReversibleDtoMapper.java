package ua.mapper.impl;

import org.springframework.stereotype.Component;
import ua.dto.EmployeeDto;
import ua.entity.Employee;
import ua.mapper.ReversibleDtoMapper;

@Component
public class EmployeeReversibleDtoMapper implements ReversibleDtoMapper<Employee, EmployeeDto> {

    public EmployeeDto mapToDto(Employee entity) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(entity.getId());
        employeeDto.setFirstName(entity.getFirstName());
        employeeDto.setLastName(entity.getLastName());
        employeeDto.setAge(entity.getAge());
        return employeeDto;
    }

    public Employee mapToEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        return employee;
    }


}
