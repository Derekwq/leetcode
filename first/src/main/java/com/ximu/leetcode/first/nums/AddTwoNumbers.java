package com.ximu.leetcode.first.nums;

import com.ximu.leetcode.first.ListNode;

/**
 * Problem 2: 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p/>
 * 
 * @author derek.wu
 * @date 2019-07-10
 * @since v1.0.0
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = createListNode(2, 4, 3);
        ListNode l2 = createListNode(5, 6, 4);
        print(solution, l1, l2);
    }

    private static void print(Solution solution, ListNode l1, ListNode l2) {
        long startTime = System.currentTimeMillis();
        ListNode res = solution.addTwoNumbers(l1, l2);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("cost: %8d, res: %s", cost, listNodeToString(res)));
    }

    private static String listNodeToString(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
            if (listNode != null) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    private static ListNode createListNode(int... arr) {
        ListNode l = new ListNode(arr[0]);
        if (arr.length == 1) {
            return l;
        }
        ListNode p = l;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return l;
    }

    static class Solution {

        /**
         * Run结果
         * 提交结果：AC
         * 执行用时：7ms
         * 内存消耗：44.7MB
         * 
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode curNode = null;
            // 进位
            int carry = 0;
            while (l1 != null || l2 != null) {
                int value1 = l1 == null ? 0 : l1.val;
                int value2 = l2 == null ? 0 : l2.val;
                int sum = value1 + value2 + carry;
                carry = sum / 10;
                int val = sum % 10;

                ListNode newL = new ListNode(val);
                if (curNode == null) {
                    curNode = newL;
                } else {
                    curNode.next = newL;
                    curNode = curNode.next;
                }
                head = head == null ? curNode : head;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if (carry > 0) {
                curNode.next = new ListNode(carry);
            }
            return head;
        }
    }

}
