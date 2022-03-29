package arrays;

/**
 * in an array of n size and elements in the range of 0 - n-1 find the num that is duplicate
 * we need to make use of the fact that elements in the array will be in 0 - n-1
 * using it to kind of mark the visited nums = making it -ve, later when we try to access that location, if its values
 * i.e. if nums[Math.abs(nums[i])] is -ve we get our duplicate num
 */

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] > 0)
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            else
                return Math.abs(nums[i]);


        }
        return -1;
    }
}
