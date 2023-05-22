import static org.junit.jupiter.api.Assertions.*;

import controller.Calculator;
import org.junit.Test;

public class CalculatorTest {
    Calculator calc = new Calculator();
    final double precision = 0.001;

    @Test
    public void getTrigonometry() {
        assertEquals(-1.049, calc.calculate("sec(60)"), precision);
//        assertEquals(1.950, calc.calculate("sec(60) + cot(45) - cosec(30)"), precision);
        assertEquals(-0.462, calc.calculate("sin(30) + cos(45)"), precision);
        assertEquals(0.286, calc.calculate("tan(60) * sin(90)"), precision);
        assertEquals(-0.944, calc.calculate("sin(2 * cos(60))"), precision);
        assertEquals(0.321, calc.calculate("(sin(45) + cos(30)) * tan(60)"), precision);
        assertEquals(-0.798, calc.calculate("sin(2 * (cos(45) + sin(30)))"), precision);
        assertEquals(-0.786, calc.calculate("cos(45) / (tan(60) + sin(30))"), precision);
        assertEquals(-0.048, calc.calculate("sin(cos(tan(45)))"), precision);
        assertEquals(-1.042, calc.calculate("(sin(30) + cos(45)) * tan(60) - sin(90)"), precision);
        assertEquals(-2.496, calc.calculate("sin(2 * (cos(45) + sin(30))) / tan(60)"), precision);
        assertEquals(-1.562, calc.calculate("sin(cos(tan(45))) + sin(30) - cos(45)"), precision);
        assertEquals(-1.374, calc.calculate("sin(cos(tan(45))) + sin(30) - cos(sin(cos(tan(45))) + sin(sin(cos(tan(sin(cos(tan(sin(cos(tan(45))) + sin(30) - cos(45)))) + sin(30) - cos(45)))) + sin(30) - cos(45)) - cos(sin(cos(tan(45))) + sin(30) - cos(sin(cos(tan(45))) + sin(30) - cos(45))))"), precision);

    }

    @Test
    public void testGetSummation() {
        assertEquals(0, calc.calculate("-1+2+(1-2)"));
        assertEquals(0.322, calc.calculate("sin(60+sin(30))+sin(90-30)"), precision);
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