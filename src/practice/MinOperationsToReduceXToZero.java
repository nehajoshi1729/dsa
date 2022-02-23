package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. recursion based simple approach to mimic considering left and right element, and the ops are minimised
 * throwing TLE
 * 2. min operations to remove x from left / right == max subarray in between left and right that sums to sum(nums)-x
 * prefix sum + hashmap
 */
public class MinOperationsToReduceXToZero {
    private static int minOps;

    private static void recusrionHelper(int[] nums, int start, int end, int target, int ops) {
        if (target == 0) {
            minOps = Math.min(minOps, ops);
            return;
        }
        if (start > end)
            return;
        recusrionHelper(nums, start + 1, end, target - nums[start], ops + 1);
        recusrionHelper(nums, start, end - 1, target - nums[end], ops + 1);


    }

    private static int get(int nums[], int x) {

//        recursion based
//        minOps = Integer.MAX_VALUE;
//        recusrionHelper(nums, 0, nums.length - 1, x, 0);
//        return minOps == Integer.MAX_VALUE ? -1 : minOps;


//        int totalSum = Arrays.stream(nums).sum();
//        int totalSumRequired = totalSum - x;
        int totalSumRequired = -x;
        for (int num : nums) totalSumRequired += num;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - totalSumRequired))
                ans = Math.max(ans, i - map.get(prefixSum - totalSumRequired));
            map.put(prefixSum, i);

        }
        return ans == Integer.MIN_VALUE ? -1 : nums.length - ans;

    }

    public static void main(String[] args) {
        int nums[] = {5, 6, 7, 8, 9};
        int x = 5;
        System.out.println(get(nums, x));
    }
}
