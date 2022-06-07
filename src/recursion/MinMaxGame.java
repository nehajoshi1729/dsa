package recursion;

/**
 * basic recursion
 * Apply the following algorithm on nums:
 * <p>
 * Let n be the length of nums. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n / 2.
 * For every even index i where 0 <= i < n / 2, assign the value of newNums[i] as min(nums[2 * i], nums[2 * i + 1]).
 * For every odd index i where 0 <= i < n / 2, assign the value of newNums[i] as max(nums[2 * i], nums[2 * i + 1]).
 * Replace the array nums with newNums.
 * Repeat the entire process starting from step 1.
 * Return the last number that remains in nums after applying the algorithm.
 */

public class MinMaxGame {
    private int getGame(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int newNum[] = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            if (i % 2 == 0)
                newNum[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            else
                newNum[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        }
        int res = getGame(newNum);
        return res;
    }
}
