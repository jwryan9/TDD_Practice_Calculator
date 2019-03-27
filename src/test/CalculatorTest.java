import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static int expected;
    private static int actual;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void addOneTwoOrThreeTest() throws Exception {
        expected = 0;
        actual = Calculator.Add("");
        assertEquals(expected, actual);

        expected = 1;
        actual = Calculator.Add("1");
        assertEquals(expected, actual);

        expected = 3;
        actual = Calculator.Add("1,2");
        assertEquals(expected, actual);
    }

    @Test
    public void addManyTest() throws Exception {
        expected = 15;
        actual = Calculator.Add("1,2,3,4,5");
        assertEquals(expected, actual);

        expected = 55;
        actual = Calculator.Add("1,2,3,4,5,6,7,8,9,10");
        assertEquals(expected,actual);
    }

    @Test
    public void addNewLineTest() throws Exception {
        expected = 6;
        actual = Calculator.Add("1\n2,3");
        assertEquals(expected,actual);

        expected = 3;
        actual = Calculator.Add("1\n\n2");
        assertEquals(expected, actual);

        expected = 15;
        actual = Calculator.Add("1,2\n3\n\n\n4,5");
        assertEquals(expected, actual);
    }

    @Test
    public void addCustomDelimiterTest() throws Exception {
        expected = 3;
        actual = Calculator.Add("//;\n1;2");
        assertEquals(expected, actual);

        expected = 6;
        actual = Calculator.Add("//.\n1.2.3");
        assertEquals(expected, actual);
    }

    @Test
    public void addNegativeNumbersTest() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage("negatives not allowed. -1");
        Calculator.Add("-1");
    }
}

