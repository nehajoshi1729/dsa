package twoPointer;

/**
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * follow-up : using library sort is not allowed
 * <p>
 * Dutch National Flag Algorithm, TC = O(N)
 * in case of current and high swap, only high will be decremented. For current, we can not be sure if the swapped number is 0/1/2,
 * it will go through one more check and be located at it's correct location
 *
 */

public class SortColours {
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortColors(int[] nums) {
        int low = -1;
        int mid = 0;
        int high = nums.length;

        while (mid < high) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                low++;
                swap(nums, low, mid);
                mid++;
            } else {
                high--;
                swap(nums, high, mid);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);

    }
}
