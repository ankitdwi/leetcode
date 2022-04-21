package leetcode.LinkedList;

public class ReverseInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        ListNode prev = head;
        ListNode next = null;

        while (count <= k && curr != null) {
            next = curr.next; // store next node
            curr.next = prev; // break curr to next link and point curr to prev

            //move forward
            prev = curr; // prev will become curr
            curr = next; // curr will become next

            count++;
        }

        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
