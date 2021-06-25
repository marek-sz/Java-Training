package MathUtils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("All tests for MathUtil class")
class MathUtilsTest {
    private MathUtils mathUtils;

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("cleaning up...");
    }

    @Test
    @DisplayName("1.0 adding")
    void shouldAddTwoNumbers() {
        int a = 2;
        int b = 2;
        assertEquals(4, mathUtils.add(a, b));
    }

    @Test
    @DisplayName("1.1 adding")
    void youCanAlsoPassMessageArgumentToMethodAssert() {
        int a = 2;
        int b = 2;
        assertEquals(4, mathUtils.add(a, b), "Should add two numbers");
    }

    @Test
    @DisplayName("1.2 compute radius")
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }

    @Test
    @DisplayName("1.3 dividing")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

    @Test
    @Disabled
    @DisplayName("Disabled Test")
    void testDisabled() {
        fail();
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void enableOnCertainOs() {
        fail();
    }

    @Nested
    @DisplayName("Nested class for Adding")
    class AddTest {
        @Test
        @DisplayName("Testing methods for positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1));
        }

        @Test
        @DisplayName("Testing methods for negative numbers")
        void testAddNegatives() {
            assertEquals(-2, mathUtils.add(-1, -1));
        }
    }

}
