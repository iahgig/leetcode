public class leetcode_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode pre_group = prehead;// pre_group是上一组的最后一个节点
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        while (len >= k) {
            ListNode pre = null;
            ListNode tail = cur;// tail是翻转后当前组的最后一个节点
            for (int i = 0; i < k; i++) {
                ListNode cur_next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = cur_next;
            }
            pre_group.next = pre;// pre是当前组头结点
            pre_group = tail;
            len -= k;
        }
        pre_group.next = cur;
        return prehead.next;
    }
}
