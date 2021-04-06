package com.muaccel.testapp.employee;

public class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Long id) {
        super("Could not found employee with id: " + id);
    }
}
