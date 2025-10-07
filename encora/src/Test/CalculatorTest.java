package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void CheckAddMethod() {
		Calculator c = new Calculator();
		
		int sum = c.add(20, 10);
		// assertEquals(expected, observed)
		assertEquals(20, sum);
		
		int mul = c.multiply(20, 30);
		assertEquals(600, mul);
	}
}
