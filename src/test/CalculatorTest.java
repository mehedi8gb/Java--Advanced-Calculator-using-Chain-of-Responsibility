package test;

import static org.junit.jupiter.api.Assertions.*;

import controller.Calculator;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testGetSummation() {

        Calculator calc = new Calculator();

        assertEquals(0, calc.calculate("(-1+2+(1-2)+sin(0)"));
        assertEquals(0, calc.calculate("(-1+2+(1-2))"));
        assertEquals(1073.875, calc.calculate("(((2 + 4 * 3) - 8 / 2) ^ 3) + ((5 - 1) * (7 + 9) - 2) / (4 ^ 2) + ((10 - 2) ^ 2 + 3 * (8 / 4))\n"));
        assertEquals(-3371.33333333, calc.calculate("(1+2+(1-2+(5+5-(6-6+(50+40*(10*50/6))))))"), 0.000001);
        assertEquals(-25, calc.calculate("1-5^2-1"));
        assertEquals(-4.0, calc.calculate("1-2-3"));
        assertEquals(6.0, calc.calculate("1+2+3"));
        assertEquals(6.0, calc.calculate("1*2*3"));
        assertEquals(5.0, calc.calculate("50/2/5"));
        assertEquals(-3.0, calc.calculate("1+2-3-3"));
        assertEquals(16.0, calc.calculate("5+2*4+6/2"));
        assertEquals(-8.0, calc.calculate("-2*4+3-6/2"));
        assertEquals(0.0, calc.calculate("2-2"));
        assertEquals(24.333333333333332, calc.calculate("2+3*8-5/3"));
        assertEquals(379, calc.calculate("200-12/3+3*2*3*7-2+1+2*12-1+7*5"));
        assertEquals(9, calc.calculate("-1+10"));
        assertEquals(9, calc.calculate("3^2"));
        assertEquals(30, calc.calculate("5+5^2"));
        assertEquals(2, calc.calculate("++++++1--++--1"));
        assertEquals(-15, calc.calculate("5*-3"));
        assertEquals(-110, calc.calculate("20+50*-3+20"));
        assertEquals(87, calc.calculate("20+50-3+20"));
        assertEquals(83, calc.calculate("20+50-7+20"));
        assertEquals(0, calc.calculate("0"));
        assertEquals(10, calc.calculate("5+5"));
        assertEquals(-5, calc.calculate("10-15"));
        assertEquals(100, calc.calculate("50*2"));
        assertEquals(12, calc.calculate("4*3"));
        assertEquals(5, calc.calculate("10/2"));
        assertEquals(2, calc.calculate("8/4"));
        assertEquals(25, calc.calculate("5^2"));
        assertEquals(27, calc.calculate("1+5^2+1"));
        assertEquals(25, calc.calculate("2*5^2/2"));
    }
}