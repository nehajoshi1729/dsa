package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * On each turn, we choose the heaviest two stones and smash them together. After smash, if both are equal both are destroyed if not x - y will be remaining
 * at end only at most one stone will be left
 *
 * naive approach == keep sorting and getting the two largest stones,recalculate the remnant stone and sort again
 * better approach == maxHeap (implement using PriorityQueue) to get the top n elements,smash stones and heapify
 */

public class LastStoneWeight {
    private static int getNaiveSolution(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);

        }
        return stones[0];
    }

    private static int getOptimalSolution(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
            maxHeap.offer(stone);
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x > y)
                maxHeap.offer(x - y);
            if (maxHeap.size() == 0)
                return 0;
        }
        return maxHeap.poll();
    }

}
