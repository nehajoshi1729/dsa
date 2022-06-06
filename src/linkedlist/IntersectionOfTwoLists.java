package linkedlist;

import CommonLibrary.ListNode;

/**
 * only twist is lists could not be of the same lens
 * so we find the len diff, balance it and then find the intersecting element in the usual way
 */

public class IntersectionOfTwoLists {
    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = lenB - lenA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }

        }
        //diff covered, lens match now
        //now find the intresecting node in the two equal sized lists
        while (headA != null && headB != null) {
            if (headA == headB)
                return headB;
            headA = headA.next;
            headB = headB.next;

        }

        return null;

    }
}
