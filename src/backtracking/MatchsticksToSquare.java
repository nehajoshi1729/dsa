package backtracking;

/**
 * every matchstick can belong to any one side of the square
 * we need subsets of sides that sum up to perimeter/4 each => backtracking
 */

public class MatchsticksToSquare {
    private static boolean get(int[] nums) {
        if (nums.length < 4)
            return false;
        int perimeter = 0;
        for (int num : nums)
            perimeter += num;
        if (perimeter % 4 != 0)
            return false;
        int side = perimeter / 4;
        //sides[] will maintain the current state of matchsticks added to each side
        int[] sides = new int[]{side, side, side, side};

        return backtrack(nums, 0, sides);

    }

    private static boolean backtrack(int[] nums, int i, int[] sides) {
        if (i == nums.length)
            return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
        for (int j = 0; j < 4; j++) {
            if (nums[i] > sides[j]) continue;
            sides[j] -= nums[i];
            if (backtrack(nums, i + 1, sides)) return true;
            sides[j] += nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 2, 2};
        int[] nums = {3,3,3,3,4};
        System.out.println(get(nums));
    }
}
