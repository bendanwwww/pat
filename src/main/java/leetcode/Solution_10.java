package leetcode;

import leetcode.utils.ListNode;

/**
 * 题目描述
 * 判断给定的链表中是否有环
 * 扩展：
 * 你能给出不利用额外空间的解法么？
 *
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution_10 {

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
