package tv.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/")
public class EmployeeResource {

    /**
     * Employee endpoint documentation available at http://localhost:8080/swagger-ui/index.html when you start the associated Spring Boot Application
     */

    ConcurrentHashMap<String, Employee> employeeRecords = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeRecords.get(id);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeRecords.values());
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeRecords.put(employee.getId(), employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee modifyEmployee(@RequestBody Employee employee, @PathVariable String id) {
        employeeRecords.put(employee.getId(), employee);
        return employee;
    }
}
