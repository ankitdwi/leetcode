package leetcode;

public class Kadanes {

    // Maximum Sum SubArray with K element
    public static int solution(int[] arr) {
        int currentSum = arr[0];
        int overallSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(currentSum >=0) {
                currentSum += arr[i];
            } else {
                currentSum = arr[i];
            }

            if(currentSum > overallSum) {
                overallSum = currentSum;
            }
        }
        return overallSum;
    }



    // Maximum Sum SubArray with at least Size K
    public static int solution2(int[] arr, int k) {
        int ans = Integer.MAX_VALUE;
        int currentSum = arr[0];
        int maxSumSoFar[] = new int[arr.length];
        maxSumSoFar[0] = currentSum;

        for (int i = 1; i < arr.length; i++) {
            if(currentSum >=0) {
                currentSum += arr[i];
            } else {
                currentSum = arr[i];
            }

            maxSumSoFar[i] = currentSum;
        }
        int exactK = 0;

        for (int i = 0; i < k; i++) {
            exactK += arr[i];
        }

        if(exactK > ans) {
            ans = exactK;
        }

        for (int i = k; i < arr.length; i++) {
            exactK = exactK + arr[i] - arr[i-k];

            if(exactK > ans) {
                ans = exactK;
            }
            int moreThanK = maxSumSoFar[i-k] + exactK;

            if(moreThanK > ans) {
                ans = moreThanK;
            }
        }

        return ans;

    }
}
