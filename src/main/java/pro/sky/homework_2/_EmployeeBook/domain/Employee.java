package pro.sky.homework_2._EmployeeBook.domain;

import java.util.Objects;

public class Employee {

    // поля класса
    private final String firstName;
    private final String lastName;
    private final String departmentId;
    private final int salary;

    // конструктор
    public Employee(String firstName, String lastName, String departmentId, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    // методы по работе с полями
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(departmentId, employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }
}
