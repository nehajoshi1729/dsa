package strings;

import java.util.HashSet;

/**
 * Given a binary string s and an integer k,
 * return true if every binary code of length k is a substring of s. Otherwise, return false.
 * <p>
 * s = "00110110", k = 2 ==> true
 * go through the string creating substrings (kinda sliding windows of size k) and add it in set (unique subsets)
 * if at the end size of set is == powersetSize ( 2 ^ k ) return true
 */

public class HasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k)
            return false;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (Math.pow(2, k));

    }
}
