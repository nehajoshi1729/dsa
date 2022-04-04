package linkedlist;

import CommonLibrary.ListNode;

/**
 * swap the kth node from the beginning with the kth node from the end
 * use two pointers - fast and slow to get to the correct indices and then swap
 *      maintain constant distance between fast and slow
 *      firstKth is fast pointer going k-1 from beginning
 *      lastKth is slow pointer when fast reaches the end
 */

public class SwapNodes {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode firstKth = head;
        ListNode lastKth = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        firstKth = fast;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        lastKth = slow;

        //swap the firstKth and lastKth
        int temp = firstKth.val;
        firstKth.val = lastKth.val;
        lastKth.val = temp;


        return head;

    }
}
