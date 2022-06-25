package greedy;

public class NonDecreasingArray {
    private static boolean get(int[] nums) {
        int modificationCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                modificationCount++;

                if (i >= 2 && nums[i - 2] > nums[i])
                    nums[i] = nums[i - 1];
                else
                    nums[i - 1] = nums[i];
            }
        }
        return modificationCount <= 1;


    }
}
