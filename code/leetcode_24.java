public class leetcode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode pre = prehead;
        ListNode p1;
        ListNode p2;
        while (pre.next != null && pre.next.next != null) {//先迭代，边界条件放在循环体外，代码更简洁
            p1 = pre.next;
            p2 = p1.next;
            pre.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            pre = p1;
        }
        return prehead.next;
    }
}
