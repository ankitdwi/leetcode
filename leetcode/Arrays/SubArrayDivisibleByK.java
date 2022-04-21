package leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayDivisibleByK {

    //1. You are given an array of integers(arr) and a number K.
    //2. You have to find the count of subarrays whose sum is divisible by K.
    public static int solution2(int[] arr, int k) {
        int ans = 0;
        Map<Integer, Integer> remainderFreq = new HashMap<>();
        remainderFreq.put(0,1);
        int sum =0;
        int remainder = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
           remainder = sum % k;

           // important line
            // remainder is negative make is positive
            // negative remainder means kn-y
            // kn-y + k - k -> k(n-1) + (k-y)
           if(remainder < 0) {
               remainder += k;
           }

            if(remainderFreq.containsKey(remainder)) {
                ans += remainderFreq.get(remainder);
                remainderFreq.put(remainder, remainderFreq.get(remainder) + 1);
            } else {
                remainderFreq.put(remainder, 1);
            }

        }

        return ans;
    }
}
