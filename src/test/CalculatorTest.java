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

        expected = 15;
        actual = Calculator.Add("1,2,3,4,5");
        assertEquals(expected, actual);

        expected = 55;
        actual = Calculator.Add("1,2,3,4,5,6,7,8,9,10");
        assertEquals(expected,actual);

        expected = 6;
        actual = Calculator.Add("1\n,2,3");
        assertEquals(expected,actual);
    }
}

