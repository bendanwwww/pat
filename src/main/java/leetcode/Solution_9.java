package leetcode;

import leetcode.utils.ListNode;

/**
 * 题目描述
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution_9 {

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        boolean hasHoop = false;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                hasHoop = true;
                break;
            }
        }

        if(!hasHoop) {
            return null;
        }

        ListNode last = head;
        ListNode intersection = slow;

        while(last != intersection) {
            last = last.next;
            intersection = intersection.next;
        }

        return last;
    }

    public static void main(String[] args) {
        Solution_9 solution = new Solution_9();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode res = solution.detectCycle(head1);

        System.out.println(res);

    }
}
