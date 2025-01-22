package pro.sky.homework_2._EmployeeBook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework_2._EmployeeBook.domain.Employee;
import pro.sky.homework_2._EmployeeBook.service.DepartmentService;
import pro.sky.homework_2._EmployeeBook.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")

public class DepartmentController {
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    /* Методы, которые должны быть реализованы:
      GET http://localhost:8080/department/{id}/employees — возвращает список сотрудников по департаменту.

      GET http://localhost:8080/department/{id}/salary/sum — возвращает сумму зарплат по департаменту.

     GET http://localhost:8080/department/{id}/salary/max — возвращает максимальную зарплату по департаменту.

     GET http://localhost:8080/department/{id}/salary/min — возвращает минимальную зарплату по департаменту.

     GET http://localhost:8080/department/employees — возвращает сотрудников, сгруппированных по отделам в виде Map<Integer,List<Employees>>,
     где ключ — это номер отдела, а значение — список сотрудников данного отдела.
     */

    @GetMapping(path = "/{id}/salary/sum")
    public int findSumSalaryInDepartment(@PathVariable String id) {
        return departmentService.findSumSalaryInDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee findMaxSalaryInDepartment(@PathVariable String id) {
        return departmentService.findMaxSalaryInDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee findMinSalaryInDepartment(@PathVariable String id) {
        return departmentService.findMinSalaryInDepartment(id);
    }

    @GetMapping(path = "{id}/employees")
    public List<Employee> getAllEmployeesInDepartment(@PathVariable String id) {
        if (id == null) {
            return employeeService.getAllEmployee();
        }
        return departmentService.getAllEmployeesInDepartment(id);
    }

    @GetMapping(path = "/employees")
    public Map<String, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
