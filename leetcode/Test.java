package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    private static List<String> sortNumber(List<String> input) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (isInteger(input.get(i)))
                result.add(Integer.valueOf(input.get(i)));
        }

        Collections.sort(result);

        int i = 0;
        int j = 0;

        while (i < input.size()) {
            if(isInteger(input.get(i))) {
                input.set(i, String.valueOf(result.get(j)));
                i++;
                j++;
            } else {
                i++;
            }
        }

        return input;
    }

    private static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }





    public static void main(String[] args) {
//        List<String> input =Arrays.asList("1","3","@","2","3","%","5","7","4");
        List<String> input =Arrays.asList("#","500","79","@","2","3","%","899","&","7","4","/" );
        System.out.println(sortNumber(input));
    }
}


[a, ...b] = arr

