package com.employee.management;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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
                        employee -> {
                            employee.setSalary(newSalary);
                            System.out.println("Salary updated successfully..!");
                        },
                        () -> System.out.println("Salary cannot be updated..!")
                );
    }

    public void deleteEmployeeById(int id){
        this.findEmployeeById(id)
                .ifPresentOrElse(
                        employee -> {
                            employees.remove(employee);
                            System.out.println("Employee deleted successfully..!");
                        },
                        () -> System.out.println("Employee not found..!")
                );
    }

    public List<Employee> findEmployeesByDepartment(String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}