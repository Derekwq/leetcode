package com.derek.leetcode.ds;

import com.derek.leetcode.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = ListNode.build(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        ListNode r1 = solution.deleteDuplicates(l1);
        System.out.println(ListNode.listNodeToString(r1));

        ListNode l2 = ListNode.build(new int[] { 1, 1, 1, 2, 3 });
        ListNode r2 = solution.deleteDuplicates(l2);
        System.out.println(ListNode.listNodeToString(r2));

        ListNode l3 = ListNode.build(new int[] { 1, 2, 2 });
        ListNode r3 = solution.deleteDuplicates(l3);
        System.out.println(ListNode.listNodeToString(r3));
    }

    static class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode p = head;
            ListNode newHead = head;
            boolean isPDuplicate = false;
            while (p.next != null) {
                if (!valEquals(p, p.next)) {
                    if (isPDuplicate) {
                        if (pre == null) {
                            newHead = p.next;
                        } else {
                            pre.next = p.next;
                        }
                        p = p.next;
                    } else {
                        pre = p;
                        p = p.next;
                    }
                    isPDuplicate = false;
                    continue;
                }
                isPDuplicate = true;
                if (p.next.next == null) {
                    if (pre == null) {
                        return null;
                    } else {
                        pre.next = null;
                        p.next = null;
                    }
                } else {
                    p.next = p.next.next;
                }
            }
            return newHead;
        }

        private boolean valEquals(ListNode node1, ListNode node2) {
            return node1.val == node2.val;
        }
    }
}
