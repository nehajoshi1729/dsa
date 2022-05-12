package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 * <p>
 * classic backtracking
 * P.S /Hint 101 - combinations / permutations any flavour ; try to think of backtracking : D
 */

public class PermutationII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> ansSet = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, ansSet, visited, new ArrayList<>());
        for (List<Integer> i : ansSet)
            ans.add(i);
        return ans;


    }

    private static void backtrack(int[] nums, Set<List<Integer>> res, boolean[] visited, List<Integer> currentList) {
        if (currentList.size() == nums.length) {
            res.add(new ArrayList<>(currentList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                currentList.add(nums[i]);
                visited[i] = true;
                backtrack(nums, res, visited, currentList);
                visited[i] = false;
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 2};
        System.out.println(permuteUnique(nums));

    }


}
