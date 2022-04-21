package leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    // Count subarray Equals K
    // if at any point sum is y then check if hasmap has every seen y-k sum
    public static int solution2(int[] arr, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int remainingSum = sum - k;

            if(map.containsKey(remainingSum)) {
                ans += map.get(remainingSum);
            }

            map.put(sum, map.getOrDefault(sum,0) + 1);

        }

        return ans;
    }
}
