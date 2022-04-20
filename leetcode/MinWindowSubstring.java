package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        String result = "";
        boolean f1 = false;
        boolean f2 = false;
        Map<Character, Integer> desiredCountMap = new HashMap<>();
        Map<Character, Integer> currentCountMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            desiredCountMap.put(t.charAt(i), desiredCountMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int currentMatchCount = 0;
        int desiredMatchCount = t.length();
        int i=-1;
        int j=-1;
        while(true) {
            //acquire
            while(i<s.length() && currentMatchCount < desiredMatchCount) {
                i++;
                currentCountMap.put(s.charAt(i), currentCountMap.getOrDefault(s.charAt(i), 0) + 1);
                if(currentCountMap.getOrDefault(s.charAt(i), 0) <= desiredCountMap.getOrDefault(s.charAt(i), 0)) {
                    currentMatchCount++;
                }
                f1=true;
            }

            //collect ans and release
            while(j<i && currentMatchCount == desiredMatchCount){
                String tempResult = s.substring(j+1, i+1);
                if(tempResult.length() < result.length() || result.length() == 0) {
                    result = tempResult;
                }

                j++;

                Character ch = s.charAt(j);
                if(currentCountMap.get(ch) == 1) {
                    currentCountMap.remove(ch);
                } else {
                    currentCountMap.put(ch, currentCountMap.get(ch) - 1);
                }

                if(currentCountMap.getOrDefault(ch, 0) < desiredCountMap.getOrDefault(ch, 0)) {
                    currentMatchCount--;
                }
                f2 = true;
            }

            if(f1==false & f2==false) {
                break;
            }
        }

        return result;
    }
}
