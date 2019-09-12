package leetcode;

import leetcode.utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 *
 * 现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
 * 请对这个链表进行深拷贝。
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class Solution_13 {

    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null) {
            return null;
        }

        RandomListNode copyHead = new RandomListNode(head.label);

        RandomListNode copyTmp = copyHead;

        RandomListNode first = head;

        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

        while(first != null) {
            RandomListNode copy = new RandomListNode(first.label);
            nodeMap.put(first, copy);
            first = first.next;
        }

        first = head;

        while(first != null && (first.next != null || first.random != null)) {
            RandomListNode next = first.next;
            RandomListNode random = first.random;
            RandomListNode copyNext = null;
            RandomListNode copyRandom = null;
            if(next != null) {
                copyNext = nodeMap.get(next);
            }
            if(random != null) {
                copyRandom = nodeMap.get(random);
            }
            copyTmp.next = copyNext;
            copyTmp.random = copyRandom;
            copyTmp = copyTmp.next;
            first = first.next;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        Solution_13 solution = new Solution_13();
        RandomListNode head1 = new RandomListNode(-1);
        //RandomListNode head2 = new RandomListNode(-1);
        head1.next = null;
        head1.random = head1;
        solution.copyRandomList(head1);
    }
}
