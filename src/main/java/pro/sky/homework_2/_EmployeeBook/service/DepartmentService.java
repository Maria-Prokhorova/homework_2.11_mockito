package pro.sky.homework_2._EmployeeBook.service;

import pro.sky.homework_2._EmployeeBook.domain.Employee;

import java.util.List;

public interface DepartmentService {

    Employee findMaxSalary(String departmentId);

    Employee findMinSalary(String departmentId);

    List<Employee> getAllEmployeesDepartment(String departmentId);
}
