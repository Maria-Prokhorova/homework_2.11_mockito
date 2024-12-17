package pro.sky.homework_2._EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2._EmployeeBook.domain.Employee;
import pro.sky.homework_2._EmployeeBook.service.DepartmentService;
import pro.sky.homework_2._EmployeeBook.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController

public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    // 1. Возвращать сотрудника с максимальной зарплатой на основе номера отдела, который приходит в запрос из браузера.
    // /departments/max-salary?departmentId=5
    @GetMapping(path = "/departments/max-salary")
    public Employee findMaxSalary(@RequestParam("departmentId") String departmentId) {
        return departmentService.findMaxSalary(departmentId);
    }

    // 2. Возвращать сотрудника с минимальной зарплатой на основе номера отдела.
    // /departments/min-salary?departmentId=5
    @GetMapping(path = "/departments/min-salary")
    public Employee findMinSalary(@RequestParam("departmentId") String departmentId) {
        return departmentService.findMinSalary(departmentId);
    }

    // 3. Возвращать всех сотрудников по отделу.
    // /departments/all?departmentId=5

    // 4. Возвращать всех сотрудников с разделением по отделам.
    // /departments/all
    @GetMapping(path = "/departments/all")
    public List<Employee> getAllEmployees(@RequestParam(value = "departmentId", required = false) String departmentId) {
        if (departmentId == null) {
            return employeeService.getAllEmployee();
        }
        return departmentService.getAllEmployeesDepartment(departmentId);
    }
}
