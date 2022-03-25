package greedy;
/**
 * schedule travel of 2n people in 2 cities such that there are n people in each city
 * return min cost required to do this
 *
 * min cost to split in groups => greedy
 *      sort on the basis of profit of flying to A over B for every i
 *      half of that sorted people will go in A (more +ve profits)
 *      other half will fly to B (more profits calculated might be -ve i.e need to fly to B)
 */

import java.util.Arrays;

public class TwoCityScheduling {
    private static int twoCityScheduledCost(int[][] costs) {
        int minSchedulingCost = 0;
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);

        });
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2)
                minSchedulingCost += costs[i][0];
            else
                minSchedulingCost += costs[i][1];
        }
        return minSchedulingCost;

    }

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(twoCityScheduledCost(costs));

    }
}
