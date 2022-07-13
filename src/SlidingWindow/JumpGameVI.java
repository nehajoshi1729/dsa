package SlidingWindow;

import java.util.PriorityQueue;

/**
 *  sliding window to depict the jump range
 *  max heap / priority queue to get the max score in the current jump scope
 */


public class JumpGameVI {
    private static int maxResult(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int maxScore = nums[0];
        //[index, maxScore]
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        priorityQueue.add(new int[]{0, maxScore});
        for (int i = 1; i < nums.length; i++) {
            while (!(i - priorityQueue.peek()[0] <= k))
                priorityQueue.poll();
            int[] top = priorityQueue.peek();
            maxScore = top[1] + nums[i];
            priorityQueue.offer(new int[]{i, maxScore});

        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        System.out.println(maxResult(nums, k));
    }

}
