package pro.sky.homework_2._EmployeeBook;

import org.junit.jupiter.api.Test;
import pro.sky.homework_2._EmployeeBook.domain.Employee;
import pro.sky.homework_2._EmployeeBook.exception.ValidataException;
import pro.sky.homework_2._EmployeeBook.service.EmployeeService;
import pro.sky.homework_2._EmployeeBook.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeService out = new EmployeeServiceImpl();

    private static final String DEFULT_MESSAGE_ADD = "Такой сотрудник уже есть";
    private static final String CORRECT_MESSAGE_ADD = "Сотрудник успешно добавлен";
    private static final String DEFULT_MESSAGE_FIND = "Такого сотрудника в базе нет";
    public static List<Employee> EMPLOYEE = new ArrayList<>(List.of(
            new Employee("Maria", "Prokhorova", "1", 95000),
            new Employee("Ivan", "Ivanov", "1", 15000),
            new Employee("Petr", "Petrov", "2", 59000)
    ));

    @Test
    public void shouldResultAddEmployeeTest() {
        // добавляем сотрудника, которого нет еще в базе
        String result1 = out.addEmployee("Ivan", "Petrov", "3", 45000);
        assertEquals(CORRECT_MESSAGE_ADD, result1);

        // добавляем сотрудника, который уже есть в базе
        String result2 = out.addEmployee("Ivan", "Petrov", "3", 45000);
        assertEquals(DEFULT_MESSAGE_ADD, result2);

        // проверка на выброс исключения, если введены некорректные данные
        assertThrows(ValidataException.class, () -> out.addEmployee("1234", "Petrov", "3", 45000));
    }

    @Test
    public void shouldResultFindEmployeeTest() {
        // ищем сотрудника, который есть в базе
        String result1 = out.findEmployee("Maria", "Prokhorova");
        String CORRECT_MESSAGE_FIND = "Maria Prokhorova";
        assertEquals(CORRECT_MESSAGE_FIND, result1);

        // ищем сотрудника, которого нет в базе
        String result2 = out.findEmployee("Ivan", "Petrov");
        assertEquals(DEFULT_MESSAGE_FIND, result2);

        // проверка на выброс исключения, если введены некорректные данные
        assertThrows(ValidataException.class, () -> out.addEmployee("1234", "Petrov", "3", 45000));
    }

    @Test
    public void shouldResultRemoveTest() {
        // проверяем удаление сотрудника, который есть в базе (метод должен отработать и не выбросить исключение)
        assertDoesNotThrow(() -> out.removeEmployee("Maria", "Prokhorova"));

        // проверяем удаление сотрудника, которого нет в базе (метод должен выбросить исключение)
        assertThrows(RuntimeException.class, () -> out.removeEmployee("Ivan", "Petrov"));

        // проверка на выброс исключения, если введены некорректные данные
        assertThrows(ValidataException.class, () -> out.addEmployee("1234", "Petrov", "3", 45000));
    }

    @Test
    void shouldResultGetAllEmployeeTest() {
        List<Employee> result = out.getAllEmployee();
        assertTrue(result.containsAll(EMPLOYEE) && EMPLOYEE.containsAll(result));
    }
}
