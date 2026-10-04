package com.employee.management;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        this.findEmployeeById(id)
                .ifPresentOrElse(
                        employee-> {
                            employee.setSalary(newSalary);
                            System.out.println("Salary updated successfully..!");
                        },
                        () -> System.out.println("Salary cannot be updated..!")
                );
    }
}