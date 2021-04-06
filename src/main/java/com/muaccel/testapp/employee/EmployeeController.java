package com.muaccel.testapp.employee;

import com.muaccel.testapp.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping
    List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    Employee newEmployee(@Valid @RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/{id}")
    Employee getOneEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee with id " + id + " could not found!"));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee newEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return employeeRepository.save(employee);
        })
                .orElseThrow(() -> new NotFoundException("Employee with id " + id + " could not found!"));
    }

}
