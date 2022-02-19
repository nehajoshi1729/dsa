package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ret);
        return ret;
    }

    private static void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
        ret.add(path);
        for (int i = idx; i < nums.length; i++) {
            List<Integer> p = new ArrayList<>(path);
            p.add(nums[i]);
            System.out.println(p);
            dfs(nums, i + 1, p, ret);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

}
