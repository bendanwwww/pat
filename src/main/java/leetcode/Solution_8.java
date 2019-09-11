package leetcode;

import leetcode.utils.ListNode;

/**
 * 题目描述
 *
 * 将给定的单链表L： L 0→L 1→…→L n-1→L n,
 * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * 例如：
 * 对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 *
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class Solution_8 {

    public void reorderList(ListNode head) {

        if(head == null) {
            return;
        }

        if(head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode midhead = slow.next;
        slow.next = null;

        ListNode l1 = midhead;
        ListNode l2 = l1.next;
        l1.next = null;
        while(l2 != null) {
            ListNode tmp = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = tmp;
        }

        ListNode head1 = head;
        ListNode head2 = l1;


        while(head2 != null) {
            ListNode tmp1 = head1.next;
            head1.next = head2;
            ListNode tmp2 = head2.next;
            head2.next = tmp1;
            head1 = tmp1;
            head2 = tmp2;
        }

    }

    public static void main(String[] args) {
        Solution_8 solution = new Solution_8();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        //ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        //head4.next = head5;
        solution.reorderList(head1);

    }
}
