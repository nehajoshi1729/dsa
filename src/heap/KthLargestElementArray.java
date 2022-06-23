package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementArray {
    private static int get(int nums[], int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        int extractFirstKElements = k - 1;
        while (extractFirstKElements > 0) {
            priorityQueue.poll();
            extractFirstKElements--;
        }
        return priorityQueue.peek();
    }
}
