package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int length(ListNode node) {
        ListNode curr = node;
        int len = 0;
        while (node != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    public void addFirst(ListNode node) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        ListNode prev = head;
        ListNode next = null;

        while (count <= k && curr != null) {
            next = curr.next; // store next node
            curr.next = prev; // break curr to next link and point curr to prev

            //moce forward
            prev = curr; // prev will become curr
            curr = next; // curr will become next

            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }

    public int divide(int dividend, int divisor) {
        int sign = 1;

        if (dividend > 0 && divisor < 0) {
            sign = -1;
        } else if (dividend < 0 && divisor > 0) {
            sign = -1;
        }

        // Update both divisor and
        // dividend positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Initialize the quotient
        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }
        //if the sign value computed earlier is -1 then negate the value of quotient
        if (sign == -1) quotient = -quotient;

        return quotient;

    }

}
