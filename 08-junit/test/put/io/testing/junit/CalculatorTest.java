package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
        private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd1() {
        assertEquals(11, calculator.add(5, 6),
                "Regular addition should work");
    }

    @Test
    void testAdd2() {
        assertEquals(0, calculator.add(-5, 5),
                "Adding two opposite values should work");
    }

    @Test
    void testMultiply1() {
        assertEquals(30, calculator.multiply(5,6),
                "Regular multiplication should work");
    }

    @Test
    void testMultiply2() {
        assertEquals(0, calculator.multiply(0, 2131),
                "Multiplying by 0 should work");
    }

    @Test
    void testAddPositiveNumbers2() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                calculator.addPositiveNumbers(-5, 1));
        assertEquals("The arguments must be positive",
                exception.getMessage());
    }

    //@Test
}