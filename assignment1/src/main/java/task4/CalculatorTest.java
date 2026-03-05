package task4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
	public final void testDividingTwoPositiveIntegers() {
	    Calculator calculator = new Calculator();
	    assertEquals(2, calculator.divide(10, 5));
	}

    @Test
	public final void testDividingTwoNegativeIntegers() {
	    Calculator calculator = new Calculator();
	    assertEquals(2, calculator.divide(-10, -5));
	}
    
    @Test
	public final void testDividingByZero() {
	    Calculator calculator = new Calculator();
	    assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
	}

	@Test
	public final void testDividingTwoIntegers() {
	    Calculator calculator = new Calculator();
	    assertEquals(-6, calculator.divide(12, -2));
	}

}
