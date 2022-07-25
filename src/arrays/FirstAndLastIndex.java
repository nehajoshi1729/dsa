package arrays;

/**
 * Given a sorted array, return the first and last occurrence of a target character in logN => Binary Search
 */


public class FirstAndLastIndex {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = getFirstIndex(nums, target);
        ans[1] = getLastIndex(nums, target);
        return ans;

    }

    private int getFirstIndex(int nums[], int target) {
        int firstIndex = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //if target found go further left
            if (nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
            if (nums[mid] == target) firstIndex = mid;

        }
        return firstIndex;
    }

    private int getLastIndex(int nums[], int target) {
        int lastIndex = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //go further right if target found
            if (nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
            if (nums[mid] == target)
                lastIndex = mid;
        }
        return lastIndex;

    }
}
