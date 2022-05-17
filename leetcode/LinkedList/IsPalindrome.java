package leetcode.LinkedList;

public class IsPalindrome {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head){
        ListNode mid = getMid(head);
        ListNode head1 = reverseList(mid);
        ListNode head2 = head;

        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            } else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
