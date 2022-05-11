package recursion;

/**
 * Given an integer n,
 * return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 *
 * a e i o u
 * aa => aa ,ae, ai, ao, au 5 solutions
 * ae => ae ,ai,ao,au
 * ai => ai, ao ,au
 * ao => ao, au
 * au => au
 *
 * ee ei eo eu
 *
 * 5 + 4 + 3 + 2 + 1
 * 4 + 3 + 2 + 1
 * 3 + 2 + 1
 *
 *
 *
 *      recursion stack => bt(5,0)
 *                         bt(4,1)
 *                         bt(3,2)
 *                         bt(1,4)
 *                         cnt = 1
 *
 *      bt(1,4)
 *      cnt = 2
 *
 *      bt(3,2)
 *      bt(2,3)
 *      bt(1,4)
 *      cnt = 3
 *
 *      bt(4,1)
 *      bt(3,2)
 *      bt(2,3)
 *      bt(1,4)
 *      cnt = 4
 *
 *      bt(5,0)
 *      bt(4,1)
 *      bt(3,2)
 *      bt(2,3)
 *      bt(1,4)
 *      cnt = 5
 */

public class CountSortedVowelStrings {
    public static int count;
    public static int get(int n) {
        count = 0;
        backTrack(n, 0);
        return count;
    }
    private static void backTrack(int n, int indexToStart){
        if(n == 0){
            count++;
            return;
        }
        for(int i = indexToStart; i < 5; i++){
            System.out.println(count);
            System.out.println(n);
            System.out.println(i);
            System.out.println("---");
            backTrack(n - 1, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(get(1));
    }
}
