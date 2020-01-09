package com.ximu.leetcode.first.ds;

import com.ximu.leetcode.first.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 1) {
            if (head.next == null) {
                return null;
            }
            // 删除最后一个
            ListNode p = head.next;
            ListNode pre = head;
            while (p.next != null) {
                pre = p;
                p = p.next;
            }
            pre.next = null;
            return head;
        }
        // 两个指针 p1, p2，p1先走 n 步，后面 p1,p2以相同的速度向后移动，p1到达尾部，p2的next就是要删除的节点
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        if (p1 == null) {
            // 要删除的是头结点
            return head.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }
}
