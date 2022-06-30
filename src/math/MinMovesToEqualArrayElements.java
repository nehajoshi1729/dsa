package math;

import java.util.Arrays;
/*
in one move you can increment or decrement any element by 1
 */

public class MinMovesToEqualArrayElements {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int minMoves = 0;
        for (int i = 0; i < nums.length; i++) {
            minMoves += Math.abs(nums[i] - median);
        }
        return minMoves;
    }

}
