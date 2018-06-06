package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mapper.impl.EmployeeReversibleDtoMapper;
import ua.model.dto.EmployeeDto;
import ua.repository.EmployeeRepository;
import ua.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private EmployeeReversibleDtoMapper dtoMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeReversibleDtoMapper dtoMapper) {
        this.employeeRepository = employeeRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public Optional<EmployeeDto> findEmployeeById(Integer id) {
        return Optional.of(
                dtoMapper.mapToDto(
                        employeeRepository.findEmployeeById(id)));
    }

    @Override
    public Optional<List<EmployeeDto>> getAllEmployees() {
        return Optional.of(
                employeeRepository.getAllEmployees().stream()
                        .map(employee -> dtoMapper.mapToDto(employee)).collect(Collectors.toList()));
    }

    @Override
    public boolean deleteEmployee(EmployeeDto employeeDto) {

        return employeeRepository.deleteEmployee(dtoMapper.mapToEntity(employeeDto));
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {
        return employeeRepository.updateEmployee(dtoMapper.mapToEntity(employeeDto));
    }

    @Override
    public boolean createEmployee(EmployeeDto employeeDto) {
        return employeeRepository.createEmployee(dtoMapper.mapToEntity(employeeDto));
    }
}
