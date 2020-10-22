import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void testAddShouldReturn0() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
}
