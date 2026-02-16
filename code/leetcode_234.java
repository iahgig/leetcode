/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode cur_next;
        while (cur != null) {
            cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur_next;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {// 找到中间节点,分成两半，逆序比较,复原
        ListNode pre_tail = null;// 前半序列尾
        ListNode post_head = head;// 后半序列头
        ListNode p = head;
        int len = 0;
        boolean flag = true;
        while (p != null) {
            len++;
            p = p.next;
        }
        for (int i = 0; i < len / 2; i++) {
            if (i == len / 2 - 1)
                pre_tail = post_head;
            post_head = post_head.next;
        }
        if (pre_tail != null) {
            pre_tail.next = null;
            ListNode post_tail = ReverseList(post_head);
            p = head;
            ListNode q = post_tail;
            while (true) {
                if (p == null || q == null)
                    break;
                if (p.val != q.val) {
                    flag = false;
                    break;
                }
                p = p.next;
                q = q.next;
            }
            post_head = ReverseList(post_tail);
            pre_tail.next = post_head;
        }
        return flag;
    }
}