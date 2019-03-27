import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static int expected;
    private static int actual;

    @Test
    public void add() {
        expected = 0;
        actual = Calculator.Add("");
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
        actual = Calculator.Add("1\n2,3");
        assertEquals(expected,actual);

        expected = 3;
        actual = Calculator.Add("1\n\n2");
        assertEquals(expected, actual);

        expected = 15;
        actual = Calculator.Add("1,2\n3\n\n\n4,5");
        assertEquals(expected, actual);

        expected = 3;
        actual = Calculator.Add("//;\n1;2");
        assertEquals(expected, actual);

        expected = 6;
        actual = Calculator.Add("//.\n1.2");
        assertEquals(expected, actual);
    }
}

