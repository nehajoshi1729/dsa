package greedy;

/**
 * Given two integers startValue and target,
 * return the minimum number of operations needed to display target on the calculator.
 * Rules :
 * -- multiply the number on display by 2, or
 * -- subtract 1 from the number on display
 * <p>
 * greedily need to get to target with min steps => need doubling operator,
 * in case of odd target need to add one more step to decrement and get the desired target
 */

public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        if (startValue > target)
            return startValue - target;
        if (startValue == target)
            return 0;
        if (target % 2 == 0)
            return 1 + brokenCalc(startValue, target / 2);
        else
            return 1 + brokenCalc(startValue, target + 1);

    }

    public static void main(String[] args) {
        int startValue = 3;
        int target = 10;
        BrokenCalculator brokenCalculator = new BrokenCalculator();
        System.out.println(brokenCalculator.brokenCalc(startValue, target));

    }
}
