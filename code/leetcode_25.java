public class leetcode_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prehead = new ListNode(-1, head);
        ListNode pretail = prehead;
        ListNode cur = head;
        ListNode pre = null;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        while (n >= k) {
            ListNode tail = cur;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            pretail.next = pre;
            pretail = tail;
            pre = null;
            n -= k;
        }
        pretail.next = cur;
        return prehead.next;
    }
}
