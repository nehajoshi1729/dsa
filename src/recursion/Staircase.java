package recursion;

import java.util.Arrays;

/**
 * a child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps
 * at a time. Implement a method to count how many possible ways the child can run up the stairs
 **/

public class Staircase {
    public static int countWays(int n) {
        int memoStep[] = new int[n + 1];
        Arrays.fill(memoStep, -1);
        return countWays(n, memoStep);
    }

    public static int countWays(int n, int[] memoStep) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (memoStep[n] > -1)
            return memoStep[n];
        else {
            memoStep[n] = countWays(n - 1, memoStep) + countWays(n - 2, memoStep) + countWays(n - 3, memoStep);
            return memoStep[n];
        }


    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countWays(n));
    }
}
