package pro.sky.homework_2._EmployeeBook.service;

import pro.sky.homework_2._EmployeeBook.domain.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    int findSumSalaryInDepartment(String departmentId);

    Employee findMaxSalaryInDepartment(String departmentId);

    Employee findMinSalaryInDepartment(String departmentId);

    List<Employee> getAllEmployeesInDepartment(String departmentId);

    Map<String, List<Employee>> getAllEmployees();
}
