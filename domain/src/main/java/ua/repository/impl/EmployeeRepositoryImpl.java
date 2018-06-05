package ua.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.entity.Employee;
import ua.mapper.EmployeeMapper;
import ua.repository.EmployeeRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    JdbcTemplate jdbcTemplate;

    EmployeeMapper employeeMapper;

    private final String SQL_FIND_EMPLOYEE_BY_ID = "select * from employee where id = ?";
    private final String SQL_DELETE_EMPLOYEE_BY_ID = "delete from employee where id = ?";
    private final String SQL_UPDATE_EMPLOYEE_BY_ID = "update employee set first_name = ?, last_name = ?, age  = ?"
            + " where id = ?";
    private final String SQL_FIND_ALL = "select * from employee";
    private final String SQL_INSERT_EMPLOYEE = "insert into employee(id, first_name, last_name, age) values(?,?,?,?)";

    @Autowired
    public EmployeeRepositoryImpl(DataSource dataSource, EmployeeMapper employeeMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE_BY_ID, new Object[]{id}, employeeMapper);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query(SQL_FIND_ALL, employeeMapper);
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return jdbcTemplate.update(SQL_DELETE_EMPLOYEE_BY_ID, employee.getId()) > 0;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE_BY_ID, employee.getFirstName(), employee.getLastName(),
                employee.getAge(), employee.getId()) > 0;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getId(), employee.getFirstName(),
                employee.getLastName(), employee.getAge()) > 0;
    }
}
