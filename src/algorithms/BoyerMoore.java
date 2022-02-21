package algorithms;

/**
 * majority element will occur more than n/2 times
 * prefix except the majority will have count = 0 --> other nums will cancel each other out
 */

public class BoyerMoore {
    public static int majorityElement(int[] nums) {
        int count = 1;
        int majorityElement = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majorityElement)
                count += 1;
            else
                count -= 1;

            if (count == 0) {
                majorityElement = nums[i];
                count = 1;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
