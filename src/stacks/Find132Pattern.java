package stacks;

import java.util.Stack;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
 * such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * -- > monotonic stack
 *          lower value -- max --- second max
 *          iterate from right to left
 *              1. running variable for second max (max of pop'ed elements from the stack)
 *              2 .max will be stored in the stack (non max will get pop)
 *              3. 32 structure is maintained by 1 & 2 steps
 *              4. if the current element, while iterating is lesser than the second max. That's it.That's our 1
 */

public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        for(int i = nums.length-1;i>=0;i--)
        {
            if(nums[i] < secondMax)
                return true;
            while(!stack.isEmpty() && stack.peek() <nums[i])
            {
                secondMax = Math.max(secondMax,stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
