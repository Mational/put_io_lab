package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void test1() {
        assertEquals(5, calculator.add(5,6));
    }

    @Test
    void test2() {
        assertEquals(5, calculator.addPositiveNumbers(-5, 10));
    }

    @Test
    void test3() {
        try{
            assertEquals(5, calculator.add(5, 6));
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
