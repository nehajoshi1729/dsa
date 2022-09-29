package twoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * input arr in sorted order, keep refining the k element window, based on the two closeness defining rules
 * 1. lesser diff is closer
 * 2. in case of same diff, higher index num is farther
 * <p>
 * until window size is k, keep removing farther elements (either one left or one right at a time) based
 * the above two rules
 */

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;
        while (high - low >= k) {
            if (Math.abs(arr[low] - x) > Math.abs(arr[high] - x))
                low++;
            else
                high--;

        }
        for (int i = low; i <= high; i++)
            ans.add(arr[i]);

        return ans;
    }
}
