package pro.sky.homework_2._EmployeeBook.service;

import pro.sky.homework_2._EmployeeBook.domain.Employee;

import java.util.List;

public interface EmployeeService {

    String addEmployee(String firstName, String lastName, String department, int salary);

    void removeEmployee(String firstName, String lastName);

    String findEmployee(String firstName, String lastName);

    List<Employee> getAllEmployee();
}
