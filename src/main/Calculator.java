import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int Add(String numbers) {
        int result = 0;

        if (numbers.equals("")) {
            result = 0;
        } else {
            List<String> numbersStringList = Arrays.asList(numbers.split(","));
            List<Integer> numbersIntList = new ArrayList<>();

            for (String s : numbersStringList) numbersIntList.add(Integer.valueOf(s));

            for (Integer i : numbersIntList) result += i;
        }

        return result;
    }
}
