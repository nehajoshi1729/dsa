package strings;

/**
 * You are given two integers n and k.
 * Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 * <p>
 * ans needs to be like a a a ...remainder char ..... z z z
 */

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char ans[] = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 'a';
        }
        k = k - n;
        int i = n - 1;

        while (k > 0) {
            if (k < 25) {
                ans[i] = (char) ('a' + k);
                k = 0;

            } else {
                ans[i] = 'z';
                k = k - 25;
            }

            i--;
        }
        return new String(ans);
    }
}
