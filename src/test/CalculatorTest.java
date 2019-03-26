import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add() {
        int expected = 0;
        int actual = Calculator.Add("");
        assertEquals(expected, actual);

        expected = 1;
        actual = Calculator.Add("1");
        assertEquals(expected, actual);

        expected = 3;
        actual = Calculator.Add("1,2");
        assertEquals(expected, actual);
    }
}