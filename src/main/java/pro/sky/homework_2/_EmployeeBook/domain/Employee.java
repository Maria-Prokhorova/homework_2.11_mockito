package pro.sky.homework_2._EmployeeBook.domain;

import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final String departmentId;
    private final int salary;

    public Employee(String firstName, String lastName, String departmentId, int salary) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.departmentId = departmentId;
        this.salary = salary;
    }

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

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", salary=" + salary +
                '}';
    }
}
