import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    public void testAddShouldReturn0() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAddShouldReturn3() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testAddShouldReturnMany() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(36, calculator.add("1,2,3,4,5,6,7,8"));
    }

    @Test
    public void testAddShouldReturnSumWithNewLineCharacter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testAddShouldReturnSumWithNewLineCharacter2() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//###\n1###2###3")); //  //;\n1;2   //;\n1;2;3   //+\n1+2+3  //---\n1---2---3   //,\n1,2,3
    }

    @Test
    public void testAddShouldReturnException() {
        StringCalculator calculator = new StringCalculator();

        Throwable exceptionThatWasThrown = assertThrows(Exception.class, () -> {
            calculator.add("1,4,-1");
        });
        assertEquals(exceptionThatWasThrown.getMessage(), "negatives not allowed: -1");
    }

    @Test
    public void testAddShouldIgnoreBigNums() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("2,1001"));
    }
}
