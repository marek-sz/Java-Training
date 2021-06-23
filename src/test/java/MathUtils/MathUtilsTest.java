package MathUtils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void shouldAddTwoNumbers() {
        int a = 2;
        int b = 2;
        assertEquals(4, mathUtils.add(a, b));
    }

    @Test
    void youCanAlsoPassMessageArgumentToMethodAssert() {
        int a = 2;
        int b = 2;
        assertEquals(4, mathUtils.add(a, b), "Should add two numbers");
    }

    @Test
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0));
    }

}
