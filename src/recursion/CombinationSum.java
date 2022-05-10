package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n
 * classic backtracking
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int k, int remaining, int start) {
        if (temp.size() > k)
            return;
        else if (temp.size() == k && remaining == 0)
            ans.add(new ArrayList<>(temp));
        else {
            for (int i = start; i <= 9; i++) {
                temp.add(i);
                backtrack(ans, temp, k, remaining - i, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
