package pro.sky.homework_2._EmployeeBook.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework_2._EmployeeBook.domain.Employee;
import pro.sky.homework_2._EmployeeBook.exception.ValidataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employeeMap = new HashMap<>(Map.of(
            "Prokhorova Maria",
            new Employee("Maria", "Prokhorova", "1", 95000),
            "Ivanov Ivan",
            new Employee("Ivan", "Ivanov", "1", 15000),
            "Petrov Petr",
            new Employee("Petr", "Petrov", "2", 59000)
    ));

    Map<String, String> professions = new HashMap<>(Map.of(
            "1", "administrativnii otdel",
            "2", "hozaistvennii otdel",
            "3", "bukhalteria",
            "4", "iuridicheskii otdel",
            "5", "rukovodstvo"
    ));

    @Override
    public String addEmployee(String firstName, String lastName, String departmentId, int salary) {
        validataInput(firstName, lastName);

        String key = lastName + " " + firstName;
        if (employeeMap.containsKey(key)) {
            return "Такой сотрудник уже есть";
        } else {
            final Employee person = new Employee(firstName, lastName, departmentId, salary);
            employeeMap.put(key, person);
            return "Сотрудник успешно добавлен";
        }
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        validataInput(firstName, lastName);

        String key = lastName + " " + firstName;
        if (employeeMap.containsKey(key)) {
            employeeMap.remove(key);
        } else throw new RuntimeException();
    }

    @Override
    public String findEmployee(String firstName, String lastName) {
        validataInput(firstName, lastName);

        String key = lastName + " " + firstName;
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key).getFirstName() + " " + employeeMap.get(key).getLastName();
        } else return "Такого сотрудника в базе нет";
    }

    @Override
    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employeeMap.values());
    }

    /*
    @Override
    public List<String> getAllEmployeesWithNameDepartments() {
        return employeeMap.entrySet().stream()
                .map(employeeMap -> employeeMap.getValue().getFirstName() + " " + employeeMap.getValue().getLastName() + " " + employeeMap.getValue().getSalary() + " " + professions.get(employeeMap.getValue().getDepartment()))
                .collect(Collectors.toList());
    }*/

    private void validataInput(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new ValidataException();
        }
    }
}
