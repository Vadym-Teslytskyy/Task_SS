import entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.EmployeeRepository;
import spring.config.PersistenceContext;

public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        System.out.println("List of employees: ");

        for (Employee e: employeeRepository.getAllEmployees()) {
            System.out.println(e);
        }
    }
}
