package leetcode.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedLinkedList {

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



}
