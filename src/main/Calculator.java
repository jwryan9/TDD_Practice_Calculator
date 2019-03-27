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
        String delimiter = selectDelimiter(numbers);
        List<String> numbersStringList = Arrays.asList(numbers.split("[/" + delimiter + "\n]"));
        List<Integer> numbersIntList = new ArrayList<>();

        for (String s : numbersStringList) {
            if (!s.equals("")) {
                numbersIntList.add(Integer.valueOf(s));
            }
        }

        return numbersIntList;
    }

    private static String selectDelimiter(String numbers) {
        String result = ",";
        List<String> delimiterSplit = Arrays.asList(numbers.split("//"));
        if (delimiterSplit.size() > 1) {
            result = delimiterSplit.get(1).substring(0,1);
        }
        return result;
    }
}
