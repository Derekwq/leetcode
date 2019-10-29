package com.derek.leetcode.ds;

import com.derek.leetcode.ListNode;

/**
 * 23. 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[] { 1, 4, 5 });
        ListNode l2 = ListNode.build(new int[] { 1, 3, 4 });
        ListNode l3 = ListNode.build(new int[] { 2, 6 });

        ListNode[] lArr = new ListNode[] { l1, l2, l3 };
        ListNode newL = new Solution1().mergeKLists(lArr);
        System.out.println("newL: " + ListNode.listNodeToString(newL));

        ListNode newL2 = new Solution2().mergeKLists(lArr);
        System.out.println("newL2: " + ListNode.listNodeToString(newL2));
    }

    /**
     * 执行用时：97ms
     * 内存消耗：49.7MB
     */
    static class Solution1 {

        /**
         * 纯链表操作解法。 O(k*n)
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode[] pArr = new ListNode[lists.length];
            for (int i = 0; i < lists.length; i++) {
                pArr[i] = lists[i];
            }
            if (!isGoOn(pArr)) {
                return null;
            }
            int min = minOf(pArr);
            ListNode newL = new ListNode(min);
            ListNode pn = newL;

            while (isGoOn(pArr)) {
                int curMin = minOf(pArr);
                pn.next = new ListNode(curMin);
                pn = pn.next;
            }
            return newL;
        }

        private int minOf(ListNode[] pArr) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < pArr.length; i++) {
                if (pArr[i] == null) {
                    continue;
                }
                if (pArr[i].val < min) {
                    min = pArr[i].val;
                    idx = i;
                }
            }
            if (idx >= 0) {
                pArr[idx] = pArr[idx].next;
            }
            return min;
        }

        private boolean isGoOn(ListNode[] pArr) {
            if (pArr == null || pArr.length == 0) {
                return false;
            }
            for (ListNode p : pArr) {
                if (p != null) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 执行用时：4ms
     * 内存消耗：42.3MB
     */
    static class Solution2 {

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            if (lists.length == 2) {
                return mergeTwoLists(lists[0], lists[1]);
            }

            int half = lists.length / 2;
            ListNode[] left = new ListNode[half];
            ListNode[] right = new ListNode[lists.length - half];
            for (int i = 0; i < half; i++) {
                left[i] = lists[i];
            }
            for (int i = half, j = 0; i < lists.length; i++) {
                right[j++] = lists[i];
            }
            return mergeTwoLists(mergeKLists(left), mergeKLists(right));
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode p;
            if (l1.val < l2.val) {
                p = l1;
                p.next = mergeTwoLists(l1.next, l2);
            } else {
                p = l2;
                p.next = mergeTwoLists(l1, l2.next);
            }
            return p;
        }
    }

}
