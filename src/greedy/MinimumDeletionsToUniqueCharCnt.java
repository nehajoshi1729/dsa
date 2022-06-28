package greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * no two characters should have the same frequency => return min deletions needed to do this
 */

public class MinimumDeletionsToUniqueCharCnt {
    private static int get(String s) {
        int minDeletionsCount = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Integer> uniqueFrequencies = new HashSet<>();
        for (char c : hashMap.keySet()) {
            int freq = hashMap.get(c);
            if (!uniqueFrequencies.contains(freq))
                uniqueFrequencies.add(freq);
            else {
                while (freq > 0 && uniqueFrequencies.contains(freq)) {
                    freq--;
                    minDeletionsCount++;
                }
                uniqueFrequencies.add(freq);
            }
        }
        return minDeletionsCount;
    }
    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "aaabbbcc";
        get(s2);
    }
}
