package test;

import static org.junit.jupiter.api.Assertions.*;

import controller.Calculator;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testGetSummation() {
        // Test case 1
        Calculator calc = new Calculator();
        assertEquals(6.0, calc.calculate("1+2+3"));

        // Test case 2
        assertEquals(-4.0, calc.calculate("1-2-3"));

        // Test case 3
        assertEquals(6.0, calc.calculate("1*2*3"));

        // Test case 4
        assertEquals(5.0, calc.calculate("50/2/5"));

        // Test case 5
        assertEquals(-3.0, calc.calculate("1+2-3-3"));

        // Test 6
        assertEquals(16.0, calc.calculate("5+2*4+6/2"));

        // Test 7
//        assertEquals(-10.0, calc.calculate("-2*4+3-6/2"));
        assertEquals(0.0, calc.calculate("2-2"));

        // Test 8
        assertEquals(24.333333333333332, calc.calculate("2+3*8-5/3"));

    }
}