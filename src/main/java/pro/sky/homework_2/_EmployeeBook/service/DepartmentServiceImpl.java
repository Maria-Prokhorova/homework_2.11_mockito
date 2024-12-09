package pro.sky.homework_2._EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_2._EmployeeBook.domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // 1. Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
    // /departments/max-salary?departmentId=5

    @Override
    public Employee findMaxSalary(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);

    }

    // 2. Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
    // /departments/min-salary?departmentId=5

    @Override
    public Employee findMinSalary(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);

    }

    // 3. Возвращать всех сотрудников по отделу.
    // /departments/all?departmentId=5

    // 4. Возвращать всех сотрудников с разделением по отделам.
    // /departments/all
    @Override
    public List<Employee> getAllEmployeesDepartment(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

}
