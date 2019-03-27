import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int Add(String numbers) throws Exception {
        int result = 0;

        if ("".equals(numbers)) {
            return result;
        } else {
            List<Integer> numbersList = SplitStringList(numbers);

            for (Integer i : numbersList) {
                result += i;
            }
        }

        return result;
    }

    private static List<Integer> SplitStringList(String numbers) throws Exception {
        String negatives = "";
        String delimiterRegex = selectDelimiter(numbers);
        List<String> numbersStringList = Arrays.asList(numbers.split(delimiterRegex));

        List<Integer> numbersIntList = new ArrayList<>();

        for (String s : numbersStringList) {
            if (!"".equals(s)) {
                numbersIntList.add(Integer.valueOf(s));
                if (Integer.valueOf(s) < 0) {
                    if ("".equals(negatives)) {
                        negatives += s;
                    } else {
                        negatives = negatives + "," + s;
                    }
                }
            }
        }

        if (!"".equals(negatives)) {
            throw new Exception("negatives not allowed. " + negatives);
        }

        return numbersIntList;
    }

    private static String selectDelimiter(String numbers) {
        String result = "[/";
        List<String> delimiterSplit = Arrays.asList(numbers.split("//"));
        if (delimiterSplit.size() > 1) {
            result += delimiterSplit.get(1).substring(0,1);
        } else {
            result += ",";
        }
        result += "\n]";
        return result;
    }
}
