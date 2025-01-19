package pro.sky.homework_2._EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_2._EmployeeBook.domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryInDepartment(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployee();

        boolean departmentExists = employees.stream()
                .anyMatch(employee -> employee.getDepartment().equals(departmentId));

        if (departmentExists) {
            return employees.stream()
                    .filter(employee -> employee.getDepartment().equals(departmentId))
                    .max(Comparator.comparingInt(employee -> employee.getSalary()))
                    .orElse(null);
        } else throw new IllegalArgumentException();
    }

    @Override
    public Employee findMinSalaryInDepartment(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployee();

        boolean departmentExists = employees.stream()
                .anyMatch(employee -> employee.getDepartment().equals(departmentId));

        if (departmentExists) {
            return employees.stream()
                    .filter(employee -> employee.getDepartment().equals(departmentId))
                    .min(Comparator.comparingInt(employee -> employee.getSalary()))
                    .orElse(null);
        } else throw new IllegalArgumentException();

    }

    @Override
    public int findSumSalaryInDepartment(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployee();

        boolean departmentExists = employees.stream()
                .anyMatch(employee -> employee.getDepartment().equals(departmentId));

        if (departmentExists) {
            return employees.stream()
                    .filter(employee -> employee.getDepartment().equals(departmentId)).
                    mapToInt(employee -> employee.getSalary()).sum();
        } else throw new IllegalArgumentException();
    }

    @Override
    public List<Employee> getAllEmployeesInDepartment(String departmentId) {
        List<Employee> employees = employeeService.getAllEmployee();

        boolean departmentExists = employees.stream()
                .anyMatch(employee -> employee.getDepartment().equals(departmentId));

        if (departmentExists) {
            return employees.stream()
                    .filter(employee -> employee.getDepartment().equals(departmentId))
                    .collect(Collectors.toList());
        } else throw new IllegalArgumentException();
    }

    @Override
    public Map<String, List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
