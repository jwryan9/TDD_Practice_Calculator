import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int Add(String numbers) {
        int result = 0;

        if (numbers.equals("")) {
            return result;
        } else {
            List<Integer> numbersList = SplitStringList(numbers);

            for (Integer i : numbersList) { result += i; }
        }

        return result;
    }

    private static List<Integer> SplitStringList(String numbers) {
        List<String> numbersStringList = Arrays.asList(numbers.split(","));
        List<Integer> numbersIntList = new ArrayList<>();

        for (String s : numbersStringList) {
            numbersIntList.add(Integer.valueOf(s));
        }

        return numbersIntList;
    }
}
