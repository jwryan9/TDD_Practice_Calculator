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
        String listOfNegatives = "";
        List<String> numbersStringList = Arrays.asList(numbers.split(selectDelimiter(numbers)));
        List<Integer> numbersIntList = new ArrayList<>();

        for (String s : numbersStringList) {
            if (!"".equals(s)) {
                if (Integer.valueOf(s) < 0) {
                    if ("".equals(listOfNegatives)) {
                        listOfNegatives += s;
                    } else {
                        listOfNegatives = listOfNegatives + "," + s;
                    }
                } else {
                    numbersIntList.add(Integer.valueOf(s));
                }
            }
        }

        if (!"".equals(listOfNegatives)) {
            throw new Exception("negatives not allowed. " + listOfNegatives);
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
