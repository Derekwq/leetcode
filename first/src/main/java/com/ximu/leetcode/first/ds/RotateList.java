package com.ximu.leetcode.first.ds;

import com.ximu.leetcode.first.ListNode;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class RotateList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = ListNode.build(new int[] { 1, 2, 3, 4, 5 });
        ListNode rl = solution.rotateRight(l, 2);
        System.out.println(ListNode.listNodeToString(rl));

        ListNode l2 = ListNode.build(new int[] { 0, 1, 2 });
        ListNode rl2 = solution.rotateRight(l2, 4);
        System.out.println(ListNode.listNodeToString(rl2));

        ListNode l3 = ListNode.build(new int[] { 1, 2 });
        ListNode rl3 = solution.rotateRight(l3, 1);
        System.out.println(ListNode.listNodeToString(rl3));

        ListNode l4 = ListNode.build(new int[] { 1, 2, 3, 4, 5 });
        ListNode rl4 = solution.rotateRight(l4, 4);
        System.out.println(ListNode.listNodeToString(rl4));
    }

    static class Solution {

        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k <= 0) {
                return head;
            }
            // 将链表首尾相连，并且计算得出链表长度
            ListNode p = head;
            int len = 1;
            while (p.next != null) {
                p = p.next;
                len += 1;
            }
            p.next = head;

            // 计算新的尾部：从 head 向后移动 len - (k % len) - 1个位置
            ListNode tail = head;
            int j = len - (k % len) - 1;
            for (int i = 0; i < j; i++) {
                tail = tail.next;
            }
            ListNode newHead = tail.next;
            tail.next = null;
            return newHead;
        }
    }
}
