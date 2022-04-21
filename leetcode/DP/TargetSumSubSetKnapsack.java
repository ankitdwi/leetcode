package leetcode.DP;

public class TargetSumSubSetKnapsack {

    public void knapsack(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    // if not included in subset
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else { // lets include this into knapsack
                        int totalVal = arr[i - 1];
                        if (j >= totalVal) {
                            if (dp[i - 1][j - totalVal] == true) {
                                dp[i][j] = true;
                            } else {
                                dp[i][j] = false;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dp[arr.length][target]);
    }

}
