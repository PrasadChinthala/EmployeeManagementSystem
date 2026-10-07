package com.employee.management;

import java.util.Optional;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee(
                101,
                "Prasad",
                26,
                60000,
                "IT"
        );
        employeeService.addEmployee(employee1);
        Employee employee2 = new Employee(
                102,
                "Chandra",
                30,
                90000,
                "Data Engineer"
        );
        Employee employee3 = new Employee(
                103,
                "Shivam",
                26,
                50000,
                "NodeJs Developer"
        );
        Employee employee4 = new Employee(
                104,
                "Ravi",
                32,
                120000,
                "Python"
        );
        Employee employee5 = new Employee(
                105,
                "Kiran",
                35,
                70000,
                "Network"
        );
        employeeService.addEmployee(employee2);
        employeeService.addEmployee(employee3);
        employeeService.addEmployee(employee4);
        employeeService.addEmployee(employee5);
        List<Employee> employees = employeeService.getAllEmployees();
        employees.stream().map(Employee::getName).forEach(System.out::println);
//        Optional<Employee> searchedEmployee = employeeService.findEmployeeById(101);
//        searchedEmployee.ifPresentOrElse(
//            employee -> System.out.println(employee.getName()),
//                () -> System.out.println("Employee not found..!")
//        );
//        employeeService.updateEmployeeSalary(909, 80000);
//        Optional<Employee> updateEmployee = employeeService.findEmployeeById(101);
//        updateEmployee.ifPresentOrElse(
//                employee -> System.out.println(
//                        employee.getName() + " - " + employee.getSalary()
//                    ),
//                    () -> System.out.println("Employee not found..!")
//        );
//        employeeService.deleteEmployeeById(909);
//        employees.stream().map(Employee::getName).forEach(System.out::println);
        List<Employee> itEmployees = employeeService.findEmployeesByDepartment("HR");

        itEmployees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
