package recursion;

/**
 * check if a num is any power of three
 * recursion level 0 :
 * f(27) =1 and f(9)
 * f(9) = 1 and f(3)
 * f(3) = 1 and f(1)
 * <p>
 * f(1) = 1
 */

public class PowerOfThree {
    private boolean get(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        return (n % 3 == 0) && get(n / 3);
    }
}
