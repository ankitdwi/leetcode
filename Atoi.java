import java.util.ArrayList;
import java.util.List;

public class Atoi {
    final static char[][] L = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static List<String> letterCombinations(String x) {
        List<String> result = new ArrayList<>();

        if(x.length() == 0) {
            return result;
        }

        if(x.length() == 1) {
            char[] currChars = L[Integer.parseInt(x)];
            for (Character ch: currChars) {
                result.add(ch.toString());
            }

            return result;
        }

        char ch = x.charAt(0);
        String rest = x.substring(1);

        List<String> prevResult = letterCombinations(rest);

        char[] currChars = L[Character.getNumericValue(ch)];

        for (int i = 0; i < currChars.length; i++) {
            char charToAdd = currChars[i];
            for (int j = 0; j < prevResult.size(); j++) {
                result.add(prevResult.get(j) + charToAdd);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}