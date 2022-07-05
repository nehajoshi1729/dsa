package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * return the length of the longest consecutive elements sequence.
 * eg nums = [100,4,200,1,3,2] , return 4
 */

public class LongestConsecutiveSequence {
    private static int get(int[] nums) {
        int longestSequenceLength = 0;
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums)
            hashSet.add(n);
        for (int n : nums) {
            if (hashSet.contains(n)) {
                hashSet.remove(n);
                int leftEndOfSequence = n - 1;
                int rightEndOfSequence = n + 1;
                while (hashSet.contains(leftEndOfSequence))
                    hashSet.remove(leftEndOfSequence--);
                while (hashSet.contains(rightEndOfSequence))
                    hashSet.remove(rightEndOfSequence);
                longestSequenceLength = Math.max(longestSequenceLength, rightEndOfSequence - leftEndOfSequence - 1);
            }

        }
        return longestSequenceLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(get(nums));
    }


}
