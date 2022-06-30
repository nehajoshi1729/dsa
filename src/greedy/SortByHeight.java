package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * people[i] = [hi, ki], k is no. of people of height greater than or equal to k
 * Approach
 *          1. sort in desc order of height
 *          2. iterate from left to right, if ith k is at wrong position,move it to the kth position
 *              {this will not affect the people ahead of them as the inserted person is anyway shorter}
 *          3. in case of same height, we still want to keep them sorted in ascending order(by k) to maintain their k values
 *
 */

public class SortByHeight {
    private static int[][] get(int[][] people)
    {
        List<int[]> orderedHeight =new LinkedList<>();
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int[]p : people)
        {
            orderedHeight.add(p[1],p);
        }
        return orderedHeight.toArray(new int[people.length][2]);
    }
}
