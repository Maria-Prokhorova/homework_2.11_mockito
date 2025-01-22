package pro.sky.homework_2._EmployeeBook;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework_2._EmployeeBook.domain.Employee;
import pro.sky.homework_2._EmployeeBook.service.DepartmentServiceImpl;
import pro.sky.homework_2._EmployeeBook.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;
    public static final Employee MAX_SALARY = new Employee("John", "Smith", "1", 15000);
    public static final Employee MIN_SALARY = new Employee("John", "Smith", "1", 5000);
    public static List<Employee> EMPLOYEE = new ArrayList<>(List.of(MAX_SALARY, MIN_SALARY));
    public static final int SUM_SALARY = 20000;
    public static Map<String, List<Employee>> EMPLOYEE_MAP = new HashMap<>(Map.of("1", EMPLOYEE));

    @Test
    void shouldResultMinSalaryTest() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEE);
        assertEquals(MIN_SALARY, out.findMinSalaryInDepartment("1"));

        // проверка на выброс исключения, когда переданный отдел отсутствует или вообще не передан пользователем
        assertThrows(IllegalArgumentException.class, () -> out.findMinSalaryInDepartment(""));
        assertThrows(IllegalArgumentException.class, () -> out.findMinSalaryInDepartment("5"));
    }

    @Test
    void shouldResultMaxSalaryTest() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEE);
        assertEquals(MAX_SALARY, out.findMaxSalaryInDepartment("1"));

        // проверка на выброс исключения, когда переданный отдел отсутствует или вообще не передан пользователем
        assertThrows(IllegalArgumentException.class, () -> out.findMaxSalaryInDepartment(""));
        assertThrows(IllegalArgumentException.class, () -> out.findMaxSalaryInDepartment("5"));
    }

    @Test
    void shouldResultSumSalaryTest() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEE);
        assertEquals(SUM_SALARY, out.findSumSalaryInDepartment("1"));

        // проверка на выброс исключения, когда переданный отдел отсутствует или вообще не передан пользователем
        assertThrows(IllegalArgumentException.class, () -> out.findSumSalaryInDepartment(""));
        assertThrows(IllegalArgumentException.class, () -> out.findSumSalaryInDepartment("5"));
    }

    @Test
    void shouldResultGetAllInDepartmentTest() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEE);
        assertEquals(EMPLOYEE, out.getAllEmployeesInDepartment("1"));

        // проверка на выброс исключения, когда переданный отдел отсутствует или вообще не передан пользователем
        assertThrows(IllegalArgumentException.class, () -> out.getAllEmployeesInDepartment(""));
        assertThrows(IllegalArgumentException.class, () -> out.getAllEmployeesInDepartment("5"));
    }

    @Test
    void shouldResultGetAllTest() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEE);
        assertEquals(EMPLOYEE_MAP, out.getAllEmployees());
    }


}
