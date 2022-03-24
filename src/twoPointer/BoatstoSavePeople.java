package twoPointer;

import java.util.Arrays;

/**
 * return min num of boats with the capacity of limit kgs needed to carry people[] (each boat can carry 2 people only)
 * classic two pointer algo
 * -- we try to pair lightest with the heaviest
 * -- if their sum is greater than target, need to let go heavier one alone
 */

public class BoatstoSavePeople {
    private static int numRescueBoats(int[] people, int limit) {
        int minRescueBoats = 0;
        Arrays.sort(people);
        for (int i = 0, j = people.length-1; i <= j; ) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                minRescueBoats++;
            } else {
                minRescueBoats++;
                j--;
            }

        }
        return minRescueBoats;
    }

    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));


    }
}
