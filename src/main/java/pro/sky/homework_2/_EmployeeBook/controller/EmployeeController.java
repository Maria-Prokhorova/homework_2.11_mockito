package pro.sky.homework_2._EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2._EmployeeBook.domain.Employee;
import pro.sky.homework_2._EmployeeBook.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("name") String firstName,
                              @RequestParam("surname") String lastName,
                              @RequestParam("department") String department,
                              @RequestParam("salary") int salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("name") String firstName,
                                 @RequestParam("surname") String lastName) {
        try {
            employeeService.removeEmployee(firstName, lastName);
        } catch (RuntimeException e) {
            return "Сотрудник не найден";
        }
        return "Сотрудник успешно удален";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("name") String firstName,
                               @RequestParam("surname") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/getAll")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
