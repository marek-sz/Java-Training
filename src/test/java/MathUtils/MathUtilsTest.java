package MathUtils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("All tests for MathUtil class")
class MathUtilsTest {
    private TestInfo testInfo;
    private TestReporter testReporter;
    private MathUtils mathUtils;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
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

    // for optimisation write lambda expression to create a message. Will be executed only if test fails
    @Test
    @DisplayName("Message passed only when test fails")
    void testComputeCircleArena() {
        double expected = 314.1592653589793;
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), () -> "Test should return " + expected);
        assertEquals(0, mathUtils.computeCircleArea(10), () -> "Test should return " + expected);
    }

    @RepeatedTest(3)
    void repeatedTest() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }

    @RepeatedTest(3)
    void repeatedTestWhenYouWantToTakeControlOfRepetitions(RepetitionInfo repetitionInfo) {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10));
    }

    //before that you have to add parameter to method (BeforeAll e.g)
    @Test
    @DisplayName("test info and test tags")
    void showLogsOfTheTest() {
        testReporter.publishEntry(" " + testInfo.getDisplayName() + testInfo.getTags());

    }
}