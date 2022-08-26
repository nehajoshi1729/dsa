package linkedlist;

import CommonLibrary.ListNode;

/**
 * crux : need to reverse half of the ll and then compare
 * 1. use fast and slow pointers to get to end and middle (fast goes to end and slow goes to middle)
 * 2. reverse right half, slow becomes head of the reversed half, original head is still the head of the first half
 * 3. run and compare head and slow pointers together (classic two pointers thingy)
 */

public class PalindromeLL {
    private boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) // in case of odd length, as we are moving fast node two places at a time
            slow = slow.next; //right half smaller
        slow = reverseLinkedList(slow);
        fast = head; //starting of the left half
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;
    }

}
