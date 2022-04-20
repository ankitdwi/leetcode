package leetcode.DP;

import java.util.HashSet;

public class WordBreak {
    public static boolean solution(String sentence, HashSet<String> dictionary) {
        int dp[] = new int[sentence.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String wordToCheck = sentence.substring(j, i + 1);
                if(dictionary.contains(wordToCheck)) {
                    if (j > 0)
                        dp[i] += dp[j-1];
                    else
                        dp[i] += 1;
                }
            }
        }

        return dp[sentence.length() - 1] > 0;

    }
}
