import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StreamApiExerciseTest {
    List<Employee> employees;

    @BeforeAll
    void init() {
        employees = new ArrayList<>();
        Employee employee = new Employee("Marek", "Kowalski", 35, Arrays.asList("Java", "JavaScript", "Python"));
        Employee employee1 = new Employee("Tomasz", "Magdziarz", 36, Arrays.asList("TypeScript", "JavaScript", "Python"));
        Employee employee2 = new Employee("Jacek", "Milorząb", 31, Arrays.asList("Linux", "JavaScript", "Python"));
        Employee employee3 = new Employee("Jacek", "Czarnecki", 21, Arrays.asList("Bootstrap", "Python"));
        Employee employee4 = new Employee("Marta", "Mirzeja", 11, Arrays.asList("Vue", "Angular"));
        Employee employee5 = new Employee("Tomek", "Wilczyński", 32, Arrays.asList("Java", "JavaScript", "Angular", "Python", "Fast Typing"));
        Employee employee6 = new Employee("Jan", "Wiewiórkowski", 40, Arrays.asList("Java", "JavaScript", "Python"));

        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
    }

}