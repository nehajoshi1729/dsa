package math;

/**
 * only two possible targets : bottoms[0] and tops[0]
 * to get the valid ans, at-least of the target should be equal to target, at all the indices of tops and bottoms
 * or else ans is not possible => -1
 * if ans is possible get the min possible val => 4 possibilities
 *      -- convert tops to target 1
 *      -- convert tops to target 2
 *      -- convert bottoms to target 1
 *      -- convert bottoms to target 2
 */

public class MinDominoRotations {


    private static int helper(int[] tops, int[] bottoms, int target) {
        int topRotations = 0;
        int bottomRotations = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target)
                return -1;
            if (tops[i] == target && bottoms[i] != target)
                bottomRotations += 1;
            if (tops[i] != target && bottoms[i] == target)
                topRotations += 1;

        }
        return Math.min(topRotations, bottomRotations);
    }

    public static void main(String[] args) {
//        int tops[] = {2,1,2,4,2,2};
//        int bottoms[] = {5,2,6,2,3,2};
        int tops[] = {3,5,1,2,3};
        int bottoms[] = {3,6,3,3,4};


        int ans1 = helper(tops,bottoms,tops[0]);
        int ans2 = helper(tops,bottoms,bottoms[0]);

        if(ans1 > 0 && ans2 > 0)
            System.out.println(Math.min(ans1,ans2));

        else if(ans1 > 0)
            System.out.println(ans1);
        else
            System.out.println(ans2);



    }
}
