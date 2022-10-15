package arrays;

/**
 * return true of you find an IncreasingTripletSubsequence
 * i < j < k
 * nums[i] < nums[j] < nums[k]
 * <p>
 * find two smallest nums in the array such that
 * if current < left ,update left
 * if current > left and <mid, update mid
 * if you find a third number right, greater than mid, return true
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > mid)
                return true;
            if (num > left && num < mid)
                mid = num;
            else if (num < left)
                left = num;
        }
        return false;

    }
}
