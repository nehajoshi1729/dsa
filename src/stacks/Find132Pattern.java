package stacks;

import java.util.Stack;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
 * such that i < j < k and nums[i] < nums[k] < nums[j].
 */

public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int thirdElement = Integer.MIN_VALUE;

        for(int i = nums.length-1;i>=0;i--)
        {
            if(nums[i] < thirdElement)
                return true;
            while(!stack.isEmpty() && stack.peek() <nums[i])
            {
                thirdElement = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
