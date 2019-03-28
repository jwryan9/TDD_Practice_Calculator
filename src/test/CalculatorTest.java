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
        assertEquals(0, Calculator.Add(""));
        assertEquals(1, Calculator.Add("1"));
        assertEquals(3, Calculator.Add("1,2"));
    }

    @Test
    public void addManyTest() throws Exception {
        assertEquals(15, Calculator.Add("1,2,3,4,5"));
        assertEquals(55, Calculator.Add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void addNewLineTest() throws Exception {
        assertEquals(6, Calculator.Add("1\n2,3"));
        assertEquals(3, Calculator.Add("1\n\n2"));
        assertEquals(15, Calculator.Add("1,2\n3\n\n\n4,5"));
    }

    @Test
    public void addCustomDelimiterTest() throws Exception {
        assertEquals(3, Calculator.Add("//;\n1;2"));
        assertEquals(6, Calculator.Add("//.\n1.2.3"));
    }

    @Test
    public void addNegativeNumbersTest1() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage("negatives not allowed. -1");
        Calculator.Add("-1");
    }

    @Test
    public void addNegativeNumbersTest2() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage("negatives not allowed. -1,-2,-3");
        Calculator.Add("-1,4,-2,-3,10");
    }

    @Test
    public void addBigNumbersTest() throws Exception {
        assertEquals(2, Calculator.Add("2,1001"));
        assertEquals(3, Calculator.Add("1,2,1000000"));
    }
}

