package com.muaccel.testapp.employee;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@Valid @RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    Employee getOneEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee newEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return employeeRepository.save(employee);
        })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

}
