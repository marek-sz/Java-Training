import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamApiExerciseTest {
    List<Employee> employees;

    @BeforeEach
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

    @Test
    void firstStream() {
        employees
                .forEach(System.out::println);
    }

    @Test
    void mapOperations() {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
    }

    @Test
    void flatMapOperations() {
        List<List<String>> allSkills = employees.stream()
                .map(Employee::getSkills)
                .collect(Collectors.toList());
        System.out.println(allSkills);

        //flat mapa wypłaszcza listę, w wyniku czego nie dostajemy listę list, tylko pojedynczą listę
        List<String> allSkillsFlatten = employees.stream()
                .map(Employee::getSkills)
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(allSkillsFlatten);
    }

    @Test
    void filterOperations() {
        employees.stream()
                .filter(employee -> employee.getLastName().startsWith("M"))
                .forEach(System.out::println);
    }

    @Test
    void sortedOperations() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    //funkcja limit ogranicza ilość przetwarzanych elementów
    @Test
    void limitOperations() {
        employees.stream()
                .limit(2)
                .forEach(System.out::println);
    }

    //funkcja skip pomija pierwsze n elementów listy
    @Test
    void skipOperations() {
        employees.stream()
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    void countOperations() {
        long numberOfEmployees = employees.stream()
                .filter(employee -> employee.getLastName().startsWith("W"))
                .count();
        System.out.println(numberOfEmployees);
    }

    @Test
    void minMaxOperations() {
        Employee youngestEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getAge))
                .get();

        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .get();

        System.out.println("Youngest employee: " + youngestEmployee);
        System.out.println("Oldest employee: " + oldestEmployee);
    }

    @Test
    void findAnyFindFirstOperations() {
        Employee firstEmployee = employees.stream()
                .filter(e -> e.getLastName().startsWith("M"))
                .findFirst()
                .get();
        System.out.println(firstEmployee);

        Employee anyEmployee = employees.stream()
                .filter(e -> e.getLastName().startsWith("M"))
                .findAny()
                .get();
        System.out.println(anyEmployee);
    }

    //allMatch - zwraca boolean jesli wszystkie elementy strumienia pasuja do predykatu
    //anyMatch - jesli ktorykolwiek z elementow pasuje do predykatu
    @Test
    void matchOperations() {
        assertFalse(employees.stream()
                .allMatch(employee -> employee.getLastName().startsWith("B")));

        assertTrue(employees.stream()
                .anyMatch(employee -> employee.getLastName().startsWith("M")));

        assertTrue(employees.stream()
                .anyMatch(employee -> employee.getFirstName().contains("a")));
        assertTrue(employees.stream()
                .noneMatch(employee -> employee.getFirstName().startsWith("x")));
    }

    //zadaniem reduce jest zredukować wartości streama do pojedynczej wartości
    @Test
    void reduceOperations() {
        Integer totalAge = employees.stream()
                .map(Employee::getAge)
                .reduce((age1, age2) -> age1 + age2)
                .get();
        System.out.println(totalAge);

        //drugi konstruktor, z początkową wartością, od której redukujemy
        Integer totalAgeWithStartingValue = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);
        System.out.println(totalAgeWithStartingValue);

        //w trzecim konstruktorze mapujemy wartość
        Integer totalAgeWithStartingValueAndAccumulator = employees.stream()
                .reduce(0, (age, employee) -> age + employee.getAge(), Integer::sum);
        System.out.println(totalAgeWithStartingValueAndAccumulator);

        String firstNamesJoined = employees.stream()
                .map(Employee::getFirstName)
                .reduce((name, name2) -> name + ", " + name2)
                .get();
        System.out.println(firstNamesJoined);

        String firstCharactersJoined = employees.stream()
                .map(Employee::getFirstName)
                .map(employee -> employee.charAt(0))
                .map(Object::toString)
                .reduce((c1, c2) -> c1 + c2)
                .get();
        System.out.println(firstCharactersJoined);
    }

}