package greedy;

import java.util.Arrays;

/**
 * distribute candies following these rules :
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 */

public class Candy {
    public int candy(int[] ratings) {
        int minCandies = 0;
        int distributionArr[] = new int[ratings.length];
        Arrays.fill(distributionArr, 1);
        //allocate more candies to more rated neighbour
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i])
                distributionArr[i + 1] = distributionArr[i] + 1;

        }

        //correct the downward pattern
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (distributionArr[i - 1] <= distributionArr[i])
                    distributionArr[i - 1] = distributionArr[i] + 1;

            }
        }

        for (int i = 0; i < distributionArr.length; i++) {
            minCandies += distributionArr[i];
        }
        return minCandies;
    }
}
